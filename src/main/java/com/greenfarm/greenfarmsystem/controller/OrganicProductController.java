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
  public List<OrganicProductEntity> findAll() {
    return organicProductService.findAll();
  }

  @GetMapping("/{id}")
  public OrganicProductEntity findById(@PathVariable("id") Long id) {
    return organicProductService.findById(id);
  }

  @PostMapping
  public OrganicProductEntity save(
      @RequestBody @Valid OrganicProductEntity organicProductEntity) {
    return organicProductService.save(organicProductEntity);
  }

  @PutMapping
  public OrganicProductEntity update(
      @RequestBody OrganicProductEntity organicProductEntity) {
    return organicProductService.update(organicProductEntity);
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicProductService.delete(id);
    return "Organic product deleted!";
  }

}
