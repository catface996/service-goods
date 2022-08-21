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
@ApiModel(description = "查询公共类目请求")
public class GetPublicCategoryRequest {

    @ApiModelProperty(value = "父级类目ID", required = true, example = "121212")
    @NotNull(message = "父级类目ID不能为空")
    private Long parentId = -1L;

}
