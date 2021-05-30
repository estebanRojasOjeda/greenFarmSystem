package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import com.greenfarm.greenfarmsystem.service.TechInputService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/tech-input")
public class TechInputController {

  private TechInputService techInputService;

  @Autowired
  public TechInputController(
      TechInputService techInputService) {
    this.techInputService = techInputService;
  }

  @ApiOperation(value = "Get all technological inputs",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Technological Input")
  @RequestMapping(method = RequestMethod.GET)
  public List<TechInputEntity> findAll(){
    return techInputService.findAll();
  }

  @ApiOperation(value = "Get technological input by id",
      notes = "This endpoint needs an technological input id like a parameter",
      response = List.class,
      responseContainer = "Technological Input")
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public TechInputEntity findById(@PathVariable("id") Long id) throws Exception {
    return techInputService.findById(id);
  }

  @ApiOperation(value = "Save technological input",
      notes = "this endpoint needs an technological input object",
      response = List.class,
      responseContainer = "Technological Input")
  @RequestMapping(method = RequestMethod.POST)
  public TechInputEntity save(@RequestBody TechInputEntity techInputEntity){
    return techInputService.save(techInputEntity);
  }

  @ApiOperation(value = "Update technological input",
      notes = "this endpoint needs an technological input object",
      response = List.class,
      responseContainer = "Technological Input")
  @RequestMapping(method = RequestMethod.PUT)
  public TechInputEntity update(@RequestBody TechInputEntity techInputEntity){
    return techInputService.update(techInputEntity);
  }

  @ApiOperation(value = "Delete technological input",
      notes = "this endpoint needs an technological input id",
      response = List.class,
      responseContainer = "Technological Input")
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    techInputService.delete(id);
    return "Technological input deleted!";
  }

}
