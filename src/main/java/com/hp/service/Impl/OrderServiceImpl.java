package com.hp.service.Impl;

import com.hp.dao.OrderMapper;
import com.hp.pojo.Orders;
import com.hp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Curtain-call
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有订单
     *
     * @return 返回一个List，实现查询功能
     */
    @Override
    public List<Orders> getFindOrderAll() {
        return orderMapper.getFindOrderAll();
    }

    /**
     * 根据id查询订单
     *
     * @param id :
     * @return 返回一个List，实现根据ID查询功能
     */
    @Override
    public List<Orders> getFindOrderById(int id) {
        return orderMapper.getFindOrderById(id);
    }

    /**
     * 根据order.id查询goods.name
     *
     * @param id :
     * @return 返回一个List
     */
    @Override
    public List<Orders> getOrderGoodNameById(int id) {
        return orderMapper.getOrderGoodNameById(id);
    }
}
