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
@Table(name = "organic_input")
public class OrganicInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orginput_seq")
  @SequenceGenerator(name = "orginput_seq", sequenceName = "orginput_seq")
  @Column(name = "orin_id")
  private Long id;

  @Column(name = "orin_manufacturer", length = 60)
  private String manufacturer;

  @Column(name = "orin_model", length = 60)
  private String model;

  @Column(name = "orin_price")
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "orin_oity_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_input_type"))
  private OrganicInputTypeEntity organicInputTypeEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrganicInputTypeEntity getOrganicInputTypeEntity() {
    return organicInputTypeEntity;
  }

  public void setOrganicInputTypeEntity(
      OrganicInputTypeEntity organicInputTypeEntity) {
    this.organicInputTypeEntity = organicInputTypeEntity;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
