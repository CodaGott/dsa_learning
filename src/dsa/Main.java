package dsa;

public class Main {

    public static void main(String[] args) {

        Object [] ar = new Object[10];

//        Student student = new Student();
//        student.name = "Name";
//
//        ar[0] = student;
//        System.out.println(ar[0]);


        System.out.println(Math.PI);
        String name = " b";

        String name1 = " b";


        System.out.println(name.equals(name1));
    }
}

class Student<E> {
    String name;
    E[] str = (E[])new Object[10];

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}


