package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import com.greenfarm.greenfarmsystem.service.OrganicProductService;
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
@RequestMapping("/gfs/production/organic-product")
public class OrganicProductController {

  private OrganicProductService organicProductService;

  @Autowired
  public OrganicProductController(
      OrganicProductService organicProductService) {
    this.organicProductService = organicProductService;
  }

  @ApiOperation(value = "Get all organic products",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Organic Products List")
  @GetMapping
  public List<OrganicProductEntity> findAll() {
    return organicProductService.findAll();
  }

  @ApiOperation(value = "find by id a organic product",
      notes = "Needs a organic product id",
      response = List.class,
      responseContainer = "Organic Product")
  @GetMapping("/{id}")
  public OrganicProductEntity findById(@PathVariable("id") Long id) throws Exception {
    return organicProductService.findById(id);
  }

  @ApiOperation(value = "Save a new organic product",
      notes = "Needs a organic product object",
      response = List.class,
      responseContainer = "New Organic Product")
  @PostMapping
  public OrganicProductEntity save(
      @RequestBody @Valid OrganicProductEntity organicProductEntity) {
    return organicProductService.save(organicProductEntity);
  }

  @ApiOperation(value = "Update a organic product",
      notes = "Needs a organic product object",
      response = List.class,
      responseContainer = "Update Organic Products")
  @PutMapping
  public OrganicProductEntity update(
      @RequestBody OrganicProductEntity organicProductEntity) {
    return organicProductService.update(organicProductEntity);
  }

  @ApiOperation(value = "Delete a organic product",
      notes = "Needs a organic product id",
      response = List.class,
      responseContainer = "Delete Organic Products")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicProductService.delete(id);
    return "Organic product deleted!";
  }

}
