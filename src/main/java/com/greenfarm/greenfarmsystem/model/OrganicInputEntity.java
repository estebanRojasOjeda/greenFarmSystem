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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organic_input")
public class OrganicInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orginput_seq")
  @SequenceGenerator(name = "orginput_seq", sequenceName = "orginput_seq", initialValue = 1)
  @Column(name = "orin_id")
  private Long id;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de insumo organico debe contener entre 1 y 60 caracteres")
  @Column(name = "orin_name", length = 60, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de fabricante debe contener entre 1 y 60 caracteres")
  @Column(name = "orin_manufacturer", length = 60, nullable = true)
  private String manufacturer;

  @Size(min=1, max=60, message = "El nombre de modelo debe contener entre 1 y 60 caracteres")
  @Column(name = "orin_model", length = 60)
  private String model;

  @NotNull
  @Column(name = "orin_price", nullable = true)
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
