
import java.util.Scanner;
class inp{
    Scanner sc;
    inp(){
        sc=new Scanner(System.in);
    }
    public String nextLine(){
        String st=this.sc.nextLine();
        if(st.equals("Exit FutureBuilder")){
            System.exit(0);
        }
        return st;
    }
}


public class RunApplication {
        static ass1 ap = new ass1();
        static inp sc=new inp();
        public static void main(String[] args) {
        System.out.print("Enter Code: ");

        while(true){
            String enter = sc.nextLine();
            int choice=0;
            if(enter.equals("Enter FutureBuilder")){
                while(choice!=2){
                    System.out.println("Welcome to FutureBuilder\n\t 1) Enter the Application\n\t 2) Exit the Application\n\t ");
                    choice = Integer.parseInt(sc.nextLine());
                    if(choice == 1){
                        ap.main(null);  
                    }
                    else if(choice ==2){ 
                        System.exit(0); 
                }
            }
        }
    }
}
}