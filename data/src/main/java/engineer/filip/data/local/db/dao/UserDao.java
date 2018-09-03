package engineer.filip.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import engineer.filip.data.model.db.User;
import java.util.List;

@Dao
public interface UserDao {

  @Delete
  void delete(User user);

  @Query("SELECT * FROM users WHERE name LIKE :name LIMIT 1")
  User findByName(String name);

  @Query("SELECT * FROM users WHERE id LIKE :id LIMIT 1")
  User findById(Long id);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(User user);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertAll(List<User> users);

  @Query("SELECT * FROM users")
  List<User> loadAll();


}
