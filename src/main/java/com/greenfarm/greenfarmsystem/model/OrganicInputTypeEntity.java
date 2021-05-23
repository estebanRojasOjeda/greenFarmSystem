package com.greenfarm.greenfarmsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organic_input_type")
public class OrganicInputTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orinputtype_seq")
  @SequenceGenerator(name = "orinputtype_seq", sequenceName = "orinputtype_seq", initialValue=1)
  @Column(name = "oity_id")
  private Long id;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de insumo organico debe contener entre 1 y 60 caracteres")
  @Column(name = "oity_name", length = 60, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=3, message = "El nombre de unidad de medición debe contener entre 1 y 3 caracteres")
  @Column(name = "oity_measurement_type", length = 3, nullable = true)
  private String measurementType;


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

}
