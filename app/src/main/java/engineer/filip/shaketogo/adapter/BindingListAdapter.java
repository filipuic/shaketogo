package engineer.filip.shaketogo.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import engineer.filip.shaketogo.R;
import engineer.filip.shaketogo.BR;
import java.util.ArrayList;
import java.util.List;

public class BindingListAdapter<T> extends RecyclerView.Adapter<BindingViewHolder<ViewDataBinding>> {

    private final List<BindingItemTypeAdapter> typeAdapters = new ArrayList<>();

    private List<T> list = new ArrayList<>();

    private BindingListEventHandler<T> eventHandler;

    private boolean isPaginationEnabled = false;

    private int numOfItemsBeforePagination = 8;

    private int itemCountBeforePagination;

    public void setList(final List<T> list) {
        this.list.clear();
        this.list.addAll(list);
    }

    /**
     * Add {@link BindingItemTypeAdapter} adapters that will handle the binding of different row types
     * You will add one {@link BindingItemTypeAdapter} per row type.
     *
     * @param adapter {@link BindingItemTypeAdapter} for each row type
     */
    public void addTypeAdapter(final BindingItemTypeAdapter adapter) {
        this.typeAdapters.add(adapter);
    }

    /**
     * Set {@link BindingListEventHandler} to handle adapter and row item specific events
     *
     * @param eventHandler event handler
     */
    public void setEventHandler(final BindingListEventHandler<T> eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * Sets whether this adapter needs pagination
     *
     * @param isPaginationEnabled true if this adapter needs pagination; otherwise false
     */
    public void setPaginationEnabled(final boolean isPaginationEnabled) {
        this.isPaginationEnabled = isPaginationEnabled;
    }

    /**
     * Sets the number of items from the bottom of the list at which the next page needs to be requested
     *
     * @param numOfItems number of items the next page needs to be requested from
     */
    public void setNumOfItemsBeforePagination(final int numOfItems) {
        this.numOfItemsBeforePagination = numOfItems;
    }

    @Override
    public BindingViewHolder<ViewDataBinding> onCreateViewHolder(ViewGroup parent, int viewType) {

        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final int layout;

        if (viewType > -1) {
            final BindingItemTypeAdapter typeAdapter = typeAdapters.get(viewType);
            layout = typeAdapter.layout();
        } else {
            layout = R.layout.list_item_type_adapter_missing_error;
        }

        final ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater, layout, parent, false);
        return new BindingViewHolder<>(dataBinding);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BindingViewHolder<ViewDataBinding> holder, int position) {
        final int viewType = getItemViewType(position);
        final T item = list.get(position);

        if (viewType > -1) {
            final BindingItemTypeAdapter typeAdapter = typeAdapters.get(viewType);
            typeAdapter.bind(holder.getBinding(), item, eventHandler);
        } else {
            holder.getBinding().setVariable(BR.message, "No type adapter for item: " + item.toString());
        }

        holder.getBinding().executePendingBindings();

        handlePagination(position);
    }


    @SuppressWarnings("unchecked")
    @Override
    public int getItemViewType(int position) {

        final T item = list.get(position);
        for (int i = 0; i < typeAdapters.size(); i++) {
            if (typeAdapters.get(i).isItemHandled(item)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public long getItemId(int position) {
        return hasStableIds() ? position : super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    /**
     * Checks if next page needs to be requested via the event handler
     * and sends the onNextPage event through the {@link BindingListEventHandler}
     *
     * @param position current row position
     */
    private void handlePagination(final int position) {

        if (isPaginationEnabled) {

            final int positionFromBottom = getItemCount() - (position + 1);
            final boolean nextPageDelivered = itemCountBeforePagination < getItemCount();

            if (positionFromBottom <= numOfItemsBeforePagination && nextPageDelivered) {

                itemCountBeforePagination = getItemCount();
                eventHandler.onNextPage(position);
            }
        }
    }
}
