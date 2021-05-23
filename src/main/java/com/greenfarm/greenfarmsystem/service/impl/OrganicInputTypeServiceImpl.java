package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicInputTypeRepository;
import com.greenfarm.greenfarmsystem.service.OrganicInputTypeService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrganicInputTypeServiceImpl implements OrganicInputTypeService {

  @Autowired
  private OrganicInputTypeRepository organicInputTypeRepository;

  @Override
  public OrganicInputTypeEntity findById(Long id) {
    Optional<OrganicInputTypeEntity> optionalOrganicInputTypeEntity = organicInputTypeRepository.findById(id);
    if(!optionalOrganicInputTypeEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Tipo de insumo organico no encontrado!: ");
    }
    return optionalOrganicInputTypeEntity.get();
  }

  @Override
  public List<OrganicInputTypeEntity> findAll() {
    return organicInputTypeRepository.findAll();
  }


  @Override
  public OrganicInputTypeEntity save(OrganicInputTypeEntity organicInputTypeEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<OrganicInputTypeEntity>> violations = validator.validate(organicInputTypeEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    OrganicInputTypeEntity organicInputTypeEntity1 = organicInputTypeRepository.save(organicInputTypeEntity);
    return organicInputTypeEntity1;

  }

  @Override
  public OrganicInputTypeEntity update(OrganicInputTypeEntity organicInputTypeEntity) {
    return organicInputTypeRepository.save(organicInputTypeEntity);
  }

  @Override
  public void delete(Long id) {
    organicInputTypeRepository.deleteById(id);
  }
}
