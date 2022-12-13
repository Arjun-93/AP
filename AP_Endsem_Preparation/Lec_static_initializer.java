package AP_Endsem_Preparation;

public class Lec_static_initializer {
    public static void main(String[] args) {
        System.out.println(test.i);
    }
}

class test {
    static int i;
    static{
        i = 10;
        System.out.println("Static block called");
    }
}