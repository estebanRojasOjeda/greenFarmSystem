package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.dto.ProductiveCycleDto;
import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicInputRepository;
import com.greenfarm.greenfarmsystem.repository.ProductiveCycleRepository;
import com.greenfarm.greenfarmsystem.repository.TechInputRepository;
import com.greenfarm.greenfarmsystem.service.OrganicInputService;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import com.greenfarm.greenfarmsystem.service.TechInputService;
import java.util.ArrayList;
import java.util.List;
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

  @Autowired
  private OrganicInputRepository organicInputRepository;

  @Autowired
  private TechInputRepository techInputRepository;

  @Autowired
  private OrganicInputService organicInputService;

  @Autowired
  private TechInputService techInputService;


  @Override
  public ProductiveCycleEntity findById(Long id) {
    return null;
  }

  @Override
  public List<ProductiveCycleEntity> findAll() {
    return null;
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
    return null;
  }

  @Override
  public boolean delete(Long id) throws Exception {
    return false;
  }

  @Override
  public List<ProductiveCycleDto> getProductiveCycleDTO() throws Exception {

    List<ProductiveCycleEntity> productiveCycleEntityList = productiveCycleRepository.findAll();
    List<ProductiveCycleDto> productiveCycleDtos = new ArrayList<>();

    productiveCycleEntityList.forEach(prodCycle -> {
      try {
        ProductiveCycleDto dto = new ProductiveCycleDto();
        ProductiveCycleDto prodCycleDto = new ProductiveCycleDto();

        OrganicInputEntity organicInputEntity = organicInputService
            .findById(prodCycle.getOrganicInputEntity().getId());
        TechInputEntity techInputEntity = techInputService
            .findById(prodCycle.getTechInputEntity().getId());

        dto.setStartDate(prodCycle.getStartDate());
        dto.setEndDate(prodCycle.getEndDate());
        dto.setOrganicInputEntity(organicInputEntity);
        dto.setTechInputEntity(techInputEntity);
        dto.setTemperature(prodCycle.getTemperature());
        dto.setHumidity(prodCycle.getHumidity());
        dto.setComments(prodCycle.getComments());

        productiveCycleDtos.add(dto);

      } catch (Exception e) {
        System.out.println("Error" + e.getMessage());
      }

    });

    return productiveCycleDtos;

  }
}
