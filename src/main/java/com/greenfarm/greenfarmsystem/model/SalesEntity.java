package com.greenfarm.greenfarmsystem.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sales")
public class SalesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_seq")
  @SequenceGenerator(name = "sales_seq", sequenceName = "sales_seq", initialValue = 1)
  @Column(name = "sale_id")
  private Long id;

  @NotNull
  @Column(name = "sale_date", nullable = true)
  private LocalDateTime saleDate;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de cliente debe contener entre 1 y 60 caracteres")
  @Column(name = "sale_client_name", length = 60, nullable = true)
  private String saleClientName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
