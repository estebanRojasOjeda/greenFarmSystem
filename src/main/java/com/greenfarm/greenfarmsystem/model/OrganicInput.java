package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organic_input")
public class OrganicInput {

  @Id
  @Column(name = "orin_id")
  private Integer id;

}
