package engineer.filip.shaketogo.adapter;


import androidx.annotation.LayoutRes;
import androidx.databinding.ViewDataBinding;

public interface BindingItemTypeAdapter<B extends ViewDataBinding, T> {

    /**
     * This method determines whether the current item is handled by this type adapter
     *
     * @param item data for row item
     * @return true if the passed item is handled by this type adapter; otherwise false
     */
    boolean isItemHandled(T item);

    /**
     * Bind variables to xml
     *
     * @param binding      current item binding object
     * @param item         item to bind to xml
     * @param eventHandler {@link BindingListEventHandler} to bind to xml
     */
    void bind(B binding, T item, BindingListEventHandler<T> eventHandler);

    /**
     * Layout id to use for the current item type
     *
     * @return layout id e.g.: R.layout.list_item_van or R.layout.list_item_car
     */
    @LayoutRes
    int layout();
}
