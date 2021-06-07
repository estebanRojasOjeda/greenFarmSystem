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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "sales")
@Data
public class SalesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_seq")
  @SequenceGenerator(name = "sales_seq", sequenceName = "sales_seq", initialValue = 1)
  @Column(name = "sale_id")
  private Long salesId;

  @NotNull
  @Column(name = "sale_date", nullable = true)
  private LocalDateTime saleDate;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de cliente debe contener entre 1 y 60 caracteres")
  @Column(name = "sale_client_name", length = 60, nullable = true)
  private String saleClientName;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "jt_sales_organicproduct",
      joinColumns = @JoinColumn(name = "sale_id", referencedColumnName = "sale_id"),
      inverseJoinColumns = @JoinColumn(name = "org_product_id", referencedColumnName = "org_product_id"))
  private List<OrganicProductEntity> organicProductEntityList;

}
