package app;

import java.util.ArrayList;

public class GradeBook {
	private Record[] gradeBook;
	private int nrecords;

	GradeBook() {
		loadFromTables();
		sortbyId();
	}
	
	Record find(String key){
		int low = 0;
	         int high = nrecords - 1;
		          
		         while(high >= low) {
		             int middle = (low + high) / 2;
		             if(gradeBook[middle].getStudentid().equals(key)) {
		                 return gradeBook[middle];
		             }
		             if(gradeBook[middle].getStudentid().compareTo( key)<1) {
		                 low = middle + 1;
		             }
		             if(gradeBook[middle].getStudentid().compareTo( key)>1) {
		                 high = middle - 1;
		             }
		        }
		        return null;
	}
	
	ArrayList<Record> find(int mark1, int mark2){
		
		ArrayList<Record> arrlist= new ArrayList<Record>();
		for (int i=0; i<nrecords; i++)
			if(gradeBook[i].getTotal()>=mark1 && gradeBook[i].getTotal()<=mark2)
				arrlist.add(gradeBook[i]);
		return arrlist;
	}
	
	int lowestmark(){
		return gradeBook[0].getTotal();
	}
	
	int highestmark(){
		return gradeBook[nrecords-1].getTotal();
	}
	
	double averageMark()
	{
		double sum=0;
		for (int i=0; i<nrecords; i++)
			sum=sum+gradeBook[i].getTotal();
		
		return sum/nrecords; 
	}
	
	private void sortbyId()
	{
		for (int i = 0; i < nrecords - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < nrecords-1; j++)
                if (gradeBook[j].getStudentid().compareTo(gradeBook[index].getStudentid())<1)
                    index = j;
      
            Record smallerObj = gradeBook[index];
            gradeBook[index] = gradeBook[i];
            gradeBook[index] = gradeBook[i];
            gradeBook[i] = smallerObj;
        }
	}
	
	private String calculateGrade(int t){
		if (t>=85)
			return "HD";
		else if (t>=75 && t<85)
			return "D";
		else if (t>=75 && t<85)
			return "D";
		else if (t>=65 && t<75)
			return "D";
		else if (t>=50 && t<65)
			return "D";
		else if(t>0 && t<50)
			return "F";
		else
			return "AF";
	}

	private void loadFromTables() {

		String[] students = { "S10", "S20", "S30", "S40", "S50", "S60", "S08", "S18", "S28", "S38", "S48", "S58", "S06",
				"S16", "S26", "S36", "S46", "S56", };
		int[] assignment = { 0, 10, 20, 30, 30, 40, 0, 10, 20, 30, 30, 40, 0, 10, 20, 30, 30, 40, };
		int[] exam = { 0, 39, 44, 44, 54, 59, 1, 40, 45, 45, 55, 60, 2, 41, 46, 46, 56, 58, };

		nrecords = students.length;
		gradeBook = new Record[nrecords];
		for (int i = 0; i < nrecords; i++) {
			int t = assignment[i] + exam[i];
			String g = calculateGrade(t);
			Record r = new Record(students[i], assignment[i], exam[i], t, g);
			gradeBook[i] = r;
		}
	}

}
