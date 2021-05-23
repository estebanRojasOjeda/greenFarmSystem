package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicInputTypeEntity;
import com.greenfarm.greenfarmsystem.service.OrganicInputTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(method = RequestMethod.GET)
  public List<OrganicInputTypeEntity> findAll(){
    return organicInputTypeService.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public OrganicInputTypeEntity findById(@PathVariable("id") Long id){
    return organicInputTypeService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public OrganicInputTypeEntity save(@RequestBody OrganicInputTypeEntity organicInputTypeEntity){
    return organicInputTypeService.save(organicInputTypeEntity);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public OrganicInputTypeEntity update(@RequestBody OrganicInputTypeEntity organicInputTypeEntity){
    return organicInputTypeService.update(organicInputTypeEntity);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id){
    organicInputTypeService.delete(id);
    return "Organic input deleted!";
  }

}
