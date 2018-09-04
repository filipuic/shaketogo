package engineer.filip.shaketogo;

import android.app.Activity;
import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import engineer.filip.shaketogo.di.DaggerAppComponent;
import javax.inject.Inject;

public class ShakeApplication extends Application implements HasActivityInjector {

  @Inject
  DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return activityDispatchingAndroidInjector;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this);

    AndroidNetworking.initialize(getApplicationContext());
    if (BuildConfig.DEBUG) {
      AndroidNetworking.enableLogging(Level.BODY);
    }

  }
}
