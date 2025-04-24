package in.myorg.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "BookingFormData")
public class BookingForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotBlank(message = "*Name can not be  blank")
	private String name;

	
	@NotBlank(message = "*Source can not be blank")
    private String source;

	
	

	@NotNull(message="*Phone Number must not be empty")
	@Min(value=1000000000, message="*Number must contain 10 digits")
	@Max(value=9999999999L, message="*Number must contain 10 digits")
	private Long phone;

	
	@NotBlank(message = "*Destination can not be blank")
	private String destination;
	
	
    @NotNull(message = "*Time can not be empty")
	private LocalTime time;
    @NotNull(message = "*Date can not be empty")
	private LocalDate date;
    
    
	@NotEmpty(message = "*Choose your comfort")
	private String comfort;
	
	@Min(value=1 ,message = "*Adult must be atleast 1 ")
	@Max(value=4 ,message = "*Adult can be atmost 4 ")
	private Integer adult;
	
	@Max(value=3,message = "*Children can be atmost 3 ")
	private Integer children;
	
	
	@NotBlank(message = "*Message can not be blank")
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


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public Long getPhone() {
		return phone;
	}


	public void setPhone(Long phone) {
		this.phone = phone;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getComfort() {
		return comfort;
	}


	public void setComfort(String comfort) {
		this.comfort = comfort;
	}


	public Integer getAdult() {
		return adult;
	}


	public void setAdult(Integer adult) {
		this.adult = adult;
	}


	public Integer getChildren() {
		return children;
	}


	public void setChildren(Integer children) {
		this.children = children;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public String toString() {
		return "BookingForm [id=" + id + ", name=" + name + ", source=" + source + ", phone=" + phone + ", destination="
				+ destination + ", time=" + time + ", date=" + date + ", comfort=" + comfort + ", adult=" + adult
				+ ", children=" + children + ", message=" + message + "]";
	}


	public BookingForm() {
		
	}

	
}
