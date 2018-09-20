package engineer.filip.shaketogo.ui.home;

import engineer.filip.data.DataManager;
import engineer.filip.shaketogo.base.BaseViewModel;
import engineer.filip.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigator> {

  public MainViewModel(DataManager dataManager,
      SchedulerProvider schedulerProvider) {
    super(dataManager, schedulerProvider);
  }

  public void onOpenVenue() {
    getNavigator().openVenue();
  }
}
