import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Person extends User implements Comparable{
    private String name;
    private int age;


    public Person(String name) {
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        setUsername(this.name + this.age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean equals(Object object) {
        Person person = (Person) object;
        return getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object obj) {
        Person person = (Person) obj;

        return person.getName().compareTo(name);
    }


}
