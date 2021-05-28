package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.TechInputTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechInputTypeRepository extends JpaRepository<TechInputTypeEntity, Long> {

}
