package com.comtest.forwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * 工单表(TbOrder)
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbOrder implements Serializable {
    private static final long serialVersionUID = -56414857934141340L;
    /**
     * id
     */
    private Integer id;
    /**
     * 工单编号
     */
    private String orderNo;
    /**
     * 工单类型（0交办 1直接答复 3无效工单）
     */
    private Integer orderType;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 处理部门id
     */
    private Integer handleDeptId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 分派时间
     */
    private Date fenpaiTime;
    /**
     * 是否超期（0否 1是）
     */
    private Integer isOverdue;

}

