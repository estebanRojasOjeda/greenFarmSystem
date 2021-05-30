package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycleEntity, Long> {

}
