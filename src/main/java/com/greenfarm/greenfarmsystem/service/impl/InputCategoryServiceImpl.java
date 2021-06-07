package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.exception.ExceptionNotFoundModel;
import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.repository.InputCategoryRepository;
import com.greenfarm.greenfarmsystem.service.InputCategoryService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputCategoryServiceImpl implements InputCategoryService {

  @Autowired
  private InputCategoryRepository inputCategoryRepository;

  public InputCategoryServiceImpl(
      InputCategoryRepository inputCategoryRepository) {
    this.inputCategoryRepository = inputCategoryRepository;
  }


  @Override
  public InputCategoryEntity findById(Long id) throws Exception {
    Optional<InputCategoryEntity> inputCategoryEntity = inputCategoryRepository
        .findById(id);
    if (!inputCategoryEntity.isPresent()) {
      throw new ExceptionNotFoundModel("CATEGORIA DE INSUMO NO ENCONTRADO!, ID: " + id);
    }
    return inputCategoryEntity.get();
  }

  @Override
  public List<InputCategoryEntity> findAll() {
    return inputCategoryRepository.findAll();
  }

  @Override
  public InputCategoryEntity save(InputCategoryEntity inputCategoryEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<InputCategoryEntity>> violations = validator
        .validate(inputCategoryEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    InputCategoryEntity inputCategoryEntity1 = inputCategoryRepository
        .save(inputCategoryEntity);
    return inputCategoryEntity1;
  }

  @Override
  public InputCategoryEntity update(InputCategoryEntity inputCategoryEntity) {
    return inputCategoryRepository.save(inputCategoryEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<InputCategoryEntity> optionalInputCategoryEntity = inputCategoryRepository
        .findById(id);
    if (!optionalInputCategoryEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    inputCategoryRepository.deleteById(id);
    return true;
  }
}
