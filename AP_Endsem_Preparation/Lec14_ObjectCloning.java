package AP_Endsem_Preparation;

/*
The object cloning is a way to create exact copy of an object.
The clone() method of Object class is used to clone an object.

Definition
protected Object clone() throws CloneNotSupportedException{
..........
..........
}

It helps us make a shallow copy (field-to-field) of the object.
 */
public class Lec14_ObjectCloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 =new Student(01,"Nikhil");
        System.out.println(s1.name+" "+s1.rollno);
//        Student s2 = new Student(02,"Piyush");
         Student s3 = (Student) s1.clone();
        System.out.println(s3.name+" "+s3.rollno);
    }
}

class Student implements  Cloneable{
    int rollno;
    String name;

    Student(int rollno, String name){
        this.name = name;
        this.rollno = rollno;
    }

    @Override
    public Object clone() throws  CloneNotSupportedException{
        Object o = super.clone();
        return o;
    }
}





















