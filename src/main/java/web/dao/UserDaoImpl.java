package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private static int users_count = 1;
    List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(users_count++, "Gosha", "Petrov", "Russia", 23));
        users.add(new User(users_count++, "Mick", "Praden", "USA", 46));
        users.add(new User(users_count++, "Elisabeth", "Hearly", "France", 24));
        users.add(new User(users_count++, "Sam", "Stone", "Japan", 41));
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++users_count);
        users.add(user);
    }

    @Override
    public void update(int id, User user) {
        User updateUser = show(id);
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setCountry(user.getCountry());
        updateUser.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
