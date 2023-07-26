package com.hp;

import com.hp.dao.GoodMapper;
import com.hp.dao.OrderMapper;
import com.hp.pojo.Admins;
import com.hp.pojo.Goods;
import com.hp.pojo.Orders;
import com.hp.service.AdminsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShangmiMallApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void contextLoads() {
       /* List<Orders> findOrderById = orderMapper.getFindOrderById();
        System.out.println(findOrderById);*/
    }

}
