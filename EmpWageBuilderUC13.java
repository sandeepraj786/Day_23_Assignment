import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
interface EmpWageBuilder
{
	void addCompany(final String name, final int empRate, final int numOfWorkingDays, final int maxHrsInMonth);
	void computeEmpWage();
}

public class EmpWageBuilderUC13 implements EmpWageBuilder {
	private List<Company> companies;
	private Map<String,Integer>companyWages;

	public EmpWageBuilderUC13() {
		companies = new ArrayList<Company>();
		companyWages = new HashMap<String,Integer>();
	}

	public static void main(String[] args) {
		System.out.println("Starting of program");
		final EmpWageBuilder empBuilder = new EmpWageBuilderUC13();
		empBuilder.addCompany("DMart", 20, 20, 100);
		empBuilder.addCompany("Relience", 20, 18, 110);

		empBuilder.computeEmpWage();
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
