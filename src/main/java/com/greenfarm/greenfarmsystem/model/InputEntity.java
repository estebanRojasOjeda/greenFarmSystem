package com.greenfarm.greenfarmsystem.model;

import com.google.auto.value.AutoValue.Builder;
import io.swagger.annotations.ApiModel;
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

@ApiModel(description = "Input properties")
@Entity
@Table(name = "input")
public class InputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_seq")
  @SequenceGenerator(name = "input_seq", sequenceName = "input_seq", initialValue = 1)
  @Column(name = "input_id")
  private Long inputId;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de insumo debe contener entre 1 y 30 caracteres")
  @Column(name = "input_name", length = 30, nullable = true)
  private String name;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de fabricante debe contener entre 1 y 30 caracteres")
  @Column(name = "input_manufacturer", length = 30, nullable = true)
  private String manufacturer;

  @Size(min=1, max=30, message = "El nombre de modelo debe contener entre 1 y 30 caracteres")
  @Column(name = "input_model", length = 30)
  private String model;

  @NotNull
  @Column(name = "input_price", nullable = true)
  private Integer price;

  @NotBlank
  @Size(min=1, max=100, message = "El comentario debe contener entre 1 y 100 caracteres")
  @Column(name = "input_comments", length = 30, nullable = true)
  private String comments;

  @ManyToOne
  @JoinColumn(name = "input_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_input_type"))
  private InputTypeEntity inputTypeEntity;

  @ManyToOne
  @JoinColumn(name = "input_category_id", nullable = false, foreignKey = @ForeignKey(name = "FK_input_category"))
  private InputCategoryEntity inputCategoryEntity;



  public Long getInputId() {
    return inputId;
  }

  public void setInputId(Long inputId) {
    this.inputId = inputId;
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

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public InputTypeEntity getInputTypeEntity() {
    return inputTypeEntity;
  }

  public void setInputTypeEntity(InputTypeEntity inputTypeEntity) {
    this.inputTypeEntity = inputTypeEntity;
  }

  public InputCategoryEntity getInputCategoryEntity() {
    return inputCategoryEntity;
  }

  public void setInputCategoryEntity(
      InputCategoryEntity inputCategoryEntity) {
    this.inputCategoryEntity = inputCategoryEntity;
  }

}
