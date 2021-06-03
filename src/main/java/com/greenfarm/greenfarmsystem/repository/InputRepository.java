package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.InputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<InputEntity, Long> {

}
