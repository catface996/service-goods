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
 * 商品
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GoodsSpuSnap对象", description="商品")
public class GoodsSpuSnap implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "spu id，主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "spu名称")
    private String spuName;

    @ApiModelProperty(value = "商品类目ID")
    private Long categoryId;

    @ApiModelProperty(value = "客户ID")
    private Long clientId;

    @ApiModelProperty(value = "创建人")
    private Long creator;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "创建时间")
    private Date created;

    @ApiModelProperty(value = "更新时间")
    private Date updated;

    @ApiModelProperty(value = "备注")
    private String remark;


}
