import java.util.*;
import java.text.*;

public class CurrentTimeOutput {

   public static void main(String args[]) {
      Date dateNow = new Date();
      SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");

      System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
   }
}