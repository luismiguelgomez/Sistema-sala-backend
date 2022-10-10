package com.sala.edu.co.SistemaSala.dao.imp;


import com.sala.edu.co.SistemaSala.dao.EstadoUsuarioDao;
import com.sala.edu.co.SistemaSala.models.EstadoUsuario;
import com.sala.edu.co.SistemaSala.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class EstadoUsuarioDaoImp implements EstadoUsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<EstadoUsuario> getAll() {
        String hqlObtenerTodosUsuarios = "FROM EstadoUsuario as e";
        return (List<EstadoUsuario>) entityManager.createQuery(hqlObtenerTodosUsuarios).getResultList();
    }

    @Transactional
    @Override
    public EstadoUsuario get(long id) {
        return entityManager.find(EstadoUsuario.class, id);
    }

    @Transactional
    @Override
    public EstadoUsuario register(EstadoUsuario estadoUsuario) {
        entityManager.merge(estadoUsuario);
        return estadoUsuario;
    }

    @Transactional
    @Override
    public EstadoUsuario update(EstadoUsuario estadoUsuario) {
        entityManager.merge(estadoUsuario);
        return estadoUsuario;
    }

    @Transactional
    @Override
    public void delete(long id) {
        EstadoUsuario estadoAeliinar = get(id);
        entityManager.remove(estadoAeliinar);
    }
}
