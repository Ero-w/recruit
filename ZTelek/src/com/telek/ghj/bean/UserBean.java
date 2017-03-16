package com.telek.ghj.bean;

public class UserBean {
	private Long userid;
	private String email;
	private String password;
	private String realname;
	private String mobile;
	private String sex;
	private String school;
	private String major;
	private String degree;
	private String cet;
	private String java;
	private String html;
	private String spring;
	private String project;
	private String practice;
	private String picture;
	private String filepath;
	private String state;
	private String remark;
	private String place;
	private String political;
	private String birthday;
	
	public UserBean(){
		
	}
	
	
	public UserBean(Long userid, String email, String password,
			String realname, String mobile, String sex, String school,
			String major, String degree, String cet, String java, String html,
			String spring, String project, String practice, String picture,
			String filepath, String state, String remark, String place,
			String political, String birthday) {
		super();
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.realname = realname;
		this.mobile = mobile;
		this.sex = sex;
		this.school = school;
		this.major = major;
		this.degree = degree;
		this.cet = cet;
		this.java = java;
		this.html = html;
		this.spring = spring;
		this.project = project;
		this.practice = practice;
		this.picture = picture;
		this.filepath = filepath;
		this.state = state;
		this.remark = remark;
		this.place = place;
		this.political = political;
		this.birthday = birthday;
	}
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCet() {
		return cet;
	}
	public void setCet(String cet) {
		this.cet = cet;
	}
	public String getJava() {
		return java;
	}
	public void setJava(String java) {
		this.java = java;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getSpring() {
		return spring;
	}
	public void setSpring(String spring) {
		this.spring = spring;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPractice() {
		return practice;
	}
	public void setPractice(String practice) {
		this.practice = practice;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPolitical() {
		return political;
	}
	public void setPolitical(String political) {
		this.political = political;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
