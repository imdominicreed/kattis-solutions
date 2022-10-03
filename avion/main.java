import java.awt.*;
import java.util.Scanner;

public class main {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String answer = "";
      for(var i =0; i<5; i++) {
         String poo = scanner.nextLine();
         if(poo.contains("FBI")){
            answer += " " + (i+1);
         }
      }
      System.out.println(answer.equals("")? "HE GOT AWAY!" : answer.substring(1));
   }
}