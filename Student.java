public class Student
{
	int roll;
	String name;
	String grade;
	int totalMarks;
	
	public Student(int roll, String name, int totalMarks, String grade)
	{
		this.roll = roll;
		this.name = name;
		this.totalMarks = totalMarks;
		this.grade = grade;
	}
	public int getRoll()
	{ 
		return this.roll;
	}
	public String getName()
	{
		return name;
	}
	public int getTotalMarks()
	{
		int tot = Integer.valueOf(totalMarks);
		return tot;
	}
	public String getGrade()
	{
		return grade;
	}
}