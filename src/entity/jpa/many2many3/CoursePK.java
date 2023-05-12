package entity.jpa.many2many3;

import javax.persistence.*;
import java.io.PrintWriter;

public class CoursePK implements java.io.Serializable{
	private int student_id;
	private int teacher_id;
	private int id;
	
	public CoursePK() { 
	}
	public CoursePK(int student_id, int teacher_id) {
		this.student_id = student_id;
		this.teacher_id = teacher_id;
	} 
	public int getStudent_id()
	{
	      return student_id;
	}

	public void setStudent_id(int student_id)
	{
	      this.student_id = student_id;
	}

	public int getTeacher_id()
	{
	      return teacher_id;
	}

	public void setTeacher_id(int teacher_id)
	{
	      this.teacher_id = teacher_id;
	}
		
	//ʵ��hashCode����
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((student_id == 0) ? 0 : student_id);
		result = PRIME * result + ((teacher_id == 0) ? 0 : teacher_id);
		result = PRIME * result + id;
		return result;
	} 

	//ʵ��equals����
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj == null) {
			result = false;
		}
		if (this == obj) {
			result = true;
		}

		if (obj instanceof CoursePK) {
			CoursePK pk = (CoursePK) obj;
			if ((this.student_id==pk.getStudent_id()) && (this.teacher_id==pk.getTeacher_id()) && (this.id==pk.getId())) {
				result = true;
			}

		} else {
			result = false;
		}
		return result;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
