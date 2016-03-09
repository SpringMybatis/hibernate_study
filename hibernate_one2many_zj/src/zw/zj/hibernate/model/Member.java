package zw.zj.hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class Member {

	private String id;
	private String name;
	private Integer age;

	private Set<Member> childMembers = new HashSet<Member>();

	private Member parentMember;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Member> getChildMembers() {
		return childMembers;
	}

	public void setChildMembers(Set<Member> childMembers) {
		this.childMembers = childMembers;
	}

	public Member getParentMember() {
		return parentMember;
	}

	public void setParentMember(Member parentMember) {
		this.parentMember = parentMember;
	}

}
