package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.exception.ExceptionNotFoundModel;
import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.repository.InputRepository;
import com.greenfarm.greenfarmsystem.repository.ProductiveCycleRepository;
import com.greenfarm.greenfarmsystem.service.InputService;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import java.util.ArrayList;
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
public class ProductiveCycleServiceImpl implements ProductiveCycleService {

  @Autowired
  private ProductiveCycleRepository productiveCycleRepository;

  public ProductiveCycleServiceImpl(
      ProductiveCycleRepository productiveCycleRepository) {
    this.productiveCycleRepository = productiveCycleRepository;
  }


  @Override
  public ProductiveCycleEntity findById(Long id) {
    Optional<ProductiveCycleEntity> productiveCycleEntity = productiveCycleRepository
        .findById(id);
    if (!productiveCycleEntity.isPresent()) {
      throw new ExceptionNotFoundModel("CICLO PRODUCTIVO NO ENCONTRADO!, ID: " + id);
    }
    return productiveCycleEntity.get();
  }

  @Override
  public List<ProductiveCycleEntity> findAll() {
    return productiveCycleRepository.findAll();
  }

  @Override
  public ProductiveCycleEntity save(ProductiveCycleEntity productiveCycleEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<ProductiveCycleEntity>> violations = validator
        .validate(productiveCycleEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
        /*
        * for (ConstraintViolation<User> violation : violations) {
            log.error(violation.getMessage());
        }
        * */
    ProductiveCycleEntity productiveCycleEntity1 = productiveCycleRepository
        .save(productiveCycleEntity);
    return productiveCycleEntity1;
  }

  @Override
  public ProductiveCycleEntity update(ProductiveCycleEntity productiveCycleEntity) {
    return productiveCycleRepository.save(productiveCycleEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<ProductiveCycleEntity> optionalProductiveCycleEntity = productiveCycleRepository
        .findById(id);
    if (!optionalProductiveCycleEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    productiveCycleRepository.deleteById(id);
    return true;
  }

//  @Override
//  public List<ProductiveCycleDto> getProductiveCycleDTO() throws Exception {
//
//    List<ProductiveCycleEntity> productiveCycleEntityList = productiveCycleRepository.findAll();
//    List<ProductiveCycleDto> productiveCycleDtos = new ArrayList<>();
//
//    productiveCycleEntityList.forEach(prodCycle -> {
//      try {
//        ProductiveCycleDto dto = new ProductiveCycleDto();
//        ProductiveCycleDto prodCycleDto = new ProductiveCycleDto();
//
//        InputEntity inputEntity = inputService
//            .findById(prodCycle.getInputEntity().getId());
//        TechInputEntity techInputEntity = techInputService
//            .findById(prodCycle.getTechInputEntity().getId());
//
//        dto.setStartDate(prodCycle.getStartDate());
//        dto.setEndDate(prodCycle.getEndDate());
//        dto.setInputEntity(inputEntity);
//        dto.setTechInputEntity(techInputEntity);
//        dto.setTemperature(prodCycle.getTemperature());
//        dto.setHumidity(prodCycle.getHumidity());
//        dto.setComments(prodCycle.getComments());
//
//        productiveCycleDtos.add(dto);
//
//      } catch (Exception e) {
//        System.out.println("Error" + e.getMessage());
//      }
//
//    });
//
//    return productiveCycleDtos;
//
//  }
}
