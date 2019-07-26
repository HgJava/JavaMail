package com.test.mail.domain;

/**
 * 用户实体类
 * 
 * @author 劳资独宠一方 `uid` int(11) NOT NULL AUTO_INCREMENT, `username` varchar(20)
 *         DEFAULT NULL, `password` varchar(20) DEFAULT NULL, `nickname`
 *         varchar(20) DEFAULT NULL, `email` varchar(30) DEFAULT NULL, `state`
 *         int(11) DEFAULT NULL, `code` varchar(64) DEFAULT NULL,
 */
public class User {

	private Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String emil;
	private Integer state;
	private String code;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmil() {
		return emil;
	}

	public void setEmil(String emil) {
		this.emil = emil;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User() {
		super();
	}

	public User(Integer uid, String username, String password, String nickname, String emil, Integer state,
			String code) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.emil = emil;
		this.state = state;
		this.code = code;
	}

}
