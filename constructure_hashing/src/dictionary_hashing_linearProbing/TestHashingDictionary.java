package dictionary_hashing_linearProbing;

import java.util.Scanner;

public class TestHashingDictionary {

	public static void main(String[] args) {
		HashTable dictionary = new HashTable();
		Scanner scanner = new Scanner(System.in);
		int state = 0, option;
		String str;
		while (state != -1) {
			switch(state) {
			case 0:
				System.out.println("1) Insert. 2) Search. -1) Quit:");
				state = scanner.nextInt();
				break;
			case 1:
				System.out.print("Sentence: ");
				while((str = scanner.nextLine()).equals(""));
				dictionary.add(str);
				state = 0;
				break;
			case 2:
				System.out.print("Query: ");
				while((str = scanner.nextLine()).equals(""));
				if (dictionary.search(str))
					System.out.println("'" + str + "' is found!");
				else
					System.out.println("'" + str + "' is not found!");
				state = 0;
				break;
			default:
				System.out.println("Input error!");	
				state = 0;
			}
		} 
		System.out.println("Bye!");
	}

}
