package com.bhavik3210.kiwi.repositories;

import com.bhavik3210.kiwi.models.PricingCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingCategoryJpaRepository extends JpaRepository<PricingCategory, String> {
}
