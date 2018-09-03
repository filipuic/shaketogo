package engineer.filip.data.local.db;

import engineer.filip.data.model.db.User;
import io.reactivex.Observable;
import java.util.List;

public interface DbHelper {

  Observable<Boolean> insertUser(final User user);
  Observable<List<User>> getAllUsers();

}
