package zw.zj.hibernate.model;

public class Member {

	private Integer id;
	private String name;
	private Integer age;
	private IdCard card;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public IdCard getCard() {
		return card;
	}

	public void setCard(IdCard card) {
		this.card = card;
	}

}
