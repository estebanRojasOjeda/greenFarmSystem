package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.dto.ProductiveCycleDto;
import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
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

  @ApiOperation(value = "Save productive cycle",
      notes = "this endpoint needs an productive cycle object",
      response = List.class,
      responseContainer = "Productive Cycle")
  @RequestMapping(method = RequestMethod.POST)
  public ProductiveCycleEntity save(@RequestBody ProductiveCycleEntity productiveCycleEntity){
    return productiveCycleService.save(productiveCycleEntity);
  }

  @GetMapping("/prod-cycles")
  private List<ProductiveCycleDto> getProductiveDTO() throws Exception {
    return productiveCycleService.getProductiveCycleDTO();
  }

}
