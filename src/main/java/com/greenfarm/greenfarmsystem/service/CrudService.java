package com.greenfarm.greenfarmsystem.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

public interface CrudService<T> {

  T findById(Long id) throws Exception;

  List<T> findAll();

  T save(T t);

  T update(T t);

  boolean delete(Long id) throws Exception;

}
