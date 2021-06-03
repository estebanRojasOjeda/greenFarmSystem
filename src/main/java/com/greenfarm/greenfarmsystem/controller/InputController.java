package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.InputEntity;
import com.greenfarm.greenfarmsystem.service.InputService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/input")
public class InputController {

  private InputService inputService;

  @Autowired
  public InputController(
      InputService inputService) {
    this.inputService = inputService;
  }

  @ApiOperation(value = "Get all  inputs",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = " Input")
  @RequestMapping(method = RequestMethod.GET)
  public List<InputEntity> findAll(){
    return inputService.findAll();
  }

  @ApiOperation(value = "Get  input by id",
      notes = "This endpoint needs an  input id like a parameter",
      response = List.class,
      responseContainer = " Input")
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public InputEntity findById(@PathVariable("id") Long id) throws Exception {
    return inputService.findById(id);
  }

  @ApiOperation(value = "Save  input",
      notes = "this endpoint needs an  input object",
      response = List.class,
      responseContainer = " Input")
  @RequestMapping(method = RequestMethod.POST)
  public InputEntity save(@RequestBody InputEntity inputEntity){
    return inputService.save(inputEntity);
  }

  @ApiOperation(value = "Update  input",
      notes = "this endpoint needs an  input object",
      response = List.class,
      responseContainer = " Input")
  @RequestMapping(method = RequestMethod.PUT)
  public InputEntity update(@RequestBody InputEntity inputEntity){
    return inputService.update(inputEntity);
  }

  @ApiOperation(value = "Delete  input",
      notes = "this endpoint needs an  input id",
      response = List.class,
      responseContainer = " Input")
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
        inputService.delete(id);
        return " input deleted!";
  }

}
