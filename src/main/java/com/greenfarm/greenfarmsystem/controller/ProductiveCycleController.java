package com.greenfarm.greenfarmsystem.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.greenfarm.greenfarmsystem.dto.InputDto;
import com.greenfarm.greenfarmsystem.dto.ProductiveCycleDetailDto;
import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ProductiveCycleEntity save(@RequestBody ProductiveCycleEntity productiveCycleEntity) {
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


  @GetMapping("/prod-cycle-details")
  private List<ProductiveCycleDetailDto> getProductiveCycleDetailsDtoList() throws Exception {

    List<ProductiveCycleEntity> productiveCycleEntityList = new ArrayList<>();
    List<ProductiveCycleDetailDto> productiveCycleDetailDtoList = new ArrayList<>();
    productiveCycleEntityList = productiveCycleService.findAll();

    productiveCycleEntityList.forEach(prod -> {
      ProductiveCycleDetailDto prodCycleDetail = new ProductiveCycleDetailDto();
      prodCycleDetail.setProductiveCycleId(prod.getProductiveCycleId());
      prodCycleDetail.setStartDate(prod.getStartDate());
      prodCycleDetail.setEndDate(prod.getEndDate());
      prodCycleDetail.setTemperature(prod.getTemperature());
      prodCycleDetail.setHumidity(prod.getHumidity());
      prodCycleDetail.setComments(prod.getComments());

      List<InputDto> inputDtoList = new ArrayList<>();
      List<Link> inputLinkList = new ArrayList<>();
      prod.getInputEntityList().forEach(input -> {
        InputDto inputDto = new InputDto();
        inputDto.setInputId(input.getInputId());
        inputDto.setName(input.getName());
        inputDto.setManufacturer(input.getManufacturer());
        inputDto.setModel(input.getModel());
        inputDto.setPrice(input.getPrice());
        inputDto.setComments(input.getComments());

        ControllerLinkBuilder linkTo = null;
        try {
          linkTo = linkTo(methodOn(InputController.class).findById((input.getInputId())));
        } catch (Exception e) {
          e.printStackTrace();
        }
        inputLinkList.add(linkTo.withRel("Input").withType("Dto").withTitle("Input Dto Link"));
      });

      prodCycleDetail.setInputEntity(inputLinkList);

      productiveCycleDetailDtoList.add(prodCycleDetail);

    });

    return productiveCycleDetailDtoList;

  }
}
