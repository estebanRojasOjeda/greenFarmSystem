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

  @ApiOperation(value = "Get all organic inputs",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Organic Input")
  @ApiResponses(value = {
      @ApiResponse(code = 400, message = "Bad request or data not sent correctly"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 405, message = "No organic input were found in the BD"),
      @ApiResponse(code = 200, message = "OK")})
  @GetMapping
  public List<OrganicProductTypeEntity> findAll() {
    return organicProductTypeService.findAll();
  }

  @GetMapping("/{id}")
  public OrganicProductTypeEntity findById(@PathVariable("id") Long id) {
    return organicProductTypeService.findById(id);
  }

  @PostMapping
  public OrganicProductTypeEntity save(
      @RequestBody @Valid OrganicProductTypeEntity organicProductTypeEntity) {
    return organicProductTypeService.save(organicProductTypeEntity);
  }

  @PutMapping
  public OrganicProductTypeEntity update(
      @RequestBody OrganicProductTypeEntity organicProductTypeEntity) {
    return organicProductTypeService.update(organicProductTypeEntity);
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicProductTypeService.delete(id);
    return "Organic product type deleted!";
  }


}
