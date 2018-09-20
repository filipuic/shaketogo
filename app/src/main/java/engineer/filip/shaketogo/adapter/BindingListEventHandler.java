package engineer.filip.shaketogo.adapter;

import engineer.filip.shaketogo.base.BaseViewModel;
import io.reactivex.subjects.PublishSubject;

public class BindingListEventHandler<T> {

    private final PublishSubject<T> clickObserver = PublishSubject.create();

    private final PublishSubject<T> secondaryClickObserver = PublishSubject.create();

    private final PublishSubject<Integer> nextPageObserver = PublishSubject.create();

    /**
     * Subscribe to this Observer if you would like to be notified when an item is clicked
     * This should be subscribed to in a {@link BaseViewModel} subclass
     *
     * @return PublishSubject to subscribe to
     */
    public PublishSubject<T> getClickObserver() {
        return clickObserver;
    }

    /**
     * Subscribe to this Observer if you would like to be notified when a button on the item is clicked
     * This should be subscribed to in a {@link BaseViewModel} subclass
     *
     * @return PublishSubject to subscribe to
     */
    public PublishSubject<T> getSecondaryClickObserver() {
        return secondaryClickObserver;
    }

    /**
     * Subscribe to this Observer if you would like to be notified when the adapter needs a new page
     * This should be subscribed to in a {@link BaseViewModel} subclass
     *
     * @return PublishSubject to subscribe to
     */
    public PublishSubject<Integer> getNextPageObserver() {
        return nextPageObserver;
    }

    /**
     * Call it when an item is clicked.
     * Binding example: android:onClick="@{ () -> eventHandler.onClick(item) }"
     * where eventHandler is a variable bound to the row item
     *
     * @param itemData the data of the clicked item
     */
    public void onClick(T itemData) {
        clickObserver.onNext(itemData);
    }

    /**
     * Call it when a button on the item is clicked.
     * Binding example: android:onClick="@{ () -> eventHandler.onSecondaryClick(item) }"
     * where eventHandler is a variable bound to the row item
     *
     * @param itemData the data of the clicked item
     */
    public void onSecondaryClick(T itemData) {
        secondaryClickObserver.onNext(itemData);
    }

    /**
     * This is automatically called if pagination is enabled on {@link BindingListAdapter}
     *
     * @param position current position the pagination is called at
     */
    void onNextPage(int position) {
        nextPageObserver.onNext(position);
    }
}
