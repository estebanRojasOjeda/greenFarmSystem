package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.TechInputTypeEntity;
import com.greenfarm.greenfarmsystem.service.TechInputTypeService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/gfs/production/tech-input-type")
public class TechInputTypeController {

  private TechInputTypeService techInputTypeService;

  @Autowired
  public TechInputTypeController(
      TechInputTypeService techInputTypeService) {
    this.techInputTypeService = techInputTypeService;
  }

  @ApiOperation(value = "Get all technological inputs types",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Technological Input Type")
  @RequestMapping(method = RequestMethod.GET)
  public List<TechInputTypeEntity> findAll(){
    return techInputTypeService.findAll();
  }

  @ApiOperation(value = "Find by id technological input type",
      notes = "this endpoint needs an technological input type id",
      response = List.class,
      responseContainer = "Technological Input Type")
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public TechInputTypeEntity findById(@PathVariable("id") Long id) throws Exception {
    return techInputTypeService.findById(id);
  }

  @ApiOperation(value = "Save a new technological input type",
      notes = "this endpoint needs an technological input type object",
      response = List.class,
      responseContainer = "Technological Input Type")
  @RequestMapping(method = RequestMethod.POST)
  public TechInputTypeEntity save(@RequestBody TechInputTypeEntity techInputTypeEntity){
    return techInputTypeService.save(techInputTypeEntity);
  }

  @ApiOperation(value = "Update a technological input type",
      notes = "this endpoint needs an technological input type object",
      response = List.class,
      responseContainer = "Technological Input Type")
  @RequestMapping(method = RequestMethod.PUT)
  public TechInputTypeEntity update(@RequestBody TechInputTypeEntity techInputTypeEntity){
    return techInputTypeService.update(techInputTypeEntity);
  }

  @ApiOperation(value = "Delete a technological input type",
      notes = "this endpoint needs an technological input type id",
      response = List.class,
      responseContainer = "Technological Input Type")
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    techInputTypeService.delete(id);
    return "Technological input type deleted!";
  }

}
