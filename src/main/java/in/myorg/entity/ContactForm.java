package in.myorg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table(name = "ContactFormData")
@Entity
public class ContactForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "*Name Can not be empty")
	@Size(min = 2, max = 30, message = "*Invalid Name")
	private String name;

	@NotEmpty(message = "*Email Can not be empty")
	@Size(min = 5, max = 50, message = "*Invalid Email")
	private String email;

	@NotNull(message = "*Phone Number must not be empty")
	@Min(value = 1000000000, message = "*Number must contain 10 digits")
	@Max(value = 9999999999L, message = "*Number must contain 10 digits")
	private Long phone;

	@NotEmpty(message = "*Message Can not be empty")
	@Size(min = 3, max = 500, message = "*Invalid Message Size ")
	private String message;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactForm [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", message="
				+ message + "]";
	}

	public ContactForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactForm(Integer id, String name, String email, Long phone, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
	}

}
