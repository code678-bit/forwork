package com.comtest.forwork.controller;


import com.comtest.forwork.entity.TbOrder;
import com.comtest.forwork.entity.vo.OrderVo;
import com.comtest.forwork.entity.vo.PageVo;
import com.comtest.forwork.service.OrderService;
import com.comtest.forwork.utils.ResBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public ResBack save(@RequestBody TbOrder tbOrder) {

        if (tbOrder == null){
            return ResBack.FAILURE(600, "发生异常，请重试。", null);
        }
        return orderService.saveOrder(tbOrder);
    }

    @PostMapping("/delete")
    public ResBack delete(@RequestBody TbOrder tbOrder) {
        if (tbOrder == null){
            return ResBack.FAILURE(600, "发生异常，请重试。", null);
        }
        return orderService.deleteOrder(tbOrder);
    }

    @PostMapping("/update")
    public ResBack update(@RequestBody TbOrder tbOrder) {
        if (tbOrder == null){
            return ResBack.FAILURE(600, "发生异常，请重试。", null);
        }
        return orderService.updateOrder(tbOrder);
    }

    @PostMapping("/search")
    public ResBack search(@RequestBody PageVo pageVo) {
        if (pageVo == null){
            return ResBack.FAILURE(600, "发生异常，请重试。", null);
        }
        return orderService.searchOrder(pageVo);
    }

    @PostMapping("/fenpai")
    public ResBack fenpai(@RequestBody OrderVo orderVo) {
        if (orderVo == null){
            return ResBack.FAILURE(600, "发生异常，请重试。", null);
        }
        return orderService.fenpaiOrder(orderVo);
    }

}
