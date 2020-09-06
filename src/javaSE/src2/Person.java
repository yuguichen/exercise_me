package javaSE.src2;

public class Person extends Object{

    private String name;
    private int age;

    public Person(String name,int age){
        this.age=age;
        this.name=name;
        //System.out.println(this.age+".........."+this.name);
    }

    public Person(){
        System.out.println("person run");
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

    @Override
    public int hashCode() {
        //return super.hashCode();
        return name.hashCode()+age;
    }

    @Override
    public boolean equals(Object obj) {
        Person p =(Person)obj;
        return this.name.equals(p.name)&&this.age==p.age ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
