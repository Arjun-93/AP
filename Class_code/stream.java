import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class stream{

    // Question 1
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while((c =in.read()) != -1){
                out.write(c);
            }
        } finally{
            if (in != null) in.close();
            if (out !=null) out.close();
        }
    }
}

class Question2{

    public static void main(String[] args) throws IOException{
        FileInputStream in1 = null;

        try{
            in1 = new FileInputStream("source.txt");
            int c;
            while((c = in1.read())!= -1){
                System.out.print((char)c);
            }
            } finally{
            if (in1!= null) in1.close();
        }   
    }
}