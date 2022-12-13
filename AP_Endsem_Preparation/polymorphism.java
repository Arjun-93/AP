package AP_Endsem_Preparation;


/*
● Polymorphism is derived from 2 Greek words: poly and morphs.
The word "poly" means many and "morphs" means forms. So
polymorphism means many forms.
● For example, a man at the same time can be a father, a
husband, and an employee. So the same person possesses
different behavior in different situations.
 */

/*
Advantage of method overloading
Method overloading increases the readability of the program.
Different ways to overload a method
There are two ways to overload the method in java
1. By changing number of arguments
2. By changing the data type of arguments
 */

public class polymorphism {
    public static void main(String args[]){

        parent p= new parent();

        func(p);

        p=new Child1();

        func(p);

        p=new Child2();

        func(p);

    }

    static void func(parent p){

        p.disp();

    }
}
class Adder1{
//    static  int add(int a , int b){return a+b;}
//    static double add(int a,int b) {
//        return a + b;
//    } -- > this code gives compilation error due to different return types of same function

}

class Adder2{
    static  int add(int a , int b){return a+b;}
    static double add(double a,double b) {
        return a + b;
    }
    void sum(int a, long b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Adder2 add = new Adder2();
        add.sum(20,20);
    }
}

class Adder3{
    static  int add(int a , int b){return a+b;}
    static int add(int a,int b, int c) {
        return a + b+ c;
    }
}



class parent {
    void disp(){System.out.println("Parent");}
}

class Child1 extends parent {

    void disp(){System.out.println("Child1");}

}

class Child2 extends parent {

    void disp(){System.out.println("Child2");}

}













