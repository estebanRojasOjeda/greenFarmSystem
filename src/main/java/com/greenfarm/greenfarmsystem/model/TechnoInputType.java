package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "technological_input_type")
public class TechnoInputType {

  @Id
  @Column(name = "tity_id")
  private Integer id;

  @Column(name = "tity_name")
  private String name;

  @Column(name = "tity_manufacturer_name")
  private String manufacturer_name;

  @Column(name = "tity_model")
  private String model;

}
