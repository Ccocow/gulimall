package cn.ccocow.gulimall.product.entity;

import cn.ccocow.gulimall.valid.AddGroup;
import cn.ccocow.gulimall.valid.UpdateGroup;
import cn.ccocow.gulimall.valid.annotation.ListValue;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

/**
 * 品牌
 *
 * @author Ccocow
 * @email
 * @date 2024-06-15 17:21:21
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 品牌id
   */
  @TableId
  @Null(message = "新增不能指定id", groups = {AddGroup.class})
  @NotNull(message = "修改必须指定id", groups = {UpdateGroup.class})
  private Long brandId;
  /**
   * 品牌名
   */
  @NotBlank(message = "品牌不能为空", groups = {AddGroup.class, UpdateGroup.class})
  private String name;
  /**
   * 品牌logo地址
   */
  @NotEmpty(message = "品牌logo地址不能为空", groups = {AddGroup.class})
  @URL(message = "品牌logo地址必须是一个合法的url地址", groups = {AddGroup.class, UpdateGroup.class})
  private String logo;
  /**
   * 介绍
   */
  private String descript;
  /**
   * 显示状态[0-不显示；1-显示]
   */
  @ListValue(values = {0, 1}, groups = {AddGroup.class})
  private Integer showStatus;
  /**
   * 检索首字母
   */
  @NotEmpty(message = "检索首字母不能为空", groups = {AddGroup.class})
  @Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {AddGroup.class, UpdateGroup.class})
  private String firstLetter;
  /**
   * 排序
   */
  @NotNull(message = "排序不能为空")
  @Min(value = 0, message = "排序必须大于0")
  private Integer sort;

}
