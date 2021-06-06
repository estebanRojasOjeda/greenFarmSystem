package com.greenfarm.greenfarmsystem.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class ProductiveCycleDetailDto extends ResourceSupport {

  private Long productiveCycleId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Float temperature;
  private Float humidity;
  private String comments;
  private List<Link> inputEntity;

}
