package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputCategoryRepository extends JpaRepository<InputCategoryEntity, Long> {

}
