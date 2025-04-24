package in.myorg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sn;
	@Column(unique = true)
	private String username;
	private String password;

	public Integer getSn() {
		return sn;
	}

	public void setSn(Integer sn) {
		this.sn = sn;
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

	@Override
	public String toString() {
		return "Admin [sn=" + sn + ", username=" + username + ", password=" + password + "]";
	}

	public Admin(Integer sn, String username, String password) {
		super();
		this.sn = sn;
		this.username = username;
		this.password = password;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
