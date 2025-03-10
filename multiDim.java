import java.util.ArrayList;
import java.util.Collection;

public class Main {
  public static void swap(ArrayList<Integer>list, int idx1, int idx2) {
      int temp = list.get(idx1);
      list.set(idx1, list.get(idx2));
      list.set(idx2, temp);
  }
  public static void main(String args[]) {
      ArrayList<ArrayList<Integer>>mainList = new ArrayList<>();
      ArrayList<Integer>list1 = new ArrayList<>();
      ArrayList<Integer>list2 = new ArrayList<>();
      ArrayList<Integer>list3 = new ArrayList<>();
      
      for(int i=1; i<=5; i++) {
          list1.add(i*1);
          list2.add(i*2);
          list3.add(i*3);
      }
      mainList.add(list1); //add
      mainList.add(list2);
      mainList.add(list3);
      list2.remove(3);  //remove 
      list2.remove(2);
      
      System.out.println(mainList);
      
      //nested loop
      
      for(int i=0; i<mainList.size(); i++) {
          ArrayList<Integer>currList = mainList.get(i);
          for(int j=0; j<currList.size(); j++) {
              System.out.print(currList.get(j) + "");
          }
          System.out.println();
      }
  }
}



=== Code Output ===

[[1, 2, 3, 4, 5], [2, 4, 10], [3, 6, 9, 12, 15]]
12345
2410
3691215

=== Code Execution Successful ===
