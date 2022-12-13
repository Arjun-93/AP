package AP_Endsem_Preparation;

public class Lec6_Abstract_Interfaces {
    public static void main(String[] args) {
        Parent2 b = new abstract_child1();
        Parent2 c = new abstract_child2();
        Parent2 p3;
        p3 = b;
        p3.disp();
        c.disp();
        b.disp();


        // Interface
        Parent1 intchild = new interface_child1();
        abstract_child2 bc = new abstract_child2();
        bc.disp();
        Parent1 p2;
        p2 = intchild;
        p2.disp();
        intchild.setname("Nobita");
        intchild.disp();
    }
}


// Abstract Example
abstract class Parent2{
    String name;
    Parent2(){
        System.out.println("Constructor of parent abstract class");
    }
    void disp(){
        System.out.println(name);
    }

    void setname(String name){
        this.name =name;
    }
}
class abstract_child1 extends Parent2{
    @Override
    void disp() {
        System.out.println("Child3");
    }
}
class abstract_child2 extends Parent2{
    void display(){
    }
}

// Interface
interface Parent1{
    public void setname(String name);
    void disp();
}

class interface_child1 implements Parent1{
    private String name;
    @Override
    public void setname(String name) {
        this.name = name;
    }
    @Override
    public void disp() {
        System.out.println(name);
        System.out.println("Interface child 1");
    }

}