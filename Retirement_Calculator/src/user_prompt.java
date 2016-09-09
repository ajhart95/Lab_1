import java.util.Scanner; //imports the package
import org.apache.poi.ss.formula.functions.*; //imports library

public class user_prompt {

	public static void main(String[] args) {
		//creates scanner
		java.util.Scanner input = new Scanner(System.in);

		//Prompts the user to input the number of years they want to work and assigns variable
		System.out.print("How many years do you plan on working:");
		double years_work = input.nextDouble();
		
		//Prompts user to input expected return while saving and assigns variable
		System.out.print("Enter the annual expected return (between 0% and 20%) on your investment while you are saving:");
		double rate_work = input.nextDouble();
		
		//Prompts user to input their expected number of years in retirement and assigns variable
		System.out.print("How many years do you want to draw from your retirement savings?");
		double years_retire = input.nextDouble();
		
		//Prompts user to input expected return while spending their savings and assigns variable
		System.out.print("Enter the annual expected return(between 0% and 3%) on your investment, while retired :");
		double rate_retire = input.nextDouble();
		
		//Prompts user to input required monthly income and assigns variable
		System.out.print("Enter your required monthly income while retired:");
		double income = input.nextDouble();
		
		//Prompts user to input expected SSI
		System.out.print("Enter your monthly Social Security Income(SSI):");
		double monthly_ssi = input.nextDouble();
		
		double monthly_need = (income - monthly_ssi) * -1;
		double decline_rate = rate_retire / 12 / 100;
		double decline_period = years_retire * 12;
		
		double total_savings= FinanceLib.pv(decline_rate, decline_period, monthly_need, 0, false);
		
		double growth_rate = rate_work / 12 / 100;
		double growth_period = years_work * 12;
		
		double monthly_savings = (-1) * FinanceLib.pmt(growth_rate, growth_period, 0, total_savings, false);

		System.out.println("Before you retire your retirement savings should be $" + total_savings);
		System.out.println("This means you should save $" + monthly_savings + " to your retirement account each month.");

		
		
	
		
	}

}
