package com.wonders.commons.dto;

import java.io.Serializable;

/**
 * UserProvider返回给Consumer的通用返回结果类型。
 * 定义此类型为统一规范。
 */
public class UserProviderResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	// 状态编码， 如： 200 - 操作成功， 500 - 服务器错误， 400 - 客户端请求错误等。
	private int status;
	// 服务响应消息内容
	private String message;
	// 服务响应数据对象
	private Object data;
	public static UserProviderResponse ok(){
		return new UserProviderResponse(200, "处理成功", null);
	}
	public static UserProviderResponse ok(Object data){
		return new UserProviderResponse(200, "处理成功", data);
	}
	public static UserProviderResponse ok(String message, Object data){
		return new UserProviderResponse(200, message, data);
	}
	public static UserProviderResponse build(int status, String message, Object data){
		return new UserProviderResponse(status, message, data);
	}
	public static UserProviderResponse error(){
		return new UserProviderResponse(500, "处理失败", null);
	}
	public static UserProviderResponse error(Object data){
		return new UserProviderResponse(500, "处理失败", data);
	}
	public static UserProviderResponse error(String message, Object data){
		return new UserProviderResponse(500, message, data);
	}
	public UserProviderResponse() {
		super();
	}
	public UserProviderResponse(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
