// package AP_Assignmnets.Assignmnet1;
// import java.time.LocalDateTime;
// // import java.time.format.DateTimeFormatter;
// import java.util.*;
// import java.util.Scanner;

// public class Application{
//     static Application ap = new Application();
//     public static int studentregisters = 0;
//     Scanner sc = new Scanner(System.in);
//     public void Mode_selections(){
//         System.out.println("Choose The mode you want to Enter in:- \n\t 1) Enter as Student Mode \n\t 2) Enter as Company_Mode \n\t 3) Enter as Placemnet Cell Mode \n\t 4) Return to Main Application");

//         int n2 = sc.nextInt();
//         if(n2 == 1) {
//             // Student Mode_selections()
//             Student_Mode sd = new Student_Mode(null, n2, n2, null);
//             sd.dispStudentMenu(sd);
//         }
//         if (n2 == 2) { 
//             // Company Mode_selections()
//             Company_Mode cd = new Company_Mode(null, null, n2, n2);
//             cd.dispCompanyMenu(cd);
//         }
//         if (n2 == 3) {
//             // Placemnet Cell Mode_selections()
//             Placement_Cell_Mode pcm = new Placement_Cell_Mode();
//             pcm.dispPlacementCellMenu();
//         }
//         if (n2 == 4) { 
//             RunApplication.main(null);
//         }

//         else if(n2>4 || n2<=0) {
//             System.out.println("\nInvalid option: " );
//             Mode_selections();
//         }
//     }
// }
//     // Placemnet Cell Class ********************************
// class Placement_Cell_Mode extends Application{
//     Scanner sc = new Scanner(System.in);
//     private int companyCount;
//     private int studentCount;
//     private String str;
    

//     public void openStudentRegistration(){
//         System.out.println("Fill in the details: \n\t1) Set the Opening time for Student registrations ");
//         String openStudent = sc.nextLine();
//         setopeningTimeCompany(openStudent);
//         System.out.println("Fill in the details: \n\t2) Set the Closing time for Student registrations ");
//         String closeStudent = sc.nextLine();
//         setclosingTimeCompany(closeStudent);
//     }
//     public void setOpenTimeStudent(String s1){this.str = s1;}
//     public void setClosingTimeStudent(String s2){this.str = s2;}


//     public void openCompanyRegistration(){
//             System.out.println("\n1) Set the Opening time for company registrations ");
//             String openComp = sc.nextLine();
//             setopeningTimeCompany(openComp);
//             System.out.println("\n2) Set the Closing time for Company registrations ");
//             String closeComp = sc.nextLine();
//             setclosingTimeCompany(closeComp);
//     }
//     public void setopeningTimeCompany(String str) {this.str = str;}
//     public void setclosingTimeCompany(String str) {this.str = str;}




//     public int getno_student_registered(){
//         return studentregisters; // example 5
//     }

//     public int getno_company_registered(){
//         return 5; // example 5
//     }

//     public void getoffered_unoffered_blocked_student(){
//         int offered_students = 10;
//         int unoffered_students = 5;
//         int blocked_students = 0;
//         System.out.println("Offered students: " + offered_students + " \nunoffered students: " + unoffered_students + "\nblocked students: " + blocked_students);
//     }

//     public void getstudent_details(Student_Mode student){
//         System.out.println("Student name: "+student.getname());
//         System.out.println("Roll number: "+student.getrollnumber());
//         System.out.println("CGPA: "+student.getcgpa());
//     }

//     public void getcompany_details(Company_Mode company){
//         System.out.println("Company name: "+company.getname());
//         System.out.println("Roll number: "+company.getrollnumber());

//     }

//     public void getAverage_packages(){

//     }

//     public void get_company_process_results(){

//     }

//     public void dispPlacementCellMenu() {
//         Scanner sc = new Scanner(System.in);
//         System.out.println(" Welcome to IIITD Placement Cell\n\t 1) Open Student Registrations \n\t 2) Open Company Registrations \n\t 3) Get Number of Student Registrations \n\t 4) Get Number of Company Registrations \n\t 5) Get Number of Offered/Unoffered/Blocked Students \n\t 6) Get Student Details \n\t 7) Get Company Details \n\t 8) Get Average Package \n\t 9) Get Company Process Results\n\t 10) Back ");

//         int n3 = sc.nextInt();

//         if(n3 == 1) {
//             //Open Student Registrations  
//             openStudentRegistration();
//         }
//         else if(n3 == 2) {
//             // Open Company Registrations
//             openCompanyRegistration();
//         }
//         else if(n3 == 3) {
//             // Get Number of Student Registrations
//             getno_student_registered();
//         }
//         else if(n3 == 4) {
//             // Get Number of Company Registrations
//             getno_company_registered();
//         }
//         else if(n3 == 5) {
//             // Get Number of Offered/Unoffered/BlockedStudents
//             getoffered_unoffered_blocked_student();
//         }
//         else if(n3 == 6) {
//             // Get Student Details
//             //getstudent_details(studentregister);
            
//         }
//         else if(n3 == 7) {
//             // Get Company Details
//             //getcompany_details(company);
//         }
//         else if(n3 == 8) {
//             // Get Average Package Details
//             getAverage_packages();
//         }
//         else if(n3 == 9) {
//             // Get Company Process Results
//             get_company_process_results();
//         }
//         else if(n3 == 10) {
//             // Back
//            //Mode_selections();
//            ap.Mode_selections();
//         }
//         else if(n3>10 || n3<=0){
//             // Invalid Options
//             System.out.println("\nInvalid option: " );
//             dispPlacementCellMenu();
//         }
//     }   

// }

//     // Company Class ********************************
// class Company_Mode extends Application{
//     Scanner sc = new Scanner(System.in);
//         private static String name;
//         private String role;
//         private int ctc;
//         private double cgpa;
//         private LocalDateTime joining_Date;
//         private int companyCount = 0;
//         private static ArrayList allCompaniesList = new ArrayList();
    
//         Company_Mode(String name,String role,int ctc,double cgpa){
//             this.name=name;
//             this.role=role;
//             this.ctc=ctc;
//             this.cgpa=cgpa;
//             this.joining_Date=LocalDateTime.now();
    
//         }
//         public String toString(){
//             return "Company name: "+name+" Role: "+role+" CTC: "+ctc+" CGPA: "+cgpa;
//         }
    
//         public String getname(){
//             return name;
//         }
    
//         public String getrole(){
//             return role;
//         }
//         public int getctc(){
//             return ctc;
//         }
//         public double getcgpa(){
//             return cgpa;
//         }
//         public void Update_role(String role){
//             this.role=role;
//         }
//         public void Update_ctc(int ctc){
//             this.ctc=ctc;
//         }
//         public void Update_cgpa(double cgpa){
//             this.cgpa=cgpa;
//         }
//         public String getrollnumber() {
//             return null;
//         }
//         public void dispCompanyMenu(){
//             System.out.println(" Choose the company Query to perform- \n\t 1) Add Company and Details \n\t 2) Choose Company \n\t 3) Get Available Companies\n\t 4) Back ");

//             int n4 = sc.nextInt();
    
//             if(n4 == 1) {
//                 // Add Company Details
//                 String c1_name = sc.nextLine();
//                 String c1_role = sc.nextLine();
//                 String xt = sc.nextLine();
//                 int c1_ctc = sc.nextInt();
//                 double c1_cgpa = sc.nextDouble();
//                 companyCount = companyCount+1;
//                 Company_Mode company = new Company_Mode(c1_name, c1_role, c1_ctc, c1_cgpa);
//                 dispCompanyMenu();
//             }
            
//             else if(n4 == 2) {
//                 // Choose Company
//                 System.out.println(Company_Mode.name);
//                 allCompaniesList.add(Company_Mode.name);
//                 System.out.println("Choose to enter into mode of Available Companpies");
//                 for(int i = 0; i < allCompaniesList.size(); i++) {
//                     System.out.println((i+1)+") "+allCompaniesList.get(i));
//                 }
//                 dispCompanyMenu();
//             }
//             else if(n4 == 3) {
//                 //Back
//                 ap.Mode_selections();
//             }
//             else{
//                 // Invalid Options
//                 System.out.println("\nInvalid option: " );
//                 dispCompanyMenu();
                
//             }
//         }
//         public void dispCompanyMenu(Company_Mode cd){
//             int c1 = sc.nextInt();

//             System.out.println("Welcome "+ allCompaniesList.get(c1));
//             System.out.println("1) Update Role \n\t 2) UpdatPackage\n\t3) Update CGPA criteria\n\t4) Register To InstitutDrive\n\t5) Back");

//             int c2 = sc.nextInt();

//             if(c2 == 1){
//                String role1 = sc.nextLine();
//                 Update_role(role1);
//             }
//             if(c2 == 2){
//                 int ctc1 = sc.nextInt();
//                 Update_ctc(ctc1);
//             }
//             if(c2 == 3){
//                 int cgpa1 = sc.nextInt();
//                 Update_cgpa(cgpa1);
//             }
//             if(c2 == 4){
//                 java.util.Date date = new java.util.Date();    
//                 System.out.println(date); 
//                 System.out.println("Registered");
//             }
//             else if(c2 >4|| c2<=0){
//                 System.out.println("Invalid Choice");
//                 dispCompanyMenu(cd);
//             }   
//         }
//     }

//     // Student Class ********************************
// class Student_Mode extends Application{
//     //Company_Mode cd = new Company_Mode(branch, branch, rollnumber, cgpa);
//     Scanner sc = new Scanner(System.in);
//     private String name;
//     private int rollnumber;
//     private double cgpa;
//     private String branch;
//     private boolean is_Placed;
//     private Company_Mode com;
//     private boolean is_blocked;
//     Student_Mode(String name,int rollnumber,double cgpa,String branch){
//         this.name=name;
//         this.rollnumber=rollnumber;
//         this.cgpa=cgpa;
//         this.branch=branch;
//         this.is_Placed=false;
//         this.com=null;
//         this.is_blocked=false;
//     }

//     public String getname(){
//         return name;
//     }

//     public int getrollnumber(){
//         return rollnumber;
//     }
//     public double getcgpa(){
//         return cgpa;
//     }
//     public String getbranch(){
//         return branch;
//     }
//     public double setCGPA(double newcgpa){
//         this.cgpa = newcgpa;
//         return this.cgpa;
//     }

//     public boolean is_Eligible(Company_Mode c){
//         if(is_Placed){
//             if(c.getcgpa()<=cgpa && c.getctc()>=3*com.getctc()){
//                 return true;
//             }
//         }
//         else{
//             if(c.getcgpa()<=cgpa){
//                 return true;
//             }
//         }
//         return false;
//     }

//     public void place(Company_Mode c){
//         this.is_Placed=true;
//         this.com=c;
//     }
//     public void addStudent(String name, int rollnumber){
//         this.name = name;
//         this.rollnumber = rollnumber;
//     }

//     public void StudentMenuDisps(){
//         studentregisters = studentregisters+1;
//         System.out.println("1 Welcome"+name+"!!");
//         System.out.println("\n\t1) Register For Placement Drive \n\t 2) Register For Company \n\t3) Get All available companies \n\t 4) Get Current Status\n\t5) Update CGPA\n\t6) Accept offer\n\t7) Reject offer\n\t8) Back");
//     }

//     public void dispStudentMenu(Student_Mode sd) {
//         Scanner scanner=new Scanner(System.in);
//         System.out.println(" Choose the Student Query Perform- \n\t 1) Enter as Student (Give Student Name, and Roll No.) \n\t 2) Add Students \n\t 3) Back ");

//         int n5 = scanner.nextInt();

//         if(n5 == 2) {
//             // Add Students            
//             int no_ofStudent = scanner.nextInt();
//             studentregisters = no_ofStudent;
//             for(int i = 0; i < no_ofStudent; i++) {
//                 System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
//                 //DateTimeFormatter date = new DateTimeFormatter("dd'th' MM yyyy, hh:mm PM");
//                 System.out.print("Enter Name: ");
//                 String name=scanner.nextLine();
//                 sc.nextLine();
//                 System.out.print("Enter Roll Number: ");
//                 int rollnumber=scanner.nextInt();
//                 System.out.print("Enter CGPA: ");
//                 double cgpa=scanner.nextDouble();
//                 System.out.print("Enter Branch: ");
//                 String branch=scanner.nextLine();
//                 sc.nextLine();
//                 Student_Mode s3 =new Student_Mode(name,rollnumber,cgpa,branch);
//                 sd = s3;
//                 //System.out.println(s3.getrollnumber() + s3.getname() + s3.getcgpa());
//             }
//             dispStudentMenu(sd);
//         }
//         else if(n5 == 1) {
//             // Add Student
//             System.out.print("Enter Name: ");
//             String name=scanner.nextLine();
//             sc.nextLine();
//             System.out.print("Enter Roll Number: ");
//             int rollnumber=scanner.nextInt();
//             Student_Mode s2 =new Student_Mode(name,rollnumber,9.02,"ECE");
//             s2 = sd;
//             sd.StudentMenuDisps();
//             int sel = scanner.nextInt();
//             //sd.studentConditions(sel , sd);
//         }
//         else if(n5 == 3) {
//             ap.Mode_selections();
//         }
//         else if(n5>3 || n5<=0) {
//             //Invalid Options
//             System.out.println("\nInvalid option: " );
//             sd.dispStudentMenu(sd);
//         }
//     }
    
//     public void studentConditions(int sel, Student_Mode s2) {
//         s2.StudentMenuDisps();
//         Scanner sc = new Scanner(System.in);

//         if(sel==1) {
//             //1) Register For Placement Drive
//             // System.out.println("List of All available companies is as follows:\n\tCompany Name: " + s2.getCompanyName() + "\n Company roleoffering: " + s2.getCompanyRoleOffering() + "\n Company package: " + s2.getctc() + "\nCompany CGPA Criteria: " + s2.getcgpa());
//         }
//         if(sel==2) {
//             //2) Register For Company
//             //getcompanyDetails();
//             System.out.println("Successfully Registered for Hardware Role at GooFlix!!!!");
//         }
//         if(sel==3) {
//             // getallavilablecompanies();
            
//         }
//         if(sel==4) {
//             // getcurrentstatus();
//             System.out.println("You have been offered by "+"Company Name "+ "Please accept the offer.");
//         }
//         if(sel==5) {
//             //updatecgpa();
//             double updateCGPA = sc.nextDouble();
//             s2.setCGPA(updateCGPA);
//         }
//         if(sel==6) {
//             //acceptoffer();
//             System.out.println("Congratulations Smarthak!!! You have accepted the offer by GooFlix!!" );
//         }
//         if(sel==7) {
//             //rejectoffer();
//             System.out.println("Offer Rejected" );
//         }
//         if(sel==8) {
//             //back();
//             System.out.println("Back" );
//             s2.dispStudentMenu(s2);
//         }
//         else if(sel>8 || sel<=0) {
//             System.out.println("\nInvalid option: " );
//             s2.StudentMenuDisps();
//             int s4 = sc.nextInt();
//             s2.studentConditions(s4, s2);
//         }   
//     }
// }
