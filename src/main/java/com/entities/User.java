package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(length=10, name="user_id")
	private int userid;
	@Column(length=100, name="user_name")
	private String username;
	@Column(length=200, name="user_email")
	private String useremail;
	@Column(length=100, name="user_pass")
	private String password;
	@Column(length=12, name="user_phone")
	private String phoneno;
	@Column(length=1500, name="user_pic")
	private String userpic;
	@Column(length=1500, name="user_address")
	private String userAddress;
	@Column(length = 50, name="user_type")
	private String usertype;

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", useremail=" + useremail + ", password="
				+ password + ", phoneno=" + phoneno + ", userpic=" + userpic + ", userAddress=" + userAddress +
				"usertype=" + usertype + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getUserpic() {
		return userpic;
	}
	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public User() {
	}

	public User(String username, String useremail, String password, String phoneno, String userpic,
				String userAddress, String usertype) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.password = password;
		this.phoneno = phoneno;
		this.userpic = userpic;
		this.userAddress = userAddress;
		this.usertype=usertype;
	}
	public User(int userid, String username, String useremail, String password, String phoneno, String userpic,
				String userAddress, String usertype) {
		super();
		this.userid = userid;
		this.username = username;
		this.useremail = useremail;
		this.password = password;
		this.phoneno = phoneno;
		this.userpic = userpic;
		this.userAddress = userAddress;
		this.usertype=usertype;
	}

}
