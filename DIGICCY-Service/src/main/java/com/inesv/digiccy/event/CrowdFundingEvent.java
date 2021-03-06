package com.inesv.digiccy.event;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class CrowdFundingEvent {
	private Long id;
    /** 众筹编号 */
    private String ico_no;
    /** 众筹名称 */
    private String ico_name;
    /** 众筹图片 */
    private String ico_photo;
    /** 目标数 */
    private Integer ico_target;
    /** 当前数 */
    private Integer ico_current;
    /** 当前数 */
    private Double ico_status;
    /** 单价*/
    private String ico_price_type;
	/** 单价*/
    private BigDecimal ico_price;
    /** 总价*/
    private BigDecimal ico_sum_price;
    /** 详情*/
    private String ico_remark;
    /** 详情*/
    private String ico_explain;
    /** 状态 :0-未完成，1-完成*/
    private Integer ico_state;

    private Date begin_date;
    
    private Date end_date;

    private String attr1;

    private String attr2;
    
    private String operation;
	
	public CrowdFundingEvent(Long id, String ico_no, String ico_name,
			String ico_photo, Integer ico_target, Integer ico_current,
			Double ico_status, String ico_price_type, BigDecimal ico_price, BigDecimal ico_sum_price,
			String ico_remark, String ico_explain, Integer ico_state, Date begin_date, Date end_date, String attr1, String operation) {
		this.id = id;
		this.ico_no = ico_no;
		this.ico_name = ico_name;
		this.ico_photo = ico_photo;
		this.ico_target = ico_target;
		this.ico_current = ico_current;
		this.ico_status = ico_status;
		this.ico_price_type = ico_price_type;
		this.ico_price = ico_price;
		this.ico_sum_price = ico_sum_price;
		this.ico_remark = ico_remark;
		this.ico_explain = ico_explain;
		this.ico_state = ico_state;
		this.begin_date = begin_date;
		this.end_date = end_date;
		this.attr1 = attr1;
		this.operation = operation;
	}

	public Long getId() {
		return id;
	}

	public String getIco_no() {
		return ico_no;
	}

	public String getIco_name() {
		return ico_name;
	}

	public String getIco_photo() {
		return ico_photo;
	}

	public Integer getIco_target() {
		return ico_target;
	}

	public Integer getIco_current() {
		return ico_current;
	}
	
	public Double getIco_status() {
		return ico_status;
	}

	public String getIco_price_type() {
		return ico_price_type;
	}

	public BigDecimal getIco_price() {
		return ico_price;
	}

	public BigDecimal getIco_sum_price() {
		return ico_sum_price;
	}

	public String getIco_remark() {
		return ico_remark;
	}
	
	public String getIco_explain() {
		return ico_explain;
	}

	public Integer getIco_state() {
		return ico_state;
	}

	public Date getBegin_date() {
		return begin_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public String getAttr1() {
		return attr1;
	}

	public String getAttr2() {
		return attr2;
	}

	public String getOperation() {
		return operation;
	}
}
