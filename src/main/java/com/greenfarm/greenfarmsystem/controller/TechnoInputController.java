package com.greenfarm.greenfarmsystem.controller;

import com.greenfarm.greenfarmsystem.model.TechnoInputEntity;
import com.greenfarm.greenfarmsystem.service.TechnoInputService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gfs/production/techno-input")
public class TechnoInputController {

  private TechnoInputService technoInputService;

  @Autowired
  public TechnoInputController(
      TechnoInputService technoInputService) {
    this.technoInputService = technoInputService;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<TechnoInputEntity> findAll(){
    return technoInputService.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public TechnoInputEntity findById(@PathVariable("id") Long id){
    return technoInputService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public TechnoInputEntity save(@RequestBody TechnoInputEntity technoInputEntity){
    return technoInputService.save(technoInputEntity);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public TechnoInputEntity update(@RequestBody TechnoInputEntity technoInputEntity){
    return technoInputService.update(technoInputEntity);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public String deleteById(@PathVariable("id") Long id) throws Exception {
    technoInputService.delete(id);
    return "Organic input deleted!";
  }

}
