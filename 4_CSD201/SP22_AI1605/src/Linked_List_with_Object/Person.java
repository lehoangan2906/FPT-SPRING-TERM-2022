
package Linked_List_with_Object;

public class Person implements Comparable<Person>{
	String name;
	int age;
	
	public Person(){

	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
    public int compareTo(Person person2) {
        int d = this.name.compareTo(person2.name);
        return d;
    }
}
