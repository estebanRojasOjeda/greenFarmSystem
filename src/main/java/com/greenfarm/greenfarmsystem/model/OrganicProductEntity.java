package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "organic_product")
public class OrganicProductEntity {

  @Id
  @Column(name = "orpr_id")
  private Integer Id;

  @Column(name = "orpr_name", length = 30, nullable = true)
  private String name;

  @ManyToOne
  @JoinColumn(name = "orpr_opty_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_product_type"))
  private OrganicProductTypeEntity organicProductTypeEntity;


}
