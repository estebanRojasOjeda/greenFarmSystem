package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicProductTypeEntity;
import com.greenfarm.greenfarmsystem.service.OrganicProductTypeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@RequestMapping("/gfs/production/organic-product-type")
public class OrganicProductTypeController {

  private OrganicProductTypeService organicProductTypeService;

  @Autowired
  public OrganicProductTypeController(
      OrganicProductTypeService organicProductTypeService) {
    this.organicProductTypeService = organicProductTypeService;
  }

  @ApiOperation(value = "Get all organic products",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Organic Product")
  @GetMapping
  public List<OrganicProductTypeEntity> findAll() {
    return organicProductTypeService.findAll();
  }


  @ApiOperation(value = "Find by id organic product type",
      notes = "this endpoint needs an organic product type id",
      response = List.class,
      responseContainer = "Organic Product Type")
  @GetMapping("/{id}")
  public OrganicProductTypeEntity findById(@PathVariable("id") Long id) throws Exception {
    return organicProductTypeService.findById(id);
  }

  @ApiOperation(value = "Save a new organic product type",
      notes = "this endpoint needs an organic product type object",
      response = List.class,
      responseContainer = "Organic Product Type")
  @PostMapping
  public OrganicProductTypeEntity save(
      @RequestBody @Valid OrganicProductTypeEntity organicProductTypeEntity) {
    return organicProductTypeService.save(organicProductTypeEntity);
  }

  @ApiOperation(value = "Update a organic product type",
      notes = "this endpoint needs an organic product type object",
      response = List.class,
      responseContainer = "Organic Product Type")
  @PutMapping
  public OrganicProductTypeEntity update(
      @RequestBody OrganicProductTypeEntity organicProductTypeEntity) {
    return organicProductTypeService.update(organicProductTypeEntity);
  }

  @ApiOperation(value = "Delete a organic product type",
      notes = "this endpoint needs an organic product type id",
      response = List.class,
      responseContainer = "Organic Product Type")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicProductTypeService.delete(id);
    return "Organic product type deleted!";
  }


}
