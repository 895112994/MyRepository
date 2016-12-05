package org.springmvc.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	private String userName;
	private String password;
	private String tel;
	private String email;
	
	public User() {
	}
	public User(String userName, String password, String tel, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.tel = tel;
		this.email = email;
	}
	@NotEmpty(message="用户名不能为空")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Length(min=4,max=8,message="密码长度必须在4到8之间")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Email(message="邮箱格式不正确")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
