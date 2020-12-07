import java.io.*;
import java.util.*;
import java.lang.*;

public class Dia7{

  public static void main(String[] args) {

       ArrayList<String> arr =  new ArrayList<>();
       Scanner file = null;
       File archivo = new File("G:\\prueba4.txt");

       try{

         file = new Scanner(archivo);

       }
       catch(FileNotFoundException e){

         System.err.println("File does not exists " + e.getMessage());
         System.exit(0);

       }

       while(file.hasNextLine())
         arr.add(file.nextLine());
       file.close();

       ArrayList<String> nonValid =  new ArrayList<>();
       nonValid.add("prueba");
       System.out.println("Case 1 : " +metodo(arr,"shiny gold", nonValid));
       System.out.println("Case 2 : " +metodo2(arr,"shiny gold"));
  }

  public static int metodo2(ArrayList a, String b){

   int res = 0;
   int var = 0;
   for(int i = 0; i<a.size();i++){
     String currentLine = (String)a.get(i);
     String[] split1 = currentLine.split(" contain ");
     if(split1[0].indexOf(b)>=0){
       if(split1[1].indexOf("no other bags")>=0&&currentLine.indexOf(b)>=0){return res = 0;}
       String[] split = split1[1].split(", ");
       for(int j = 0; j<split.length; j++){
         String[] split2 = split[j].split(" ",2);
         String next = quitarPunto(split2[1]);
         int n =  Integer.parseInt(split2[0]);
         res += n + Integer.parseInt(split2[0])*metodo2(a,next);
       }
     }
    }
   return res ;
   }





  public static int metodo(ArrayList a, String b, ArrayList nonValid){

   int res = 0;
   int var = 0;
   for(int i = 0; i<a.size();i++){
     String currentLine = (String)a.get(i);
     if(currentLine.indexOf(b)>=0){
       String[] split = currentLine.split(" bags");
       String bag = split[0];
       if(!b.equals(bag)){
         for(int j = 0; j<nonValid.size();j++){
           String validation =(String) nonValid.get(j);
           if(validation.indexOf(bag)>=0){var++;}
         }
         if(var==0){
           res++;
           res += metodo(a,bag,nonValid);
           nonValid.add(bag);
         }
         var = 0;
       }
     }
   }
    return res;

 }



 public static String quitarPunto( String a){
    String res =  a.replace(".","");
    return res;

  }
}
