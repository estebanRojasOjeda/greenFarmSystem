package com.greenfarm.greenfarmsystem.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.greenfarm.greenfarmsystem.dto.ProductiveCycleDetailDto;
import com.greenfarm.greenfarmsystem.dto.ProductiveCycleRequestDto;
import com.greenfarm.greenfarmsystem.dto.SalesDetailDto;
import com.greenfarm.greenfarmsystem.dto.SalesRequestDto;
import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import com.greenfarm.greenfarmsystem.model.SalesEntity;
import com.greenfarm.greenfarmsystem.service.SalesService;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/gfs/sales")
public class SalesController {

  SalesService salesService;

  public SalesController(SalesService salesService) {
    this.salesService = salesService;
  }

  @ApiOperation(value = "Get all sales",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "sales")
  @GetMapping
  public List<SalesEntity> findAll() {
    return salesService.findAll();
  }

  @ApiOperation(value = "Find by id  sales",
      notes = "this endpoint needs a sales id",
      response = List.class,
      responseContainer = "sales")
  @GetMapping("/{id}")
  public SalesEntity findById(@PathVariable("id") Long id) throws Exception {
    return salesService.findById(id);
  }

  @ApiOperation(value = "Save sales entity with details",
      notes = "this endpoint needs a sales Dto",
      response = List.class,
      responseContainer = "sales entity")
  @PostMapping
  public ResponseEntity<Object> saveSales(@Valid @RequestBody SalesRequestDto salesRequestDto) {
    SalesEntity obj = salesService.saveSales(salesRequestDto);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getSalesId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @ApiOperation(value = "Update a  sales",
      notes = "this endpoint needs a sales object",
      response = List.class,
      responseContainer = "sales")
  @PutMapping
  public SalesEntity update(@RequestBody SalesEntity salesEntity) {
    return salesService.update(salesEntity);
  }

  @ApiOperation(value = "Delete a  sales",
      notes = "this endpoint needs a sales id",
      response = List.class,
      responseContainer = "sales")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    salesService.delete(id);
    return "sales deleted!";
  }


  @GetMapping("/sales-details")
  private List<SalesDetailDto> getSalesDetail() throws Exception {

    List<SalesEntity> salesEntityList;
    List<SalesDetailDto> salesDetailDtoList = new ArrayList<>();
    salesEntityList = salesService.findAll();

    salesEntityList.forEach(sale -> {
      SalesDetailDto salesDetail = new SalesDetailDto();
      salesDetail.setSalesId(sale.getSalesId());
      salesDetail.setSaleDate(sale.getSaleDate());
      salesDetail.setClientName(sale.getSaleClientName());

      List<Link> orgProductLinkList = new ArrayList<>();
      sale.getOrganicProductEntityList().forEach(org -> {
        ControllerLinkBuilder linkTo = null;
        try {
          linkTo = linkTo(methodOn(OrganicProductController.class).findById((org.getId())));
        } catch (Exception e) {
          e.printStackTrace();
        }
        orgProductLinkList.add(linkTo.withRel("Organic Product").withType("Dto response").withTitle("Organic product Dto Link"));
      });
      salesDetail.setOrganicProduct(orgProductLinkList);
      salesDetailDtoList.add(salesDetail);

    });
    return salesDetailDtoList;
  }

}
