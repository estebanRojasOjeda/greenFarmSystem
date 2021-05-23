package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicInputTypeRepository;
import com.greenfarm.greenfarmsystem.service.OrganicInputTypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganicInputTypeServiceImpl implements OrganicInputTypeService {

  @Autowired
  private OrganicInputTypeRepository organicInputTypeRepository;

  @Override
  public OrganicInputTypeEntity findById(Long id) {
    Optional<OrganicInputTypeEntity> optionalOrganicInputTypeEntity = organicInputTypeRepository.findById(id);
    return optionalOrganicInputTypeEntity.isPresent()?optionalOrganicInputTypeEntity.get(): new OrganicInputTypeEntity();
  }

  @Override
  public List<OrganicInputTypeEntity> findAll() {
    return organicInputTypeRepository.findAll();
  }

  @Override
  public OrganicInputTypeEntity save(OrganicInputTypeEntity organicInputTypeEntity) {
    return organicInputTypeRepository.save(organicInputTypeEntity);
  }

  @Override
  public OrganicInputTypeEntity update(OrganicInputTypeEntity organicInputTypeEntity) {
    return organicInputTypeRepository.save(organicInputTypeEntity);
  }

  @Override
  public void delete(Long id) {
    organicInputTypeRepository.deleteById(id);
  }
}
