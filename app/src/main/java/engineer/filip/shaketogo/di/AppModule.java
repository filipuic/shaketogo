package engineer.filip.shaketogo.di;

import android.app.Application;
import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import engineer.filip.data.DataManager;
import engineer.filip.data.DataManagerImpl;
import engineer.filip.data.local.db.AppDatabase;
import engineer.filip.data.local.db.DbHelper;
import engineer.filip.data.local.db.DbHelperImpl;
import engineer.filip.data.local.prefs.PrefsHelper;
import engineer.filip.data.local.prefs.PrefsHelperImpl;
import engineer.filip.data.remote.ApiHelper;
import engineer.filip.data.remote.ApiHelperImpl;
import engineer.filip.di.DatabaseInfo;
import engineer.filip.di.PrefsInfo;
import engineer.filip.utils.C;
import engineer.filip.utils.rx.SchedulerProvider;
import engineer.filip.utils.rx.SchedulerProviderImpl;
import javax.inject.Singleton;

@Module
public class AppModule {

  @Provides
  @Singleton
  ApiHelper provideApiHelper(ApiHelperImpl apiHelper) {
    return apiHelper;
  }

  @Provides
  @Singleton
  AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
    return Room.databaseBuilder(context, AppDatabase.class, dbName)
        .fallbackToDestructiveMigration()
        .build();
  }

  @Provides
  @Singleton
  DbHelper provideDbHelper(DbHelperImpl dbHelper) {
    return dbHelper;
  }

  @Provides
  @Singleton
  PrefsHelper providePrefsHelper(PrefsHelperImpl prefsHelper) {
    return prefsHelper;
  }

  @Provides
  @Singleton
  DataManager provideDataManager(DataManagerImpl dataManager) {
    return dataManager;
  }

  @Provides
  @Singleton
  Context provideContext(Application application) {
    return application;
  }

  @Provides
  SchedulerProvider provideSchedulerProvider() {
    return new SchedulerProviderImpl();
  }

  @Provides
  @DatabaseInfo
  String provideDatabaseName() {
    return C.DB_NAME;
  }

  @Provides
  @PrefsInfo
  String providePreferencesName() {
    return C.PREFS_NAME;
  }



}
