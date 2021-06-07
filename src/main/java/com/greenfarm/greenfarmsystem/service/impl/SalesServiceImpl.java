package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.dto.SalesRequestDto;
import com.greenfarm.greenfarmsystem.model.SalesEntity;
import com.greenfarm.greenfarmsystem.repository.SalesOrganicProductRepository;
import com.greenfarm.greenfarmsystem.repository.SalesRepository;
import com.greenfarm.greenfarmsystem.service.SalesService;
import corp.sche.trmg.commons.exception.BusinessException;
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
public class SalesServiceImpl implements SalesService {

  @Autowired
  private SalesRepository salesRepository;

  @Autowired
  private SalesOrganicProductRepository salesOrganicProductRepository;

  public SalesServiceImpl(SalesRepository salesRepository,
      SalesOrganicProductRepository salesOrganicProductRepository) {
    this.salesRepository = salesRepository;
    this.salesOrganicProductRepository = salesOrganicProductRepository;
  }


  @Override
  public SalesEntity findById(Long id) throws Exception {
    Optional<SalesEntity> optionalSalesEntity = salesRepository
        .findById(id);
    if (!optionalSalesEntity.isPresent()) {
      throw new BusinessException("", "Error de negocio", "Venta no encontrada!: ");
    }
    return optionalSalesEntity.get();
  }

  @Override
  public List<SalesEntity> findAll() {
    return salesRepository.findAll();
  }

  @Override
  public SalesEntity save(SalesEntity salesEntity) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    Set<ConstraintViolation<SalesEntity>> violations = validator
        .validate(salesEntity);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    SalesEntity salesEntity1 = salesRepository
        .save(salesEntity);
    return salesEntity1;
  }

  @Override
  public SalesEntity update(SalesEntity salesEntity) {
    return salesRepository.save(salesEntity);
  }

  @Override
  public boolean delete(Long id) throws Exception {
    Optional<SalesEntity> optionalSalesEntity = salesRepository
        .findById(id);
    if (!optionalSalesEntity.isPresent()) {
      throw new Exception("ID NO ENCONTRADO: " + id);
    }
    salesRepository.deleteById(id);
    return true;
  }

  @Transactional
  @Override
  public SalesEntity saveSales(SalesRequestDto salesRequestDto) {
    salesRepository.save(salesRequestDto.getSalesEntity());

    salesRequestDto.getOrganicProduct()
        .forEach(orgProductId -> salesOrganicProductRepository.registrar(
            salesRequestDto.getSalesEntity().getSalesId(), orgProductId, salesRequestDto.getPrice()));
    return salesRequestDto.getSalesEntity();
  }
}
