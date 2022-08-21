package com.catface.goods.http.web.controller.category.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.catface.common.enums.common.VisibilityEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author catface
 * @since 2022/8/21
 */
@Data
@ApiModel(description = "保存类目请求")
public class SaveCategoryRequest {

    @ApiModelProperty(value = "类目ID")
    private Long id;

    @ApiModelProperty(value = "父级类目ID",required = true,example = "121212")
    @NotNull(message = "父级类目ID不能为空")
    private Long parentId = -1L;

    @ApiModelProperty(value = "会话中的客户ID",required = true,example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "类目名称",required = true,example = "鞋帽")
    @NotNull(message = "类目名称不能为空")
    private String categoryName;

    @ApiModelProperty(value = "类目级别",required = true,example = "2")
    @NotNull(message = "类目级别不能为空")
    private Integer level;

    @ApiModelProperty(value = "会话中的用户ID",required = true,example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "备注")
    private String remark;
}
