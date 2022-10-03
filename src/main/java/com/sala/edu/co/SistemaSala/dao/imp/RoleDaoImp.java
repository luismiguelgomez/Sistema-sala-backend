package com.sala.edu.co.SistemaSala.dao.imp;

import com.sala.edu.co.SistemaSala.dao.RoleDao;
import com.sala.edu.co.SistemaSala.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll() {
        String hqlObtenerTodosUsuarios = "FROM Role as r";
        return (List<Role>) entityManager.createQuery(hqlObtenerTodosUsuarios).getResultList();
    }

    @Transactional
    @Override
    public Role get(long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    @Override
    public Role register(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public Role update(Role role) {
        entityManager.merge(role);
        return role;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Role usuarioEliminar = get(id);
        entityManager.remove(usuarioEliminar);
    }
}
