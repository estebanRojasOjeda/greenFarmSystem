package com.greenfarm.greenfarmsystem.dto;

import com.greenfarm.greenfarmsystem.model.OrganicProductEntity;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class SalestDto extends ResourceSupport {
  private Long salesId;
  private String clientName;
  private LocalDateTime saleDate;
  private Float price;
  private OrganicProductEntity organicProductTypeEntity;
}
