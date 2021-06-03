package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.InputTypeEntity;
import com.greenfarm.greenfarmsystem.service.InputTypeService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/gfs/production/input-type")
public class InputTypeController {

  private InputTypeService inputTypeService;

  @Autowired
  public InputTypeController(
      InputTypeService inputTypeService) {
    this.inputTypeService = inputTypeService;
  }

  @ApiOperation(value = "Get all inputs types",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Input Type")
  @GetMapping
  public List<InputTypeEntity> findAll() {
    return inputTypeService.findAll();
  }

  @ApiOperation(value = "Find by id  input type",
      notes = "this endpoint needs an  input type id",
      response = List.class,
      responseContainer = " Input Type")
  @GetMapping("/{id}")
  public InputTypeEntity findById(@PathVariable("id") Long id) throws Exception {
    return inputTypeService.findById(id);
  }

  @ApiOperation(value = "Save a new  input type",
      notes = "this endpoint needs an  input type object",
      response = List.class,
      responseContainer = " Input Type")
  @PostMapping
  public InputTypeEntity save(
      @RequestBody @Valid InputTypeEntity inputTypeEntity) {
    return inputTypeService.save(inputTypeEntity);
  }

  @ApiOperation(value = "Update a  input type",
      notes = "this endpoint needs an  input type object",
      response = List.class,
      responseContainer = " Input Type")
  @PutMapping
  public InputTypeEntity update(@RequestBody InputTypeEntity inputTypeEntity) {
    return inputTypeService.update(inputTypeEntity);
  }

  @ApiOperation(value = "Delete a  input type",
      notes = "this endpoint needs an  input type id",
      response = List.class,
      responseContainer = " Input Type")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    inputTypeService.delete(id);
    return " input type deleted!";
  }

}
