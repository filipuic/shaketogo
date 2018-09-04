package engineer.filip.data;

import engineer.filip.data.local.db.DbHelper;
import engineer.filip.data.local.prefs.PrefsHelper;
import engineer.filip.data.model.api.fq.FqNearbyRequest;
import engineer.filip.data.model.api.fq.FqNearbyResponse;
import engineer.filip.data.model.db.User;
import engineer.filip.data.remote.ApiHelper;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManagerImpl implements DataManager {

  private final ApiHelper apiHelper;

  private final DbHelper dbHelper;

  private final PrefsHelper prefsHelper;

  @Inject
  public DataManagerImpl(ApiHelper apiHelper, DbHelper dbHelper, PrefsHelper prefsHelper) {
    this.apiHelper = apiHelper;
    this.dbHelper = dbHelper;
    this.prefsHelper = prefsHelper;
  }

  @Override
  public Observable<Boolean> insertUser(User user) {
    return dbHelper.insertUser(user);
  }

  @Override
  public Observable<List<User>> getAllUsers() {
    return dbHelper.getAllUsers();
  }

  @Override
  public Long getCurrentUserId() {
    return prefsHelper.getCurrentUserId();
  }

  @Override
  public void setCurrentUserId(Long userId) {
    prefsHelper.setCurrentUserId(userId);
  }

  @Override
  public Single<FqNearbyResponse> getFqNearbyVenues(FqNearbyRequest request) {
    return apiHelper.getFqNearbyVenues(request);
  }
}
