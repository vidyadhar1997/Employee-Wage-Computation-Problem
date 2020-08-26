/**
* Use Case 1 for employeee is prsent or not
*/
public class EmployeeWageComputationProblem{
   public static void main(String [] args){
   final int isFullTime=1;
   //for random value
   final double randomValue=Math.floor(Math.random()*10)%2;
   if(randomValue == isFullTime){
      System.out.println("Employee is prsent");
   }else{
      System.out.println("Employee is absent");
   }
 }
}

