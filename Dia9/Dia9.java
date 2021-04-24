import java.util.*;
import java.io.*;

public class Dia9 {

  public static void main (String[] args ) {
   ArrayList<Double> pre = new ArrayList<>();
   ArrayList<Double> post = new ArrayList<>();
    Scanner file = null;
    File archivo = new File("G:\\input8.txt");

    try{

      file = new Scanner(archivo);

    }
    catch(FileNotFoundException e){

      System.err.println("File does not exists " + e.getMessage());
      System.exit(0);

    }
    int i = 0;
    int a = 0;
    while(file.hasNextLine()){
    if(i<25){
      double a1 = Double.parseDouble(file.nextLine());
      pre.add(a1);
      post.add(a1);
      i++;
    }
    else{
      double a2 = Double.parseDouble(file.nextLine());
      double var = metodo(pre ,a2);
      if(var != 0 && a !=1){
        System.out.println(var);
        a=1;
        System.out.println(metodo2(post ,var));
      }
      post.add(a2);
    }
    }
    file.close();



  }

  public static double metodo (ArrayList<Double> a, double num ){
    double num1 = 0;
    double num2 = 0;
    for(int i = 0; i<a.size(); i++){
      for(int j = i + 1; j<a.size(); j++){
      num1 = a.get(i) ;
       num2 = a.get(j);
      if(a.get(i) + a.get(j) == num ){
        a.add(num);
        a.remove(0);
        return 0;
      }
    }

  }
  return num;
  }

  public static double metodo2 (ArrayList<Double> a, double num ){

      for(int i = 0; i<a.size(); i++){
          int j = i +1;
          double primero = a.get(i);
          double sum = primero;
          double ultimo = 0;

          while(j<a.size()&&sum<=num){
            if(primero > a.get(j)){primero = a.get(j);}
            if(ultimo < a.get(j)){ultimo = a.get(j);}
            if(sum + a.get(j) == num){return primero + ultimo;}
            sum+=a.get(j);
            j++;
           }

    }

    return 0;
    }
}
