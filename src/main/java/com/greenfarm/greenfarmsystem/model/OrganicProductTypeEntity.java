package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organic_product_type")
public class OrganicProductTypeEntity {

  @Id
  @Column(name = "opty_id")
  private Integer id;

}
