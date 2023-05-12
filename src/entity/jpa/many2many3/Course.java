package entity.jpa.many2many3;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
//@IdClass(CoursePK.class)
@Table(name="course")
public class Course {

	private static final long serialVersionUID = 1L;

		
	@ManyToOne(cascade = { CascadeType.ALL },optional=false)
    //@JoinColumn(name = "teacher_id", referencedColumnName = "id",nullable=false, updatable=false,insertable=false)
	@JoinColumn(name = "teacher_id")
	private Teacher_m2m3 teacher;
    @ManyToOne(cascade={CascadeType.ALL},optional=false)
    //@JoinColumn(name = "student_id", referencedColumnName = "id",nullable=false, updatable=false,insertable=false)
	@JoinColumn(name = "student_id")
	private Student_m2m3 student;
	private String course;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Id
//	private int teacher_id;
//	@Id
//	private int student_id;


	public Course() {
	}

	public String getCourse() {
		return this.course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public Teacher_m2m3 getTeacher() {
		return this.teacher;
	}
	public void setTeacher(Teacher_m2m3 teacher) {
		this.teacher = teacher;
	}
	
	public Student_m2m3 getStudent() {
		return this.student;
	}
	public void setStudent(Student_m2m3 student) {
		this.student = student;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	public int getTeacher_id() {
//		return teacher_id;
//	}
//
//	public void setTeacher_id(int teacher_id) {
//		this.teacher_id = teacher_id;
//	}
//
//	public int getStudent_id() {
//		return student_id;
//	}
//
//	public void setStudent_id(int student_id) {
//		this.student_id = student_id;
//	}
}
