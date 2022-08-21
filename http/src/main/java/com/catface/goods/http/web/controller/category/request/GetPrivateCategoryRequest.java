package com.catface.goods.http.web.controller.category.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author catface
 * @since 2022/8/21
 */
@Data
@ApiModel(description = "查询私有类目请求")
public class GetPrivateCategoryRequest {

    @ApiModelProperty(value = "会话中的客户ID", required = true, example = "1234567890")
    @NotNull(message = "客户ID不能为空")
    private Long ctxClientId;

    @ApiModelProperty(value = "会话中的用户ID", required = true, example = "9876543210")
    @NotNull(message = "用户ID不能为空")
    private Long ctxUserId;

    @ApiModelProperty(value = "父级类目ID", required = true, example = "121212")
    @NotNull(message = "父级类目ID不能为空")
    private Long parentId = -1L;
}
