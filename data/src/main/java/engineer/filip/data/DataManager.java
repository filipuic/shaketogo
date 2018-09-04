package engineer.filip.data;

import engineer.filip.data.local.db.DbHelper;
import engineer.filip.data.local.prefs.PrefsHelper;
import engineer.filip.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PrefsHelper, ApiHelper {

}
