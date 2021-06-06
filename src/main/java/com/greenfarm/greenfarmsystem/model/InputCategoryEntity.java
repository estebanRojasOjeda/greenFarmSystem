package com.greenfarm.greenfarmsystem.model;

import com.google.auto.value.AutoValue.Builder;
import io.swagger.annotations.ApiModel;
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


@ApiModel(description = "Input category properties")
@Entity
@Table(name = "input_category")
@Builder
@Data
public class InputCategoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_category_seq")
  @SequenceGenerator(name = "input_category_seq", sequenceName = "input_category_seq", initialValue = 1)
  @Column(name = "input_category_id")
  private Long id;

  @NotBlank
  @Size(min = 1, max = 60, message = "El nombre de categoria debe contener entre 1 y 60 caracteres")
  @Column(name = "input_category_name", length = 60, nullable = true)
  private String name;

}
