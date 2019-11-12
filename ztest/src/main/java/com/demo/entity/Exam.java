package com.demo.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 正文
     */
    private String text;
    /**
     * 状态(0: 正常，-1: 删除)
     */
    private Integer status;


}
