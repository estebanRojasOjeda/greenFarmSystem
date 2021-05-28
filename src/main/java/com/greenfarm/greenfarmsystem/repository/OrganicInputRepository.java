package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganicInputRepository extends JpaRepository<OrganicInputEntity, Long> {

}
