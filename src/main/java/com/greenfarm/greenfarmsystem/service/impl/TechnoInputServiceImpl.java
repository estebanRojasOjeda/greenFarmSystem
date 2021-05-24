package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.TechnoInputEntity;
import com.greenfarm.greenfarmsystem.repository.TechnoInputRepository;
import com.greenfarm.greenfarmsystem.service.TechnoInputService;
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
public class TechnoInputServiceImpl implements TechnoInputService {

  @Autowired
  private TechnoInputRepository technoInputRepository;


  @Override
  public TechnoInputEntity findById(Long id) {
    Optional<TechnoInputEntity> optionalTechnoInputEntity = technoInputRepository.findById(id);
    if(!optionalTechnoInputEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Insumo Tecnologico no encontrado!: ");
    }
    return optionalTechnoInputEntity.get();
  }

  @Override
  public List<TechnoInputEntity> findAll() {
    return technoInputRepository.findAll();
  }

  @Override
  public TechnoInputEntity save(TechnoInputEntity technoInputEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<TechnoInputEntity>> violations = validator.validate(technoInputEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    TechnoInputEntity technoInputEntity1 = technoInputRepository.save(technoInputEntity);
    return technoInputEntity1;
  }

  @Override
  public TechnoInputEntity update(TechnoInputEntity technoInputEntity) {
    return technoInputRepository.save(technoInputEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<TechnoInputEntity> optionalTechnoInputEntity = technoInputRepository
        .findById(id);
    if (!optionalTechnoInputEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    technoInputRepository.deleteById(id);
    return true;
  }
}
