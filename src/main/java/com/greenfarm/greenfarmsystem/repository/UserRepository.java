package com.greenfarm.greenfarmsystem.repository;

import com.greenfarm.greenfarmsystem.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findOneByUserName(String username);
}
