package com.sala.edu.co.SistemaSala.dao.imp;

import com.sala.edu.co.SistemaSala.dao.PermisoDao;
import com.sala.edu.co.SistemaSala.models.Permiso;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll() {
        String hqlObtenerTodosUsuarios = "FROM Permiso as p";
        return (List<Permiso>) entityManager.createQuery(hqlObtenerTodosUsuarios).getResultList();
    }

    @Transactional
    @Override
    public Permiso get(long id) {
        return entityManager.find(Permiso.class, id);
    }

    @Transactional
    @Override
    public Permiso register(Permiso Permiso) {
        entityManager.merge(Permiso);
        return Permiso;
    }

    @Transactional
    @Override
    public Permiso update(Permiso Permiso) {
        entityManager.merge(Permiso);
        return Permiso;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Permiso usuarioEliminar = get(id);
        entityManager.remove(usuarioEliminar);
    }
}
