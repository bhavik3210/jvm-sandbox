package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.TicketPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/* Below not used because Spring boot will produce below functionality automatically because there is JPA based repository */
@Repository
public class TicketPriceRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public TicketPrice create(TicketPrice tp) {
        entityManager.persist(tp);
        entityManager.flush();
        return tp;
    }

    public TicketPrice update(TicketPrice tp) {
        tp = entityManager.merge(tp);
        entityManager.flush();
        return tp;
    }

    public void delete(Long id) {
        entityManager.remove(find(id));
        entityManager.flush();
    }

    public TicketPrice find(Long id) {
        return entityManager.find(TicketPrice.class, id);
    }

    public List<TicketPrice> list() {
        return entityManager.createQuery("select t from TicketPrice t").getResultList();
    }
}
