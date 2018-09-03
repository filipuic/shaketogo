package engineer.filip.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import engineer.filip.data.local.db.dao.UserDao;
import engineer.filip.data.model.db.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

  public abstract UserDao userDao();
}
