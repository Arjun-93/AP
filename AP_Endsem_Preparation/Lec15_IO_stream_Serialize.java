package AP_Endsem_Preparation;

import java.io.*;

public class Lec15_IO_stream_Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileInputStream in = null;
//        FileOutputStream out  =  null ;
//
//        try{
//            in = new FileInputStream("input.txt");
//            out = new FileOutputStream("output.txt");
//            int c;
//
//            c = in.read();
//            while(c!=-1){
//                out.write(c);
//                c = in.read();
//            }
//        }
//        finally {
//            if(in!=null) in.close();
//            if(out!=null) out.close();
//        }
        serialize();
        deserialize();
    }

    public static void serialize() throws IOException{
        Manager m1 = new Manager("IronAMy");
        ObjectOutputStream out  =null;
        try{
            out = new ObjectOutputStream(new FileOutputStream("output.txt"));
            out.writeObject(m1);
        } finally {
            out.close();
        }
    }

    public static void deserialize() throws IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        try{
            in  =new ObjectInputStream(new FileInputStream("output.txt"));
            Manager m1 = (Manager) in.readObject();
        } finally {
            in.close();
        }
    }
}
// --> Use transient KeyWord if you don't want to make serialze all the instance members of a object

/*
Serialization in Java is a mechanism
of writing the state of an object into a
byte stream
The reverse operation is called
deserialization
 */

class Manager implements Serializable{
    private String name;
    public  Manager (String n){
        this.name =n;
    }
}
/*
Important Points

● There is no point in serializing static field members in a class
○ Static fields do not represents object state but they represent class state
○ There will not be any compilation/runtime issue, although the value serialized will not make any
sense as it can always be updated later in the class.

● transient keyword in Java
○ If you don’t want any field to be serialized then mark that as “transient”.
○ When JVM comes across transient keyword, it ignores original value of the variable and save default
value of that variable data type.
 */