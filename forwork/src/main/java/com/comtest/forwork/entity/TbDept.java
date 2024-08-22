package com.comtest.forwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 部门表(TbDept)
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDept implements Serializable {
    private static final long serialVersionUID = -23123311277103022L;
    /**
     * 部门id
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;

}

