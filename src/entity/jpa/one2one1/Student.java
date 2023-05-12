package entity.jpa.one2one1;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student_o2o1")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "address_id")
    private Address address;
	private String gender;
	private String major;


	public Student() {
	}
	

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public entity.jpa.one2one1.Address getAddress() {
		return address;
	}
	public void setAddress(entity.jpa.one2one1.Address address) {
		this.address = address;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}