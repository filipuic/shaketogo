package engineer.filip.shaketogo.ui.home;


import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import engineer.filip.data.DataManager;
import engineer.filip.shaketogo.utils.ViewModelProviderFactory;
import engineer.filip.utils.rx.SchedulerProvider;

@Module
public class HomeActivityModule {

  @Provides
  ViewModelProvider.Factory homeViewModelProvider(HomeViewModel viewModel) {
    return new ViewModelProviderFactory<>(viewModel);
  }

  @Provides
  HomeViewModel provideHomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
    return new HomeViewModel(dataManager, schedulerProvider);
  }

}
