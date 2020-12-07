import java.util.*;
import java.io.*;

public class Dia5{

   public static void main(String[] args) {

    Scanner file = null;
    File archivo = new File("G:\\input5.txt");
    int highestID = 0;
    int lowestID = 922;

    try{

      file = new Scanner(archivo);

    }
    catch(FileNotFoundException e){
      System.err.println("File does not exists " + e.getMessage());
      System.exit(0);
    }
    int i = 0;
    String[] line = new String[874];
      while(file.hasNextLine()){
       line[i]= file.nextLine();
      if(seatID(line[i])>highestID){highestID=seatID(line[i]);}
      else if(seatID(line[i])<lowestID){lowestID=seatID(line[i]);}
      i++;

    }
    file.reset();

    int[] seats = new int[highestID-lowestID];

     for(int j = 0; j<line.length;j++){
       seats[j]=seatID(line[j]);

     }


    Arrays.sort(seats);
    System.out.println("My seat is : "+mySeat(seats));



  }
  public static int mySeat(int[] a){

    for(int i = 0; i<a.length;i++){
      if(a[i+1]-a[i]!=1){return a[i]+1;}

    }
    return 0;

  }
  public static int seatID(String a){
    int maxRow = 127;
    int minRow = 0;
    int maxColumn = 7;
    int minColumn = 0;
    int seatRow = 0;
    int res = 0;
    int seatColumn = 0;
    char[] charArray = a.toCharArray();

    for(int i = 0; i<charArray.length;i++){

          if(charArray[i]=='F'){
           if(i==6){
             seatRow=minRow;
           }
           else{
            maxRow=(maxRow-minRow)/2 +minRow;
            if(minRow!=0){minRow=minRow;}
            else{ minRow = 0;}
           }
          }
          else if(charArray[i]=='B'){
            if(i==6){
             seatRow=maxRow;
           }
           else{
            maxRow=maxRow;
            minRow=(maxRow-minRow)/2 +minRow + 1 ;
           }
          }
          else if(charArray[i]=='R'){
             if(i==9){
             seatColumn=maxColumn;
           }
           else{
            maxColumn=maxColumn;
            minColumn=(maxColumn-minColumn)/2 +minColumn + 1 ;
           }

          }
          else if(charArray[i]=='L'){
               if(i==9){
             seatColumn=minColumn;
           }
           else{
            maxColumn=(maxColumn-minColumn)/2 +minColumn;
            if(minColumn!=0){minColumn=minColumn;}
            else{ minColumn = 0;}
           }

          }

        }
        return res = seatRow * 8 +seatColumn;
    }



  }
