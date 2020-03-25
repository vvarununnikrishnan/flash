import java.util.ArrayList;
import java.util.*;
import java.util.Collections;

import java.util.*;

public class StudentAssessment
{
	public String getGrade(int totalMarks) 
	{
		if(totalMarks<=100 && totalMarks>=90)
			return "A+";
		else if (totalMarks<90 && totalMarks>=80)
			return "A";
		else if (totalMarks<80 && totalMarks>=70)
			return "B+";
		else if (totalMarks<70 && totalMarks>=60)
			return "B";
		else if (totalMarks<60 && totalMarks>=50)
			return "C+";
		else if (totalMarks<50 && totalMarks>=40)
			return "C";
		else 
			return "D";
	}	
	// to get the list of students with high marks
	public ArrayList<Student> highPerformanceAssessment(ArrayList<Student> students)
	{	
		ArrayList<Student> highestStudents = new ArrayList<Student>();
		ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
		listOfMarks = getListOfMarks(students);
		int high = Collections.max(listOfMarks);
		int low = Collections.min(listOfMarks);
		if( high == low )
		{
			return highestStudents;
		}
		else 
		{
			for(Student student : students)
			{ 	
				if(student.getTotalMarks() == high)
				{
					if(Collections.frequency(listOfMarks,high) >= 1)
					{
						highestStudents.add(student);
					}
				}
//				else 
//				{
//					continue;
//				}		
			}
		}
		return highestStudents;
	}
	// to get the list of students with low marks
	public ArrayList<Student> lowPerformanceAssessment(ArrayList<Student> students)
	{	
		ArrayList<Student> lowestStudents = new ArrayList<Student>();
		ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
		listOfMarks = getListOfMarks(students);
		int high = Collections.max(listOfMarks);
		int low = Collections.min(listOfMarks);
		if( high == low )
		{
			return lowestStudents;
		}
		else 
		{
			for(Student student : students)
			{ 	
				if(student.getTotalMarks() == low)
				{
					if(Collections.frequency(listOfMarks,low) >= 1)
					{
						lowestStudents.add(student);
					}
				}
//				else 
//				{
//					continue;
//				}		
			}
		}
		return lowestStudents;
	}
	// To get the list of total marks
	private static ArrayList<Integer> getListOfMarks(ArrayList<Student> students)
	{
		ArrayList<Integer> listOfMarks = new ArrayList<Integer>();
		for(Student student : students)
		{
			listOfMarks.add(student.getTotalMarks()); 
		}
		return listOfMarks;
	}
	
	public int getClassAverage(ArrayList<Student> students)
	{	
		int total = 0;
		for(Student student: students)
		{
			total += student.getTotalMarks();
		}
		return total/students.size();		
	}
	
}

// File edited
