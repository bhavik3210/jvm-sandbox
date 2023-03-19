package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.PricingCategory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/* Below not used because Spring boot will produce below functionality automatically because there is JPA based repository */
@Repository
public class PricingCategoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public PricingCategory find(String id) {
        return entityManager.find(PricingCategory.class, id);
    }
}
