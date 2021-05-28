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
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_input_seq")
  @SequenceGenerator(name = "org_input_seq", sequenceName = "org_input_seq", initialValue = 1)
  @Column(name = "org_input_id")
  private Long id;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de insumo organico debe contener entre 1 y 30 caracteres")
  @Column(name = "org_input_name", length = 30, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de fabricante debe contener entre 1 y 30 caracteres")
  @Column(name = "org_input_manufacturer", length = 30, nullable = true)
  private String manufacturer;

  @Size(min=1, max=30, message = "El nombre de modelo debe contener entre 1 y 30 caracteres")
  @Column(name = "org_input_model", length = 30)
  private String model;

  @NotNull
  @Column(name = "org_input_price", nullable = true)
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "org_input_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_input_type"))
  private OrganicInputTypeEntity organicInputTypeEntity;


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

  public OrganicInputTypeEntity getOrganicInputTypeEntity() {
    return organicInputTypeEntity;
  }

  public void setOrganicInputTypeEntity(
      OrganicInputTypeEntity organicInputTypeEntity) {
    this.organicInputTypeEntity = organicInputTypeEntity;
  }
}
