import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeData {
    
    public static class Employee{
        private String name;
        private int age;
        private String gender;
        private String DepartmentName;
        private int salary;
        private LocalDate joining;
        public Employee(String name,int age,String gender,String department,int Salary,LocalDate joiningDate)
        {
            this.name=name;
            this.age=age;
            this.gender=gender;
            this.DepartmentName=department;
            this.salary=Salary;
            this.joining=joiningDate;
        }
        public String getName(){
            return this.name;
        }
        public String getGender(){
            return this.gender;
        }

        public String getDept(){
            return this.DepartmentName;
        }
        public Integer getAge(){
            return this.age;
        }
        public Integer getSalary(){
            return this.salary;
        }
        public LocalDate getJoiningDate(){
            return this.joining;
        }
    }
    public static class organization{
        private List<Employee>EmployeeData;

        public organization(List<Employee>emp)
        {
            this.EmployeeData=emp;
        }

        // How many male and female employees are there in the organization?
        public void countOfMaleFemale()
        {
            System.out.println("Female Employees Count: "+EmployeeData.stream().filter(e->e.getGender()=="Female").count()+"\n");
            System.out.println("Female Employees Count: "+EmployeeData.stream().filter(e->e.getGender()=="Male").count());
        }

        // Print the name of all departments in the organization.
        public void AllDepartments(){
            // System.out.println("Departments Name: "+);
            
            Set<String>s=EmployeeData.stream().map(e->e.getDept()).collect(Collectors.toSet());

            System.out.println("\nList Of All Departments: "+s);
        }

        // What is the average age of male and female employees?
        public void AverageAge(){
            double averageSum1=EmployeeData.stream().filter(e->e.getGender()=="Male").mapToInt(Employee::getAge).average().orElse(0);
            System.out.println("\nAverage Age of Male Employees: "+averageSum1);

            double averageSum2=EmployeeData.stream().filter(e->e.getGender()!="Male").mapToInt(Employee::getAge).average().orElse(0);
            System.out.println("\nAverage Age of Femle Employees: "+averageSum2);
        }

        // Get the details of highest paid employee in the organization
        public void HighestPaidEmployee(){

            int maxi=0;
            for(Employee e:EmployeeData)
            {   
                maxi=Math.max(maxi,e.getSalary());
            }
            System.out.println("\nHighest Paid Employee in Organisation is: "+maxi);
        }

        // Get the names of all employees who have joined after 2015
        public void JoinedAfter2015(){
            for(Employee e:EmployeeData)
            {
                if(e.getJoiningDate().isAfter(LocalDate.of(2015,1,1)))
                {
                    System.out.println(e.getName());
                }
            }
        }

        // Count the number of employees in each department
        public void DepartmentWiseCount(){
            Map<String,Long>DeptMap=EmployeeData.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));

            System.out.println("\nNumber of Employees In Each Department: \n"+DeptMap+"\n");
        }

        // What is the average salary of each department?
        public void AverageSalaryEachDepartment(){
            Map<String,Double>SalaryMap=EmployeeData.stream().collect(
                Collectors.groupingBy(Employee::getDept,Collectors.averagingDouble(Employee::getSalary)));
            SalaryMap.forEach((e,j)->System.out.println("Dept Name: "+e+" Average Salary: "+j));
        }

        // Who has the most working experience in the organization?
        public void MostExpriencedEmp(){
            System.out.println("\nMost Exprienced Employee in Organisation: "+EmployeeData.stream().min(Comparator.comparing(Employee::getJoiningDate)).orElse(null).getName());
        }

        // Get the details of youngest male employee in the each department.
        public void YoungestMaleEmp(){
            System.out.println("\nYoungest Male Employee in Organisation: "+EmployeeData.stream().filter(e->e.getGender()=="Male").min(Comparator.comparing(Employee::getAge)).orElse(null).getName());
        }

        // What is the average salary and total salary of the whole organization?
        public void AverageAndWholeSalary(){
            System.out.println("\nWhole Salary of Organisation: "+EmployeeData.stream().mapToDouble(Employee::getSalary).sum());
            System.out.println("\nAverage Salary of Organisation: "+EmployeeData.stream().mapToDouble(Employee::getSalary).sum()/EmployeeData.size());

        }
    }
    public static void main(String[] args)
    {
         List<Employee> employeesData = new ArrayList<>();
         employeesData.add(new Employee("Vinit", 30, "Male", "HR",75000, LocalDate.of(2015, 5, 15)));
         employeesData.add(new Employee("Dev", 28, "Male", "HR",65000, LocalDate.of(2020, 5, 15)));
         employeesData.add(new Employee("Fenil", 35, "Male", "IT",55000, LocalDate.of(2010, 5, 15)));
         employeesData.add(new Employee("Gopi", 25, "Female", "Finance",45000, LocalDate.of(2010, 5, 15)));
         employeesData.add(new Employee("Yash", 40, "Male", "Finance",55000, LocalDate.of(2010, 5, 15)));

         organization org=new organization(employeesData);
        
         org.countOfMaleFemale();

         org.AllDepartments();

         org.AverageAge();

         org.HighestPaidEmployee();

         org.JoinedAfter2015();

         org.DepartmentWiseCount();

         org.AverageSalaryEachDepartment();

         org.MostExpriencedEmp();

         org.YoungestMaleEmp();

         org.AverageAndWholeSalary();
    }
}
