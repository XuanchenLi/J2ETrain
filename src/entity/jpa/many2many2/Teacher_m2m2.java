package entity.jpa.many2many2;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;
import java.util.ArrayList;

/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name = "teacher_m2m2")
//@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher_m2m1 t")
public class Teacher_m2m2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String gender;    
	private String teacherName;
	@ManyToMany(mappedBy="teachers")
	private Collection<Student_m2m2> students= new  ArrayList<Student_m2m2>();
	
	public Teacher_m2m2() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public Collection<Student_m2m2> getStudents() {
        return this.students;
    }
    public void setStudents(Collection students) {
        this.students = students;
    }

	


}