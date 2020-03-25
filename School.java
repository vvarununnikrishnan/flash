import java.util.ArrayList;

import java.util.Scanner;

public class School 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);

		ArrayList<Student> students = new ArrayList<Student>();
		StudentAssessment studentAssessment1 = new StudentAssessment();
		int numberOfStudents = Validation.read_number(input, "Enter the number of students : ");
		int roll, totalMarks; 
		String name,grade;
		System.out.println("Enter the student details");
		for(int i=0; i< numberOfStudents; i++)
		{
			System.out.println("Student"+(i+1));
			roll = Validation.read_roll(input, "Enter the roll number : ",students);
			name = Validation.read_name(input, "Enter the name : ");
			totalMarks = Validation.read_int_score(input, "Enter the total marks : ");
			grade = studentAssessment1.getGrade(totalMarks);	
			students.add(new Student(roll, name, totalMarks, grade));
			System.out.println("One record inserted.");
			System.out.println();
		}		
		if(numberOfStudents == 1)
		{
			for(Student student: students)
			{
				System.out.println("only one record found.");
				System.out.println("------- Details of Student --------");
				System.out.println("Roll Number : "+student.getRoll());
				System.out.println("Name : "+student.getName());
				System.out.println("Total Marks : "+student.getTotalMarks());
				System.out.println("Grade : "+student.getGrade());
			}
		}
		else 
		{
			ArrayList<Student> listOfHighPerformStudents = new ArrayList<Student>();
			ArrayList<Student> listOfLowPerformStudents = new ArrayList<Student>();
			try 
			{
				listOfHighPerformStudents = studentAssessment1.highPerformanceAssessment(students);
				listOfLowPerformStudents = studentAssessment1.lowPerformanceAssessment(students);
				if(listOfHighPerformStudents.isEmpty())
				{
					if(listOfLowPerformStudents.isEmpty())
					{
						System.out.println("No student record with highest and lowest marks");
						System.out.println("------------- Details of students -----------");
						for(Student student: students)
						{
							System.out.println("Roll Number : "+student.getRoll());
							System.out.println("Name : "+student.getName());
							System.out.println("Total Marks : "+student.getTotalMarks());
							System.out.println("Grade : "+student.getGrade());
							System.out.println();
						}
					}
				}
				else
				{
					System.out.println("----- Details of students with highest marks ------");
					for(Student listOfHighPerformStudent : listOfHighPerformStudents)
					{
							System.out.println("Roll Number : "+listOfHighPerformStudent.getRoll());
							System.out.println("Name : "+listOfHighPerformStudent.getName());
							System.out.println("Total Marks : "+listOfHighPerformStudent.getTotalMarks());
							System.out.println("Grade : "+listOfHighPerformStudent.getGrade());
							System.out.println();
					}
					System.out.println("---------------------------------------");
					System.out.println("----- Details of students with lowest marks ------");
					for(Student listOfLowPerformStudent : listOfLowPerformStudents)
					{
							System.out.println("Roll Number : "+listOfLowPerformStudent.getRoll());
							System.out.println("Name : "+listOfLowPerformStudent.getName());
							System.out.println("Total Marks : "+listOfLowPerformStudent.getTotalMarks());
							System.out.println("Grade : "+listOfLowPerformStudent.getGrade());
							System.out.println();
					}
					System.out.println("---------------------------------------");
				}
			}
			catch(Exception e) 
			{}
			
			System.out.println("Class Average : "+studentAssessment1.getClassAverage(students));
			
		}
		
		input.close();
	}
}