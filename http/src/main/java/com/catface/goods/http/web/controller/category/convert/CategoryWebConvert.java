package com.catface.goods.http.web.controller.category.convert;

import com.catface.goods.http.web.controller.category.request.SaveCategoryRequest;
import com.catface.goods.http.web.controller.category.response.CategoryResponse;
import com.catface.goods.repository.entity.Category;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author catface
 * @since 2022/8/21
 */
public class CategoryWebConvert {

  private static final BeanCopier SAVE_CATEGORY_REQUEST_2_ENTITY = BeanCopier.create(
      SaveCategoryRequest.class, Category.class, false);

  private static final BeanCopier ENTITY_2_RESPONSE = BeanCopier.create(Category.class,
      CategoryResponse.class, false);

  public static Category convert(SaveCategoryRequest request) {
    Category entity = new Category();
    SAVE_CATEGORY_REQUEST_2_ENTITY.copy(request, entity, null);
    Date date = DateTime.now().toDate();
    if (entity.getId() == null) {
      entity.setCreator(request.getCtxUserId());
      entity.setCreated(date);
    }
    entity.setModifier(request.getCtxUserId());
    entity.setUpdated(date);

    entity.setClientId(request.getCtxClientId());
    return entity;
  }

  public static CategoryResponse convert(Category entity) {
    CategoryResponse response = new CategoryResponse();
    ENTITY_2_RESPONSE.copy(entity, response, null);
    return response;
  }

  public static List<CategoryResponse> convert(List<Category> entities) {
    List<CategoryResponse> list = new ArrayList<>();
    for (Category entity : entities) {
      list.add(convert(entity));
    }
    return list;
  }


}
