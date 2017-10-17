package assignment5; // package declaration is compulsory.
import java.util.Scanner; // import scanner class

abstract class Employee 
{
	// Variables declaration
	int empId;
	String empName;
	int total_leaves;
	
	Scanner input=new Scanner(System.in); // scanner to take input from the user.
	
	Employee() // Default constructor of Employee class , it will accept basic employee details
	{
		System.out.println("Enter Employee ID :");
		empId=input.nextInt();
		System.out.println("Enter Employee Name :");
		empName=input.next();
		
		
	}
	
	//abstract methods
	abstract void calculate_balance_leaves(); 
	
	abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	
	abstract void calculate_salary();
	
}

class PermanentEmp extends Employee // PermanentEmp class inheriting Employee class
{
	// Variables declaration
	int paid_leave, sick_leave, casual_leave;
	double basic, hra,pfa,total_salary;
	final int total_leaves=50;
	int balance_leaves;
	
	// implementation of abstract method print_leave_details to print the leave details
	void print_leave_details()
	{
		System.out.println("Enter number of paid leaves taken :"); 
		paid_leave=input.nextInt(); // initializing paid leaves
		System.out.println("Enter number of sick leaves taken :"); 
		sick_leave=input.nextInt(); // initializing sick leaves
		System.out.println("Enter number of casual leaves taken :"); 
		casual_leave=input.nextInt(); // initializing casual leaves
		System.out.println("paid leaves = "+paid_leave+" "+"sick leaves = "+sick_leave+" "+"casual leaves = "+casual_leave);
		
	}
	
	// implementation of abstract method calculate_balance_leaves to calculate balance leaves
	void calculate_balance_leaves()
	{
		balance_leaves=total_leaves-paid_leave-sick_leave-casual_leave; // calculating balance leaves
		System.out.println("total_leaves =" +total_leaves+" "+"Balance leaves = "+balance_leaves);
	}
	
	// implementation of abstract method avail_leave to check whether leaves are allowed or not
	boolean avail_leave(int no_of_leaves,char type_of_leave)
	{
		// condition to check if number of leaves are allowed or not
		if(no_of_leaves>balance_leaves && (type_of_leave!='P'||type_of_leave!='S'||type_of_leave!='C'))
		{
			System.out.println("Leaves not allowed");
			return false;
		}
		
		else
		{
			System.out.println("Leaves allowed");
			return true;
		}
			
	}
	
	// implementation of method calculate_salary to calculate total salary
	void calculate_salary()
	{
		System.out.println("Enter Basic Salary :");
		basic=input.nextDouble();
		pfa=12*(basic/100);
		hra=50*(basic/100);
		total_salary=basic+hra-pfa;
		System.out.println("Total Salary = "+total_salary);
		
	}
}

class TemporaryEmp extends Employee // PermanentEmp class inheriting Employee class
{
	
	// Variables declaration
	double basic, hra,pfa,total_salary;
	final int total_leaves=30;
	int leaves_taken,balance_leaves;
	
	// implementation of abstract method calculate_balance_leaves to calculate balance leaves
	void calculate_balance_leaves()
	{
		System.out.println("Enter total leaves taken by tempoerary employee :");
		leaves_taken=input.nextInt(); // initializing leaves taken
		balance_leaves=total_leaves-leaves_taken; // calculating balance leaves
		System.out.println("total_leaves =" +total_leaves+" "+"Balance leaves = "+balance_leaves);
	}
	
	// implementation of abstract method avail_leave to check whether leaves are allowed or not
	boolean avail_leave(int no_of_leaves,char type_of_leave)
	{
		// condition to check if number of leaves are allowed or not
		if(no_of_leaves>balance_leaves && (type_of_leave!='P'||type_of_leave!='S'||type_of_leave!='C'))
		{
			System.out.println("Leaves not allowed");
			return false;
		}
		
		else
		{
			System.out.println("Leaves allowed");
			return true;
		}
			
	}
	
	// implementation of method calculate_salary to calculate total salary
	void calculate_salary()
	{
		System.out.println("Enter Basic Salary :");
		basic=input.nextDouble();
		pfa=12*(basic/100);
		hra=50*(basic/100);
		total_salary=basic+hra-pfa;
		System.out.println("Total Salary = "+total_salary);
		
	}

}

public class Assignment5_3 
{

	 
	public static void main(String[] args) // main method starts
	{
		// TODO Auto-generated method stub
		
		// Variables declaration
		int no_of_leaves;
		char type_of_leave;
		
		// Accepting the details of Permanent Employee
		System.out.println("Enter Permanent Employee Details :");
		
		PermanentEmp pe=new PermanentEmp(); // creating object of PermanentEmp class
		// calling the methods of PermanentEmp class
		pe.calculate_salary();
		pe.print_leave_details();
		pe.calculate_balance_leaves();
		
		Scanner sc=new Scanner(System.in); // scanner to take input from the user.
		System.out.println("Enter Number of leaves to be availed :");
		no_of_leaves=sc.nextInt(); // initializing number of leaves for permanent employee
		
		System.out.println("Enter type of leaves to be availed :");
		type_of_leave=sc.next().charAt(0); // initializing type of leaves for permanent employee
		
		// calling method avail_leave of PermanentEmp class 
		pe.avail_leave(no_of_leaves, type_of_leave);
		
		
		// Accepting the details of Temporary Employee
		System.out.println("Enter Temporary Employee Details :");
		
		TemporaryEmp te=new TemporaryEmp(); // creating object of TemporaryEmp class
		
		// calling the methods of TemporaryEmp class 
		te.calculate_salary();
		te.calculate_balance_leaves();
		
		System.out.println("Enter Number of leaves to be availed :");
		no_of_leaves=sc.nextInt(); // initializing number of leaves for temporary employee
		
		System.out.println("Enter type of leaves to be availed :");
		type_of_leave=sc.next().charAt(0); // initializing type of leaves for temporary employee
		
		// calling method avail_leave of TemporaryEmp class 
		te.avail_leave(no_of_leaves, type_of_leave);
		
		sc.close();
		
		
	}

}
