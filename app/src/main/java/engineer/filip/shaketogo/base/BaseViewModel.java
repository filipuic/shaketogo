package engineer.filip.shaketogo.base;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.ViewModel;
import engineer.filip.data.DataManager;
import engineer.filip.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;

public abstract class BaseViewModel<N> extends ViewModel {

  private final ObservableBoolean isLoading = new ObservableBoolean(false);

  private final DataManager dataManager;

  private final SchedulerProvider schedulerProvider;

  private CompositeDisposable compositeDisposable;

  private WeakReference<N> navigator;


  protected BaseViewModel(DataManager dataManager,
      SchedulerProvider schedulerProvider) {
    this.dataManager = dataManager;
    this.schedulerProvider = schedulerProvider;
    this.compositeDisposable = new CompositeDisposable();
  }

  @Override
  protected void onCleared() {
    compositeDisposable.dispose();
    super.onCleared();
  }

  public ObservableBoolean getIsLoading() {
    return isLoading;
  }

  public DataManager getDataManager() {
    return dataManager;
  }

  public SchedulerProvider getSchedulerProvider() {
    return schedulerProvider;
  }

  public CompositeDisposable getCompositeDisposable() {
    return compositeDisposable;
  }

  public N getNavigator() {
    return navigator.get();
  }

  public void setIsLoading(boolean isLoading) {
    this.isLoading.set(isLoading);
  }

  public void setNavigator(N navigator) {
    this.navigator = new WeakReference<>(navigator);
  }

}
