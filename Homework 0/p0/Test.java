package p0;

public class Test {

	public Test (int s) { // Default Constructor
	
		int x;
		
		x = 10;
		
		// MyIntArray object variable of length (s)
		//MyIntArray testCase = new MyIntArray(s);
		
		/*for (int i = 0; i < testCase.size; i++){ 
			// Sets the values of testCase
			testCase.set(i,i);
		} 
		
		for (int j = 0; j < testCase.size; j++){ 
			// Prints the values of testCase
			System.out.println(testCase.get(j));
		}  
		*/

		// Reverse Order Test Code	*WORKS*
		/*
		MyIntArray rTestCase = new MyIntArray(s); // Will be used to hold the reverse value of 'testCase';
		rTestCase = Practice.reverseOrder(testCase); //Assigns rTestCase to be reverse of testCase
	   
		for (int k = 0; k < rTestCase.size; k++){ //Prints the values of testCase
			System.out.println(rTestCase.get(k));
		}
		*/
		

		// clumpFinder Code *WORKS*
		/* int clumpCount = 0; //Will count the num of clumps in an array

		testCase.set(0,1);
		testCase.set(1,2);
		testCase.set(2,3);
		testCase.set(3,4);
		testCase.set(4,5);
		testCase.set(5,3);
		
		clumpCount = Practice.findClumps(testCase); // Runs method, assigns value to variable
		System.out.println(clumpCount); // Prints the variable 
		*/
		
		 
	}

	public Test (MyString a, MyString b){
		
		//removeString Code *WORKS*
		
		
		MyString result = Practice.removeMyString(a, b);
		System.out.println(result.getContents());
		
		
	}

	public Test (MyString c, char d){
		
		// Count Char Code *WORKS*
		 System.out.println(Practice.countChar(c, d));
		
	}

	public static void main(String[] args) {
		//Test test = new Test(6); //Creates a "Test" object for MyIntArray
		
		// Testing for removeMyString
		
		/*
		MyString one = new MyString("Hello World");
		MyString two = new MyString("l");
		Test test2 = new Test(one, two);
		*/
		
		// Testing for countChar

		/*
		MyString deb = new MyString("");
		Test test3 = new Test(deb, 'b');
		*/

		// Testing Nation / FireNation *WORKS*

		/*
		Nation dub = new Nation("Zahir", 200); //Create test nation
		Nation dub1 = new Nation("Rayhon", 10); // Create enemy
		Nation dub2 = new Nation("Reginald", 500); //Create Ally
		FireNation dub4 = new FireNation("Zachary", 150, "dogs", 30); // Create a Fire Nation
	
		
		
		// Sets the enemy
		dub4.setEnemy(dub1);
		
		// Sets the ally	
		dub4.setAlly(dub2);	

		// Testing the toString methods
		System.out.println(dub4.toString());
		System.out.println(dub1.toString());
		System.out.println(dub2.toString());

		// Test backstab method
		dub.backstab();
		dub.setAlly(dub1);
		System.out.println(dub.toString());
		dub.backstab();
		System.out.println(dub.toString());
		//System.out.println(dub2.toString());

		// Testing relationship method
		System.out.println(dub.getRelationship(dub1));
		System.out.println(dub.getRelationship(dub2));
		*/
		
	}

}

