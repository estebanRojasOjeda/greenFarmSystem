package com.greenfarm.greenfarmsystem.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Organic input type properties")
@Entity
@Table(name = "organic_input_type")
public class OrganicInputTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_input_type_seq")
  @SequenceGenerator(name = "org_input_type_seq", sequenceName = "org_input_type_seq", initialValue=1)
  @Column(name = "org_input_type_id")
  private Long id;

  @ApiModelProperty(notes = "Name must be between 1 and 60 characters")
  @NotBlank
  @Size(min=1, max=30, message = "El nombre de insumo organico debe contener entre 1 y 30 caracteres")
  @Column(name = "org_input_type_name", length = 30, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=3, message = "El nombre de unidad de medición debe contener entre 1 y 3 caracteres")
  @Column(name = "org_input_type_measurement", length = 3, nullable = true)
  private String measurement;


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

  public String getMeasurement() {
    return measurement;
  }

  public void setMeasurement(String measurement) {
    this.measurement = measurement;
  }
}
