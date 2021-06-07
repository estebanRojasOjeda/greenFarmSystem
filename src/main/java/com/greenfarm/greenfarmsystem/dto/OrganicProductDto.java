package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.InputCategoryEntity;
import com.greenfarm.greenfarmsystem.model.InputTypeEntity;
import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class OrganicProductDto extends ResourceSupport {
  private Long organicProductId;
  private String name;
  private String price;
  private OrganicProductEntity organicProductTypeEntity;
}
