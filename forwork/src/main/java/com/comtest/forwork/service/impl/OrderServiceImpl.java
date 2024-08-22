package com.comtest.forwork.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comtest.forwork.entity.TbDept;
import com.comtest.forwork.entity.vo.ChaoQiVo;
import com.comtest.forwork.mapper.OrderMapper;
import com.comtest.forwork.entity.TbOrder;
import com.comtest.forwork.entity.vo.OrderVo;
import com.comtest.forwork.entity.vo.PageVo;
import com.comtest.forwork.service.DeptService;
import com.comtest.forwork.service.OrderService;
import com.comtest.forwork.utils.ResBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TbOrder> implements OrderService {

    @Autowired
    DeptService deptService;

    @Autowired
    OrderMapper orderMapper;

    @Override
    public ResBack saveOrder(TbOrder tbOrder) {

        String check = check(tbOrder);
        if (!check.equals("OK")){
            return ResBack.FAILURE(601, check, null);
        }

        boolean save = super.save(tbOrder);
        if (save){
            return ResBack.SUCCESS(200, "存入成功！", null);
        }
        return ResBack.FAILURE(601, "存入失败！", null);
    }

    @Override
    public ResBack deleteOrder(TbOrder tbOrder) {
        boolean empty = StringUtils.isEmpty(tbOrder.getId());
        if (empty) {
            return ResBack.FAILURE(602, "id为空", null);
        }

        boolean remove = super.removeById(tbOrder);
        if (remove) {
            return ResBack.SUCCESS(200, "删除成功！", null);
        }
        return ResBack.FAILURE(602, "删除失败！", null);
    }

    @Override
    public ResBack updateOrder(TbOrder tbOrder) {
        String check = check(tbOrder);
        if (!check.equals("OK")){
            return ResBack.FAILURE(603, check, null);
        }
        boolean empty = StringUtils.isEmpty(tbOrder.getId());
        if (empty) {
            return ResBack.FAILURE(603, "id为空", null);
        }
        boolean update = super.updateById(tbOrder);
        if (update) {
            return ResBack.SUCCESS(200, "修改成功！", null);
        }
        return ResBack.FAILURE(603, "修改失败！", null);
    }

    @Override
    public ResBack searchOrder(PageVo pageVo) {
        if (pageVo.getPage() == null){
            return ResBack.FAILURE(604, "页码为空", null);
        }
        if (pageVo.getSize() == null){
            return ResBack.FAILURE(604, "size为空", null);
        }

        Page<TbOrder> page = new Page<>(pageVo.getPage(), pageVo.getSize());
        List<TbOrder> records = super.page(page).getRecords();

        return ResBack.SUCCESS(200, "查询成功！", records);
    }

    @Override
    public ResBack fenpaiOrder(OrderVo orderVo) {

        boolean empty = StringUtils.isEmpty(orderVo.getHandleDeptId());
        if (empty) return ResBack.FAILURE(605, "处理部门id为空", null);
        boolean deptExist = deptService.deptExist(new TbDept(orderVo.getHandleDeptId(), orderVo.getDeptName()));
        if (!deptExist){
            return ResBack.FAILURE(605, "部门不存在", null);
        }
        TbOrder order = super.getById(orderVo.getId());
        order.setHandleDeptId(orderVo.getHandleDeptId());
        order.setFenpaiTime(new Timestamp(new Date().getTime()));

        boolean update = super.updateById(order);
        if (update){
            return ResBack.SUCCESS(200, "分派成功！", null);
        }
        return ResBack.FAILURE(605, "分派失败！", null);
    }

    @Override
    public ResBack everyday() {
        List<ChaoQiVo> everyday = orderMapper.everyday();
        return ResBack.SUCCESS(200, "everyday", everyday);
    }

    @Override
    public ResBack everyDept() {
        List<ChaoQiVo> everyDept = orderMapper.everyDept();
        return ResBack.SUCCESS(200, "everyDept", everyDept);
    }


    public String check(TbOrder tbOrder) {
        boolean orderNoEmpty = StringUtils.isEmpty(tbOrder.getOrderNo());
        boolean orderTypeEmpty = StringUtils.isEmpty(tbOrder.getOrderType());
        boolean titleEmpty = StringUtils.isEmpty(tbOrder.getTitle());
        boolean contentEmpty = StringUtils.isEmpty(tbOrder.getContent());

        if (orderNoEmpty) return "工单编号不能为空";
        if (orderTypeEmpty) return "工单类型不能为空";
        if (titleEmpty) return "标题不能为空";
        if (contentEmpty) return "内容不能为空";
        return "OK";
    }
}
