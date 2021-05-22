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

@Entity
@Table(name = "technological_input")
public class TechnoInputEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "techno_input_seq")
  @SequenceGenerator(name = "techno_input_seq", sequenceName = "techno_input_seq")
  @Column(name = "tein_id")
  private Integer id;

  @Column(name = "tein_start_date")
  private LocalDateTime start_date;

  @Column(name = "tein_end_date")
  private LocalDateTime end_date;

  @Column(name = "tein_manufacturer", length = 60)
  private String manufacturer;

  @Column(name = "tein_model", length = 60)
  private String model;

  @Column(name = "tein_price")
  private Integer price;

  @Column(name = "tein_measurement_type", length = 60)
  private String measurementType;

  @ManyToOne
  @JoinColumn(name = "tein_tity_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_techno_input_type"))
  private TechnoInputTypeEntity technoInputTypeEntity;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public String getMeasurementType() {
    return measurementType;
  }

  public void setMeasurementType(String measurementType) {
    this.measurementType = measurementType;
  }
}
