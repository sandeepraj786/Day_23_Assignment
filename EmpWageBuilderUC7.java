public class EmpWageBuilderUC7
{
	private static final int EMP_RATE_PER_HRS  = 20;
	private static final int MaX_HRS_IN_MONTH  =100;
	private static int NUM_OF_WORKING_DAYS		 = 20;

	public static int getEmpHrs()
	{
		int isFullTime=1;
		int isPartTime=2;
		int empHrs=0;

		int randomValue=(int)Math.floor(Math.random()*10)%3;
		switch(randomValue)
		{
			case 1:
				empHrs=8;
				break;
			case 2:
				empHrs=4;
				break;
			default:
				empHrs=0;
				break;
		}

		return empHrs;
	}

	public static void calDailyWage()
	{
		int totalWage=0;
		int totalEmpHrs=0;
		int totalWorkingDays=0;

		while(totalEmpHrs<MaX_HRS_IN_MONTH && totalWorkingDays<NUM_OF_WORKING_DAYS)
		{
			totalWorkingDays++;
			int empHrs=getEmpHrs();
			totalEmpHrs+=empHrs;
		}
		totalWage=totalEmpHrs*EMP_RATE_PER_HRS;
		System.out.println("Total employee wage is:" + totalWage);
	}

	public static void main(String args[])
	{
		calDailyWage();
	}
}
