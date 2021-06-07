package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.repository.InputRepository;
import com.greenfarm.greenfarmsystem.service.InputService;
import corp.sche.trmg.commons.exception.BusinessException;
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
public class InputServiceImpl implements InputService {

  @Autowired
  private InputRepository inputRepository;

  @Override
  public InputEntity findById(Long id) throws Exception{
    Optional<InputEntity> optionalOrganicInputEntity = inputRepository.findById(id);
    if(!optionalOrganicInputEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Insumo no encontrado!: ");
    }
    return optionalOrganicInputEntity.get();
  }



  @Override
  public List<InputEntity> findAll() {
    return inputRepository.findAll();
  }

  @Override
  public InputEntity save(InputEntity inputEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<InputEntity>> violations = validator.validate(inputEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<UserEntity> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    InputEntity inputEntity1 = inputRepository.save(inputEntity);
    return inputEntity1;
  }

  @Override
  public InputEntity update(InputEntity inputEntity) {
    return inputRepository.save(inputEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception{

    Optional<InputEntity> optionalOrganicInputEntity = inputRepository
        .findById(id);
    if (!optionalOrganicInputEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    inputRepository.deleteById(id);
    return true;
  }

}

