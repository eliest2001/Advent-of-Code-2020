import java.util.*;
import java.io.*;

public class Dia8 {

  public static void main (String[] args ) {
   List<String> arr = new ArrayList<>();
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
    arr.add(file.nextLine());
    }
    file.close();
    List<List<String>> lista = crear(arr);
    //System.out.println("Case 1 : " +metodo(arr));
    System.out.println("Case 2 : " +metodo2(lista));

  }

  public static int metodo (List<String> a){
      int acc = 0;
      ArrayList<Integer> repeated = new ArrayList();
      int i = 0;
      while(!repeated.contains(i)&& i < a.size()){
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
        i++;
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
    if(i>=a.size()){return acc;}
    else{
    return 0;
    }

  }


  public static int metodo2 (List<List<String>> a ){

      for(int i = 0; i<a.size(); i++){
        if(metodo(a.get(i))!=0){return metodo(a.get(i)); }
        else {}
        }
       return 0;
    }
  public static List<List<String>> crear (List<String> a){
      List<List<String>> dev = new ArrayList<>();
      dev.add(a);
      for(int i = 0; i<a.size(); i++){
        List<String> var = new ArrayList<>();
        for(int j = 0; j<a.size(); j++){
            var.add(a.get(j));
        }
        String currentLine = (String)var.get(i);
        String[] val = currentLine.split(" ");

        switch(val[0]){
            case "nop":
            var.set(i, "jmp "+ val[1]);
            dev.add(var);
            break;

            case "jmp":
            var.set(i, "nop "+ val[1]);
            dev.add(var);
            break;
        }
        }
      return dev;
    }
}
