package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "organic_input_type")
public class OrganicInputTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orinputtype_seq")
  @SequenceGenerator(name = "orinputtype_seq", sequenceName = "orinputtype_seq")
  @Column(name = "oity_id")
  private Long id;

  @Column(name = "oity_name", length = 60)
  private String name;

  @Column(name = "oity_measurement_type", length = 60)
  private String measurementType;

  @Column(name = "oity_supplier", length = 60)
  private String supplier;

  @Column(name = "tein_price")
  private Integer price;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMeasurementType() {
    return measurementType;
  }

  public void setMeasurementType(String measurementType) {
    this.measurementType = measurementType;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
