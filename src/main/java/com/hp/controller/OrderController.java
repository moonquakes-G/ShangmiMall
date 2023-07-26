package com.hp.controller;

import com.hp.pojo.Orders;
import com.hp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/toOrder_List")
    public String toOrder_List(Model model) {
        List<Orders> findOrderAll = orderService.getFindOrderAll();
        model.addAttribute("findOrderAll",findOrderAll);

        System.out.println("【debug】====>获取到的order"+findOrderAll);
        return "admin/order_list";
    }
}
