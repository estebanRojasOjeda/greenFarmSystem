package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import com.greenfarm.greenfarmsystem.repository.TechInputRepository;
import com.greenfarm.greenfarmsystem.service.TechInputService;
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
public class TechInputServiceImpl implements TechInputService {

  @Autowired
  private TechInputRepository techInputRepository;


  @Override
  public TechInputEntity findById(Long id) {
    Optional<TechInputEntity> optionalTechnoInputEntity = techInputRepository.findById(id);
    if(!optionalTechnoInputEntity.isPresent()){
      throw new BusinessException("", "Error de negocio", "Insumo Tecnologico no encontrado!: ");
    }
    return optionalTechnoInputEntity.get();
  }

  @Override
  public List<TechInputEntity> findAll() {
    return techInputRepository.findAll();
  }

  @Override
  public TechInputEntity save(TechInputEntity techInputEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<TechInputEntity>> violations = validator.validate(techInputEntity);
    if(!violations.isEmpty()){
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    TechInputEntity techInputEntity1 = techInputRepository.save(techInputEntity);
    return techInputEntity1;
  }

  @Override
  public TechInputEntity update(TechInputEntity techInputEntity) {
    return techInputRepository.save(techInputEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<TechInputEntity> optionalTechnoInputEntity = techInputRepository
        .findById(id);
    if (!optionalTechnoInputEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    techInputRepository.deleteById(id);
    return true;
  }
}
