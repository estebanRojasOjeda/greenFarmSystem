package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.service.OrganicInputService;
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

  @RequestMapping(method = RequestMethod.GET)
  public List<OrganicInputEntity> findAll(){
    return organicInputService.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public OrganicInputEntity findById(@PathVariable("id") Long id){
    return organicInputService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public OrganicInputEntity save(@RequestBody OrganicInputEntity organicInputEntity){
    return organicInputService.save(organicInputEntity);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public OrganicInputEntity update(@RequestBody OrganicInputEntity organicInputEntity){
    return organicInputService.update(organicInputEntity);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
        organicInputService.delete(id);
        return "Organic input deleted!";
  }

}
