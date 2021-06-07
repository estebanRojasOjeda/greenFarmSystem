package com.greenfarm.greenfarmsystem.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.greenfarm.greenfarmsystem.dto.ProductionDetailDto;
import com.greenfarm.greenfarmsystem.dto.ProductionRequestDto;
import com.greenfarm.greenfarmsystem.dto.ProductiveCycleDetailDto;
import com.greenfarm.greenfarmsystem.dto.ProductiveCycleRequestDto;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.service.ProductiveCycleService;
import io.swagger.annotations.ApiOperation;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

  @ApiOperation(value = "Save productive cycle entity with details",
      notes = "this endpoint needs an productive cycle Dto",
      response = List.class,
      responseContainer = "productive cycle entity")
  @PostMapping
  public ResponseEntity<Object> saveProductiveCycle(@Valid @RequestBody ProductiveCycleRequestDto productiveCycleRequestDto) {
    ProductiveCycleEntity obj = productiveCycleService.saveProdCycleDetail(productiveCycleRequestDto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProductiveCycleId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @ApiOperation(value = "Save productive production entity with details",
      notes = "this endpoint needs an production cycle Dto",
      response = List.class,
      responseContainer = "productive cycle entity")
  @PostMapping("/production")
  public ResponseEntity<Object> saveProduction(@Valid @RequestBody ProductionRequestDto productionRequestDto) {
    ProductiveCycleEntity obj = productiveCycleService.saveProduction(productionRequestDto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getProductiveCycleId()).toUri();
    return ResponseEntity.created(location).build();
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

    List<ProductiveCycleEntity> productiveCycleEntityList;
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

      List<Link> inputLinkList = new ArrayList<>();
      prod.getInputEntityList().forEach(input -> {
        ControllerLinkBuilder linkTo = null;
        try {
          linkTo = linkTo(methodOn(InputController.class).findById((input.getInputId())));
        } catch (Exception e) {
          e.printStackTrace();
        }
        inputLinkList.add(linkTo.withRel("Input").withType("Dto response").withTitle("Input Dto Link"));
      });
      prodCycleDetail.setInputEntity(inputLinkList);
      productiveCycleDetailDtoList.add(prodCycleDetail);

    });
    return productiveCycleDetailDtoList;
  }

  @GetMapping("/production")
  private List<ProductionDetailDto> getProduction() throws Exception {

    List<ProductiveCycleEntity> productiveCycleEntityList;
    List<ProductionDetailDto> productionDetailDtoList = new ArrayList<>();
    productiveCycleEntityList = productiveCycleService.findAll();

    productiveCycleEntityList.forEach(prod -> {
      ProductionDetailDto productionDet = new ProductionDetailDto();
      productionDet.setProductiveCycleId(prod.getProductiveCycleId());
      productionDet.setStartDate(prod.getStartDate());
      productionDet.setEndDate(prod.getEndDate());
      productionDet.setTemperature(prod.getTemperature());
      productionDet.setHumidity(prod.getHumidity());
      productionDet.setComments(prod.getComments());

      List<Link> inputLinkList = new ArrayList<>();
      prod.getOrganicProductEntityList().forEach(org -> {
        ControllerLinkBuilder linkTo = null;
        try {
          linkTo = linkTo(methodOn(OrganicProductController.class).findById((org.getId())));
        } catch (Exception e) {
          e.printStackTrace();
        }
        inputLinkList.add(linkTo.withRel("Organic Product").withType("Dto response").withTitle("Organic Product Dto Link"));
      });
      productionDet.setOrganicProduct(inputLinkList);
      productionDetailDtoList.add(productionDet);

    });
    return productionDetailDtoList;
  }

}
