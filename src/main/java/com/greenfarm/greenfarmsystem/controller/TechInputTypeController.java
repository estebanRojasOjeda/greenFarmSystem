package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.TechInputTypeEntity;
import com.greenfarm.greenfarmsystem.service.TechInputTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequestMapping("/gfs/production/techno-input-type")
public class TechInputTypeController {

  private TechInputTypeService techInputTypeService;

  @Autowired
  public TechInputTypeController(
      TechInputTypeService techInputTypeService) {
    this.techInputTypeService = techInputTypeService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<TechInputTypeEntity> findAll(){
    return techInputTypeService.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public TechInputTypeEntity findById(@PathVariable("id") Long id){
    return techInputTypeService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public TechInputTypeEntity save(@RequestBody TechInputTypeEntity techInputTypeEntity){
    return techInputTypeService.save(techInputTypeEntity);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public TechInputTypeEntity update(@RequestBody TechInputTypeEntity techInputTypeEntity){
    return techInputTypeService.update(techInputTypeEntity);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    techInputTypeService.delete(id);
    return "Technological input type deleted!";
  }

}
