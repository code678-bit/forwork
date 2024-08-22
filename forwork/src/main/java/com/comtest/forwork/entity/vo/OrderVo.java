package com.comtest.forwork.entity.vo;

import lombok.Data;

@Data
public class OrderVo {

    /**
     * id
     */
    private Integer id;
    /**
     * 处理部门id
     */
    private Integer handleDeptId;
    /**
     * 部门名称
     */
    private String deptName;

}
