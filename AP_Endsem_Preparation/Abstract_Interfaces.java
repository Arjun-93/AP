package AP_Endsem_Preparation;

public class Abstract_Interfaces {
    public static void main(String[] args) {
        abstract_child1 b = new abstract_child1();
        b.disp();
    }
}


// Abstract Example
abstract class Parent{
    Parent(){
        System.out.println("Constructor of parent abstract class");
    }
    void disp(){
    }
}
class abstract_child1 extends Parent{
    @Override
    void disp() {
        System.out.println("Child3");
    }
}
class abstract_child2 extends Parent{
    void display(){
    }
}

// Interface
interface Parent1{
    void disp();
}

class interface_child1 implements Parent1{
    @Override
    public void disp() {
        System.out.println("Interface child 1");
    }
}