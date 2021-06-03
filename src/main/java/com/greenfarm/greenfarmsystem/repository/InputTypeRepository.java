package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.InputTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputTypeRepository extends JpaRepository<InputTypeEntity, Long> {

}
