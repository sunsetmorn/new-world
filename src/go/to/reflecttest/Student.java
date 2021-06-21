package go.to.reflecttest;

public class Student {
    private String name;
    private Integer age;
    public String flag;

    public Student(){}
    public Student(String n,Integer a){
        this.name = n;
        this.age = a;
    }
    private Student(String n){
        this.name = n;
    }

    public void introduce(){
        System.out.println("My name is:" + name + ",");
        System.out.println("I'm " + age + " years old;\n");
    }
    private void leaveUp(){

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
}
