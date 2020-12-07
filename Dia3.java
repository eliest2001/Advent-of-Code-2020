import java.util.*;
import java.io.*;
public class Dia3{

  public static void main(String[] args) {
    Scanner file = null;
    File archivo = new File("G:\\input3.txt");
    ArrayList<String> arr = new ArrayList<>();
    long nt11 = 0;
    long nt31 = 0;
    long nt51 = 0;
    long nt71 = 0;
    long nt12 = 0;

    try{
        file = new Scanner(archivo);

    }
    catch(FileNotFoundException e){
      System.err.println("File does not exists " + e.getMessage());
      System.exit(0);
    }

    while(file.hasNext()){
      arr.add(file.nextLine());
    }
    nt11 = nTrees(arr, 1, 1);
    nt31 = nTrees(arr, 3, 1);
    nt51 = nTrees(arr, 5, 1);
    nt71 = nTrees(arr, 7, 1);
    nt12 = nTrees(arr, 1, 2);
    System.out.println("nTrees with (1,1): "+nt11);
    System.out.println("nTrees with (3,1): "+nt31);
    System.out.println("nTrees with (5,1): "+nt51);
    System.out.println("nTrees with (7,1): "+nt71);
    System.out.println("nTrees with (1,2): "+nt12);
    long res = nt11*nt31*nt51*nt71*nt12;
    System.out.println("nTrees multiplied: "+res);

  }

  public static long nTrees(ArrayList a, int b,int c){
    int pos = 0;
    char[] linea = null;

    int res = 0;
    for(int i=0;i<a.size();i+=c){
      String var =(String)a.get(i);
      linea =var.toCharArray();
      if(linea[pos]=='#'){res++;}
      pos = pos+b;
      pos=(pos%linea.length);
    }
    return res;
  }







}
