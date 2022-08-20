package com.catface.goods.service.goods.convert;

import com.catface.goods.service.goods.model.GoodsDetailModel;
import com.catface.goods.service.goods.param.SaveGoodsParam;
import org.springframework.cglib.beans.BeanCopier;

/**
 * @author by 大猫
 * @date 2022/4/15 3:22 PM catface996 出品
 */
public class GoodsConvert {

    private GoodsConvert() {}

    private static final BeanCopier PARAM_2_MODEL = BeanCopier.create(SaveGoodsParam.class, GoodsDetailModel.class,
        false);

    public static GoodsDetailModel convert(SaveGoodsParam param) {
        GoodsDetailModel model = new GoodsDetailModel();
        PARAM_2_MODEL.copy(param, model, null);
        return model;
    }
}
