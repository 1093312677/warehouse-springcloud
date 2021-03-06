package com.kone.productservice.service;

import com.kone.utils.bo.ProductByDayBO;
import com.kone.utils.conditions.CommonCondition;
import com.kone.utils.entity.OrderProduct;
import com.kone.utils.entity.ProductMaterial;
import com.kone.utils.msg.ResponseMsg;

import java.util.List;

public interface IProductMaterialService {

    ResponseMsg saveProductMaterial(ProductMaterial productMaterial);

    ResponseMsg<List<ProductMaterial>> viewProductMaterialByProductId(CommonCondition condition);

    /**
     * 通过时间段查看产品的入库统计
     *    查询该时间段，入库该产品的总量
     * @param condition 通过group by统计的总数，和该产品对应的id，通过id查询材料的详细
     * @return
     */
    ResponseMsg<List<ProductByDayBO>> viewProductInByDay(CommonCondition condition);

    /**
     * 通过时间段查看产品的出库统计
     *    查询该时间段，出库该产品的总量
     * @param condition 通过group by统计的总数，和该产品对应的id，通过id查询材料的详细
     * @return
     */
    ResponseMsg<List<ProductByDayBO>> viewProductOutByDay(CommonCondition condition);

    /**
     * 修改入库记录的数量，会相应增加或减少库存
     * @param productMaterial 主要包括产品记录id和产品新的的入库数量
     * @return
     */
    ResponseMsg updateProductInRecord(ProductMaterial productMaterial);

    /**
     * 查看产品出库记录
     * @param condition
     * @return
     */
    ResponseMsg<List<OrderProduct>> viewProductOutBoundRecord(CommonCondition condition);

    /**
     * 修改出库记录的数量，会相应增加或减少库存
     * @param orderProduct 主要包括产品记录id和产品新的的出库数量
     * @return
     */
    ResponseMsg updateProductOutRecord(OrderProduct orderProduct);
}
