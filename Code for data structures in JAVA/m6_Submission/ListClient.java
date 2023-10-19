package m6_Submission;
import java.util.Arrays;


//Rafael Hidalgo


public class ListClient {
	public static void main(String[] args) {
		
		testVectorList();
		
		System.out.println();
		
		System.out.println();
		
		System.out.println();
		
		testArrayList();
	} // end main

	public static void testArrayList() {
		
		System.out.println("Will now test ListClient using ArrayList \n ");
		
		ListInterface<Character> alphaList = new ArrList <>();
		// runnerList has only methods in ListInterface
		
		System.out.println("Will now implement add method\n");
		
		
		for(Character alphabet = 'a'; alphabet <='z'; alphabet++ )
	    {
			alphaList.add(alphabet);
	    }

		
		
		
		displayList(alphaList);
		
		
		System.out.println("Will now implement remove method to remove the "
				+ "fourth letter \"d\" on the list \n");
		
		
		alphaList.remove(4);
		displayList(alphaList);  
		
		System.out.println("Will now implement add method to add "
				+ "fourth letter \"d\" on the list to the fourth position \n");
		Character d = 'd';
		alphaList.add(4,d );
		
		displayList(alphaList);
		
		System.out.println("Will now implement replace method to replace \"r\" with \"R\" "
				+ "fourth letter \"d\" on the list to the fourth position \n");
		Character R = 'R';
		
		
		alphaList.replace(18,R );
		
		displayList(alphaList);
		
		System.out.println("Will now test the toArray method");
		
		System.out.println(Arrays.toString(alphaList.toArray()) + "\n");
		
		System.out.println("Will now test the contains method by testing if 5 is in list");
		
		Character five = '5';
		
		boolean result = alphaList.contains(five);
		
		System.out.println("Contain method outputted " + result + "\n");
		
System.out.println("Will now test the contains method by testing if R is in list");
		
		result = alphaList.contains(R);
		
		System.out.println("Contain method outputted " + result + "\n");
		
		System.out.println("Will now test if list is empty.");
		
		result = alphaList.isEmpty();
		
		System.out.println("isEmpty method outputs " + result + " as a result \n");
		
		System.out.println("Will implement clear method ");
		
		alphaList.clear();
		
		result = alphaList.isEmpty();
		
		System.out.println("Will now test if list is empty. isEmpty method outputs " + result + " as a result\n");
		
		
	} // end testArrayList
	
public static void testVectorList() {
		
		System.out.println("Will now test ListClient using Vectors \n ");
		
		ListInterface<Character> alphaList = new VecList <>();
		// runnerList has only methods in ListInterface
		
		System.out.println("Will now implement add method\n");
		
		
		for(Character alphabet = 'a'; alphabet <='z'; alphabet++ )
	    {
			alphaList.add(alphabet);
	    }

		
		
		
		displayList(alphaList);
		
		
		System.out.println("Will now implement remove method to remove the "
				+ "fourth letter \"d\" on the list \n");
		
		
		alphaList.remove(4);
		displayList(alphaList);  
		
		System.out.println("Will now implement add method to add "
				+ "fourth letter \"d\" on the list to the fourth position \n");
		Character d = 'd';
		alphaList.add(4,d );
		
		displayList(alphaList);
		
		System.out.println("Will now implement replace method to replace \"r\" with \"R\" "
				+ "fourth letter \"d\" on the list to the fourth position \n");
		Character R = 'R';
		
		
		alphaList.replace(18,R );
		
		displayList(alphaList);
		
		System.out.println("Will now test the toArray method");
		
		System.out.println(Arrays.toString(alphaList.toArray()) + "\n");
		
		System.out.println("Will now test the contains method by testing if 5 is in list");
		
		Character five = '5';
		
		boolean result = alphaList.contains(five);
		
		System.out.println("Contain method outputted " + result + "\n");
		
System.out.println("Will now test the contains method by testing if R is in list");
		
		result = alphaList.contains(R);
		
		System.out.println("Contain method outputted " + result + "\n");
		
		System.out.println("Will now test if list is empty.");
		
		result = alphaList.isEmpty();
		
		System.out.println("isEmpty method outputs " + result + " as a result \n");
		
		System.out.println("Will implement clear method ");
		
		alphaList.clear();
		
		result = alphaList.isEmpty();
		
		System.out.println("Will now test if list is empty. isEmpty method outputs " + result + " as a result\n");
		
		
	} // end testVectorList

	public static void displayList(ListInterface<Character> alphaList) {
		int numberOfEntries = alphaList.getLength();
		System.out.println("The list contains " + numberOfEntries + " entries, as follows "
				+ "(This tests the getlength method):\n");

		for (int position = 1; position <= numberOfEntries; position++)
			System.out.println(alphaList.getEntry(position) + " is entry " + position + " (tests getEntry method)");

		System.out.println();
	} // end displayList
} // end ListClient