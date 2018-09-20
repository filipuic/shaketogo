package engineer.filip.shaketogo.ui.home;


import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;
import engineer.filip.data.DataManager;
import engineer.filip.shaketogo.utils.ViewModelProviderFactory;
import engineer.filip.utils.rx.SchedulerProvider;

@Module
public class MainActivityModule {

  @Provides
  ViewModelProvider.Factory homeViewModelProvider(MainViewModel viewModel) {
    return new ViewModelProviderFactory<>(viewModel);
  }

  @Provides
  MainViewModel provideHomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
    return new MainViewModel(dataManager, schedulerProvider);
  }

}
