package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import com.greenfarm.greenfarmsystem.service.TechInputService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/techno-input")
public class TechInputController {

  private TechInputService techInputService;

  @Autowired
  public TechInputController(
      TechInputService techInputService) {
    this.techInputService = techInputService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<TechInputEntity> findAll(){
    return techInputService.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public TechInputEntity findById(@PathVariable("id") Long id){
    return techInputService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public TechInputEntity save(@RequestBody TechInputEntity techInputEntity){
    return techInputService.save(techInputEntity);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public TechInputEntity update(@RequestBody TechInputEntity techInputEntity){
    return techInputService.update(techInputEntity);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    techInputService.delete(id);
    return "Technological input deleted!";
  }

}
