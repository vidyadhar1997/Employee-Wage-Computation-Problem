/**
* Use Case 2 for calculate daily employee wages
*/
public class EmployeeWageComputationProblem{
    //function for checking attendence of employee
    public int Check_Attendence(){
      //constants
    	final int isFullTime=1;
   	//for random value
   	final double randomValue=Math.floor(Math.random()*10)%2;
  		if(randomValue == isFullTime)
      	return 0;
    	else
      	return 1;
		}
      //function for calculating daily emp wages
		public int Calculate_Daily_Emoployee_Wages(int employee_wage_per_hour, int full_day_hour){
      	return employee_wage_per_hour * full_day_hour;

      }
}

class mainD{
	public static void main(String[] args){
      //constants
   	int Employee_Wage_PER_HOUR = 20;
      int FULL_DAY_HOUR = 8;
      int ABSENT = 0;
      int EMPLOYEE_PRSENT_OR_ABSENT;
      int EMPLOYEE_WEGES;
      EmployeeWageComputationProblem emp = new EmployeeWageComputationProblem();
      EMPLOYEE_PRSENT_OR_ABSENT = emp.Check_Attendence();
      if (EMPLOYEE_PRSENT_OR_ABSENT == 0){
      	EMPLOYEE_WEGES = emp.Calculate_Daily_Emoployee_Wages(Employee_Wage_PER_HOUR, FULL_DAY_HOUR);
      	}
		else{
           	EMPLOYEE_WEGES = ABSENT;
          }
            System.out.println("Daily Employee Wage is : "+EMPLOYEE_WEGES);
	   }
 }
