package com.sala.edu.co.SistemaSala.dao.imp;

import com.sala.edu.co.SistemaSala.dao.UserDao;
import com.sala.edu.co.SistemaSala.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getUserByEmail(String email) throws Exception {
        String hqlObtenerUsuarioXemail = "FROM User as u WHERE u.email = :email";
        User user= new User();
        try {
            List<User> result = entityManager.createQuery(hqlObtenerUsuarioXemail.toString())
                    .setParameter("email", email)
                    .getResultList();
            if (result.size() == 0) { return null; }
            user = result.get(0);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByCC(String cedulaParam) throws Exception {
        String hqlObtenerTodosUsuarios = "FROM User as u WHERE u.cedula = :cedulaParam";
        User user= new User();
        try {
            List<User> result = entityManager.createQuery(hqlObtenerTodosUsuarios.toString())
                    .setParameter("cedulaParam", cedulaParam)
                    .getResultList();
            if (result.size() == 0) { return null; }
            user = result.get(0);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

        return user;
    }

    @Transactional
    @Override
    public List<User> getAll() {
        String hqlObtenerTodosUsuarios = "FROM User as u";
        return (List<User>) entityManager.createQuery(hqlObtenerTodosUsuarios).getResultList();
    }

    @Transactional
    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User register(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public void delete(long id) {
        User usuarioEliminar = get(id);
        entityManager.remove(usuarioEliminar);
    }

    @Transactional
    @Override
    public User login(User dto) {
        boolean isAuthenticated = false;

        String hql = "FROM User as u WHERE u.password is not null and u.email = :email";

        List<User> result = entityManager.createQuery(hql.toString())
                .setParameter("email", dto.getEmail())
                .getResultList();
        if (result.size() == 0) { return null; }

        User user = result.get(0);
        isAuthenticated = true;

        if (!StringUtils.isEmpty(dto.getPassword())) {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            isAuthenticated = argon2.verify(user.getPassword(), dto.getPassword());
        }
        if (isAuthenticated) {
            return user;
        }
        return null;
    }
}
