package AP_Endsem_Preparation;

public class Lec3_static_initializer {
    public static void main(String[] args) {
        System.out.println(Test.i);
    }
    public void test(){
        System.out.println();
    }
}

class Test{
    static int i;
    static{
        i = 10;
        System.out.println("Static block called");
    }
}