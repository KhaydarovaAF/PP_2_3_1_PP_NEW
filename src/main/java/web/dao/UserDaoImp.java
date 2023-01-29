package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext(unitName = "emf")
    EntityManager entityManager;
    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();    }

    @Override
    public void update(int id, User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getUserById(id));
    }
}
