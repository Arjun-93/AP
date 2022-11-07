
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class test {
    
    public void set_op_cl_dates(){

    }
    
    public static void main(String[] args) {
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
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the date in dd mm yyyy, hh:mm am/pm format");
            String [] date = sc.nextLine().split(" ");
            date[0]=date[0].substring(0, 2);    
            date[1]=months.get(date[1]);
            date[2]=date[2].substring(0, 4);
            String time1=date[3].substring(0, 2);
            String time2=date[3].substring(3, 5);
            Month month = Month.of(Integer.parseInt(months.get(date[1])));
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]), month, Integer.parseInt(date[0]));
            LocalTime localTime = LocalTime.of(Integer.parseInt(time1), Integer.parseInt(time2));
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-mm-yyyy  hh:mm a");
            System.out.println(localDateTime.format(format));
            // for (String string : date) {
            //     System.out.println(string);
            // }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        }
    }

