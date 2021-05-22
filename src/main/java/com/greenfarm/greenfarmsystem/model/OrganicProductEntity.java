package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organic_product")
public class OrganicProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgproduct_seq")
  @SequenceGenerator(name = "orgproduct_seq", sequenceName = "orgproduct_seq")
  @Column(name = "orpr_id")
  private Integer Id;

  @Column(name = "orpr_name", length = 30, nullable = true)
  private String name;

  @ManyToOne
  @JoinColumn(name = "orpr_opty_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_product_type"))
  private OrganicProductTypeEntity organicProductTypeEntity;


  public Integer getId() {
    return Id;
  }

  public void setId(Integer id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganicProductTypeEntity getOrganicProductTypeEntity() {
    return organicProductTypeEntity;
  }

  public void setOrganicProductTypeEntity(
      OrganicProductTypeEntity organicProductTypeEntity) {
    this.organicProductTypeEntity = organicProductTypeEntity;
  }
}
