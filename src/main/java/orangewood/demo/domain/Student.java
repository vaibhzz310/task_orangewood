package orangewood.demo.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Student")
public class Student {

    public Student() {
    }

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
    @NotNull
    @Column(name="first_name", length=50, nullable=false, unique=false)
	private String first_name;
	
    @Column(name="last_name", length=50, unique=false)
	private String last_name;
	
	@NotNull
    @Column(name="date_of_birth", length=50, nullable=false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
	private Date date_of_birth;

	@NotNull
    @Column(name="grade", length=50, nullable=false, unique=false)
	private Integer grade;
	
	@NotNull
    @Column(name="phone", length=50, nullable=false, unique=true)
	private String phone;

	@NotNull
    @Column(name="email", length=50, nullable=false, unique=true)
	private String email;


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth() {
		return this.date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
