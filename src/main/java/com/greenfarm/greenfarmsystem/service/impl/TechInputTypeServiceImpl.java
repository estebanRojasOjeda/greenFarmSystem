package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import com.greenfarm.greenfarmsystem.model.TechInputTypeEntity;
import com.greenfarm.greenfarmsystem.repository.TechInputRepository;
import com.greenfarm.greenfarmsystem.repository.TechInputTypeRepository;
import com.greenfarm.greenfarmsystem.service.TechInputTypeService;
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
public class TechInputTypeServiceImpl implements TechInputTypeService {

  @Autowired
  private TechInputTypeRepository techInputTypeRepository;

  @Override
  public TechInputTypeEntity findById(Long id) {
    Optional<TechInputTypeEntity> optionalTechInputTypeEntity = techInputTypeRepository.findById(id);
    if(!optionalTechInputTypeEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Typo de Insumo Tecnologico no encontrado! ");
    }
    return optionalTechInputTypeEntity.get();
  }

  @Override
  public List<TechInputTypeEntity> findAll() { return techInputTypeRepository.findAll(); }

  @Override
  public TechInputTypeEntity save(TechInputTypeEntity techInputTypeEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<TechInputTypeEntity>> violations = validator.validate(techInputTypeEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    TechInputTypeEntity techInputTypeEntity1 = techInputTypeRepository.save(techInputTypeEntity);
    return techInputTypeEntity1;
  }

  @Override
  public TechInputTypeEntity update(TechInputTypeEntity techInputTypeEntity) {
    return techInputTypeRepository.save(techInputTypeEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<TechInputTypeEntity> optionalTechInputTypeEntity = techInputTypeRepository
        .findById(id);
    if (!optionalTechInputTypeEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    techInputTypeRepository.deleteById(id);
    return true;
  }
}
