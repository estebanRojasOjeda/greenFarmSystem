package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.exception.ExceptionNotFoundModel;
import com.greenfarm.greenfarmsystem.model.InputTypeEntity;
import com.greenfarm.greenfarmsystem.repository.InputTypeRepository;
import com.greenfarm.greenfarmsystem.service.InputTypeService;
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
public class InputTypeServiceImpl implements InputTypeService {

  @Autowired
  private InputTypeRepository inputTypeRepository;

  @Override
  public InputTypeEntity findById(Long id) {
    Optional<InputTypeEntity> optionalOrganicInputTypeEntity = inputTypeRepository
        .findById(id);
    if (!optionalOrganicInputTypeEntity.isPresent()) {
      throw new ExceptionNotFoundModel("TIPO DE INSUMO NO ENCONTRADO!, ID: " + id);
    }
    return optionalOrganicInputTypeEntity.get();
  }

  @Override
  public List<InputTypeEntity> findAll() {
    return inputTypeRepository.findAll();
  }


  @Override
  public InputTypeEntity save(InputTypeEntity inputTypeEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<InputTypeEntity>> violations = validator
        .validate(inputTypeEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    InputTypeEntity inputTypeEntity1 = inputTypeRepository
        .save(inputTypeEntity);
    return inputTypeEntity1;

  }

  @Override
  public InputTypeEntity update(InputTypeEntity inputTypeEntity) {
    return inputTypeRepository.save(inputTypeEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<InputTypeEntity> optionalOrganicInputTypeEntity = inputTypeRepository
        .findById(id);
    if (!optionalOrganicInputTypeEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    inputTypeRepository.deleteById(id);
    return true;
  }
}
