package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "productive_cycle")
public class ProductiveCycleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_cycle_seq")
  @SequenceGenerator(name = "prod_cycle_seq", sequenceName = "prod_cycle_seq", initialValue = 1)
  @Column(name = "productive_cycle_id")
  private Long productiveCycleId;

  @NotNull
  @Column(name = "prod_cycle_start_date", nullable = true)
  private LocalDateTime startDate;

  @NotNull
  @Column(name = "prod_cycle_end_date", nullable = true)
  private LocalDateTime endDate;

  @NotNull
  @Column(name = "prod_cycle_temperature", nullable = true)
  private Float temperature;

  @NotNull
  @Column(name = "prod_cycle_humudity", nullable = true)
  private Float humidity;

  @Size(min=1, max=100, message = "El comentario debe contener entre 1 y 100 caracteres")
  @Column(name = "prod_cycle_comments", length = 100, nullable = true)
  private String comments;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "jt_productcycle_input",
      joinColumns = @JoinColumn(name = "productive_cycle_id", referencedColumnName = "productive_cycle_id"),
      inverseJoinColumns = @JoinColumn(name = "input_id", referencedColumnName = "input_id"))
  private List<InputEntity> inputEntityList;


  public Long getProductiveCycleId() {
    return productiveCycleId;
  }

  public void setProductiveCycleId(Long productiveCycleId) {
    this.productiveCycleId = productiveCycleId;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public Float getTemperature() {
    return temperature;
  }

  public void setTemperature(Float temperature) {
    this.temperature = temperature;
  }

  public Float getHumidity() {
    return humidity;
  }

  public void setHumidity(Float humidity) {
    this.humidity = humidity;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public List<InputEntity> getInputEntityList() {
    return inputEntityList;
  }

  public void setInputEntityList(
      List<InputEntity> inputEntityList) {
    this.inputEntityList = inputEntityList;
  }
}
