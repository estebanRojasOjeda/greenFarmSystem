package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.service.OrganicInputService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/organic-input")
public class OrganicInputController {

  private OrganicInputService organicInputService;

  @Autowired
  public OrganicInputController(
      OrganicInputService organicInputService) {
    this.organicInputService = organicInputService;
  }

  @ApiOperation(value = "Get all organic inputs",
      notes = "No need for input parameters",
      response = List.class,
      responseContainer = "Organic Input")
  @RequestMapping(method = RequestMethod.GET)
  public List<OrganicInputEntity> findAll(){
    return organicInputService.findAll();
  }

  @ApiOperation(value = "Get organic input by id",
      notes = "This endpoint needs an organic input id like a parameter",
      response = List.class,
      responseContainer = "Organic Input")
  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public OrganicInputEntity findById(@PathVariable("id") Long id) throws Exception {
    return organicInputService.findById(id);
  }

  @ApiOperation(value = "Save organic input",
      notes = "this endpoint needs an organic input object",
      response = List.class,
      responseContainer = "Organic Input")
  @RequestMapping(method = RequestMethod.POST)
  public OrganicInputEntity save(@RequestBody OrganicInputEntity organicInputEntity){
    return organicInputService.save(organicInputEntity);
  }

  @ApiOperation(value = "Update organic input",
      notes = "this endpoint needs an organic input object",
      response = List.class,
      responseContainer = "Organic Input")
  @RequestMapping(method = RequestMethod.PUT)
  public OrganicInputEntity update(@RequestBody OrganicInputEntity organicInputEntity){
    return organicInputService.update(organicInputEntity);
  }

  @ApiOperation(value = "Delete organic input",
      notes = "this endpoint needs an organic input id",
      response = List.class,
      responseContainer = "Organic Input")
  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
        organicInputService.delete(id);
        return "Organic input deleted!";
  }

}
