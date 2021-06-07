package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.dto.ProductionRequestDto;
import com.greenfarm.greenfarmsystem.dto.ProductiveCycleRequestDto;
import com.greenfarm.greenfarmsystem.exception.ExceptionNotFoundModel;
import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.repository.InputRepository;
import com.greenfarm.greenfarmsystem.repository.ProductiveCycleInputRepository;
import com.greenfarm.greenfarmsystem.repository.ProductiveCycleOrganicProductRepository;
import com.greenfarm.greenfarmsystem.repository.ProductiveCycleRepository;
import com.greenfarm.greenfarmsystem.service.InputService;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
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
  private ProductiveCycleInputRepository productiveCycleInputRepository;

  @Autowired
  private ProductiveCycleOrganicProductRepository productiveCycleOrganicProductRepository;

  public ProductiveCycleServiceImpl(
      ProductiveCycleRepository productiveCycleRepository,
      ProductiveCycleInputRepository productiveCycleInputRepository,
      ProductiveCycleOrganicProductRepository productiveCycleOrganicProductRepository) {
    this.productiveCycleRepository = productiveCycleRepository;
    this.productiveCycleInputRepository = productiveCycleInputRepository;
    this.productiveCycleOrganicProductRepository = productiveCycleOrganicProductRepository;
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

  @Transactional
  @Override
  public ProductiveCycleEntity saveProdCycleDetail(ProductiveCycleRequestDto productiveCycleRequestDto) {

    productiveCycleRepository.save(productiveCycleRequestDto.getProductiveCycleEntity());

    productiveCycleRequestDto.getInputIds().forEach(inputId -> productiveCycleInputRepository.registrar(
        productiveCycleRequestDto.getProductiveCycleEntity().getProductiveCycleId(), inputId));
    return productiveCycleRequestDto.getProductiveCycleEntity();
  }

  @Transactional
  @Override
  public ProductiveCycleEntity saveProduction(ProductionRequestDto productionRequestDto) {

    productiveCycleRepository.save(productionRequestDto.getProductiveCycleEntity());

    productionRequestDto.getOrganicProductIds().forEach(orgProductId -> productiveCycleOrganicProductRepository.registrar(
        productionRequestDto.getProductiveCycleEntity().getProductiveCycleId(), orgProductId, productionRequestDto.getAmount()));
    return productionRequestDto.getProductiveCycleEntity();
  }


}
