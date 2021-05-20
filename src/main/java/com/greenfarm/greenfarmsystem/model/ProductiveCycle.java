package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productive_cycle")
public class ProductiveCycle {

  @Id
  @Column(name = "prcy_id")
  private Integer id;

  @Column(name = "prcy_start_date")
  private LocalDateTime start_date;

  @Column(name = "prcy_end_date")
  private LocalDateTime end_date;

  @Column(name = "prcy_electricity")
  private Integer electricity;

  @Column(name = "prcy_water_amount")
  private Integer water_amount;

  @Column(name = "prcy_production_amount")
  private Integer prodution_amount;


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

  public Integer getElectricity() {
    return electricity;
  }

  public void setElectricity(Integer electricity) {
    this.electricity = electricity;
  }

  public Integer getWater_amount() {
    return water_amount;
  }

  public void setWater_amount(Integer water_amount) {
    this.water_amount = water_amount;
  }

  public Integer getProdution_amount() {
    return prodution_amount;
  }

  public void setProdution_amount(Integer prodution_amount) {
    this.prodution_amount = prodution_amount;
  }
}
