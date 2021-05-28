package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import com.greenfarm.greenfarmsystem.model.OrganicProductTypeEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicProductRepository;
import com.greenfarm.greenfarmsystem.repository.OrganicProductTypeRepository;
import com.greenfarm.greenfarmsystem.service.OrganicProductService;
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
public class OrganicProductServiceImpl implements OrganicProductService {

  @Autowired
  private OrganicProductRepository organicProductRepository;

  @Override
  public OrganicProductEntity findById(Long id) {
    Optional<OrganicProductEntity> optionalOrganicProductEntity = organicProductRepository
        .findById(id);
    if (!optionalOrganicProductEntity.isPresent()) {
      throw new BusinessException("", "Error de negocio", "Producto organico no encontrado!: ");
    }
    return optionalOrganicProductEntity.get();
  }

  @Override
  public List<OrganicProductEntity> findAll() {
    return organicProductRepository.findAll();
  }

  @Override
  public OrganicProductEntity save(OrganicProductEntity organicProductEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<OrganicProductEntity>> violations = validator
        .validate(organicProductEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    OrganicProductEntity organicProductEntity1 = organicProductRepository
        .save(organicProductEntity);
    return organicProductEntity1;
  }

  @Override
  public OrganicProductEntity update(OrganicProductEntity organicProductEntity) {
    return organicProductRepository.save(organicProductEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<OrganicProductEntity> optionalOrganicProductEntity = organicProductRepository
        .findById(id);
    if (!optionalOrganicProductEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    organicProductRepository.deleteById(id);
    return true;
  }
}
