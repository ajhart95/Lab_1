import java.util.Scanner; //imports the package
import org.apache.poi.ss.formula.functions.*; //imports library

public class user_prompt {

	public static void main(String[] args) {
		//creates scanner
		java.util.Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the Retirement Calculator! Follow the prompt and it will display how much money you should save each month for retirement.");
		System.out.println("");
		
		//Prompts the user to input the number of years they want to work and assigns variable
		System.out.println("How many years do you plan on working:");
		double years_work = input.nextDouble();
		
		//Prompts user to input expected return while saving and assigns variable
		System.out.println("Enter the annual expected return as a number between 0 and 20 on your investment while you are saving(example: 7 = 7%):");
		double rate_work = input.nextDouble();
		
		//Prompts user to input their expected number of years in retirement and assigns variable
		System.out.println("How many years do you want to draw from your retirement savings?");
		double years_retire = input.nextDouble();
		
		//Prompts user to input expected return while spending their savings and assigns variable
		System.out.println("Enter the annual expected return as a number between 0 and 3 on your investment, while retired(example: 2 = 2%):");
		double rate_retire = input.nextDouble();
		
		//Prompts user to input required monthly income and assigns variable
		System.out.println("Enter your required monthly income while retired:");
		double income = input.nextDouble();
		
		//Prompts user to input expected SSI
		System.out.println("Enter your monthly Social Security Income(SSI). The maximum benefit you can recieve is $2642 per month.");
		double monthly_ssi = input.nextDouble();
		
		//Converts the user input to usable variables in correct units
		double monthly_need = (income - monthly_ssi) * -1;
		double decline_rate = rate_retire / 12 / 100;
		double decline_period = years_retire * 12;
		
		//Converts user input to usable variables in correct units
		double growth_rate = rate_work / 12 / 100;
		double growth_period = years_work * 12;
		
		//Calculates the Present value which is the amount of money the users needs to have in their retirement account when they retire
		double total_savings= FinanceLib.pv(decline_rate, decline_period, monthly_need, 0, false);
	
		
		//Calculates the Payment which is the amount of money the user needs to save each month into their retirement account
		double monthly_savings = (-1) * FinanceLib.pmt(growth_rate, growth_period, 0, total_savings, false);
		double monthly_savings_round = Math.round(monthly_savings * 100) / 100.0;
		
		//Prints the result using the user's parameters
		System.out.println("Using these parameters you should save $" + monthly_savings_round + " to your retirement account each month.");
	
	}

}
