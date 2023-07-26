package com.hp.dao;

import com.hp.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Curtain-call
 */
@Mapper
public interface OrderMapper {

    /**
     * 查询所有订单
     * @return 返回一个List，实现查询功能
     */
    @Select("select orders.*,goods.`name` AS goodName ,items.price,items.amount AS itemsAmount,users.`name` AS username from orders,items,goods,users WHERE orders.id=items.order_id AND goods.id=items.good_id AND users.id = orders.user_id")
    List<Orders> getFindOrderAll();

    /**
     * 根据id查询订单
     * @param id:
     * @return 返回一个List，实现根据ID查询功能
     */
    @Select("select orders.*,goods.`name` AS goodName ,items.price,items.amount AS itemsAmount,users.`name` AS username from orders,items,goods,users WHERE orders.id=items.order_id AND goods.id=items.good_id AND users.id = orders.user_id  AND orders.id=#{id}")
    List<Orders> getFindOrderById(@Param("id") int id);


    /**
     * 根据order.id查询goods.name
     * @param id:
     * @return 返回一个List
     */
    @Select("SELECT orders.id,goods.`name`,items.price,items.amount FROM orders,items,goods WHERE orders.id=items.order_id AND items.good_id=goods.id AND orders.id=#{id}")
    List<Orders> getOrderGoodNameById(int id);
}
