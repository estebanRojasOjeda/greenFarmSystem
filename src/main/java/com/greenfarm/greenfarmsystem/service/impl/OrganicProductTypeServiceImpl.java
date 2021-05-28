package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicProductTypeEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicProductTypeRepository;
import com.greenfarm.greenfarmsystem.service.OrganicProductTypeService;
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
public class OrganicProductTypeServiceImpl implements OrganicProductTypeService {

  @Autowired
  private OrganicProductTypeRepository organicProductTypeRepository;


  @Override
  public OrganicProductTypeEntity findById(Long id) {
    Optional<OrganicProductTypeEntity> optionalOrganicProductTypeEntity = organicProductTypeRepository
        .findById(id);
    if (!optionalOrganicProductTypeEntity.isPresent()) {
      throw new BusinessException("", "Error de negocio", "Tipo de producto organico no encontrado!: ");
    }
    return optionalOrganicProductTypeEntity.get();
  }

  @Override
  public List<OrganicProductTypeEntity> findAll() {
    return organicProductTypeRepository.findAll();
  }

  @Override
  public OrganicProductTypeEntity save(OrganicProductTypeEntity organicProductTypeEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<OrganicProductTypeEntity>> violations = validator
        .validate(organicProductTypeEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    OrganicProductTypeEntity organicProductTypeEntity1 = organicProductTypeRepository
        .save(organicProductTypeEntity);
    return organicProductTypeEntity1;
  }

  @Override
  public OrganicProductTypeEntity update(OrganicProductTypeEntity organicProductTypeEntity) {
    return organicProductTypeRepository.save(organicProductTypeEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<OrganicProductTypeEntity> optionalOrganicProductTypeEntity = organicProductTypeRepository
        .findById(id);
    if (!optionalOrganicProductTypeEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    organicProductTypeRepository.deleteById(id);
    return true;
  }
}
