package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/* Below not used because Spring boot will produce below functionality automatically because there is JPA based repository */
@Repository
public class SessionRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    public Session create(Session session) {
        entityManager.persist(session);
        entityManager.flush();
        return session;
    }

    public Session update(Session session) {
        session = entityManager.merge(session);
        entityManager.flush();
        return session;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public Session find(Long id) {
        return entityManager.find(Session.class, id);
    }

    public List<Session> list() {
        return entityManager.createQuery("select s from Session s").getResultList();
    }

    public List<Session> getSessionsThatHaveName(String name) {
//        List<Session> ses = entityManager
//                .createQuery("select s from Session s where s.sessionName like :name")
//                .setParameter("name", "%" + name + "%").getResultList();
//        return ses;
        return sessionJpaRepository.findBySessionNameContains(name);
    }
}
