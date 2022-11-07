package company;

import java.util.ArrayList;
import java.util.Scanner;

public class Assignmnet2_Arjun_2020178_InteliJ {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<product> ProductCatalog = new ArrayList<>();
    private static final ArrayList<customer> customerList = new ArrayList<>();
    public static final ArrayList<category> ctg = new ArrayList<>();
    private static final ArrayList<Integer> ctgidList = new ArrayList<>();
    public static ArrayList<deals> showdeals = new ArrayList<>();


    public static void Login(customer user) {
        int choice5 = 0;
        while (choice5 != 12) {
            System.out.println("Welcome " + user.getName() + "!!!\n" +
                    "\t1) browse products\n" +
                    "\t2) browse deals\n" +
                    "\t3) add a product to cart\n" +
                    "\t4) add products in deal to cart\n" +
                    "\t5) view coupons\n" +
                    "\t6) check account balance\n" +
                    "\t7) view cart\n" +
                    "\t8) empty cart\n" +
                    "\t9) checkout cart\n" +
                    "\t10) upgrade customer status\n" +
                    "\t11) Add amount to wallet\n" +
                    "\t12) back\n");
            choice5 = Integer.parseInt(sc.nextLine());

            switch (choice5) {
                case 1 -> {
                    // browse products
                    if (ProductCatalog.size() == 0) {
                        System.out.println("\nProduct does not exist");
                        break;
                    }
                    for (product p : ProductCatalog) {
                        p.displayProduct();
                        System.out.println("\n");
                    }
                }
                case 2 -> {
                    // browse deals
                    if (showdeals.size() == 0) {
                        System.out.println("\nDeals not exist ");
                        break;
                    }
                    for (deals px : showdeals) {
                        System.out.println(px);
                    }
                }
                case 3 -> {
                    // add a product to cart
                    if (ProductCatalog.size() == 0) {
                        System.out.println("\nProduct does not exist");
                        break;
                    }
                    do {
                        System.out.println("\nEnter product ID and quantity ");
                        System.out.print("\tEnter product ID: ");
                        double pidCustomer = Double.parseDouble(sc.nextLine());
                        System.out.print("\tEnter quantity: ");
                        int pidQuantity = Integer.parseInt(sc.nextLine());

                        for (product p : ProductCatalog) {
                            if (p.productID == pidCustomer) {
                                double amount = p.price * pidQuantity;
                                selectedProduct newitem = new selectedProduct(amount, p);
                                user.sel.add(newitem);
                            } else {
                                System.out.println("\nWrong Product ID. Product does not exist in catalog ");
                            }
                            break;

                        }
                        System.out.println("Items Successfully added to cart\n ");
                        break;
                    } while (true);
                }
                case 4 -> {
                    // add a products in deal to cart
                    if (showdeals.size() == 0) {
                        System.out.println("\nDeals does not exist");
                        break;
                    }
                    for (deals d : showdeals) {
                        product dp1 = d.getdealsProduct1();
                        product dp2 = d.getdealsProduct2();
                        double dA = d.getDealsAmount();
                        selectedProduct sd = new selectedProduct(dA, dp1, dp2);
                        user.sel.add(sd);
                        System.out.println("Deal here");
                    }
                    System.out.println("~ Deal Successfully added to cart\n");
                }
                case 5 ->
                    // view coupons
                        user.getCoupoun();
                case 6 ->
                    // check account balance
                        System.out.println("Current account balance in Rupees " + user.getAccountBalance() + "\n");
                case 7 ->
                    // view cart
                        user.getCart();
                case 8 -> {
                    // empty cart
                    System.out.println("~ Cart Successfully emptied.");
                    user.emptyCart();
                }
                case 9 -> {
                    // checkout
                    double total = user.getBillAmount();
                    System.out.println("Proceeding to checkout details: ");
                    if (user.getAccountBalance() >= total) {
                        for (selectedProduct s : user.sel) {
                            s.getProducts();
                        }
                        int charges = 0;
                        if (total >= 50000) {
                            charges = 2;
                        }

                        // Delivery charges: Rs 100 + 2% of 50000 = 100 + 1000 = Rs 1100
                        System.out.println("Delivery charges: 100 + " + charges + "% of " + total + " = 100 + " + (total * charges / 100) + " = Rs " + (100 + (total * charges / 100)));
                        double finalAmount = total + (total * charges / 100) + 100;
                        // Discount: 5% of 50000 = 2500 // discount doesn’t apply on delivery charges
                        double disc = user.getDiscountuser();

                        int havecoupon = user.isHaveCoupon();
                        // check for user coupon
                        if (havecoupon != 0) {
                            System.out.println("Coupon of " + havecoupon + " has been applied.");
                        }
                        double amount1 = finalAmount - disc;
                        double amount = (amount1) * (havecoupon / 100);
                        System.out.println("Final amount RS" + (amount1 - amount) + "\n");
                        user.setbalance(amount1 - amount);

                    } else {
                        System.out.println("Insufficient Balance");
                    }
                }
                case 10 -> {
                    // upgrade customer status
                    System.out.println("Current Status: " + user.getStatus());
                    System.out.print("\tChoose new Status: ");
                    String newStatus = sc.nextLine();
                    user.setStatus(newStatus);
                    System.out.println("Status updated to " + newStatus);
                }
                case 11 -> {
                    // Add amount to wallet
                    System.out.println("\nEnter Amount to add: ");
                    long newAmount = Integer.parseInt(sc.nextLine());
                    user.setAccountBalance(newAmount);
                    System.out.println("Amount Scuccessfully added");
                }
                case 12 -> {
                    // back
                    System.out.println("\nHappy Shopping ");
                    System.out.print("\tBye " + user.getName());
                    System.out.print("!!!");
                }
                //print a smile emoji using unicode
                default -> System.out.println("Invalid choice");
            }
        }


    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("""

                    WELCOME TO FLIPZON
                    \t1) Enter as Admin
                    \t2) Explore the Product Catalog
                    \t3) Show Available Deals
                    \t4) Enter as Customer
                    \t5) Exit the Application
                    """);
            Scanner sc = new Scanner(System.in);
            int choice1 = Integer.parseInt(sc.nextLine());
            switch (choice1) {

                case 1:

                    while (true) {
                        System.out.println("\nDear Admin,\nPlease enter your username and password");
                        System.out.print("\n\tEnter Username: ");
                        String admin1 = sc.nextLine();
                        System.out.print("\tEnter Password: ");
                        String password = sc.nextLine();
                        if (admin1.equals("ArjunMehra") && password.equals("2020178")) {

                            admin newadmin = new admin(admin1, password);
                            System.out.println("\nWelcome " + newadmin.username() + "!!!!!");
                            int choice2;
                            while (true) {
                                System.out.println("""

                                        Please choose any one of the following actions:
                                        \t1) Add category
                                        \t2) Delete category
                                        \t3) Add Product
                                        \t4) Delete Product
                                        \t5) Set Discount on Product
                                        \t6) Add giveaway deal
                                        \t7) Back
                                        """);
                                choice2 = Integer.parseInt(sc.nextLine());
                                switch (choice2) {
                                    case 1:
                                        System.out.print("\nAdd Category ID: ");
                                        int id = Integer.parseInt(sc.nextLine());
                                        ctgidList.add(id);
                                        System.out.print("Add name of the Category:");
                                        String category_name = sc.nextLine();
                                        category c1 = new category(id, category_name);
                                        ctg.add(c1);

                                        if (category_name.equals("Home Appliances")) {
                                            System.out.println("\nAdd a Product -->");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double p1id = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tCapacity: ");
                                            double cap = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tPower Consumption: ");
                                            double pc = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            product h1 = new HomeAppliances(p1id, p1name, cap, pc, price, id);
                                            ProductCatalog.add(h1);
                                            System.out.println("\tProduct Added Successfully");
                                            break;
                                        }

                                        if (category_name.equals("Electronics and Gadgets")) {
                                            System.out.println("\nAdd a Product -->");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double p1id = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tOperating System: ");
                                            String os = sc.nextLine();
                                            System.out.print("\tStorage Capacity: ");
                                            int mem = Integer.parseInt(sc.nextLine());

                                            System.out.print("\tRAM: ");
                                            int ram = Integer.parseInt(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            product eg = new Electronics_gadgets(p1id, p1name, os, mem, ram, price, id);
                                            System.out.println("\tProduct Added Successfully");
                                            ProductCatalog.add(eg);
                                            break;
                                        }
                                        if (category_name.equals("Groceries and Vegetables")) {
                                            System.out.println("\nAdd a Product -->");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double p1id = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tItem: ");
                                            String item = sc.nextLine();
                                            System.out.print("\tServes: ");
                                            int serves = Integer.parseInt(sc.nextLine());
                                            System.out.print("\tTime Sufficient for consumption: ");
                                            int expiry = Integer.parseInt(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            product gvg = new Groceries_vegetables(p1id, p1name, item, serves, expiry, price, id);
                                            ProductCatalog.add(gvg);
                                            System.out.println("\tProduct Added Successfully");
                                        } else {
                                            System.out.println("\nWrong Input\n");
                                        }
                                        break;

                                    case 2:
                                        if (ctgidList.size() == 0) {
                                            System.out.println("\nCategotry is not there");
                                            break;
                                        }
                                        System.out.print("Enter Category ID: ");
                                        int n = Integer.parseInt(sc.nextLine());
                                        for (category c : ctg) {
                                            if (c.getId() == n) {
                                                // -->
                                                for (product p : ProductCatalog) {
                                                    if (p.category_id == c.getId()) {
                                                        ProductCatalog.remove(p);
                                                    }
                                                }
                                                ctg.remove(c);
                                                break;
                                            }
                                        }
                                        break;

                                    case 3:
                                        if (ctgidList.size() == 0) {
                                            System.out.println("\nProduct cannot be added beacuse no category avialable\n");
                                            break;
                                        }
                                        System.out.print("\nEnter Category ID : ");
                                        int ctgid = Integer.parseInt(sc.nextLine());
                                        if (ctgid == 1) {
                                            System.out.println("\nAdd a Product --> ");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double pid = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            System.out.println("\nProduct Successfully added");
                                            product p1 = new HomeAppliances(pid, p1name, price);
                                            ProductCatalog.add(p1);
                                            break;
                                            // Home Appliances

                                        } else if (ctgid == 2) {
                                            System.out.println("\nAdd a Product --> ");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double pid = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            System.out.println("\nProduct Successfully added");
                                            product p1 = new Electronics_gadgets(pid, p1name, price);
                                            ProductCatalog.add(p1);
                                            break;
                                            // Electronics and gadgets
                                        } else if (ctgid == 3) {
                                            System.out.println("\nAdd a Product --> ");
                                            System.out.print("\tProduct Name: ");
                                            String p1name = sc.nextLine();
                                            System.out.print("\tProduct ID: ");
                                            double pid = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tPrice: ");
                                            double price = Double.parseDouble(sc.nextLine());
                                            System.out.println("\nProduct Successfully added");
                                            product p1 = new Groceries_vegetables(pid, p1name, price);
                                            ProductCatalog.add(p1);
                                            break;
                                            // Vegetables nad Groceries
                                        }

                                    case 4:
                                        System.out.println("""
                                                Dear Admin give the Product ID you want to delete the product for
                                                Enter the Product ID :
                                                """);
                                        double deletePrdouct = Double.parseDouble(sc.nextLine());
                                        for (product p : ProductCatalog) {
                                            if (p.productID == deletePrdouct) {
                                                ProductCatalog.remove(p);
                                                System.out.println("Product is successfully remove");
                                                break;
                                            }
                                            System.out.println("Product not found");
                                        }
                                        break;
                                    // Delete the product -->

                                    case 5:
                                        System.out.println("""
                                                Dear Admin give the Product ID you want to add discount for
                                                Enter the Product ID :
                                                """);
                                        double pid3 = Double.parseDouble(sc.nextLine());
                                        System.out.println("\nEnter discount for Elite, Prime and Normal customers respectively (in % terms)");
                                        System.out.print("\tNormal customers discount: ");
                                        double normal_dis = Double.parseDouble(sc.nextLine());
                                        System.out.print("\tElite customers discount: ");
                                        double elite_dis = Double.parseDouble(sc.nextLine());
                                        System.out.print("\tPrime customers discount: ");
                                        double prime_dis = Double.parseDouble(sc.nextLine());

                                        for (product p : ProductCatalog) {
                                            if (p.productID == pid3) {
                                                p.setDiscount(normal_dis, elite_dis, prime_dis);
                                                System.out.println("Discount successfully added");
                                                break;
                                            }
                                        }
                                        break;

                                    case 6:
                                        // Add Giveaway Deal
                                        while (true) {
                                            if (ProductCatalog.size() == 0) {
                                                System.out.println("\nProduct catalog is empty ");
                                                break;
                                            }
                                            System.out.print("\nDear Admin give the product IDS you want to combine and giveaway deal for\n\tEnter the first product ID: ");
                                            double pid1 = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tEnter the second product ID: ");
                                            double pid2 = Double.parseDouble(sc.nextLine());
                                            System.out.print("\tEnter the combined price(Should be less than their combined price: ");
                                            double net = Double.parseDouble(sc.nextLine());

                                            boolean fg = false;
                                            for (int i = 0; i < ProductCatalog.size(); i++) {
                                                for (int j = 0; j < ProductCatalog.size(); j++) {
                                                    product temp1 = ProductCatalog.get(i);
                                                    product temp2 = ProductCatalog.get(j);

                                                    if (i != j && temp1.productID == pid1 && temp2.productID == pid2) {
                                                        double check = temp1.price + temp2.price;
                                                        fg = true;
                                                        if (check > net) {
                                                            deals d1 = new deals(temp1, temp2, net);
                                                            showdeals.add(d1);

                                                            System.out.println("Deal Successfully added!! ");

                                                        } else {
                                                            System.out.println("Deal not possible due to higher sum amount");
                                                        }
                                                        break;
                                                    }

                                                }
                                                if (fg) {
                                                    break;
                                                }
                                            }
                                            if (!fg) {
                                                System.out.println("Enter Correct product ID: ");
                                            } else {
                                                break;
                                            }
                                        }
                                        break;
                                    case 7:
                                        Assignmnet2_Arjun_2020178_InteliJ.main(null);
                                    case 8:
                                        System.out.println("Invalid Choice");
                                        break;
                                }
                            }
                        } else {
                            System.out.println("Invalid Username and Password");
                        }
                    }
                case 2:
                    // Explore the Product Catalog
                    if (ProductCatalog.size() == 0) {
                        System.out.println("\nEmpty Catalog ");
                        break;
                    }
                    for (product p : ProductCatalog) {
                        p.displayProduct();
                    }
                    break;
                case 3:
                    // Show available deals
                    if (showdeals.size() == 0) {
                        System.out.println("\nThere is no deals ");
                        break;
                    }
                    for (deals d : showdeals) {
                        System.out.println(d);
                    }

                    break;
                case 4:
                    // Enter as Customer
                    while (true) {
                        System.out.println("""

                                1) Sign up
                                2) Log in
                                3) Back
                                """);
                        int choice4 = Integer.parseInt(sc.nextLine());
                        // SignUp
                        if (choice4 == 1) {
                            System.out.print("\nEnter Name: ");
                            String user1 = sc.nextLine();
                            System.out.print("Enter Password: ");
                            String password1 = sc.nextLine();
                            System.out.print("Enter age: ");

                            int age = Integer.parseInt(sc.nextLine());
                            System.out.print("EnterEmail ID: ");
                            String emailD = sc.nextLine();
                            System.out.print("Enter Phone Number: ");
                            long phn = Long.parseLong(sc.nextLine());
                            System.out.print("Customer Successfully registered");
                            customer c1 = new customer(user1, password1, age, emailD, phn);
                            customerList.add(c1);

                        } else if (choice4 == 2) {
                            // Login
                            System.out.print("\nEnter Name: ");
                            String loginName = sc.nextLine();
                            for (customer tempName : customerList) {
                                if (tempName.getName().equals(loginName)) {
                                    System.out.print("Enter Password: ");
                                    String password1 = sc.nextLine();
                                    if (tempName.getPassword().equals(password1)) {
                                        Login(tempName);
                                        break;
                                    }
                                } else {
                                    System.out.println("Customer Not exist, Please Signup");
                                }

                            }

                        } else if (choice4 == 3) {
                            break;
                        }
                    }
                    break;

                case 5:
                    // Exit the Application
                    System.out.println("Thanking You Visit again\n~ Happy Shopping !!!,\n ");
                    System.exit(0);
            }
        }
    }
}
