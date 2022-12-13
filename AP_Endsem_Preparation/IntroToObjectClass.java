package AP_Endsem_Preparation;

public class IntroToObjectClass {
    public static void main(String[] args) {
        Main2 m2  = new Main2();
        Main2 m3 = new Main2();
        m2 = m3;// this make two objects equals
        m3.setName("Spiderman");
        // Methods of Main Class
        m2.setName("Spiderman");
        System.out.println(m2.getName());

        // Methods of object class
        System.out.println(m2.getClass());
        System.out.println(m2.toString());
        System.out.println(m2.equals(m3));
        System.out.println(m2.hashCode());
    }
}

class Main2{
    private String Name;

    void setName(String Name){
        this.Name = Name;
    }

    String getName(){
        return  this.Name;
    }
}
