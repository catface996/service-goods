package com.catface.goods.repository.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.catface.common.enums.common.VisibilityEnum;
import com.catface.goods.repository.entity.Category;
import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface CategoryRpService extends IService<Category> {

  /**
   * 查询子类目列表
   *
   * @param visibility 可见性
   * @param clientId   类目所属客户ID
   * @param parentId   父级类目ID
   * @return 子类目列表
   */
  List<Category> queryList(VisibilityEnum visibility, Long clientId, Long parentId);
}
