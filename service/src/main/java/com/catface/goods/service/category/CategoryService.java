package com.catface.goods.service.category;

import com.catface.goods.repository.entity.Category;

import java.util.List;

/**
 * @author catface
 * @since 2022/8/21
 */
public interface CategoryService {

    /**
     * 保存类目
     *
     * @param entity 待保存的类目实体
     */
    void save(Category entity);

    /**
     * 删除类目
     *
     * @param categoryId 待删除类目ID
     * @param clientId   执行删除的客户ID
     */
    void delete(Long categoryId, Long clientId);

    /**
     * 根据父级类目ID查询子类目列表
     *
     * @param parentId 父级类目ID
     * @param clientId 当前操作的客户ID
     * @return 私有类目列表
     */
    List<Category> queryPrivate(Long parentId, Long clientId);

    /**
     * 查询公共类目
     *
     * @param parentId 父级类目ID
     * @return 公共类目列表
     */
    List<Category> queryPublic(Long parentId);

}
