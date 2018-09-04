package engineer.filip.shaketogo.di;

import android.app.Application;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import engineer.filip.shaketogo.ShakeApplication;
import javax.inject.Singleton;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class })
public interface AppComponent {

  void inject(ShakeApplication application);

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);
    AppComponent build();
  }

}
