package entity.jpa.one2many1_2;
import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;
import java.util.ArrayList;

/**
 * The persistent class for the teacher database table.
 * 
 */
@Entity
@Table(name = "teacher_o2m1_2")
//NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher_m2m1 t")
public class Teacher_o2m1_2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int age;

	private String gender;
    
	private String teacherName;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name="ref_student_teacher_o2m1_2",joinColumns={@JoinColumn(name="teacher_id",referencedColumnName="id")},
    inverseJoinColumns={@JoinColumn(name="student_id",referencedColumnName="id")} )
    private Collection<Student_o2m1_2> students= new  ArrayList<Student_o2m1_2>();

	public Teacher_o2m1_2() {
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
	
	public Collection<Student_o2m1_2> getStudents() {
        return students;
    }
    public void setStudents(Collection students) {
        this.students = students;
    }

}