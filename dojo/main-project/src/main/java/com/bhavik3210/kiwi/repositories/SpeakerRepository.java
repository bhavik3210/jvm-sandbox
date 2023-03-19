package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.Speaker;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/* Below not used because Spring boot will produce below functionality automatically because there is JPA based repository */
@Repository
public class SpeakerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Speaker create(Speaker speaker) {
        entityManager.persist(speaker);
        entityManager.flush();
        return speaker;
    }

    public Speaker update(Speaker speaker) {
        speaker = entityManager.merge(speaker);
        entityManager.flush();
        return speaker;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public Speaker find(Long id) {
        return entityManager.find(Speaker.class, id);
    }

    public List<Speaker> list() {
        return entityManager.createQuery("select s from Speaker s").getResultList();
    }
}
