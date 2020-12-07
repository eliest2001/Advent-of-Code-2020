import java.util.*;
import java.io.*;
public class Dia4{

  public static void main(String[] args) {
    Scanner file = null;
    File archivo = new File("G:\\input.txt");
    ArrayList<String> var = new ArrayList<>();
    String[] string = new String[8];
    String str = null;
    int x = 0;
    int res = 0;
    int res2 = 0;
    try{
        file = new Scanner(archivo);

    }
    catch(FileNotFoundException e){
      System.err.println("File does not exists " + e.getMessage());
      System.exit(0);
    }

    while(file.hasNextLine()){
      str = file.nextLine();
      if(!str.equals("")){
        String[] prueba = str.split(" ");
        for(int i=0;i<prueba.length;i++){
          string[x]=prueba[i];
          x++;
        }
        if(!file.hasNextLine()){
          if(valid1(string)){res++;}
          if(valid2(string)){res2++;}
        }
      }else{
          if(valid1(string)){res++;}
          if(valid2(string)){res2++;}
          x=0;
          string = new String[8];

        }

      }
      System.out.println(res);
      System.out.println(res2);
    }

    public static boolean valid1(String[] a){
      int res=0;
      String[] fields = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
        for(int i=0;i<fields.length;i++){
          for(int j=0;j<a.length;j++){
            if(a[j]!=null){
            if(a[j].indexOf(fields[i])>=0){res++;}
          }
          }
        }
        if(res>=7){return true;}
        return false;
      }

      public static boolean valid2(String[] a){
        String[] var = null;
        int res=0;
        int byr=0;
        int iyr=0;
        int eyr=0;
        String hgt;
        String hcl;
        String ecl;
        String pid;
        String[] fields = {"byr","iyr","eyr","hgt","hcl","ecl","pid"};
        String[] validHcl = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String[] validEcl = {"amb","blu","brn","gry","grn","hzl","oth"};
        String[] numbers = {"0","1","2","3","4","5","6","7","8","9"};
          for(int i=0;i<fields.length;i++){
            for(int j=0;j<a.length;j++){
              if(a[j]!=null){
              if(a[j].indexOf(fields[i])>=0){
                if(a[j].indexOf("byr")>=0){//byr
                 var = a[j].split(":");
                 byr = Integer.parseInt(var[1]);
                 if(byr>=1920&&byr<=2002){res++;}
               }

               else if(a[j].indexOf("iyr")>=0){//iyr
                 var = a[j].split(":");
                 iyr = Integer.parseInt(var[1]);
                 if(iyr>=2010&&iyr<=2020){res++;}
               }

               else if(a[j].indexOf("eyr")>=0){//eyr
                 var = a[j].split(":");
                 eyr = Integer.parseInt(var[1]);
                 if(eyr>=2020&&eyr<=2030){res++;}
               }

               else if(a[j].indexOf("hgt")>=0){//hgt
                 var = a[j].split(":");
                 hgt = var[1];
                 char[] hgtChar = hgt.toCharArray();
                 int hgtNum = 0;
                 if(hgtChar[hgtChar.length-2]=='i'&&hgtChar[hgtChar.length-1]=='n'){//hgt in
                   String[] var2 = hgt.split("i");
                   hgtNum = Integer.parseInt(var2[0]);
                   if(hgtNum>=59&&hgtNum<=76){res++;}
                 }
                 else if(hgtChar[hgtChar.length-2]=='c'&&hgtChar[hgtChar.length-1]=='m'){//hgt cm
                   String[] var2 = hgt.split("c");
                   hgtNum =Integer.parseInt(var2[0]);
                   if(hgtNum>=150&&hgtNum<=193){res++;}
                 }
               }

                 else if(a[j].indexOf("hcl")>=0){//hcl
                   var = a[j].split(":");
                   hcl = var[1];
                   int hclRes = 0;
                   char[] hclChar = hcl.toCharArray();
                   if(hclChar[0]=='#'){
                     for(int hcli=0; hcli<validHcl.length;hcli++){
                       for(int hclj=1; hclj<hclChar.length;hclj++){
                         String hclString = Character.toString(hclChar[hclj]);
                         if(Character.toString(hclChar[hclj]).equals(validHcl[hcli])){hclRes++;}
                     }
                   }
                   if(hclRes==6){res++;}
                 }
                }

                else if(a[j].indexOf("ecl")>=0){//ecl
                  var = a[j].split(":");
                  ecl = var[1];
                  for(int ecli=0;ecli<validEcl.length;ecli++){
                    if(ecl.indexOf(validEcl[ecli])>=0){res++;}
                  }
                 }

                 else if(a[j].indexOf("pid")>=0){//pid
                   var = a[j].split(":");
                   pid = var[1];
                   char[] pidChar = pid.toCharArray();
                   int pidRes = 0;
                   if(pidChar.length==9){
                     for(int pidi=0; pidi<pidChar.length;pidi++){
                         for( int pidj=0; pidj<numbers.length; pidj++){
                             if(pidChar[pidi]==((numbers[pidj]).charAt(0))){pidRes++;}
                       }
                      }
                    }
                    if(pidRes==9){res++;}
                  }
              }
            }
            }
          }
          if(res>=7){return true;}
          return false;
        }




}
