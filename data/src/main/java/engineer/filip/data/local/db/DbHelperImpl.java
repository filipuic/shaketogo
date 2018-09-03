package engineer.filip.data.local.db;

import engineer.filip.data.model.db.User;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

public class DbHelperImpl implements DbHelper {

  private final AppDatabase appDatabase;

  @Inject
  public DbHelperImpl(AppDatabase appDatabase) {
    this.appDatabase = appDatabase;
  }

  @Override
  public Observable<Boolean> insertUser(final User user) {
    return Observable.fromCallable(new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        appDatabase.userDao().insert(user);
        return true;
      }
    });
  }

  @Override
  public Observable<List<User>> getAllUsers() {
    return Observable.fromCallable(new Callable<List<User>>() {
      @Override
      public List<User> call() throws Exception {
        return appDatabase.userDao().loadAll();
      }
    });
  }
}
