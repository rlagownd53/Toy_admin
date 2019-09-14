package com.kimhj.toy.member.vo;

import org.apache.ibatis.type.Alias;

@Alias("memberVO")
public class MemberVO {
	private int no;
	private String userId;
	private String name;
	private String nickname;
	private String password;
	private String email;
	private String useFlag;
	private String createTime;
	private String creater;
	private String modifyTime;
	private String mofifier;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getUseFlag() {
		return useFlag;
	}
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getMofifier() {
		return mofifier;
	}
	public void setMofifier(String mofifier) {
		this.mofifier = mofifier;
	}
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", userId=" + userId + ", name=" + name + ", nickname=" + nickname + ", password="
				+ password + ", email=" + email + ", useFlag=" + useFlag + ", createTime=" + createTime + ", creater="
				+ creater + ", modifyTime=" + modifyTime + ", mofifier=" + mofifier + "]";
	}
}
