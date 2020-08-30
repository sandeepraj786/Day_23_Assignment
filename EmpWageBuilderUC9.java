public class EmpWageBuilderUC9
{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private  String Company;
	private  int empRatePerHour;
	private  int numOfWorkingDays;
	private  int maxHoursPerMonth;

	public   EmpWageBuilderUC9( final String  Company, final   int  empRatePerHour, final  int   numOfWorkingDays, final int  maxHoursPerMonth)
	{
		this.Company = Company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHoursPerMonth;
	}

	private int computeEmpWage()
	{
		int empHrs = 0;
		int totalEmpHrs = 0;
		int totalWorkingDays = 0;
		int totalEmpWage =0;

		while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays < numOfWorkingDays)
		{
			totalWorkingDays++;
			int randomValue = (int) Math.floor(Math.random()*10)%3;
			switch (randomValue) {
					case IS_PART_TIME:
						empHrs=4;
						break;
					case IS_FULL_TIME:
						empHrs=8;
						break;
					default:
						empHrs=0;
			}
			totalEmpHrs += empHrs;
			totalEmpWage =totalEmpHrs*empRatePerHour;
			totalEmpWage += totalEmpWage;

		}
		return totalEmpWage;
	}
	public static void main(String [] args)
	{
		EmpWageBuilderUC9 samsung = new EmpWageBuilderUC9("SAMSUNG",50,20,100);
		EmpWageBuilderUC9 nokia   = new EmpWageBuilderUC9("NOKIA", 60, 20, 100);

		System.out.println("Total Emp wage for Company " + samsung.Company +" is "+samsung.computeEmpWage());
		System.out.println("Total Emp wage for Company " + nokia.Company +" is "+  nokia.computeEmpWage());
	}
}
