package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.ProductiveCycleEntity;
import java.util.List;
import lombok.Data;


@Data
public class ProductionRequestDto {

  private ProductiveCycleEntity productiveCycleEntity;
  private Long amount;
  private List<Long> organicProductIds;
}
