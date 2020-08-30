/**
* Calculating Total Working Hour,Day And Total Wages
*/
public class EmployeeWageComputationProblem{

	//Constants
    private static final int WORKING_DAYS=20;
    private static final int TOTAL_MONTHLY_WORKING_DAYS=100;
    private static final int EMPLOYEE_WEG_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PARTIME_HOUR = 4;

   //Variables
    int countDays=0;
    int employeeMonthlyWages=0;
    int employeeWeges=0;
    int hours=0;
    int absent=0;
    String company="";

      //parameterized constructor
      public EmployeeWageComputationProblem(String cmp){
      this.company = cmp;
      this.employeeMonthlyWages =  wagesForMonth ();
      }

      //function for checking attendence of employee
      public int checkAttendence(){
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
      public int calculateDailyEmoployeeWages(){
         return EMPLOYEE_WEG_PER_HOUR * FULL_DAY_HOUR;

      }

      //function for calculating wagses for month
      public int wagesForMonth (){
	 		int employeePrsentOrAbsent=0;
         int partTimeOrFullTime=0;

         //Condition for total working day and hour
         while (countDays!=WORKING_DAYS && hours!=TOTAL_MONTHLY_WORKING_DAYS){
             employeePrsentOrAbsent= this.checkAttendence();

            switch (employeePrsentOrAbsent){

               case 0:
                  partTimeOrFullTime = this.checkAttendence();

                  switch (partTimeOrFullTime){

                     case 0:
                        employeeWeges= this.calculateDailyEmoployeeWages();
                        hours+=FULL_DAY_HOUR;
                        break;

                     case 1:
                        employeeWeges= this.calculateDailyEmoployeeWages();
                        hours+=PARTIME_HOUR;
                        break;

                     default:
                        break;
                  }
                  break;
               case 1:
                  employeeWeges = absent;
                  break;
             }
             employeeMonthlyWages+=employeeWeges;
             countDays++;

          }
          return employeeMonthlyWages;
    }

   //Display methode show the comany,total wages and total day and total hour
   void display(){
      System.out.println("\nCompany :"+company+"\nTotal Wages Are : "+employeeMonthlyWages+ "\nTotal days are : "+countDays + "\nTotal Hour  Are : " +hours);
   }

}

class mainD{
	public static void main(String[] args){
   	EmployeeWageComputationProblem emp1 = new EmployeeWageComputationProblem("Samsung");
   	emp1.display();
   	EmployeeWageComputationProblem emp2 = new EmployeeWageComputationProblem("microsoft");
   	emp2.display();
   	EmployeeWageComputationProblem emp3 = new EmployeeWageComputationProblem("Nokia");
   	emp3.display();
   	}
}
