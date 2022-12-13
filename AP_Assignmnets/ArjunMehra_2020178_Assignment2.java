//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class ass2 {
//    static Scanner sc= new Scanner(System.in);
//
//    public static ArrayList<deals> showdeals = new ArrayList<deals>();
//    private static ArrayList<product> ProductCatalog = new ArrayList<product>() ;
//    private static ArrayList<admin> admins = new ArrayList<admin>();
//    private static ArrayList<customer> customerList = new ArrayList<customer>();
//    public static final ArrayList<category> ctg = new ArrayList<category>();
//    private static final ArrayList<Integer> ctgidList = new ArrayList<>();
//    private static final ArrayList<selectedProduct> sel = new ArrayList<>();
//    private static String emoji =new String(Character.toChars(0x1F349));
//
//
//    public static void Login(customer user){
//        int choice5=0;
//        while(choice5!=12) {
//            System.out.println("Welcome " + user.getName() + "!!!\n" +
//                    "\t1) browse products\n" +
//                    "\t2) browse deals\n" +
//                    "\t3) add a product to cart\n" +
//                    "\t4) add products in deal to cart\n" +
//                    "\t5) view coupons\n" +
//                    "\t6) check account balance\n" +
//                    "\t7) view cart\n" +
//                    "\t8) empty cart\n" +
//                    "\t9) checkout cart\n" +
//                    "\t10) upgrade customer status\n" +
//                    "\t11) Add amount to wallet\n" +
//                    "\t12) back\n");
//            choice5 = Integer.parseInt(sc.nextLine());
//
//                switch (choice5) {
//                    case 1:
//                        // browse products
//                        if(ProductCatalog.size()==0){
//                            System.out.println("\nProduct does not exist");
//                            break;
//                        }
//                        for (product p : ProductCatalog){
//                            p.displayProduct();
//                            System.out.println("\n");
//                        }
//                        break;
//
//                    case 2:
//                        // browse deals
//                        if(showdeals.size() == 0){
//                            System.out.println("\nDeals not exist ");
//                            break;
//                        }
//                        for(deals px : showdeals){
//                            System.out.println(px);
//                        }
//                        break;
//
//                    case 3:
//                        // add a product to cart
//                        if(ProductCatalog.size()==0){
//                            System.out.println("\nProduct does not exist");
//                            break;
//                        }
//                        while(true) {
//                            System.out.println("\nEnter product ID and quantity ");
//                            System.out.print("\tEnter product ID: ");
//                            double pidCustomer = Double.parseDouble(sc.nextLine());
//                            System.out.print("\tEnter quantity: ");
//                            int pidQuantity = Integer.parseInt(sc.nextLine());
//
//                            for (product p : ProductCatalog) {
//                                if (p.productID == pidCustomer) {
//                                    double amount = p.price*pidQuantity;
//                                    selectedProduct newitem = new selectedProduct(amount,p);
//                                    user.sel.add(newitem);
//                                } else {
//                                    System.out.println("\nWrong Product ID. Product does not exist in catalog ");
//                                } break;
//
//                            }
//                            System.out.println("Items Successfully added to cart\n ");
//                            break;
//                        }
//                        break;
//
//                    case 4:
//                        // add a products in deal to cart
//                        if(showdeals.size()==0){
//                            System.out.println("\nDeals does not exist");
//                            break;
//                        }
//                        for(deals d: showdeals){
//                            product dp1 = d.getdealsProduct1();
//                            product dp2 = d.getdealsProduct2();
//                            double dA = d.getDealsAmount();
//                            selectedProduct sd = new selectedProduct(dA, dp1, dp2);
//                            user.sel.add(sd);
//                            System.out.println("Deal here");
//                        }
//                        System.out.println("~ Deal Successfully added to cart\n");
//                        break;
//
//                    case 5:
//                        // view coupons
//                        user.getCoupoun();
//                        break;
//                    case 6:
//                        // check account balance
//                        System.out.println("Current account balance in Rupees " + user.getAccountBalance()+"\n");
//                        break;
//                    case 7:
//                        // view cart
//                        user.getCart();
//                        break;
//                    case 8:
//                        // empty cart
//                        System.out.println("~ Cart Successfully emptied.");
//                        user.emptyCart();
//                    break;
//                    case 9:
//                        // checkout
//                        double total = user.getBillAmount();
//                        System.out.println("Proceeding to checkout details: ");
//                        if(user.getAccountBalance() >= total){
//                            for( selectedProduct s : user.sel){
//                                s.getProducts();
//                            }
//                                int charges=0;
//                                if(total>=50000){
//                                    charges=2;
//                                }
//
//                                // Delivery charges: Rs 100 + 2% of 50000 = 100 + 1000 = Rs 1100
//                                System.out.println("Delivery charges: 100 + " + charges+"% of "+total+" = 100 + "+(total*charges/100)+" = Rs "+(100+(total*charges/100)));
//                                double finalAmount = total + (total*charges/100)+100;
//                                // Discount: 5% of 50000 = 2500 // discount doesn’t apply on delivery charges
//                                double disc=user.getDiscountuser();
//
//                                int havecoupon = user.isHaveCoupon();
//                                // check for user coupon
//                                if(havecoupon !=0){
//                                    System.out.println("Coupon of "+havecoupon+" has been applied.");
//                                }
//                                double amount1 = finalAmount -disc;
//                                double amount = (amount1)*(havecoupon/100);
//                                System.out.println("Final amount RS"+(amount1- amount)+"\n");
//                                user.setbalance(amount1-amount);
//
//                        }
//                        else{
//                            System.out.println("Insufficient Balance");
//                        }
//                    break;
//                    case 10:
//                        // upgrade customer status
//                        System.out.println("Current Status: " + user.getStatus());
//                        System.out.print("\tChoose new Status: ");
//
//                        String newStatus = sc.nextLine();
//                        user.setStatus(newStatus);
//                        System.out.println("Status updated to "+newStatus);
//                        break;
//                    case 11:
//                        // Add amount to wallet
//                        System.out.println("\nEnter Amount to add: ");
//                        long newAmount = Integer.parseInt(sc.nextLine());
//                        user.setAccountBalance(newAmount);
//                        System.out.println("Amount Scuccessfully added");
//                        break;
//                    case 12:
//                        // back
//                        System.out.println("\nHappy Shopping ");
//                        System.out.print("\tBye "+user.getName());
//                        System.out.print("!!!");
//                        //print a smile emoji using unicode
//                        break;
//
//                    default:
//                        System.out.println("Invalid choice");
//                        break;
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        while(true) {
//            System.out.println("\nWELCOME TO FLIPZON\n\t1) Enter as Admin\n\t" +
//                    "2) Explore the Product Catalog\n\t" +
//                    "3) Show Available Deals\n\t" +
//                    "4) Enter as Customer\n\t" +
//                    "5) Exit the Application\n");
//            Scanner sc = new Scanner(System.in);
//            int choice1 = Integer.parseInt(sc.nextLine());
//            if(choice1>0 || choice1<6){
//                switch (choice1) {
//
//                    case 1:
//
//                        while (true) {
//                            System.out.println("\nDear Admin,\nPlease enter your username and password");
//                            System.out.print("\n\tEnter Username: ");
//                            String admin1 = sc.nextLine();
//                            System.out.print("\tEnter Password: ");
//                            String password = sc.nextLine();
//                            if( admin1.equals("ArjunMehra") && password.equals("2020178")){
//
//                                admin newadmin = new admin(admin1, password);
//                                admins.add(newadmin);
//                                System.out.println("\nWelcome " +newadmin.getUsername()+ "!!!!!");
//                                int choice2;
//                                while (true) {
//                                System.out.println("\nPlease choose any one of the following actions:\n\t" +
//                                        "1) Add category\n\t" +
//                                        "2) Delete category\n\t" +
//                                        "3) Add Product\n\t" +
//                                        "4) Delete Product\n\t" +
//                                        "5) Set Discount on Product\n\t" +
//                                        "6) Add giveaway deal\n\t" +
//                                        "7) Back\n");
//                                choice2 = Integer.parseInt(sc.nextLine());
//                                    switch (choice2) {
//                                        case 1:
//                                            System.out.print("\nAdd Category ID: ");
//                                            int id = Integer.parseInt(sc.nextLine());
//                                            ctgidList.add(id);
//                                            System.out.print("Add name of the Category:");
//                                            String category_name = sc.nextLine();
//                                            category c1 = new category(id, category_name);
//                                            ctg.add(c1);
//
//                                            if (category_name.equals("Home Appliances")) {
//                                                System.out.println("\nAdd a Product -->");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double p1id = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tCapacity: ");
//                                                double cap = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tPower Consumption: ");
//                                                double pc = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                product h1 = new HomeAppliances(p1id, p1name, cap, pc, price, id);
//                                                ProductCatalog.add(h1);
//                                                System.out.println("\tProduct Added Successfully");
//                                                break;
//                                            }
//
//                                            if (category_name.equals("Electronics and Gadgets")) {
//                                                System.out.println("\nAdd a Product -->");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double p1id = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tOperating System: ");
//                                                String os = sc.nextLine();
//                                                System.out.print("\tStorage Capacity: ");
//                                                int mem = Integer.parseInt(sc.nextLine());
//
//                                                System.out.print("\tRAM: ");
//                                                int ram = Integer.parseInt(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                product eg = new Electronics_gadgets(p1id, p1name, os, mem, ram, price ,id);
//                                                System.out.println("\tProduct Added Successfully");
//                                                ProductCatalog.add(eg);
//                                                break;
//                                            }
//                                            if (category_name.equals("Groceries and Vegetables")) {
//                                                System.out.println("\nAdd a Product -->");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double p1id = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tItem: ");
//                                                String item = sc.nextLine();
//                                                System.out.print("\tServes: ");
//                                                int serves = Integer.parseInt(sc.nextLine());
//                                                System.out.print("\tTime Sufficient for consumption: ");
//                                                int expiry = Integer.parseInt(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                product gvg = new Groceries_vegetables(p1id, p1name, item, serves, expiry, price, id);
//                                                ProductCatalog.add(gvg);
//                                                System.out.println("\tProduct Added Successfully");
//                                                break;
//                                            } else {
//                                                System.out.println("\nWrong Input\n");
//                                                break;
//                                            }
//
//                                        case 2:
//                                            if(ctgidList.size() == 0){
//                                                System.out.println("\nCategotry is not there");
//                                                break;
//                                            }
//                                            System.out.print("Enter Category ID: ");
//                                            int n = Integer.parseInt(sc.nextLine());
//                                            for( category c : ctg){
//                                                if(c.getId() == n){
//                                                    // -->
//                                                    for( product p : ProductCatalog){
//                                                        if(p.category_id ==  c.getId()){
//                                                            ProductCatalog.remove(p);
//                                                        }
//                                                    }
//                                                    ctg.remove(c);
//                                                    break;
//                                                }
//                                            }
//                                            break;
//
//                                        case 3:
//                                            if(ctgidList.size() == 0){
//                                                System.out.println("\nProduct cannot be added beacuse no category avialable\n");
//                                                break;
//                                            }
//                                            System.out.print("\nEnter Category ID : ");
//                                            int ctgid = Integer.parseInt(sc.nextLine());
//                                            if (ctgid == 1) {
//                                                System.out.println("\nAdd a Product --> ");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double pid = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                System.out.println("\nProduct Successfully added");
//                                                product p1 = new HomeAppliances(pid, p1name, price);
//                                                ProductCatalog.add(p1);
//                                                break;
//                                                // Home Appliances
//
//                                            } else if (ctgid == 2) {
//                                                System.out.println("\nAdd a Product --> ");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double pid = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                System.out.println("\nProduct Successfully added");
//                                                product p1 = new Electronics_gadgets(pid, p1name, price);
//                                                ProductCatalog.add(p1);
//                                                break;
//                                                // Electronics and gadgets
//                                            } else if (ctgid == 3) {
//                                                System.out.println("\nAdd a Product --> ");
//                                                System.out.print("\tProduct Name: ");
//                                                String p1name = sc.nextLine();
//                                                System.out.print("\tProduct ID: ");
//                                                double pid = Double.parseDouble(sc.nextLine());
//                                                System.out.print("\tPrice: ");
//                                                double price = Double.parseDouble(sc.nextLine());
//                                                System.out.println("\nProduct Successfully added");
//                                                product p1 = new Groceries_vegetables(pid, p1name, price);
//                                                ProductCatalog.add(p1);
//                                                break;
//                                                // Vegetables nad Groceries
//                                            }
//
//                                        case 4:
//                                            System.out.println("Dear Admin give the Product ID you want to delete the product for\n" +
//                                                    "Enter the Product ID :\n");
//                                            Double deletePrdouct = Double.parseDouble(sc.nextLine());
//                                            for( product p : ProductCatalog){
//                                                if(p.productID == deletePrdouct){
//                                                    ProductCatalog.remove(p);
//                                                    System.out.println("Product is successfully remove");
//                                                    break;
//                                                }
//                                                System.out.println("Product not found");
//                                            }
//                                            break;
//                                            // Delete the product -->
//
//                                        case 5:
//                                            System.out.println("Dear Admin give the Product ID you want to add discount for\n" +
//                                                    "Enter the Product ID :\n");
//                                            double pid3 = Double.parseDouble(sc.nextLine());
//                                            System.out.println("\nEnter discount for Elite, Prime and Normal customers respectively (in % terms)");
//                                            System.out.print("\tNormal customers discount: ");
//                                            double normal_dis =Double.parseDouble(sc.nextLine());
//                                            System.out.print("\tElite customers discount: ");
//                                            double elite_dis = Double.parseDouble(sc.nextLine());
//                                            System.out.print("\tPrime customers discount: ");
//                                            double prime_dis = Double.parseDouble(sc.nextLine());
//
//                                            for( product p: ProductCatalog){
//                                                if(p.productID == pid3){
//                                                    p.setDiscount(normal_dis,elite_dis,prime_dis);
//                                                    System.out.println("Discount successfully added");
//                                                    break;
//                                                }
//                                            }
//                                            break;
//
//                                        case 6:
//                                            // Add Giveaway Deal
//                                            while(true){
//                                            if( ProductCatalog.size() ==0){
//                                                System.out.println("\nProduct catalog is empty ");
//                                                break;
//                                            }
//                                            System.out.print("\nDear Admin give the product IDS you want to combine and giveaway deal for\n\tEnter the first product ID: ");
//                                            double pid1 = Double.parseDouble(sc.nextLine());
//                                            System.out.print("\tEnter the second product ID: ");
//                                            double pid2 = Double.parseDouble(sc.nextLine());
//                                            System.out.print("\tEnter the combined price(Should be less than their combined price: ");
//                                            double net = Double.parseDouble(sc.nextLine());
//
//                                            boolean fg = false;
//                                            for(int i=0; i<ProductCatalog.size(); i++){
//                                                for(int j = 0; j<ProductCatalog.size(); j++){
//                                                    product temp1 = ProductCatalog.get(i);
//                                                    product temp2 =ProductCatalog.get(j);
//                                                    // System.out.println(temp1.productID);
//                                                    // System.out.println(temp2.productID);
//                                                    // System.out.println(pid1+" "+pid2 );
//                                                    if(i!=j && temp1.productID == pid1 && temp2.productID==pid2){
//                                                        double check = temp1.price + temp2.price;
//                                                        fg = true;
//                                                        if(check>net){
//                                                            deals d1 = new deals(temp1, temp2,net);
//                                                            showdeals.add(d1);
//
//                                                            System.out.println("Deal Successfully added!! ");
//
//                                                        } else{
//                                                            System.out.println("Deal not possible due to higher sum amount");
//                                                        }
//                                                        break;
//                                                    }
//                                                    // else {
//                                                    //     System.out.println("Enter Correct product ID: ");
//                                                    //     break;
//                                                    // }
//                                                } if(fg == true){
//                                                    break;
//                                                }
//                                            } if(fg== false){
//                                                System.out.println("Enter Correct product ID: ");
//                                            }
//                                            else{
//                                                break;
//                                            }
//                                        }
//                                        break;
//                                        case 7:
//                                            ass2.main(null);
//                                        case 8:
//                                            System.out.println("Invalid Choice");
//                                            break;
//                                }
//                            }
//                    }else{
//                        System.out.println("Invalid Username and Password");
//                    }
//                }
//                    case 2:
//                        // Explore the Product Catalog
//                        if(ProductCatalog.size()==0){
//                            System.out.println("\nEmpty Catalog ");
//                            break;
//                        }
//                        for(product p : ProductCatalog){
//                            p.displayProduct();
//                        }
//                    break;
//                    case 3:
//                        // Show available deals
//                        if (showdeals.size()==0){
//                            System.out.println("\nThere is no deals ");
//                            break;
//                        }
//                        for( deals d : showdeals){
//                            System.out.println(d);
//                        }
//
//                        break;
//                    case 4:
//                        // Enter as Customer
//                        while (true) {
//                            System.out.println("\n1) Sign up\n" + "2) Log in\n" + "3) Back\n");
//                            int choice4 = Integer.parseInt(sc.nextLine());
//                                // SignUp
//                                if (choice4 == 1) {
//                                    System.out.print("\nEnter Name: ");
//                                    String user1 = sc.nextLine();
//                                    System.out.print("Enter Password: ");
//                                    String password1 = sc.nextLine();
//                                    System.out.print("Enter age: ");
//
//                                    int age = Integer.parseInt(sc.nextLine());
//                                    System.out.print("EnterEmail ID: ");
//                                    String emailD = sc.nextLine();
//                                    System.out.print("Enter Phone Number: ");
//                                    long phn = Long.parseLong(sc.nextLine());
//                                    System.out.print("Customer Successfully registered");
//                                    customer c1 = new customer(user1, password1, age,emailD,phn);
//                                    customerList.add(c1);
//
//                                } else if (choice4 == 2) {
//                                    // Login
//                                    System.out.print("\nEnter Name: ");
//                                    String loginName = sc.nextLine();
//                                    for (int i = 0; i < customerList.size(); i++) {
//                                        customer tempName = customerList.get(i);
//                                        if (tempName.getName().equals(loginName)) {
//                                            System.out.print("Enter Password: ");
//                                            String password1 = sc.nextLine();
//                                            if (tempName.getPassword().equals(password1)) {
//                                                Login(tempName);
//                                                break;
//                                            }
//                                        } else {
//                                            System.out.println("Customer Not exist, Please Signup");
//                                        }
//
//                                    }
//
//                                } else if (choice4 == 3) {
//                                        break;
//                                }
//                        }
//                        break;
//
//                    case 5:
//                        // Exit the Application
//                        System.out.println("Thanking You Visit again\n~ Happy Shopping !!!,\n ");
//                        System.exit(0);
//                }
//            } else {
//                System.out.println("Invalid Credentials");
//                System.out.println("Please choose correct option ");
//                ass2.main(null);
//            }
//        }
//    }
//}
//
//class deals{
//    private product p1;
//    private product p2;
//    private double dealAmount;
//
//    deals(product p1, product p2, double dealAmount){
//        this.p1 = p1;
//        this.p2 = p2;
//        this.dealAmount =dealAmount;
//
//    }
//    public String toString(){
//        return ("\nDeal of productID " + this.p1 + " and product ID "+ this.p2 +"\n Giveway deal amount is: "+ this.dealAmount);
//    }
//    public product getdealsProduct1(){
//        return this.p1;
//    }
//    public product getdealsProduct2(){
//        return this.p2;
//    }
//    public double getDealsAmount(){
//        return this.dealAmount;
//    }
//
//
//}
//
//class selectedProduct{
//
//    private double amount;
//    private product p;
//    private product p2;
//
//    public selectedProduct(double amount, product p) {
//        this.amount = amount;
//        this.p = p;
//        this.p2=null;
//    }
//    public selectedProduct(double cost, product p, product p2){
//        this.amount = cost;
//        this.p = p;
//        this.p2 = p2;
//        display(this.p, this.p2, this.amount);
//    }
//
//    public void showProduct(){
//        System.out.println(this.p);
//        if(this.p2!=null){
//            System.out.println(this.p2);
//         } //System.out.println("\nDeals Amount: "+ this.amount);
//        System.out.println("\nAmount: "+ this.amount);
//
//    }
//    public void display(product p, product p2, double cost){
//        System.out.println("");
//    }
//    //  public String toString(){
//    //     System.out.println(this.p);
//    //     if(this.p2!=null){
//    //         System.out.println(this.p2);
//    //      } //System.out.println("\nDeals Amount: "+ this.amount);
//    //     System.out.println("\nDeals Amount: "+ this.amount);
//    //  }
//
//    public double getAmount() {
//        return this.amount;
//    }
//
//    public void getProducts(){
//        System.out.println(this.p);
//        if(this.p2!=null){
//            System.out.println(this.p2);
//        }
//    }
//    public double getDiscount(int i){
//        double disc=0;
//        System.out.println("Discounted :"+this.p.getDiscount(i)+"% of "+this.p.price+"="+this.p.price*(this.p.getDiscount(i)/100));
//        disc=this.p.price*(this.p.getDiscount(i)/100);
//        if(this.p2!=null){
//            System.out.println("Discounted :"+this.p2.getDiscount(i)+"% of "+this.p2.price+"="+this.p2.price*(this.p2.getDiscount(i)/100));
//            disc+=this.p2.price*(this.p2.getDiscount(i)/100);
//        }
//        return disc;
//    }
//
//}
//
//
//interface I1{
//
//    public default void displayproduct(){
//        for( product p : ProductCatalog){
//            System.out.println(p);
//        }
//    }
//    public default void Viewcategory(){
//        for (category c: ctg){
//            System.out.println(c);
//        }
//    }
//
//}
//
//class customer implements I1{
//    private String name;
//    private String password;
//    private int age;
//    private String emailID;
//    private long PhoneNumber;
//    private double accountBalance;
//    private String status;
//    private ArrayList<Integer> coupounList;
//    public ArrayList<selectedProduct> sel;
//
//
//    public customer(String name, String password, int age, String emailID, long PhoneNumber) {
//        this.name = name;
//        this.password = password;
//        this.status="Normal";
//        this.accountBalance=1000;
//        this.sel=new ArrayList<>();
//        this.coupounList =  new ArrayList<>();
//    }
//
//    public String getName() {
//        return name;
//    }
//    public double getBillAmount(){
//        double billAmount =0;
//        for(selectedProduct p : sel){
//            billAmount = p.getAmount() + billAmount;
//        }
//        return billAmount;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//    public void setAccountBalance(double newAmount){
//        this.accountBalance += newAmount;
//    }
//
//    public double getAccountBalance(){
//        return accountBalance;
//    }
//
//    public void setStatus(String newStatus){
//        this.status = newStatus;
//    }
//
//    public String getStatus(){
//        return this.status;
//    }
//    public void getCart(){
//        for( selectedProduct p : sel){
//            p.showProduct();
//        }
//    }
//
//    public void setCart(product cart) {
//        this.cart = cart;
//    }
//    public void showcart(){
//        for(selectedProduct p : sel){
//            p.getProducts();
//        }
//    }
//    public void emptyCart(){
//        sel.clear();
//    }
//    public double getDiscountuser(){
//        int x=0;
//        if( this.status.equals("Prime")){
//            x=2;
//        }
//        else if(this.status.equals("Elite")){
//            x=1;
//        }
//        double disc=0;
//        for(selectedProduct p : sel){
//            disc+=p.getDiscount(x);
//        }
//        return disc;
//    }
//    public int isHaveCoupon(){
//
//        if(coupounList.size()==0){
//            return 0;
//        }
//        int maxCoupon = coupounList.get(0);
//        coupounList.remove(0);
//        return maxCoupon;
//    }
//
//    public void setbalance(double newBalance){
//        this.accountBalance = this.accountBalance-newBalance;
//        // this.no_ofPurchase += 1;
//        Random rand = new Random();
//        int coupoun = 5 + rand.nextInt(6);
//        coupounList.add(coupoun);
//        Collections.sort(coupounList, Collections.reverseOrder());
//    }
//
//    public void getCoupoun(){
//        if(coupounList.size()!=0){
//            for(int c : coupounList){
//                System.out.println("You have a coupon of "+c+"%.");
//            }
//        }
//        System.out.println("You don' have any coupon");
//    }
//}
//
//class admin {
//    private String username;
//    private String password;
//
//    public admin(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//}
//
//interface ctg_interface{
//
//    public default void errorMessage_category(){
//        System.out.println("Category can't be added , Please add a products ");
//    }
//    public default void errorMessage_product(){
//        System.out.println("Please add a new product take in input the category ID and add the name of the product and its details and it should get added in the respective category(NOTE: the category should exist otherwise add a category first.)");
//    }
//}
//
//
//class category implements ctg_interface{
//    private int id;
//    private String category_name;
//    private int count;
//
//    public category(int id, String name) {
//        this.id = id;
//        this.category_name = name;
//        this.count=0;
//    }
//    public String getCategory_name() {
//        return category_name;
//    }
//    public int getId() {
//        return id;
//    }
//    public void update_count(){
//        this.count+=1;
//    }
//
//    public void removeCtg(category c){
//        ass2.ctg.remove(c);
//    }
//}
//
//class product{
//    public double productID;
//    public String productName;
//    public double price;
//    public int category_id;
//    public ArrayList<Double> discount;
//
//    public void displayProduct(){
//        System.out.println();
//    }
//    public void setDiscount(double normal, double elite, double prime){
//        this.discount.add(0,normal);
//        this.discount.add(1,elite);
//        this.discount.add(2,prime);
//    }
//    public String toString(){
//        return ("\nProduct ID: " + this.productID + "\nProduct name: " + this.productName +" \nProduct Price: "+ this.price);
//    }
//    public double getDiscount(int i){
//        return this.discount.get(i);
//    }
//}
//class HomeAppliances extends product implements I1{
//    private double capacity;
//    private double powerConsumption;
//    private ArrayList<Double> discount = new ArrayList<>(3);
//
//    public HomeAppliances(double id,  String name, double capacity, double powerConsumptin, double price,int cg_id) {
//        super();
//        this.capacity = capacity;
//        this.powerConsumption = powerConsumptin;
//        this.price = price;
//        this.productID = id;
//        this.productName = name;
//        this.category_id=cg_id;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    public HomeAppliances(double id, String name, double price){
//        super();
//        this.productID = id;
//        this.productName = name;
//        this.price = price;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    @Override
//    public double getDiscount(int i){
//        return this.discount.get(i);
//    }
//    @Override
//    public void setDiscount(double normal, double elite, double prime){
//        this.discount.add(0,normal);
//        this.discount.add(1,elite);
//        this.discount.add(2,prime);
//    }
//    @Override
//    public void displayProduct(){
//        System.out.println("\nProduct Name: " + this.productName);
//        System.out.println("Product ID: " + this.productID);
//        System.out.println("Capacity: " + this.capacity);
//        System.out.println("Power Consumption: " + this.powerConsumption);
//        System.out.println("Price: " + this.price);
//    }
//}
//
//
//class Electronics_gadgets extends product{
//    private String OS;
//    private int Memory;
//    private int RAM;
//    private int category_id;
//    private ArrayList<Double> discount = new ArrayList<>(3);
//
//    public Electronics_gadgets( double id, String ssaname, String os, int memory, int RAM, double price,int cg_id) {
//
//        this.OS = OS;
//        this.Memory = memory;
//        this.RAM = RAM;
//        this.price = price;
//        this.productID = id;
//        this.productName = ssaname;
//        this.category_id = cg_id;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    public Electronics_gadgets(double id, String name, double price){
//        this.productID = id;
//        this.productName = name;
//        this.Memory = memory;
//        this.price = price;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    @Override
//    public double getDiscount(int i){
//        return this.discount.get(i);
//    }
//    @Override
//    public void setDiscount(double normal, double elite, double prime){
//        this.discount.add(0,normal);
//        this.discount.add(1,elite);
//        this.discount.add(2,prime);
//    }
//    @Override
//    public void displayProduct(){
//        System.out.println("\nProduct Name: " + this.productName);
//        System.out.println("Product ID: " + this.productID);
//        System.out.println("OS: " + this.OS);
//        System.out.println("RAM: " + this.RAM);
//        System.out.println("Memory: " + this.Memory);
//        System.out.println("Price: " + this.price);
//    }
//}
//
//class Groceries_vegetables extends product{
//    private String items;
//    private int serves;
//    private int expiry;
//    private int category_id;
//    private ArrayList<Double> discount = new ArrayList<>(3);
//
//    @Override
//    public double getDiscount(int i){
//        return this.discount.get(i);
//    }
//    @Override
//    public void setDiscount(double normal, double elite, double prime){
//        this.discount.add(0,normal);
//        this.discount.add(1,elite);
//        this.discount.add(2,prime);
//    }
//
//    public Groceries_vegetables(double id, String name, String items, int serves, int expiry, double price,int cg_id) {
////        super();
//        this.items = items;
//        this.serves = serves;
//        this.expiry = expiry;
//        this.productID = id;
//        this.productName = name;
//        this.price = price;
//        this.category_id=cg_id;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    public Groceries_vegetables(double id, String name, double price){
//        this.productID = id;
//        this.productName = name;
//        this.price = price;
//        this.discount= new ArrayList<>(3);
//        this.setDiscount(0, 0, 0);
//    }
//    @Override
//    public void displayProduct(Groceries_vegetables g){
//        System.out.println("\nProduct Name: " + g.productName);
//        System.out.println("Product ID: " + g.productID);
//        System.out.println("Items: " + g.items);
//        System.out.println("Serves: " + g.serves);
//        System.out.println("Price: " + g.price);
//    }
//}