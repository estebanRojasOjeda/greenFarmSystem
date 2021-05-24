package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.TechnoInputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnoInputRepository extends JpaRepository<TechnoInputEntity, Long> {

}
