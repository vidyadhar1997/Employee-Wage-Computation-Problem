
/*********************************************************************************************************************************************************************************************
 *@Author:-> vidyadhar
 *@purpose:->Calculated Employee Wage for Multiple company
 *@Date:-> 31/8/2020
**********************************************************************************************************************************************************************************************/

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
* Calculating Emp wage for multiple company 
*/

 interface EmployeeWageMethode{
	 void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth);
	 void computeEmpWage();
	 int getTotalWageByCompanyName(final String name);
	}

	public class EmployeeWageComputationProblem implements EmployeeWageMethode{
	
	//Declaring attributes
   private List<Company>companies;
	private Map<String,Integer>companyWages;

	//Default constructor of employee wage computation problme
	public EmployeeWageComputationProblem() {
		companies = new ArrayList<Company>();
		companyWages=new HashMap<String,Integer>();
	}

	public static void main(String[] args) {
		System.out.println("Starting...");
		final EmployeeWageMethode empBuilder = new EmployeeWageComputationProblem();

		//Added diffrent companies
	   empBuilder.addCompany("Samsung", 20, 20, 100);
		empBuilder.addCompany("Nokia", 20, 18, 110);
		empBuilder.addCompany("Bajaj", 20, 18, 110);
		empBuilder.computeEmpWage();

		//Query for Samsung
		final int totalWage=empBuilder.getTotalWageByCompanyName("Samsung");
		System.out.println("\nTotal emp wages for Samsung : "+totalWage);
		//Query for Nokia
      final int totalWage1=empBuilder.getTotalWageByCompanyName("Nokia");
      System.out.println("Total emp wages for Samsung : "+totalWage1);
		//Query for Bajaj
      final int totalWage2=empBuilder.getTotalWageByCompanyName("Bajaj");
      System.out.println("Total emp wages for Samsung : "+totalWage2);

	}

	/**
    * Calculating total wage by each comany with name
	 @ return total wage of company
   */
	public int getTotalWageByCompanyName(final String name){
		final int totalWage=companyWages.get(name);
		return totalWage;
	}

	/**
    * Added companies in the arrayList
   */
	@Override
	public void addCompany( String name,  int empRate,  int numOfWorkingDays,  int maxHrsInMonth){
		System.out.println("\nCalled add company function with name : "+ name);
		companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
	}

	/**
    * Counting company and iterator through index and put for passes key and value
   */
	@Override
	public void computeEmpWage(){
		System.out.println("\nCalled computeEmpWage --->");
		for(int i = 0; i< companies.size(); i++){
			final Company company=companies.get(i);
			final int totalWage=computeEmpWage(company);
			company.setTotalEmpWage(totalWage);
		   companyWages.put(company.getName(),totalWage);
	   }
		System.out.println("\nStored values in Map : "+companyWages.toString());
	}

	/**
	 * calculate total employee wages
	 * @param company The Company
	 * @return total employee wages.
	 */
	private int computeEmpWage(final Company company) {
		System.out.println("\nCalculating company wage for company : " + company.getName());
		int totalWage = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		while(totalEmpHrs < company.getMaxHrsInMonth() && totalWorkingDays< company.getNumOfWorkingDays()){
			totalWorkingDays++;
			final int empHrs = getEmpHrs();
			final int empWage = empHrs*company.getEmpRate();
			totalEmpHrs+=empHrs;
			totalWage+=empWage;
		}
		return totalWage;
	}

	/**
	 * Get employee hours.
	 * @return employee hrs
	 */
	public int getEmpHrs() {

		final int isFullTime = 1;
		final int isPartTime = 2;
		int empHrs = 0;

		//get random value
		final double randomValue = Math.floor(Math.random()*10)%3;

		switch((int)randomValue) {

			case isFullTime:
				empHrs = 8;
				break;

			case isPartTime:
				empHrs = 4;
				break;

			default:
				break;
		}
		return empHrs;
	}


}

/**
 * CompanyEmpWage
 */
class Company {

	private String name;
	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;


	/**
 	* Parameteized constructor for Company
	@ Param  name,empRate,numOfWorkingDays,maxHrsInMonth
	*/
	public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
		this.name = name;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;

	}
	
	//setter and getter
	public String getName(){
		return this.name;
	}

	public int getEmpRate(){
		return this.empRate;
	}

	public int getNumOfWorkingDays(){
		return this.numOfWorkingDays;
	}

	public int getMaxHrsInMonth(){
		return this.maxHrsInMonth;
	}

	public void setTotalEmpWage(final int totalEmpWage){
		this.totalEmpWage=totalEmpWage;
	}

	@Override
	public String toString(){
		return "Total emp wage for company: "+name+" is "+ totalEmpWage;
	}

}

