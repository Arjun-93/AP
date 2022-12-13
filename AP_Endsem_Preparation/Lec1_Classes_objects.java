package AP_Endsem_Preparation;

public class Lec1_Classes_objects {
    public static void main(String[] args) {
        Main m1 = new Main(1,2);
        m1.print();

    }
}

class Main{

    private int a;
    private int b;
    public static void main(String[] args) {
        System.out.println("Hello");
    }
    public Main(int a, int b){
        this.a = a;
        this.b = b;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public void setA(int a){
        this.a = a;
    }
    public void setB(int b){
        this.b = b;
    }
    public void print(){
        System.out.println("a = " + a + " b = " + b);
    }
    public String toString(){
        return "a = " + a + " b = " + b;
    }
}
