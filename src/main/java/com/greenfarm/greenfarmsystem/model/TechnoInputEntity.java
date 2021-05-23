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
public class TechnoInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "techno_input_seq")
  @SequenceGenerator(name = "techno_input_seq", sequenceName = "techno_input_seq", initialValue = 1)
  @Column(name = "tein_id")
  private Long id;

  @NotNull
  @Column(name = "tein_start_date", nullable = true)
  private LocalDateTime start_date;

  @NotNull
  @Column(name = "tein_end_date", nullable = true)
  private LocalDateTime end_date;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de fabricante debe contener entre 1 y 60 caracteres")
  @Column(name = "tein_manufacturer", length = 60, nullable = true)
  private String manufacturer;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de modelo debe contener entre 1 y 60 caracteres")
  @Column(name = "tein_model", length = 60, nullable = true)
  private String model;

  @NotNull
  @Column(name = "tein_price", nullable = true)
  private Integer price;


  @ManyToOne
  @JoinColumn(name = "tein_tity_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_techno_input_type"))
  private TechnoInputTypeEntity technoInputTypeEntity;

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

  public TechnoInputTypeEntity getTechnoInputTypeEntity() {
    return technoInputTypeEntity;
  }

  public void setTechnoInputTypeEntity(
      TechnoInputTypeEntity technoInputTypeEntity) {
    this.technoInputTypeEntity = technoInputTypeEntity;
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
