package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="loginuser")
public class LoginUser {
	
	@NotEmpty(message="用户名不能为空")
	private String loginName;
	
	@NotEmpty(message="密码不能为空")
	private String password;
	
	private String realName;
	
	
	@NotEmpty(message="邮箱不能为空！")
	@Email(message="邮件格式不正确！")
	private String mail;
	
	@Id
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

}
