package entity.jpa.many2many1;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.IdValidation;

import java.util.Collection;
import java.util.ArrayList;

/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name = "teacher_m2m1")
//@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher_m2m1 t")
public class Teacher_m2m1 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int age;
	private String gender;    
	private String teacherName;
	
	public Teacher_m2m1() {
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
	


}