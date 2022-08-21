package com.catface.goods.http.web.controller.category.response;

import com.catface.common.enums.common.VisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author catface
 * @since 2022/8/21
 */
@Data
@ApiModel(description = "类目模型")
public class CategoryResponse {

    @ApiModelProperty(value = "类目ID")
    private Long id;

    @ApiModelProperty(value = "父级类目")
    private Long parentId;

    @ApiModelProperty(value = "所属客户ID")
    private Long clientId;

    @ApiModelProperty(value = "类目名称")
    private String categoryName;

    @ApiModelProperty(value = "类目级别")
    private Long level;

    @ApiModelProperty(value = "可见性")
    private VisibilityEnum visibility;

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
