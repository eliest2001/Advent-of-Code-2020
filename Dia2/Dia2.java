import java.util.*;
import java.io.*;
public class Dia2{

   public static void main(String[] args) {
     File archivo = new File("G:\\input2.txt");

     Scanner file = null;
     int min = 0;
     int max = 0;
     char letra = 'a';
     String pass = null;
     int validas1 = 0;
     int validas2 = 0;


     try{
        file = new Scanner(archivo);

     }
     catch(FileNotFoundException e){
       System.err.println("File does not exists " + e.getMessage());
       System.exit(0);
     }
     while(file.hasNext()){

       pass = file.nextLine();
       String[] PrimerSplit = pass.split("-");
       min = Integer.parseInt(PrimerSplit[0]);
       String[] SegundoSplit = PrimerSplit[1].split(" ");
       max = Integer.parseInt(SegundoSplit[0]);
       pass = SegundoSplit[2];
       char[] cc = SegundoSplit[1].toCharArray();
        letra = cc[0];

      if(valid1(min,max,letra,pass)){validas1++;}
      if(valid2(min,max,letra,pass)){validas2++;}
     }
        System.out.println("El numero de contrseñas validas segun el metodo 1 es: "+validas1);
        System.out.println("El numero de contrseñas validas segun el metodo 2 es: "+validas2);

     }


  public static boolean valid1(int a, int b, char c, String contrasena){

    char[] contrasena2 = contrasena.toCharArray();
    int n = 0;
    for(int i=0; i<contrasena2.length; i++){

      if(contrasena2[i]==c ){n++;}
    }

    if(n>=a&&n<=b){ return true;}

    return false;

  }

  public static boolean valid2(int a, int b, char c, String contrasena){

    char[] contrasena2 = contrasena.toCharArray();

      if(contrasena2[a-1]==c&&contrasena2[b-1]!=c){return true;}
      else if(contrasena2[a-1]!=c&&contrasena2[b-1]==c){return true;}
    return false;
  }
}
