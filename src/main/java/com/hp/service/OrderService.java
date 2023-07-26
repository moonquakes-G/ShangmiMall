package com.hp.service;

import com.hp.pojo.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Curtain-call
 */
public interface OrderService {

    /**
     * 查询所有订单
     * @return 返回一个List，实现查询功能
     */
    List<Orders> getFindOrderAll();

    /**
     * 根据id查询订单
     * @param id:
     * @return 返回一个List，实现根据ID查询功能
     */
    List<Orders> getFindOrderById(int id);

    /**
     * 根据order.id查询goods.name
     * @param id:
     * @return 返回一个List
     */
    List<Orders> getOrderGoodNameById(int id);
}
