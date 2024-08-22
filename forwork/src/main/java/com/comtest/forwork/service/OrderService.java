package com.comtest.forwork.service;

import com.comtest.forwork.entity.TbOrder;
import com.comtest.forwork.entity.vo.OrderVo;
import com.comtest.forwork.entity.vo.PageVo;
import com.comtest.forwork.utils.ResBack;

public interface OrderService{
    ResBack saveOrder(TbOrder tbOrder);

    ResBack deleteOrder(TbOrder tbOrder);

    ResBack updateOrder(TbOrder tbOrder);

    ResBack searchOrder(PageVo pageVo);

    ResBack fenpaiOrder(OrderVo orderVo);

    ResBack everyday();

    ResBack everyDept();

}
