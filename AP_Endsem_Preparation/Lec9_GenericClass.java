package AP_Endsem_Preparation;

public class Lec9_GenericClass {
    public static void main(String[] args) {
        Complex<Integer> c1 = new Complex<Integer>(20,50);
        System.out.println(c1.toString());
    }
}

class Complex<T>{
    T re;
    T im;

    Complex(T re, T im){
        this.re = re;
        this.im = im;
    }

    @Override
    public String toString(){
        String str = String.valueOf(re)+'+'+String.valueOf(im)+'i';
        return str;
    }
}

// WIld Card ? to make thing simpler