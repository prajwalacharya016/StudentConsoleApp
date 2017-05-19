package app;

public class Marks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GradeBook gr= new GradeBook();
		View v= new View(gr);
		v.commandLoop();
	}

}
