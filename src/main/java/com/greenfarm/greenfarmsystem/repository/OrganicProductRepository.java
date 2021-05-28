package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganicProductRepository extends JpaRepository<OrganicProductEntity, Long> {

}
