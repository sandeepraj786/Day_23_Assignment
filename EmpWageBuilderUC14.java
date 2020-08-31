import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

//  Interface approach
interface EmpWageBuilder
{
	
	void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth);
	void computeEmpWage();
	int getTotalWageByCompanyName(final String name);
}

public class EmpWageBuilderUC14 implements EmpWageBuilder {
  // List interface
	private List<Company> companies;

	//Map Interface
	private Map<String,Integer>companyWages;

	//Overloaded constructor
	public EmpWageBuilderUC14() {
		companies = new ArrayList<Company>();
		companyWages = new HashMap<String,Integer>();
	}

	public static void main(String[] args) {
		System.out.println("Starting of program");
		final EmpWageBuilder empBuilder = new EmpWageBuilderUC14();

		//data for DMart employee
		empBuilder.addCompany("DMart", 20, 20, 100);

		// data for Relience employee
		empBuilder.addCompany("Relience", 20, 18, 110);
		empBuilder.computeEmpWage();

		//Query for DMart
		final int totalWage=empBuilder.getTotalWageByCompanyName("DMart");
		System.out.println("Total emp wage for DMart :"+totalWage);

		// Query for Relience
		//Query for DMart
      final int totalWage1=empBuilder.getTotalWageByCompanyName("Relience");
      System.out.println("Total emp wage for DMart :"+totalWage1);

	}

		@Override
	   public int getTotalWageByCompanyName(final String name)
		{
			final int totalWage = companyWages.get(name);
			return totalWage;
		}

	@Override
	public void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
		System.out.println("Called add company function with name : "+ name);
		companies.add(new Company(name, empRate, numOfWorkingDays, maxHrsInMonth));
	}

	@Override
	public void computeEmpWage(){

		System.out.println("Called computeEmpWage --->");
		for(int i = 0; i< companies.size(); i++){
			final Company company =companies.get(i);
			final int totalWage = computeEmpWage(company);
			company.setTotalEmpWage(totalWage);
			companyWages.put(company.getName(), totalWage);
		}
		System.out.println("Stored value in map....>"+companyWages.toString());

	
	}

	private int computeEmpWage(final Company company) {
		System.out.println("Calculating company wage for company : " + company.getName());
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

	public int getEmpHrs() {

		// Constant
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

class Company {

	private String name;
	private int empRate;
	private int numOfWorkingDays;
	private int maxHrsInMonth;
	private int totalEmpWage;

	public Company(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth){
		this.name = name;
		this.empRate = empRate;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHrsInMonth = maxHrsInMonth;
	}

	// getter and setter method

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
