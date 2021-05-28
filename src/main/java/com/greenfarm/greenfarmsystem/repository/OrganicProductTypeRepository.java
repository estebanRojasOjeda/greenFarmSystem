package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.OrganicProductTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganicProductTypeRepository extends JpaRepository<OrganicProductTypeEntity, Long> {

}
