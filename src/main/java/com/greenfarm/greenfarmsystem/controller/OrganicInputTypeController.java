package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import com.greenfarm.greenfarmsystem.service.OrganicInputTypeService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/organic-input-type")
public class OrganicInputTypeController {

  private OrganicInputTypeService organicInputTypeService;

  @Autowired
  public OrganicInputTypeController(
      OrganicInputTypeService organicInputTypeService) {
    this.organicInputTypeService = organicInputTypeService;
  }

  @ApiOperation(value = "Get all organic inputs types",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Organic Input Type")
  @GetMapping
  public List<OrganicInputTypeEntity> findAll() {
    return organicInputTypeService.findAll();
  }

  @ApiOperation(value = "Find by id organic input type",
      notes = "this endpoint needs an organic input type id",
      response = List.class,
      responseContainer = "Organic Input Type")
  @GetMapping("/{id}")
  public OrganicInputTypeEntity findById(@PathVariable("id") Long id) throws Exception {
    return organicInputTypeService.findById(id);
  }

  @ApiOperation(value = "Save a new organic input type",
      notes = "this endpoint needs an organic input type object",
      response = List.class,
      responseContainer = "Organic Input Type")
  @PostMapping
  public OrganicInputTypeEntity save(
      @RequestBody @Valid OrganicInputTypeEntity organicInputTypeEntity) {
    return organicInputTypeService.save(organicInputTypeEntity);
  }

  @ApiOperation(value = "Update a organic input type",
      notes = "this endpoint needs an organic input type object",
      response = List.class,
      responseContainer = "Organic Input Type")
  @PutMapping
  public OrganicInputTypeEntity update(@RequestBody OrganicInputTypeEntity organicInputTypeEntity) {
    return organicInputTypeService.update(organicInputTypeEntity);
  }

  @ApiOperation(value = "Delete a organic input type",
      notes = "this endpoint needs an organic input type id",
      response = List.class,
      responseContainer = "Organic Input Type")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicInputTypeService.delete(id);
    return "Organic input type deleted!";
  }

}
