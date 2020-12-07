

  import java.io.*;
  import java.util.*;

  public class Dia6{

    public static void main(String[] args) {

      Scanner file = null;
      File archivo = new File("G:\\input.txt");
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

          //cont += metodo(array);
          cont2 += metodo2(array);
          array.clear();

        }
        else{

          array.add(str);

        }

      }
      //cont += metodo(array);
      cont2 += metodo2(array);
      //System.out.println(cont);
      System.out.println(cont2);

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
     int a = 0;
     int b = 0;
     int c = 0;
     int d = 0;
     int e = 0;
     int f = 0;
     int g = 0;
     int h = 0;
     int ii = 0;
     int jj = 0;
     int k = 0;
     int l = 0;
     int m = 0;
     int n = 0;
     int o = 0;
     int p = 0;
     int q = 0;
     int r = 0;
     int s = 0;
     int t = 0;
     int u = 0;
     int v = 0;
     int w = 0;
     int x = 0;
     int y = 0;
     int z = 0;
     for(int i = 0; i<arr.size(); i++){
       String ss = (String)arr.get(i);
       char[] var = ss.toCharArray();
       for(int j = 0; j<var.length; j++){
         if(var[j]=='a'&& a!=1){
           res++;
           a++;
         }
         else if(var[j]=='b'&& b!=1){
           res++;
           b++;
         }
         else if(var[j]=='c'&& c!=1){
           res++;
           c++;
         }
         else if(var[j]=='d'&& d!=1){
           res++;
           d++;
         }
         else if(var[j]=='e'&& e!=1){
           res++;
           e++;
         }
         else if(var[j]=='f'&& f!=1){
           res++;
           f++;
         }
         else if(var[j]=='g'&& g!=1){
           res++;
           g++;
         }
         else if(var[j]=='h'&& h!=1){
           res++;
           h++;
         }
         else if(var[j]=='i'&& ii!=1){
           res++;
           ii++;
         }
         else if(var[j]=='j'&& jj!=1){
           res++;
           jj++;
         }
         else if(var[j]=='k'&& k!=1){
           res++;
           k++;
         }
         else if(var[j]=='l'&& l!=1){
           res++;
           l++;
         }
         else if(var[j]=='m'&& m!=1){
           res++;
           m++;
         }
         else if(var[j]=='n'&& n!=1){
           res++;
           n++;
         }
         else if(var[j]=='o'&& o!=1){
           res++;
           o++;
         }
         else if(var[j]=='p'&& p!=1){
           res++;
           p++;
         }
         else if(var[j]=='q'&& q!=1){
           res++;
           q++;
         }
         else if(var[j]=='r'&& r!=1){
           res++;
           r++;
         }
         else if(var[j]=='s'&& s!=1){
           res++;
           s++;
         }
         else if(var[j]=='t'&& t!=1){
           res++;
           t++;
         }
         else if(var[j]=='u'&& u!=1){
           res++;
           u++;
         }
         else if(var[j]=='v'&& v!=1){
           res++;
           v++;
         }
         else if(var[j]=='w'&& w!=1){
           res++;
           w++;
         }
         else if(var[j]=='x'&& x!=1){
           res++;
           x++;
         }
         else if(var[j]=='y'&& y!=1){
           res++;
           y++;
         }
         else if(var[j]=='z'&& z!=1){
           res++;
           z++;
         }
        else{

        }

       }
     }
     return res;


   }






  }
