package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganicInputTypeRepository extends JpaRepository<OrganicInputTypeEntity, Long> {

}
