package cn.ccocow.gulimall.product.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {
  private Integer pageNum;
  private Integer pageSize;
  private String search;
}
