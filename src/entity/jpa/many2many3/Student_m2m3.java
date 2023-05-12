package entity.jpa.many2many3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student_m2m3")
public class Student_m2m3 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String gender;
	private String name;
	private String major;
	@OneToMany(cascade = { CascadeType.ALL },mappedBy="student")
	private Collection<Course> courses= new  ArrayList<Course>();
	
	public Student_m2m3() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Collection<Course> getCourses() {
        return this.courses;
    }
    public void setCoursess(Collection courses) {
        this.courses = courses;
    }

}