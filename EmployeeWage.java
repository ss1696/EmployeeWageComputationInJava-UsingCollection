import java.util.ArrayList;
import java.util.Iterator;

interface ICompanyEmplopyeeWage
{
        void addCompanyEmployeeWage(String company_name, int wage_per_hour, int total_working_days, int total_working_hour);
        void computeWage();
        int computeWage(CompanyEmployeeWage CompanyEmployeeWage);
}

class TestEmployee implements ICompanyEmplopyeeWage
{
	public static byte FULL_DAY_HOUR = 8;
    public static byte HALF_DAY_HOUR = 4;

	public int totalWage = 0;

	CompanyEmployeeWage comEmp = new CompanyEmployeeWage(company_name, wage_per_hour, total_working_days, total_working_hour);

	public ArrayList<CompanyEmployeeWage> comEmpArray = new ArrayList<CompanyEmployeeWage>();

	public void addCompanyEmployeeWage(String company_name, int wage_per_hour, int total_working_days, int total_working_hour)
	{
		comEmpArray.add(CompanyEmployeeWage(comEmp));
	}

	

	public void computeWage()
        {
		Iterator<CompanyEmployeeWage> it = comEmpArray.iterator();
		while(it.hasNext())
		{
			CompanyEmployeeWage ce = it.next();
		}
	}

	public int computeWage(CompanyEmployeeWage CompanyEmpWage)
	{
		int empWageFullDay = 0;
		int empWageHalfDay = 0;
		int totalWorkingDays = 0;
		int workingHour = 0;
		int wage = 0;

		while(workingHour <= CompanyEmpWage.total_working_hour && totalWorkingDays <= CompanyEmpWage.total_working_days)
		{
			double working_time = Math.floor(Math.random() * 10) % 3;
			int day = (int) working_time;
			switch(day)
			{
			case 0:
				empWageHalfDay = CompanyEmpWage.wage_per_hour * HALF_DAY_HOUR;
				wage = wage + empWageHalfDay;
        	        	workingHour = workingHour + HALF_DAY_HOUR;
				break;
        		case 1:
				empWageFullDay = CompanyEmpWage.wage_per_hour * FULL_DAY_HOUR;
				wage = wage + empWageFullDay;
        	        	workingHour = workingHour + FULL_DAY_HOUR;
				break;
			default:
				System.out.println("employee is absent");
				break;
			}
			totalWorkingDays++;
			totalWage = totalWage + wage;
		}
		System.out.println("monthly wage = "+totalWage);
		return  totalWage;
	}
}

public class EmployeeWage
{
	public static void main(String[] args)
	{
		TestEmployee t = new TestEmployee();

		t.addCompanyEmployeeWage("DMart",20,2,10);
		t.addCompanyEmployeeWage("tcs",25,20,20);
		t.computeWage();
	}
}