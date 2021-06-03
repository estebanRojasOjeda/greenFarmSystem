package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/productive-cycle")
public class ProductiveCycleController {

  private ProductiveCycleService productiveCycleService;

  public ProductiveCycleController(
      ProductiveCycleService productiveCycleService) {
    this.productiveCycleService = productiveCycleService;
  }

  @ApiOperation(value = "Get all productive cycles categories",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "productive cycle")
  @GetMapping
  public List<ProductiveCycleEntity> findAll() {
    return productiveCycleService.findAll();
  }

  @ApiOperation(value = "Find by id  productive cycles",
      notes = "this endpoint needs an productive cycles id",
      response = List.class,
      responseContainer = "productive cycle")
  @GetMapping("/{id}")
  public ProductiveCycleEntity findById(@PathVariable("id") Long id) throws Exception {
    return productiveCycleService.findById(id);
  }

  @ApiOperation(value = "Save productive cycle",
      notes = "this endpoint needs an productive cycle object",
      response = List.class,
      responseContainer = "productive cycle")
  @RequestMapping(method = RequestMethod.POST)
  public ProductiveCycleEntity save(@RequestBody ProductiveCycleEntity productiveCycleEntity){
    return productiveCycleService.save(productiveCycleEntity);
  }

  @ApiOperation(value = "Update a  productive cycle",
      notes = "this endpoint needs an  productive cycle object",
      response = List.class,
      responseContainer = "productive cycle")
  @PutMapping
  public ProductiveCycleEntity update(@RequestBody ProductiveCycleEntity productiveCycleEntity) {
    return productiveCycleService.update(productiveCycleEntity);
  }

  @ApiOperation(value = "Delete a  productive cycle",
      notes = "this endpoint needs an  productive cycle id",
      response = List.class,
      responseContainer = "productive cycle")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    productiveCycleService.delete(id);
    return "productive cycle deleted!";
  }


//  @GetMapping("/prod-cycles")
//  private List<ProductiveCycleDto> getProductiveDTO() throws Exception {
//    return productiveCycleService.getProductiveCycleDTO();
//  }

}
