package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicInputRepository;
import com.greenfarm.greenfarmsystem.service.OrganicInputService;
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
public class OrganicInputServiceImpl implements OrganicInputService {

  @Autowired
  private OrganicInputRepository organicInputRepository;

  @Override
  public OrganicInputEntity findById(Long id) throws Exception{
    Optional<OrganicInputEntity> optionalOrganicInputEntity = organicInputRepository.findById(id);
    if(!optionalOrganicInputEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Insumo organico no encontrado!: ");
    }
    return optionalOrganicInputEntity.get();
  }



  @Override
  public List<OrganicInputEntity> findAll() {
    return organicInputRepository.findAll();
  }

  @Override
  public OrganicInputEntity save(OrganicInputEntity organicInputEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<OrganicInputEntity>> violations = validator.validate(organicInputEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    OrganicInputEntity organicInputEntity1 = organicInputRepository.save(organicInputEntity);
    return organicInputEntity1;
  }

  @Override
  public OrganicInputEntity update(OrganicInputEntity organicInputEntity) {
    return organicInputRepository.save(organicInputEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception{

    Optional<OrganicInputEntity> optionalOrganicInputEntity = organicInputRepository
        .findById(id);
    if (!optionalOrganicInputEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    organicInputRepository.deleteById(id);
    return true;
  }

}

