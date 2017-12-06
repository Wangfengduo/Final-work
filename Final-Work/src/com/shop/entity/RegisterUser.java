package com.shop.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="registeruser")
public class RegisterUser {
	@NotEmpty(message="登录账号不能为空!!!!!!!!!!!!！")
	@Id
	private String loginName;
	
	@Pattern(regexp="[0-9a-zA-Z]{6,30}", message="密码是6-30个字符，必须是字母或数字组合！")

	private String password;
	@NotEmpty(message="邮箱不能为空！")
	@Email(message="邮件格式不正确！")
	private String email;
	
	private String realName;
	
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
