package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.repository.InputCategoryService;
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
@RequestMapping("/gfs/production/input-category")
public class InputCategoryController {

  private InputCategoryService inputCategoryService;

  @Autowired
  public InputCategoryController(
      InputCategoryService inputCategoryService) {
    this.inputCategoryService = inputCategoryService;
  }

  @ApiOperation(value = "Get all inputs categories",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Input Category")
  @GetMapping
  public List<InputCategoryEntity> findAll() {
    return inputCategoryService.findAll();
  }

  @ApiOperation(value = "Find by id  input category",
      notes = "this endpoint needs an  input category id",
      response = List.class,
      responseContainer = " Input Category")
  @GetMapping("/{id}")
  public InputCategoryEntity findById(@PathVariable("id") Long id) throws Exception {
    return inputCategoryService.findById(id);
  }

  @ApiOperation(value = "Save a new  input category",
      notes = "this endpoint needs an  input category object",
      response = List.class,
      responseContainer = " Input Category")
  @PostMapping
  public InputCategoryEntity save(
      @RequestBody @Valid InputCategoryEntity inputCategoryEntity) {
    return inputCategoryService.save(inputCategoryEntity);
  }

  @ApiOperation(value = "Update a  input category",
      notes = "this endpoint needs an  input category object",
      response = List.class,
      responseContainer = " Input Category")
  @PutMapping
  public InputCategoryEntity update(@RequestBody InputCategoryEntity inputCategoryEntity) {
    return inputCategoryService.update(inputCategoryEntity);
  }

  @ApiOperation(value = "Delete a  input type",
      notes = "this endpoint needs an  input type id",
      response = List.class,
      responseContainer = " Input Type")
  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    inputCategoryService.delete(id);
    return " input category deleted!";
  }
  
}
