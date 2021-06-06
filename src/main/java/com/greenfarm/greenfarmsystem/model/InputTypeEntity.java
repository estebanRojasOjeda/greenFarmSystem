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
import lombok.Data;

@ApiModel(description = "Input type properties")
@Entity
@Table(name = "input_type")
@Data
public class InputTypeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_type_seq")
  @SequenceGenerator(name = "input_type_seq", sequenceName = "input_type_seq", initialValue=1)
  @Column(name = "input_type_id")
  private Long id;

  @ApiModelProperty(notes = "Name must be between 1 and 60 characters")
  @NotBlank
  @Size(min=1, max=30, message = "El nombre de insumo organico debe contener entre 1 y 30 caracteres")
  @Column(name = "input_type_name", length = 30, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=3, message = "El nombre de unidad de medición debe contener entre 1 y 3 caracteres")
  @Column(name = "input_type_measurement", length = 3, nullable = true)
  private String measurement;

}
