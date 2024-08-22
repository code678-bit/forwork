package com.comtest.forwork.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.comtest.forwork.entity.TbDept;
import com.comtest.forwork.mapper.DeptMapper;
import com.comtest.forwork.service.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, TbDept> implements DeptService {
    @Override
    public boolean deptExist(TbDept tbDept) {
        QueryWrapper<TbDept> wrapper = new QueryWrapper<>();
        wrapper.eq("dept_id", tbDept.getDeptId());
        TbDept one = super.getOne(wrapper);
        if (one != null) {
            return true;
        }
        return false;
    }
}
