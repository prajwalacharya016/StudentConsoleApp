package app;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
	GradeBook gr;

	View(GradeBook gb) {
		this.gr = gb;
	}

	void commandLoop() {
		System.out.println("-----------Select 1 for searching by records----------");
		System.out.println("-----------Select 2 for searching by range----------");
		System.out.println("-----------Select 3 for viewing Min, Max, Average----------");
		System.out.println("-----------Select 4 for Exiting----------");
		Scanner scanner = new Scanner(System.in);
		String values = scanner.nextLine();

		switch (Integer.parseInt(values)) {
		case 1:
			System.out.println("------------Please Enter the key to search----------");
			Scanner scannerkey = new Scanner(System.in);
			String key = scannerkey.nextLine();
			
			if ((gr.find(key) == null))
				System.out.println("Records Not found");
			else
				System.out.println(gr.find(key));
			break;
		case 2:
			System.out.println("------------Please Enter the range to search----------");
			System.out.println("First");
			Scanner scannerfirst = new Scanner(System.in);
			String first = scannerfirst.nextLine();
			Scanner scannersecond = new Scanner(System.in);
			System.out.println("Second");
			String second = scannersecond.nextLine();
			
			int firstInt = Integer.parseInt(first);
			int secondInt = Integer.parseInt(second);
			
			ArrayList<Record> arr = gr.find(firstInt, secondInt);
			if (arr.size() == 0)
				System.out.println("No Record Found");
			else {
				for (Record r : arr)
					System.out.println(r);
			}
			break;
		case 3:
			System.out.println("Minimum Value "+ gr.lowestmark());
			System.out.println("Max Value "+ gr.highestmark());
			System.out.println("Average Value "+ gr.averageMark());
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("--Wrong Input, Follow guidelines, Program Exiting--");
			break;
		}
	}
}
