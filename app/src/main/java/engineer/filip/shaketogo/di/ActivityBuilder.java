package engineer.filip.shaketogo.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import engineer.filip.shaketogo.ui.home.HomeActivity;
import engineer.filip.shaketogo.ui.home.HomeActivityModule;

@Module
public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = { HomeActivityModule.class })
  abstract HomeActivity bindHomeActivity();

}
