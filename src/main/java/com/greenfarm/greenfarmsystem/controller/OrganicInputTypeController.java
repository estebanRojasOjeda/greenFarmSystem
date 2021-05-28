package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import com.greenfarm.greenfarmsystem.service.OrganicInputTypeService;
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
@RequestMapping("/gfs/production/organic-input-type")
public class OrganicInputTypeController {

  private OrganicInputTypeService organicInputTypeService;

  @Autowired
  public OrganicInputTypeController(
      OrganicInputTypeService organicInputTypeService) {
    this.organicInputTypeService = organicInputTypeService;
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
  public List<OrganicInputTypeEntity> findAll(){
    return organicInputTypeService.findAll();
  }

  @GetMapping("/{id}")
  public OrganicInputTypeEntity findById(@PathVariable("id") Long id){
    return organicInputTypeService.findById(id);
  }

  @PostMapping
  public OrganicInputTypeEntity save(@RequestBody @Valid OrganicInputTypeEntity organicInputTypeEntity){
    return organicInputTypeService.save(organicInputTypeEntity);
  }

  @PutMapping
  public OrganicInputTypeEntity update(@RequestBody OrganicInputTypeEntity organicInputTypeEntity){
    return organicInputTypeService.update(organicInputTypeEntity);
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    organicInputTypeService.delete(id);
    return "Organic input deleted!";
  }

}
