import java.util.*;
import java.io.*;

public class Dia82nd {

  public static void main (String[] args ) {
    ArrayList<String> arr = new ArrayList<>();
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

  }

  public static int metodo (ArrayList a){
      int acc = 0;
      ArrayList<Integer> repeated = new ArrayList();
      int i = 0;
      while(!repeated.contains(i)){
        repeated.add(i);
        String currentLine = (String)a.get(i);
        String var = currentLine.substring(5);
        int entero = Integer.parseInt(var);
        String[] val = currentLine.split(" ");

        if(val[0].equals("nop")){
          i++;
        }

        else if(val[0].equals("acc")){
          if(val[1].indexOf("-")>=0){
            acc-=entero;
        }
        else{
          acc+=entero;
        }
      }

        else {
          if(val[1].indexOf("-")>=0){
            i-=entero;
        }
          else{
            i+=entero;
          }
        }


    }

    return acc;
  }


  public static int metodo2 (ArrayList a, int myAcc , int myi, ArrayList repList){
    int acc = myAcc;
    ArrayList<Integer> repeated = repList;
    int i = myi;
    while(true){
      if(repeated.contains(i)){return 0;}
      else{
        repeated.add(i);
        String currentLine = (String)a.get(i);
        String var = currentLine.substring(5);
        int entero = Integer.parseInt(var);
        String[] val = currentLine.split(" ");


        if(val[0].equals("nop")){
          if(val[1].indexOf("-")>=0){
            int varI = i;
            varI-=entero;
            if(metodo2(a, acc , varI, repeated)>0){return metodo2(a, acc , varI, repeated); }
        }
        else{
          int varI = i;
          varI+=entero;
          if(metodo2(a, acc , varI, repeated)>0){return metodo2(a, acc , varI, repeated); }
        }
        i++;
      }

        else if(val[0].equals("acc")){
          if(val[1].indexOf("-")>=0){
            acc-=entero;
        }
        else{
          acc+=entero;
        }
        }

        else {
          if(val[1].indexOf("-")>=0){
            i-=entero;
        }
          else{
            i+=entero;
          }
        }

      }

  }
}
}
