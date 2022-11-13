package MutilSourcePageDemo;

public class TestBean {

    private Integer age;
     private String Name;

    public TestBean(Integer age, String name) {
        this.age = age;
        Name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
