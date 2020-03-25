import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Validation
{
	public static int read_number(Scanner input, String input_message)
	{
		int number = -1;    
		while(number <= 0)
		{
			System.out.print(input_message);
			String num = input.nextLine();
			try 
			{
				number = Integer.valueOf(num);
				if(number<=0)
				{
					System.out.println("number of students must be a number greater than zero");
					number = -1;
				}
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("number of students must be a number greater than zero. Re-enter again.");
				number = -1;
			}
		}
		return number;
	}
	
	public static int read_roll(Scanner input, String input_message, ArrayList<Student> students)// , ArrayList<Student> students
	{
		int number = -1;    
		while(number <= 0)
		{
			System.out.print(input_message);
			String num = input.nextLine();
			try 
			{
				number = Integer.valueOf(num);
				number = read_roll_redundancy_check(Integer.valueOf(num),students);
				if(number==0)
				{
					System.out.println("Roll number must be a number greater than zero");
					number = -1;
				}
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Roll number contains only numbers. Re-enter again.");
				number = -1;
			}
		}
		return number;
	}
	// avoiding duplicates in roll number
	private static int read_roll_redundancy_check(int in, ArrayList<Student> students)
	{
		Iterator<Student> iterator =  students.iterator();
		while(iterator.hasNext())
		{
			if((iterator.next()).getRoll() == in )
			{
				System.out.println("Roll Number Already exists. Re-Enter again.");
				return -1;
			}
		}
		return in;
	}
	
	public static String read_name(Scanner in, String input_message)
	{
		String name = "";
        while(name.isEmpty())
        {
        	try 
	        {
	            System.out.print(input_message);
	            name = in.nextLine();
	            if(name.matches(".*\\d.*"))
	            {
	            	System.out.println("Name contains only alphabets. Re-enter again.");
	                name = "";
	            }
	            else if(name.matches("[$&+,:;=?@#|'<>.-^*()%!]")) 
	            {
	            	System.out.println("Name contains only alphabets. Re-enter again.");
	                name = "";
				}
	            else
	            {
	                break;
	            }
	
	        } 
        	catch (Exception e) 
        	{
        		System.out.println("Name contains only alphabets. Re-enter again.");
	            name = "";
	        }
        }
        return name;
	}

	public static int read_int_score(Scanner input, String input_message)
	{
		int number = -1;    
		while(number < 0)
		{
			System.out.print(input_message);
			String num = input.nextLine();
			try 
			{
//				number = Integer.valueOf(num);
				number = read_int_score_range(Integer.valueOf(num));
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Total marks contains only numbers from 0 to 100. Re-enter again.");
				number = -1;
			}
		}
		return number;
	}
	
	private static int read_int_score_range(int in)
	{
		if( in >= 0 && in <= 100 )
			return in;
		else
		{
			System.out.println("Total marks should be a number within a range starts from 0 to 100.");
			return -1;
		}
			
	}
	
	
	
}
