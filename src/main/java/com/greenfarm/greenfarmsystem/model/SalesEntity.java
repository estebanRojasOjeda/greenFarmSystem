package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class SalesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_seq")
  @SequenceGenerator(name = "sales_seq", sequenceName = "sales_seq")
  @Column(name = "sale_id")
  private Integer id;

  @Column(name = "sale_date")
  private LocalDateTime saleDate;

  @Column(name = "sale_client_name")
  private String saleClientName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(LocalDateTime saleDate) {
    this.saleDate = saleDate;
  }

  public String getSaleClientName() {
    return saleClientName;
  }

  public void setSaleClientName(String saleClientName) {
    this.saleClientName = saleClientName;
  }
}
