import java.util.*;
import java.io.*;
public class Dia1{
  public static void main(String args[]){
    File fd = new File("G:\\input.txt");
        Scanner file = null;
        ArrayList<Integer> arr = new ArrayList<>();
        try{
          file = new Scanner(fd);
        }
        catch(FileNotFoundException e){
          System.err.println("File does not exists " + e.getMessage());
          System.exit(0);
        }
        while(file.hasNext())
          arr.add(file.nextInt());
        file.close();
    System.out.println(suma(arr));

  }

  public static int suma( ArrayList a){
    int sum = 0;
    int mult = 0;
        for(int i=0; i<a.size(); i++){
          for(int j=i+1; j<a.size(); j++){
            for(int k=j+1; k<a.size(); k++){
            sum = (int)a.get(i)+(int)a.get(j)+(int)a.get(k);
              if(sum==2020){
                mult = (int)a.get(i)*(int)a.get(j)*(int)a.get(k);
                return mult;
              }
          }
        }
  }
  return 0;
}
}
