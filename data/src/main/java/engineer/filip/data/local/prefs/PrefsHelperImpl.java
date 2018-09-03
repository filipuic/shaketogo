package engineer.filip.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import engineer.filip.di.PrefsInfo;
import engineer.filip.utils.C;
import javax.inject.Inject;

public class PrefsHelperImpl implements PrefsHelper {

  private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";

  private final SharedPreferences sharedPreferences;

  @Inject
  public PrefsHelperImpl(Context context, @PrefsInfo String prefsFileName) {
    sharedPreferences = context.getSharedPreferences(prefsFileName, Context.MODE_PRIVATE);
  }

  @Override
  public Long getCurrentUserId() {
    long userId = sharedPreferences.getLong(PREF_KEY_CURRENT_USER_ID, C.NULL_INDEX);
    return userId == C.NULL_INDEX ? null : userId;
  }

  @Override
  public void setCurrentUserId(Long userId) {
    long id = userId == null ? C.NULL_INDEX : userId;
    sharedPreferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
  }
}
