package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User user").getResultList();
    }

    @Override
    public User show(int id) {
        return (User) entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        User updateUser = (User) entityManager.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setCountry(user.getCountry());
        updateUser.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        entityManager.remove(id);
    }
}
