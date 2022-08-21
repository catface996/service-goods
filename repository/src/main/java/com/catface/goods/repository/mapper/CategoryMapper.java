package com.catface.goods.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.catface.common.enums.common.VisibilityEnum;
import com.catface.goods.repository.entity.Category;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
public interface CategoryMapper extends BaseMapper<Category> {

  /**
   * 查询类目列表
   *
   * @param visibility 可见性
   * @param clientId   客户ID
   * @param parentId   父级类目ID
   * @return 子类目列表
   */
  List<Category> selectChildren(@Param("visibility") VisibilityEnum visibility,
      @Param("clientId") Long clientId, @Param("parentId") Long parentId);
}
