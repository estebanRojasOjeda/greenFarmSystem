package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.UserEntity;
import com.greenfarm.greenfarmsystem.repository.UserRepository;
import com.greenfarm.greenfarmsystem.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserEntity findById(Long id) throws Exception {
    return null;
  }

  @Override
  public List<UserEntity> findAll() {
    return null;
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    return null;
  }

  @Override
  public UserEntity update(UserEntity userEntity) {
    return null;
  }

  @Override
  public boolean delete(Long id) throws Exception {
    return false;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findOneByUsername(username);
    if(userEntity == null) {
      throw new UsernameNotFoundException(String.format("Usuario no existe", username));
    }
    List<GrantedAuthority> roles = new ArrayList<>();
    userEntity.getRolEntityList().forEach(rol -> {
      roles.add(new SimpleGrantedAuthority(rol.getRolName()));
    });
    UserDetails ud = new User(userEntity.getUsername()  , userEntity.getPassword(), roles);
    return ud;
  }
}
