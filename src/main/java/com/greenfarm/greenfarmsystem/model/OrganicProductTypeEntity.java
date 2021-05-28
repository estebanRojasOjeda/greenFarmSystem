package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organic_product_type")
public class OrganicProductTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_prod_type_seq")
  @SequenceGenerator(name = "org_prod_type_seq", sequenceName = "org_prod_type_seq", initialValue=1)
  @Column(name = "org_prod_type_id")
  private Long id;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de tipo de producto organico debe contener entre 1 y 30 caracteres")
  @Column(name = "org_prod_type_name", length = 30, nullable = true)
  private String productTypeName;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de familia de producto organico debe contener entre 1 y 30 caracteres")
  @Column(name = "org_prod_type_family", length = 30, nullable = true)
  private String producttypeFamily;

  @NotBlank
  @Size(min=1, max=100, message = "Las caracteristicas de producto organico debe contener entre 1 y 100 caracteres")
  @Column(name = "org_prod_type_desc", length = 100)
  private String productTypeDescription;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
