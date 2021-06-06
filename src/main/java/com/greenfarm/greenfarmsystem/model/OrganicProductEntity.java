package com.greenfarm.greenfarmsystem.model;

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
import lombok.Data;

@Entity
@Table(name = "organic_product")
@Data
public class OrganicProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "org_product_seq")
  @SequenceGenerator(name = "org_product_seq", sequenceName = "org_product_seq", initialValue=1)
  @Column(name = "org_product_id")
  private Long Id;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de tipo de insumo organico debe contener entre 1 y 60 caracteres")
  @Column(name = "org_product_name", length = 60, nullable = true)
  private String name;

  @NotNull
  @Column(name = "org_product_price", nullable = true)
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "org_prod_type_id", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_product_type"))
  private OrganicProductTypeEntity organicProductTypeEntity;

}
