package AP_Endsem_Preparation;

public class Lec8_ObjectClass_Comparison {
}


class point{
    private int x, y;
    public point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object op){
        if(op != null && getClass() == op.getClass()){
            point o = (point) op;
            return (x== o.x && y == o.y);
        }else{
            return false;
        }
    }
}

class Rectangle implements Comparable<Rectangle>{
    private  int SideA, SideB, Area;
    public  Rectangle(int a, int b){
        this.SideA  =a;
        this.SideB  =b;
        this.Area = a*b;
    }
    @Override
    public int compareTo(Rectangle o) {
       if(Area == o.Area) return 0;
       else if(Area < o.Area) return 1;
       else return 1;
    }
}
