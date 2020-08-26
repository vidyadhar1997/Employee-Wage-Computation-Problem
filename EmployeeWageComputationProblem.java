/**
* Use Case 5 for calculating monthly wages
*/
public class EmployeeWageComputationProblem{
    int countDays;
    int workingDays;
    int Employee_Monthly_Wages;
    int EMPLOYEE_WEGES;
    public EmployeeWageComputationProblem(){
    	countDays=0;
    	workingDays=20;
    	Employee_Monthly_Wages=0;
    	EMPLOYEE_WEGES=0;
    }
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
      public int Wages_For_Month(int EMPLOYEE_WEG_PER_HOUR,int FULL_DAY_HOUR,int PARTIME_HOUR,int ABSENT){
      	int EMPLOYEE_PRSENT_OR_ABSENT=0;
         int PARTIME_OR_FULLTIME=0;
         while (countDays<workingDays){
         	EMPLOYEE_PRSENT_OR_ABSENT = this.Check_Attendence();
            switch (EMPLOYEE_PRSENT_OR_ABSENT){
            	case 0:
               	PARTIME_OR_FULLTIME = this.Check_Attendence();
                  switch (PARTIME_OR_FULLTIME){
                  	case 0:
                     	EMPLOYEE_WEGES = this.Calculate_Daily_Emoployee_Wages(EMPLOYEE_WEG_PER_HOUR, FULL_DAY_HOUR);
                        break;
                     case 1:
                        EMPLOYEE_WEGES = this.Calculate_Daily_Emoployee_Wages(EMPLOYEE_WEG_PER_HOUR, PARTIME_HOUR);
                        break;
                     default:
                        break;
                  }
                  break;
                  case 1:
                  	EMPLOYEE_WEGES = ABSENT;
                     break;
           }
           Employee_Monthly_Wages+=EMPLOYEE_WEGES;
           countDays++;
        }
        return Employee_Monthly_Wages;
     }
}

class mainD{
	public static void main(String[] args){
      //constant
      int EMPLOYEE_WEG_PER_HOUR = 20;
      int FULL_DAY_HOUR = 8;
      int PARTIME_HOUR = 4;
      int ABSENT=0;
      EmployeeWageComputationProblem emp = new EmployeeWageComputationProblem();
      int Monthely_Wages=emp.Wages_For_Month(EMPLOYEE_WEG_PER_HOUR,FULL_DAY_HOUR,PARTIME_HOUR,ABSENT);
      System.out.println("Total Monthly Wages Are: "+Monthely_Wages);
      }
}
