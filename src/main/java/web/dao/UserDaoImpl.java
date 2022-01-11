package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private static int people_count;
    List<User> people;

    {
        people = new ArrayList<User>();
        people.add(new User(people_count++, "Gosha", "Petrov", "Russia", 23));
        people.add(new User(people_count++, "Mick", "Praden", "USA", 46));
        people.add(new User(people_count++, "Elisabeth", "Hearly", "France", 24));
        people.add(new User(people_count++, "Sam", "Stone", "Japan", 41));
    }

    public List<User> index() {
        return people;
    }
}
