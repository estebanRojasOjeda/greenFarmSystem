package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organic_product_type")
public class OrganicProductTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orprodtype_seq")
  @SequenceGenerator(name = "orprodtype_seq", sequenceName = "orprodtype_seq")
  @Column(name = "opty_id")
  private Integer id;

  @Column(name = "opty_name", length = 100)
  private String productTypeName;

  @Column(name = "opty_family", length = 100)
  private String producttypeFamily;

  @Column(name = "opty_desc", length = 100)
  private String productTypeDescription;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductTypeName() {
    return productTypeName;
  }

  public void setProductTypeName(String productTypeName) {
    this.productTypeName = productTypeName;
  }

  public String getProducttypeFamily() {
    return producttypeFamily;
  }

  public void setProducttypeFamily(String producttypeFamily) {
    this.producttypeFamily = producttypeFamily;
  }

  public String getProductTypeDescription() {
    return productTypeDescription;
  }

  public void setProductTypeDescription(String productTypeDescription) {
    this.productTypeDescription = productTypeDescription;
  }
}
