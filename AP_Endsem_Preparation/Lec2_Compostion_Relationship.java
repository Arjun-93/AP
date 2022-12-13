package AP_Endsem_Preparation;

public class Lec2_Compostion_Relationship {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.i.j);
        B b = new B();
        System.out.println(b.j);
    }
    // Class B composed in Class A

}


class A{
    B i=new B();
}
class B{
    int j;
    B(){
        j=10;
    }
}