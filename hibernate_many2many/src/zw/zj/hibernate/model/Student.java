package zw.zj.hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private Integer id;
	private String name;
	private Set<Course> course = new HashSet<Course>();

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

	public Set<Course> getCourse() {
		return course;
	}

	public void setCourse(Set<Course> course) {
		this.course = course;
	}

}
