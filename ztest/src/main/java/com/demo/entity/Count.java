package com.demo.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "count")
public class Count implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	/** 账单价格（单位：分） */
	private Integer countPrice;
	/** 账单备注 */
	private String countRemark;
	/** 创建时间 */
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;

}
