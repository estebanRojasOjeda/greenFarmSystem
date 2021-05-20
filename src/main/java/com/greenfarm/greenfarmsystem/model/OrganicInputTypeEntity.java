package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organic_input_type")
public class OrganicInputTypeEntity {

  @Id
  @Column(name = "oity_id")
  private Integer id;

}
