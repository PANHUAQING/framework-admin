package com.frame.admin.model;

import java.util.Date;

public class OmEmpT {
    private Long id;

    private String loginname;

    private String username;

    private String password;

    private Byte sex;

    private Byte age;

    private Byte usertype;

    private Byte status;

    private Date createdate;

    private String phone;
    
    private String strStatus;
    
    private String  strUsertype;
    
    private String strCreatedate;
    
    
    

    public String getStrUsertype() {
		return strUsertype;
	}

	public void setStrUsertype(String strUsertype) {
		this.strUsertype = strUsertype;
	}

	public String getStrCreatedate() {
		return strCreatedate;
	}

	public void setStrCreatedate(String strCreatedate) {
		this.strCreatedate = strCreatedate;
	}

	public String getStrStatus() {
		return strStatus;
	}

	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Byte getUsertype() {
        return usertype;
    }

    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}