public class Myself {
    public static void main(String[] args) {

        Person P1 = new Person("홍길동", 25, "개발자");
        Student S1 = new Student("이미래", 23, "학생", "광운대학교", 19);
        Student S2 = new Student("이자바", 20, "학생", "광운대학교", 23);

        P1.Introduce();

        System.out.println("===================================================");
        S1.Introduce();

        System.out.println("===================================================");
        S2.Introduce("컴퓨터공학과");
    }
}

class Person{
    String name;
    String job;
    int age;

    Person(){
        name = "";
        job = "";
        age = 0;
    }

    Person(String name, int age, String job){
        this.name = name;
        this.job = job;
        this.age = age;
    }
    void Introduce(){
        System.out.printf("제 이름은 %s 입니다.\n", name);
        System.out.printf("나이는 %d 입니다.\n", age);
        System.out.printf("직업은 %s 입니다.\n", job);
    }
}

class Student extends Person{
    String univ;
    int admission;

    Student(){
        name = "";
        age = 0;
        job = "";
        univ = "";
        admission = 0;
    }

    Student(String name, int age, String job, String univ, int admission){
        this.name = name;
        this.job = job;
        this.age = age;
        this.univ = univ;
        this.admission = admission;
    }

    @Override
    void Introduce() {
        super.Introduce();
        System.out.printf("학교는 %s 입니다.\n", univ);
        System.out.printf("학번은 %s 입니다.\n", admission);
    }
    void Introduce(String department){
        System.out.printf("제 이름은 %s 입니다.\n", name);
        System.out.printf("나이는 %d 입니다.\n", age);
        System.out.printf("직업은 %s 입니다.\n", job);
        System.out.printf("학교는 %s 입니다.\n", univ);
        System.out.printf("학번은 %s 입니다.\n", admission);
        System.out.printf("과는 %s 입니다.\n", department);
    }
}