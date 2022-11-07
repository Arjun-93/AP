package AP_Assignmnets.Assignmnet1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ass1 {
    private static  ArrayList<Student_Mode> stu_ls = new ArrayList<Student_Mode>();
    private static ArrayList<Company_Mode> com_ls = new ArrayList<Company_Mode>();
    static LocalDateTime c_dates[]=new LocalDateTime[2];
    static LocalDateTime s_dates[]=new LocalDateTime[2];
    static inp sc = new inp();
    // private static Placement_Cell_Mode pcm = new Placement_Cell_Mode();
    
    
    public static LocalDateTime setCompdate(String d){
        HashMap<String, String> months = new HashMap<>();
        months.put("January", "01");
        months.put("February", "02");
        months.put("March", "03");
        months.put("April", "04");
        months.put("May", "05");
        months.put("June", "06");
        months.put("July", "07");
        months.put("August", "08");
        months.put("September", "09");
        months.put("October", "10");
        months.put("November", "11");
        months.put("December", "12");

        String [] date = d.split(" ");
        date[0]=date[0].substring(0, 2);    
        date[1]=months.get(date[1]);
        date[2]=date[2].substring(0, 4);
        String time1=date[3].substring(0, 2);
        String time2=date[3].substring(3, 5);
        Month month = Month.of(Integer.parseInt(date[1]));
        LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]), month, Integer.parseInt(date[0]));
        LocalTime localTime = LocalTime.of(Integer.parseInt(time1), Integer.parseInt(time2));
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy  hh:mm a");
        System.out.println(localDateTime.format(format));
        return localDateTime;
    }

    public static void set_dates(String s){
        System.out.println("Enter the date in the format dd Month yyyy hh:mm am/pm");
        System.out.println("Set the Opening time for"+s+ "registrations");
        String d1=sc.nextLine();
        System.out.println("Set the Closing time for "+s+"registrations");
        String d2=sc.nextLine();
        if(s.equals("Company")){
            c_dates[0]=setCompdate(d1);
            c_dates[1]=setCompdate(d2);
        }
        else if(s.equals("Student")){
            s_dates[0]=setCompdate(d1);
            s_dates[1]=setCompdate(d2);
        }
    }

    public static void Studentmode(){
        while(true){
        System.out.println("\nChoose the Student Query Perform- \n\t 1) Enter as Student (Give Student Name, and Roll No.) \n\t 2) Add Students \n\t 3) Back ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice){
            case 1:
                System.out.print("Enter the Student Name: ");
                String name = sc.nextLine();
                
                System.out.print("Enter the Student Roll No.: ");
                int roll = Integer.parseInt(sc.nextLine());
                for(int m=0;m<stu_ls.size();m++){
                    Student_Mode stu= stu_ls.get(m);
                    if(stu.getStu_name().equals(name) && stu.getStu_roll() == roll){
                        while(true){
                            System.out.println(stu);
                            System.out.println("Welcome "+name+"!!");
                            System.out.println("Welcome "+stu.getStu_name()+"!!");
                            System.out.println("\n\t1) Register For Placement Drive \n\t 2) Register For Company \n\t3) Get All available companies \n\t 4) Get Current Status\n\t5) Update CGPA\n\t6) Accept offer\n\t7) Reject offer\n\t8) Back");
                            int choice1 = Integer.parseInt(sc.nextLine());
                            switch (choice1){
                                case 1:
                                    LocalDateTime now = LocalDateTime.now();
                                    if(now.isAfter(s_dates[0]) && now.isBefore(s_dates[1])){
                                        System.out.println(stu.getStu_name()+"Registered for Placement Drive at IIITD");
                                        System.out.println("\nName: " + stu.getStu_name());
                                        System.out.println("Roll No.: " + stu.getStu_roll());
                                        System.out.println("CGPA: " + stu.getStu_cgpa());
                                        System.out.println("Branch: " + stu.getStu_branch());
                                    }
                                    else{
                                        System.out.println("Registration is closed");
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter the Company Name: ");
                                    String com_name = sc.nextLine();
                                    
                                    for(int k=0; k<com_ls.size(); k++){
                                        if(com_ls.get(k).getname().equals(com_name)){
                                            stu.setComp(com_ls.get(k));
                                            System.out.println("Student "+stu.getStu_name()+" Registered "+com_ls.get(k).getrole()+" at "+com_name);
                                            break;
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.println("List of All available companies is as follows:");
                                    for( int l = 0; l < com_ls.size(); l++ ) {
                                        Company_Mode temp = com_ls.get(l-1);
                                        if(temp.getcgpa()<=stu.getStu_cgpa()){
                                            System.out.println(l+1+" "+ "Company name" + temp.getname());
                                            System.out.println(l+1+" "+ "Company role" + temp.getname());
                                            System.out.println(l+1+" "+ "Company package" + temp.getname());
                                            System.out.println(l+1+" "+ "Company CGPA" + temp.getname());
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Current Status of Student is as follows:");
                                    System.out.println("Status: " + stu.getStu_status());
                                    break;
                                case 5:
                                // update CGPA
                                    System.out.print("Enter the new CGPA: ");
                                    double cgpa = Double.parseDouble(sc.nextLine());
                                    stu.set_cgpa(cgpa);
                                    break;
                                case 6:
                                // Accept offer
                                    System.out.println("\nCongratulation!!"+stu.getStu_name()+" You have accepted the offer by"+stu.getStu_Company().getname());
                                    break;
                                case 7:
                                // Reject offer
                                    System.out.println("\nSorry!!"+stu.getStu_name()+" You have rejected the offer by"+stu.getStu_Company().getname());
                                    stu.setComp(null);
                                    break;
                                case 8:
                                // Back
                                    break;
                                default:
                                    System.out.println("Invalid Choice");
                                    break;
                            }
                            if(choice1 == 8){
                                break;
                            }
                        }
                    } 
                    else{
                    System.out.println("\nInvalid Student Name or Roll No.");
                    Studentmode();
                    }
                }
                
                break;
            case 2:
                // Add Students            
                int no_ofStudent = Integer.parseInt(sc.nextLine());
                //studentregisters = no_ofStudent;
                for(int i = 0; i < no_ofStudent; i++) {
                    System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                    //DateTimeFormatter date = new DateTimeFormatter("dd'th' MM yyyy, hh:mm PM");
                    System.out.print("Enter Name: ");
                    String name1=sc.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollnumber=Integer.parseInt(sc.nextLine());
                    System.out.print("Enter CGPA: ");
                    double cgpa=Double.parseDouble(sc.nextLine());
                    System.out.print("Enter Branch: ");
                    String branch=sc.nextLine();
                    Student_Mode stu = new Student_Mode(name1, rollnumber, cgpa, branch);
                    stu_ls.add(stu);
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
}

    public static void CompanyMode(){
        while(true){
        System.out.println(" Choose the company Query to perform- \n\t 1) Add Company and Details \n\t 2) Choose Company \n\t 3) Get Available Companies\n\t 4) Back ");
        int n4 = Integer.parseInt(sc.nextLine());

        switch (n4){
            case 1:
                System.out.print("Enter the Company Name: ");
                String name = sc.nextLine();
                
                System.out.print("Enter the Company Role.: ");
                String role = sc.nextLine();
                // sc.nextLine();
                System.out.print("Enter the Company ctc(in LPA): ");
                int ctc = Integer.parseInt(sc.nextLine());
                System.out.print("Enter the Minimum CGPA Requirement: ");
                double mincgpa = Double.parseDouble(sc.nextLine());
                Company_Mode c1 = new Company_Mode(name, role, ctc, mincgpa);
                com_ls.add(c1);
                break;
            case 2:
                System.out.println("Choose To enter into mode of Available Companies:-");
                for( int i = 0; i < com_ls.size(); i++ ) {
                    Company_Mode temp = com_ls.get(i);
                    System.out.println(i+1+" "+ temp.getname());
                }
                int selectCompany = Integer.parseInt(sc.nextLine());
                Company_Mode temp = com_ls.get(selectCompany-1);
                while(true){
                    System.out.println("Welcome "+ temp.getname());

                    System.out.println("\n\t1) Update Role \n\t2) Update Package\n\t3) Update CGPA criteria\n\t4) Register To Institute Drive\n\t5) Back");

                    int updateCompany = Integer.parseInt(sc.nextLine());

                    if(updateCompany == 1){
                        // update role
                        System.out.println("Update role: ");
                        String newrole = sc.nextLine();
                        
                        temp.Update_role(newrole);

                    }
                    else if(updateCompany == 2){
                        // update package
                        System.out.println("Update package: ");
                        int newpackage = Integer.parseInt(sc.nextLine());
                        temp.Update_ctc(newpackage);
                    }
                    else if(updateCompany == 3){
                        // update cgpa criteria
                        System.out.println("Update cgpa criteria: ");
                        double newmincgpa = Double.parseDouble(sc.nextLine());
                        temp.Update_cgpa(newmincgpa);
                    }
                    else if(updateCompany == 4){
                        LocalDateTime now = LocalDateTime.now();
                        if(now.isAfter(c_dates[0]) && now.isBefore(c_dates[1])){
                            DateFormat dateFormat = new SimpleDateFormat("dd'th' mm yyyy, HH:mm:ss");
                            Date date = new Date();
                            System.out.println(dateFormat.format(date));
                            System.out.println("Registered");
                            temp.setregister();
                        }
                        else{
                            System.out.println("Registration is closed");
                        }
                        break;
                    }
                    else if(updateCompany == 5){
                        break;
                    }
                    else if(updateCompany >5 || updateCompany <= 0){
                        System.out.println("Invalid Choice");
                        break;
                    }
                }
            
                break;
            case 3:
                System.out.println("Get Avaliable Companies-");
                for( int i = 0; i < com_ls.size(); i++ ) {
                    Company_Mode temp2 = com_ls.get(i);
                    System.out.println(i+" "+ temp2.getname());
                }
                break;
            case 4:
                return;
            default :
                System.out.println("Invalid Choice");
                break;
        }
    }
}

    public static void PcmMode(){
        while(true){
        System.out.println(" Welcome to IIITD Placement Cell\n\t 1) Open Student Registrations \n\t 2) Open Company Registrations \n\t 3) Get Number of Student Registrations \n\t 4) Get Number of Company Registrations \n\t 5) Get Number of Offered/Unoffered/Blocked Students \n\t 6) Get Student Details \n\t 7) Get Company Details \n\t 8) Get Average Package \n\t 9) Get Company Process Results\n\t 10) Back ");

        int choice = Integer.parseInt(sc.nextLine());
        
        switch (choice) {
            case 1:
                // Open Student Registrations
                set_dates("Student");
                break;
            case 2 :
                set_dates("Company");
                break;
            case 3 :
                //pcm.getNumberofStudentRegistrations();
                int noStudent = stu_ls.size();
                System.out.println("Number of Student Registrations: "+noStudent);
                break;
            case 4 :
                int noComp = com_ls.size();
                System.out.println("Number of Company registered: " + noComp);
                break;
            case 5 :
                //get number of offered/unoffered/blocked students
                int noOffered = 0;
                int noUnoffered = 0;
                int noBlocked = 0;
                for(int i = 0; i < stu_ls.size(); i++){
                    Student_Mode temp = stu_ls.get(i);
                    if(temp.getStu_status().equals("Placed")){
                        noOffered++;
                    }
                    else if(temp.getStu_status().equals("Unplaced")){
                        noUnoffered++;
                    }
                    else if(temp.getStu_status().equals("Blocked")){
                        noBlocked++;
                    }
                }
                System.out.println("\nNumber of Offered Students: "+noOffered);
                System.out.println("Number of Unoffered Students: "+noUnoffered);
                System.out.println("Number of Blocked Students: "+noBlocked+"\n");
                break;
            case 6 :    
                //get all student details
                for( int i = 0; i < stu_ls.size(); i++ ) {
                    System.out.println(stu_ls.get(i));
                }
                
                break;
            case 7 :
                // get company details
                for( int i = 0; i < com_ls.size(); i++ ) {
                    System.out.println(com_ls.get(i));
                }
                break;
            case 8 :
                //average package
                int sum = 0;    
                for( int i = 0; i < com_ls.size(); i++ ) {
                    Company_Mode temp = com_ls.get(i);
                    sum += temp.getctc();
                }
                int avg = sum/com_ls.size();
                System.out.println("Average Package: "+avg);
                break;
            case 9 :
                // Company Process Details
                for(int i=0;i<stu_ls.size();i++){
                    Student_Mode temp = stu_ls.get(i);
                    if(temp.getStu_status().equals("Placed")){
                        System.out.println(temp);
                    }
                }
                break;
            case 10 :
                break;
            default :
            System.out.println("Invalid Choice");
                break;
            }
            if(choice == 10){
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        while(true){
        System.out.println("\nChoose The mode you want to Enter in:- \n\t 1) Enter as Student Mode \n\t 2) Enter as Company_Mode \n\t 3) Enter as Placemnet Cell Mode \n\t 4) Return to Main Application");
        int ch=Integer.parseInt(sc.nextLine());
        switch (ch) {
            case 1:
                Studentmode();
                break;
            case 2:
                CompanyMode();
                break;
            case 3:
                PcmMode();
                break;
            case 4:
                //Back
                return;
                //break;
            default:
                System.out.println("Invalid Choice");
                main(null);
                break;
        }
        if(ch == 4){
            break;
        }
    }

}
}
// Student Mode Selection
class Student_Mode{
    //Company_Mode cd = new Company_Mode(branch, branch, rollnumber, cgpa);
    private String name;
    private int rollnumber;
    private double cgpa;
    private String branch;
    private boolean is_Placed;
    private Company_Mode com;
    private boolean is_blocked;
    Student_Mode(String name,int rollnumber,double cgpa,String branch){
        this.name=name;
        this.rollnumber=rollnumber;
        this.cgpa=cgpa;
        this.branch=branch;
        this.is_Placed=false;
        this.com=null;
        this.is_blocked=false;
    }
    public String getStu_status() {
        if(is_Placed==true){
            return "Placed";
        }
        else if(is_blocked==true){
            return "Blocked";
        }
        else{
            return "Unplaced";
        }
    }
    public String getStu_name(){
        return this.name;
    }
    public int getStu_roll(){
        return this.rollnumber;
    }
    public double getStu_cgpa(){
        return this.cgpa;
    }
    public String getStu_branch(){
        return this.branch;
    }
    public boolean getStu_isPlaced(){
        return this.is_Placed;
    }
    public Company_Mode getStu_Company(){
        return this.com;
    }
    public boolean getStu_isBlocked(){
        return this.is_blocked;
    }
    public void setComp(Company_Mode com){
        this.com=com;
        this.is_Placed=true;
    }

    public void set_cgpa(double cgpa2){
        this.cgpa=cgpa2;
    }
    
    public String toString(){
        return "Name: "+this.name+" Roll Number: "+this.rollnumber+" CGPA: "+this.cgpa+" Branch: "+this.branch;
    }

}

// Company Mode selection
class Company_Mode{
    Scanner sc = new Scanner(System.in);
        private static String name;
        private String role;
        private int ctc;
        private double cgpa;
        private LocalDateTime joining_Date;
        boolean isregistere=false;
        Company_Mode(String name,String role2,int ctc,double cgpa){
            this.name=name;
            this.role=role;
            this.ctc=ctc;
            this.cgpa=cgpa;
            //this.joining_Date=LocalDateTime.now();
        }
        public String toString(){
            return "Company name: "+name+" Role: "+role+" CTC: "+ctc+" CGPA: "+cgpa;
        }
    
        public String getname(){
            return name;
        }
        public String getrole(){
            return role;
        }
        public int getctc(){
            return ctc;
        }
        public double getcgpa(){
            return cgpa;
        }
        public void Update_role(String role){
            this.role=role;
        }
        public void Update_ctc(int ctc){
            this.ctc=ctc;
        }
        public void Update_cgpa(double cgpa){
            this.cgpa=cgpa;
        }
        public void setregister(){
            this.isregistere=true;
        }   
        public String tostrString(){
            return "Name: "+this.name+" Role: "+this.role+" CTC: "+this.ctc+" CGPA: "+this.cgpa;
        } 
}