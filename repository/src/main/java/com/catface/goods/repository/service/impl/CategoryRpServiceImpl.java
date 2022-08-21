package com.catface.goods.repository.service.impl;

import com.catface.common.enums.common.VisibilityEnum;
import com.catface.goods.repository.entity.Category;
import com.catface.goods.repository.mapper.CategoryMapper;
import com.catface.goods.repository.service.CategoryRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
@Slf4j
@Service
public class CategoryRpServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryRpService {

  /**
   * 查询子类目列表
   *
   * @param visibility 可见性
   * @param clientId   类目所属客户ID
   * @param parentId   父级类目ID
   * @return 子类目列表
   */
  @Override
  public List<Category> queryList(VisibilityEnum visibility, Long clientId, Long parentId) {
    return baseMapper.selectChildren(visibility,clientId,parentId);
  }
}
