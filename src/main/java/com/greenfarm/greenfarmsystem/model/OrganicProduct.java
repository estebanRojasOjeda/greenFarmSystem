package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organic_product")
public class OrganicProduct {

  @Id
  @Column(name = "orpr_id")
  private Integer Id;

  @Column(name = "orpr_name", length = 30, nullable = true)
  private String name;


}
