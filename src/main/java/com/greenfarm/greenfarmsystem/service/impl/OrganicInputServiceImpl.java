package com.greenfarm.greenfarmsystem.service.impl;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.repository.OrganicInputRepository;
import com.greenfarm.greenfarmsystem.service.OrganicInputService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganicInputServiceImpl implements OrganicInputService {

  @Autowired
  private OrganicInputRepository organicInputRepository;

  @Override
  public OrganicInputEntity findById(Long id) {
    Optional<OrganicInputEntity> optionalOrganicInputEntity = organicInputRepository.findById(id);
    return optionalOrganicInputEntity.isPresent()?optionalOrganicInputEntity.get(): new OrganicInputEntity();
  }

  @Override
  public List<OrganicInputEntity> findAll() {
    return organicInputRepository.findAll();
  }

  @Override
  public OrganicInputEntity save(OrganicInputEntity organicInputEntity) {
    return organicInputRepository.save(organicInputEntity);
  }

  @Override
  public OrganicInputEntity update(OrganicInputEntity organicInputEntity) {
    return organicInputRepository.save(organicInputEntity);
  }

  @Override
  public void delete(Long id) {
    organicInputRepository.deleteById(id);
  }
}
