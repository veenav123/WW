
import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NthSmallestNumber {
	 public static void main(String[] args) {
		 //generation random stream of numbers
		 IntStream stream = ThreadLocalRandom.current().ints(0, 1000).distinct().limit(500);
		 ArrayList<Integer>listval=new ArrayList<Integer>();
		 stream.forEach(s -> listval.add(s));
		 stream.close();
		 Collections.sort(listval);
		 System.out.print(System.lineSeparator()+"500 Random numbers between the range of 0 to 1000 are : ");
		 listval.forEach(value -> System.out.print(value+","));
		 
		 System.out.print(System.lineSeparator()+"Please enter kth value and hit enter: ");
		 Collections.sort(listval);	
		 
		 Scanner sc = new Scanner(System.in);
		 int k=sc.nextInt();
		
		 System.out.print(System.lineSeparator()+"The "+k+" smallest value in the random series is : "+listval.get(k));
          }
  }


