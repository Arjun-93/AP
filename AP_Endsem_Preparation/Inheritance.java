package AP_Endsem_Preparation;

public class Inheritance {
    public static void main(String[] args) {
        Dog germanShephered = new Dog();
        germanShephered.name = "GS";
        germanShephered.display();

        germanShephered.eat();
    }
}

class Animal {
    // field and method of the parent class
    String name;
    public void eat(){
        System.out.println("I can eat ");
    }
}
    // inherit from Animal

class Dog extends Animal {

        @Override
        public void eat(){
            super.eat();// super keyword used for calling parent class method
            System.out.println("I eat dog food");
        }
        // new method in subclass
        public void display() {
            System.out.println("My name is " + name);
        }

        public void barl(){
            System.out.println("I can :Bark");
        }
    }

    /*
    The most important use of inheritance in Java is code reusability. The code that is present in the parent
class can be directly used by the child class.
● Method overriding is also known as runtime polymorphism. Hence, we can achieve Polymorphism in
Java with the help of inheritance.
     */


/*
## Access Modifiers:

1. Private: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
2. Default: The access level of a default modifier is only within the package. It cannot be accessed from outside the package. If you do not specify any
access level, it will be the default.
3. Protected: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class,
it cannot be accessed from outside the package.
4. Public: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the
package.
 */