package com.catface.goods.service.category.impl;

import com.catface.common.enums.common.VisibilityEnum;
import com.catface.goods.repository.entity.Category;
import com.catface.goods.repository.service.CategoryRpService;
import com.catface.goods.service.category.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/21
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRpService categoryRpService;

    public CategoryServiceImpl(CategoryRpService categoryRpService) {
        this.categoryRpService = categoryRpService;
    }


    /**
     * 保存类目
     *
     * @param entity 待保存的类目实体
     */
    @Override
    public void save(Category entity) {

        // 首先判断是否是更新,如果是,需要检查原类目的归属于当前待保存的类目归属是否一致
        if (entity.getId() != null) {
            Category entityExist = categoryRpService.getById(entity.getId());
            Assert.notNull(entityExist, "待更新的类目不存在");
            Assert.state(entity.getClientId().equals(entityExist.getClientId()), "禁止修改其他客户的类目");
        }

        if (entity.getParentId().equals(-1L)) {
            // 如果父级类目id是-1,类目的level即为1,否则取父级类目的级别+1
            entity.setLevel(1);
        } else {
            Category parent = categoryRpService.getById(entity.getParentId());
            Assert.notNull(parent, "无效的父级类目");
            Assert.state(parent.getVisibility() == VisibilityEnum.PRIVATE, "禁止在公共类目下创建类目");
            // 检查父级类目是否存在,如果存在,需要检查父级类目所属客户是否与当前可与一致
            Assert.state(parent.getClientId().equals(entity.getClientId()), "禁止使用其他客户的类目");
            // 当前要创建的类目的level为父级类目的level+1
            entity.setLevel(parent.getLevel() + 1);
        }

        // 设置类目为私有
        entity.setVisibility(VisibilityEnum.PRIVATE);

        // 执行新增或者更新类目
        categoryRpService.saveOrUpdate(entity);
    }

    /**
     * 删除类目
     *
     * @param categoryId 待删除类目ID
     * @param clientId   执行删除的客户ID
     */
    @Override
    public void delete(Long categoryId, Long clientId) {

    }

    /**
     * 根据父级类目ID查询子类目列表
     *
     * @param parentId 父级类目ID
     * @param clientId 当前操作的客户ID
     * @return 私有类目列表
     */
    @Override
    public List<Category> queryPrivate(Long parentId, Long clientId) {
        return null;
    }

    /**
     * 查询公共类目
     *
     * @param parentId 父级类目ID
     * @return 公共类目列表
     */
    @Override
    public List<Category> queryPublic(Long parentId) {
        return null;
    }
}
