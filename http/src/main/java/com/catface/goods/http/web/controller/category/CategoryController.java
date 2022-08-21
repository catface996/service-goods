package com.catface.goods.http.web.controller.category;

import com.catface.common.model.JsonResult;
import com.catface.goods.http.config.swagger.SwaggerTagConst;
import com.catface.goods.http.web.controller.category.convert.CategoryWebConvert;
import com.catface.goods.http.web.controller.category.request.DeletePrivateCategoryRequest;
import com.catface.goods.http.web.controller.category.request.GetPrivateCategoryRequest;
import com.catface.goods.http.web.controller.category.request.GetPublicCategoryRequest;
import com.catface.goods.http.web.controller.category.request.SaveCategoryRequest;
import com.catface.goods.http.web.controller.category.response.CategoryResponse;
import com.catface.goods.repository.entity.Category;
import com.catface.goods.service.category.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author catface
 * @since 2022/8/21
 */
@Api(tags = {SwaggerTagConst.CATEGORY})
@Slf4j
@RestController
public class CategoryController {

  private final CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @ApiOperation(value = "保存类目")
  @PostMapping(value = "/public/category/save")
  public JsonResult<Boolean> save(@RequestBody @Valid SaveCategoryRequest request) {
    Category entity = CategoryWebConvert.convert(request);
    categoryService.save(entity);
    return JsonResult.success();
  }

  @ApiOperation(value = "查询私有类目")
  @PostMapping(value = "/public/category/getPrivate")
  public JsonResult<List<CategoryResponse>> getPrivate(
      @RequestBody @Valid GetPrivateCategoryRequest request) {
    List<Category> list = categoryService.queryPrivate(request.getParentId(),
        request.getCtxClientId());
    List<CategoryResponse> responses = CategoryWebConvert.convert(list);
    return JsonResult.success(responses);
  }

  @ApiOperation(value = "查询公共类目")
  @PostMapping(value = "/anonymous/category/getPublic")
  public JsonResult<List<CategoryResponse>> getPublic(
      @RequestBody @Valid GetPublicCategoryRequest request) {
    List<Category> list = categoryService.queryPublic(request.getParentId());
    List<CategoryResponse> responses = CategoryWebConvert.convert(list);
    return JsonResult.success(responses);
  }

  @ApiOperation(value = "删除私有类目")
  @PostMapping(value = "/public/category/deletePrivate")
  public JsonResult<Boolean> deletePrivate(
      @RequestBody @Valid DeletePrivateCategoryRequest request) {
    categoryService.delete(request.getCategoryId(), request.getCtxClientId());
    return JsonResult.success(true);
  }

}
