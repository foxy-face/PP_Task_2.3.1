package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User show(int id) {
        TypedQuery<User> query
                = sessionFactory.getCurrentSession()
                .createQuery("from User where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(int id, User user) {
        TypedQuery<User> query
                = sessionFactory.getCurrentSession()
                .createQuery("from User where id = :id");
        query.setParameter("id", id);
        User updateUser = query.getSingleResult();
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setCountry(user.getCountry());
        updateUser.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete from User where id = :id");
//        query.executeUpdate();
//        Query q = sessionFactory.getCurrentSession().createQuery("DELETE FROM Predictionlevelwater WHERE namePost = :namePost");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
