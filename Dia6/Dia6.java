

  import java.io.*;
  import java.util.*;

  public class Dia6{

    public static void main(String[] args) {

      Scanner file = null;
      File archivo = new File("G:\\input99.txt");
      ArrayList<String> array = new ArrayList<>();
      int cont = 0;
      int cont2 = 0;
      char[] letras = {'a', 'b', 'c', 'x', 'y', 'z'};
      try{

        file = new Scanner(archivo);

      }
      catch( FileNotFoundException e){

        System.err.println("File does not exists " + e.getMessage());
        System.exit(0);

      }


      while(file.hasNextLine()){
        String str = file.nextLine();
        if(str.equals("")){

          cont += metodo(array);
          cont2 += metodo2(array);
          array.clear();

        }
        else{

          array.add(str);

        }

      }
      cont += metodo(array);
      cont2 += metodo2(array);
      System.out.println("Case 1 :"+cont);
      System.out.println("Case 2 :"+cont2);

    }
   public static int metodo2(ArrayList arr){

     int res = 0;
     int res1 = 0;
     String primero = (String)arr.get(0);
     char[] primeroChar = primero.toCharArray();

     if(arr.size()==1){return primeroChar.length;}
     else{
       for(int i = 0; i<primeroChar.length;i++){
          for(int j = 1; j<arr.size();j++){
            String l = (String)arr.get(j);
            char character = primeroChar[i];
            if(l.indexOf(character)>=0){res1++;}
          }
          if(res1==arr.size()-1){
              res++;
              }
            res1= 0;
          }
        return res;
      }


   }
   public static int metodo(ArrayList arr){
     int res = 0;
     ArrayList<Character> chars = new ArrayList<>();
     for(int i = 0; i<arr.size(); i++){
       String ss = (String)arr.get(i);
       char[] var = ss.toCharArray();
       for(int j = 0; j<var.length; j++){
         if(!chars.contains(var[j])){
           res++;
           chars.add(var[j]);
         }
   }

  }
 return res;
 }



  }
