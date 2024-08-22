package com.comtest.forwork.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.comtest.forwork.entity.TbOrder;
import com.comtest.forwork.entity.vo.ChaoQiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<TbOrder> {

    @Select("select DATE(create_time) as text,count(*) as count,sum(is_overdue = 1)/count(*) as chaoqi from tb_order where MONTH(create_time)=7 group by DATE(create_time);")
    public List<ChaoQiVo> everyday();

    @Select("select handle_dept_id as text,count(*) as count,sum(is_overdue = 1)/count(*) as chaoqi from tb_order where MONTH(create_time)=7 group by handle_dept_id;")
    List<ChaoQiVo> everyDept();
}
