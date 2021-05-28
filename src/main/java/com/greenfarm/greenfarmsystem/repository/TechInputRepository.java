package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechInputRepository extends JpaRepository<TechInputEntity, Long> {

}
