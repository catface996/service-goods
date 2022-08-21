package com.catface.goods.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品sku
 * </p>
 *
 * @author catface
 * @since 2022-08-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GoodsSku对象", description="商品sku")
public class GoodsSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "sku id，主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "sku id")
    private Long skuId;

    @ApiModelProperty(value = "快照ID")
    private Long skuSnapId;

    @ApiModelProperty(value = "sku名称")
    private String skuName;

    @ApiModelProperty(value = "图片，json数组")
    private String images;

    @ApiModelProperty(value = "所属客户")
    private Long clientId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "修改时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
