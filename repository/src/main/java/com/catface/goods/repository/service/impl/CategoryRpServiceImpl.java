package com.catface.goods.repository.service.impl;

import com.catface.goods.repository.entity.Category;
import com.catface.goods.repository.mapper.CategoryMapper;
import com.catface.goods.repository.service.CategoryRpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author catface
 * @since 2022-08-20
 */
@Service
public class CategoryRpServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryRpService {

}
