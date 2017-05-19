package app;

public class Record {
	private String studentid;
	private int assignmnet;
	private int exam;
	private int total;
	private String grade;
	
	Record(String studentid, int assignment, int exam, int total, String grade){
		this.studentid = studentid;
		this.assignmnet = assignment;
		this.exam = exam;
		this.total = total;
		this.grade =grade;
	}
	
	public String getStudentid() {
		return studentid;
	}

	public int getAssignmnet() {
		return assignmnet;
	}

	public int getExam() {
		return exam;
	}

	public int getTotal() {
		return total;
	}

	public String getGrade() {
		return grade;
	}
	@Override
	public String toString()
	{
		return "studentid "+studentid +" total "+ total +  " grade "+grade;
	}
}
