package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
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
@Table(name = "technological_input")
public class TechInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tech_input_seq")
  @SequenceGenerator(name = "tech_input_seq", sequenceName = "tech_input_seq", initialValue = 1)
  @Column(name = "tech_input_id")
  private Long id;

  @NotNull
  @Column(name = "tech_input_start_date", nullable = true)
  private LocalDateTime start_date;

  @NotNull
  @Column(name = "tech_input_end_date", nullable = true)
  private LocalDateTime end_date;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de fabricante debe contener entre 1 y 30 caracteres")
  @Column(name = "tech_input_manufacturer", length = 30, nullable = true)
  private String manufacturer;

  @NotBlank
  @Size(min=1, max=30, message = "El nombre de modelo debe contener entre 1 y 30 caracteres")
  @Column(name = "tech_input_model", length = 30, nullable = true)
  private String model;

  @NotNull
  @Column(name = "tech_input_price", nullable = true)
  private Integer price;


  @ManyToOne
  @JoinColumn(name = "tech_input_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_techno_input_type"))
  private TechInputTypeEntity techInputTypeEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDateTime start_date) {
    this.start_date = start_date;
  }

  public LocalDateTime getEnd_date() {
    return end_date;
  }

  public void setEnd_date(LocalDateTime end_date) {
    this.end_date = end_date;
  }

  public TechInputTypeEntity getTechInputTypeEntity() {
    return techInputTypeEntity;
  }

  public void setTechInputTypeEntity(
      TechInputTypeEntity techInputTypeEntity) {
    this.techInputTypeEntity = techInputTypeEntity;
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
