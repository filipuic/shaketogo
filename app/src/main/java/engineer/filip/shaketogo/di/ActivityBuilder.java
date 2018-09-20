package engineer.filip.shaketogo.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import engineer.filip.shaketogo.ui.home.MainActivity;
import engineer.filip.shaketogo.ui.home.MainActivityModule;

@Module
public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = { MainActivityModule.class })
  abstract MainActivity bindHomeActivity();

}
