package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.OrganicInputEntity;
import com.greenfarm.greenfarmsystem.model.TechInputEntity;
import java.time.LocalDateTime;

public class ProductiveCycleDto {

  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private OrganicInputEntity organicInputEntity;
  private TechInputEntity techInputEntity;
  private Float temperature;
  private Float humidity;
  private String comments;


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

  public OrganicInputEntity getOrganicInputEntity() {
    return organicInputEntity;
  }

  public void setOrganicInputEntity(
      OrganicInputEntity organicInputEntity) {
    this.organicInputEntity = organicInputEntity;
  }

  public TechInputEntity getTechInputEntity() {
    return techInputEntity;
  }

  public void setTechInputEntity(TechInputEntity techInputEntity) {
    this.techInputEntity = techInputEntity;
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
}
