package com.inesv.digiccy.dto;

import java.util.Date;

/**
 * Created by JimJim on 2016/12/16 0016.
 */
public class InterfaceAddressDto {

	/**编号*/
    private int id;
    /**用户编号*/
    private long user_no;
    /**接口ID*/
    private String address_no;
    /**是否认证*/
    private int state;
    /**操作日期*/
    private Date date;
    /**密匙*/
    private String sign;
    /**备用字段1*/
    private String attr1;
    /**备用字段2*/
    private String attr2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getUser_no() {
		return user_no;
	}
	public void setUser_no(long user_no) {
		this.user_no = user_no;
	}
	public String getAddress_no() {
		return address_no;
	}
	public void setAddress_no(String address_no) {
		this.address_no = address_no;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getAttr2() {
		return attr2;
	}
	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}
	
}
