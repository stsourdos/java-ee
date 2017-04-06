package com.tsourdos.javaee7restfulapi.repo;

import com.tsourdos.javaee7restfulapi.model.SuperUser;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class JpaUserRepository implements UserRepository, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void delete(SuperUser user) {
        entityManager.remove(user);
    }

    @Override
    public SuperUser find(int id) {

        return entityManager.createNamedQuery("SuperUser.findById", SuperUser.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<SuperUser> findAll() {
        return entityManager.createNamedQuery("SuperUser.findAll", SuperUser.class)
                .getResultList();
    }

    @Override
    public void save(SuperUser user) {
        entityManager.persist(user);
    }

}
