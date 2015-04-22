package com.review;

/**
 * 不可变类中含有引用类型，且引用类型是可变类
 * @author hechen
 * @version 1.0
 */
public class ImmutablePerson {

	private final Name name;
	
	public ImmutablePerson(Name name){
		this.name=new Name(name.getFirstName(),name.getSecondName());
	}
	public Name getName(){
		return new Name(this.name.getFirstName(),this.name.getSecondName());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Name n=new Name("he","chen");
		ImmutablePerson p=new ImmutablePerson(n);
		System.out.println(p.getName().getFirstName());
		System.out.println(p.getName().getSecondName());
		n.setFirstName("chen");
		n.setSecondName("wei");
		System.out.println(p.getName().getFirstName());
		System.out.println(p.getName().getSecondName());
	}

}

class Name{
	private String firstName;
	private String secondName;
	public Name(String firstname, String secondname){
		firstName=firstname;
		secondName=secondname;
	}
	public void setSecondName(String secondname){
		this.secondName=secondname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
}
