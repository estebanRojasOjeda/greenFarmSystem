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

@Entity
@Table(name = "organic_product")
public class OrganicProductEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgproduct_seq")
  @SequenceGenerator(name = "orgproduct_seq", sequenceName = "orgproduct_seq", initialValue=1)
  @Column(name = "orpr_id")
  private Long Id;

  @NotBlank
  @Size(min=1, max=60, message = "El nombre de tipo de insumo organico debe contener entre 1 y 60 caracteres")
  @Column(name = "orpr_name", length = 60, nullable = true)
  private String name;

  @NotNull
  @Column(name = "jt_sapr_price", nullable = true)
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "orpr_opty_id_fk", nullable = false, foreignKey = @ForeignKey(name = "FK_organic_product_type"))
  private OrganicProductTypeEntity organicProductTypeEntity;


  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrganicProductTypeEntity getOrganicProductTypeEntity() {
    return organicProductTypeEntity;
  }

  public void setOrganicProductTypeEntity(
      OrganicProductTypeEntity organicProductTypeEntity) {
    this.organicProductTypeEntity = organicProductTypeEntity;
  }
}
