package entity.jpa.many2many2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@Table(name = "student_m2m2")
//@NamedQuery(name="Student.findAll", query="SELECT s FROM Student_m2m1 s")
public class Student_m2m2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String gender;
	private String name;
	private String major;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name="ref_student_teacher_m2m2",joinColumns={@JoinColumn(name="student_id",referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="teacher_id",referencedColumnName="id")} )
	private Collection<Teacher_m2m2> teachers= new  ArrayList<Teacher_m2m2>();
	
	public Student_m2m2() {
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
	public Collection<Teacher_m2m2> getTeachers() {
        return this.teachers;
    }
    public void setTeachers(Collection teachers) {
        this.teachers = teachers;
    }

}