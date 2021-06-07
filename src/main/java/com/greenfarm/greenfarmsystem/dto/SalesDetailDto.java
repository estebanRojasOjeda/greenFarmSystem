package com.greenfarm.greenfarmsystem.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Data
public class SalesDetailDto extends ResourceSupport {

  private Long salesId;
  private LocalDateTime saleDate;
  private Float price;
  private String clientName;
  private List<Link> organicProduct;

}
