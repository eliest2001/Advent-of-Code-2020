import java.util.*;
import java.io.*;

public class Dia10 {

  public static void main (String[] args ) {
   ArrayList<Integer> arr = new ArrayList<>();
    Scanner file = null;
    File archivo = new File("G:\\input8.txt");

    try{

      file = new Scanner(archivo);

    }
    catch(FileNotFoundException e){

      System.err.println("File does not exists " + e.getMessage());
      System.exit(0);

    }

    while(file.hasNextLine()){
    arr.add(Integer.parseInt(file.nextLine()));
    }
    file.close();
    System.out.println(metodo(arr));
    System.out.println(metodo2(arr));
  }

  public static int metodo (ArrayList<Integer> a){
    int[] resArray = new int[2];
    resArray[0] = 0;
    resArray[1] = 0;
    int pos = 0;
    int type = 0;
    while(a.size()!=0){
      int min  = 0;
      int minI = 0;
      for(int i = 0; i<a.size(); i++){
        if(min ==0){
            min = a.get(i);
            minI = i;
        }
        else{
          if ( min > a.get(i)){
            min =  a.get(i);
            minI = i;
          }
        }
      }
        type = min - pos;
     switch (type){
          case 1:
            resArray[0]++;
            pos = min;
            break;
          case 3:
            resArray[1]++;
            pos = min;
            break;
           }

     a.remove(minI);


   }
    return resArray[0] * (resArray[1]+1);
 }
 public static double metodo2 (ArrayList<Integer> a){
   int pos = 0;
   int type = 0;
   int res = 0;
   while(a.size()!=0){
     double min  = 0;
     int minI = 0;
     for(int i = 0; i<a.size(); i++){
       if(min ==0){
           min = a.get(i);
           minI = i;
       }
       else{
         if ( min+3 >= a.get(i)){
           if(min > a.get(i)){
             min = (double)a.get(i);
             minI = i;
           }
           min*=min;
         }
       }
     }

    a.remove(minI);


  }
   return min;
}



}
