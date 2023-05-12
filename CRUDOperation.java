import java.util.*;

public class CRUDOperation {
    private int empno;
    private String ename;
    private int salary;

    CRUDOperation(int empno, String ename, int salary){
        this.empno = empno;
        this.ename = ename;
        this.salary = salary;
    }
    public int getEmpno(){
        return empno;
    }
    public int getSalary(){
        return salary;
    }
    public String getEname(){
        return ename;
    }

    public String toString(){
        return empno+" "+ename+" "+salary;
    }
}

class CRUDDemo{
    public static void main(String[] args) {
        List<CRUDOperation> c= new ArrayList<CRUDOperation>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("4. Delete");
            System.out.println("5. Update");
            System.out.println("Enter your Choice: ");
            ch = s.nextInt();

            switch(ch){
                case 1:
                System.out.print("Enter Employee number: ");
                int eno = s.nextInt();
                System.out.print("Enter Employee name: ");
                String ename = s1.nextLine();
                System.out.print("Enter Employee Salary: ");
                int salary = s.nextInt();

                c.add(new CRUDOperation(eno, ename, salary));
                break;

                case 2:
                System.out.println("--------------------------------");
                Iterator<CRUDOperation> i = c.iterator();
                while(i.hasNext()){
                    CRUDOperation e = i.next();
                    System.out.println(e);
                }
                System.out.println("----------------------------------");
                break;

                case 3:
                boolean found = false;
                System.out.println("Enter the Employee number to search: ");
                int empno = s.nextInt();
                System.out.println("--------------------------------");
                // Iterator<CRUDOperation> j = c.iterator();
                i = c.iterator();
                while(i.hasNext()){
                    CRUDOperation e = i.next();
                    if(e.getEmpno() == empno){
                        System.out.println(e);
                        found = true;
                    }
                    
                }
                if(!found){
                    System.out.println("Record is not found");
                }
                System.out.println("----------------------------------");
                break;

                case 4:
                 found = false;
                System.out.println("Enter the Employee number to delete: ");
                empno = s.nextInt();
                System.out.println("--------------------------------");
                // Iterator<CRUDOperation> j = c.iterator();
                i = c.iterator();
                while(i.hasNext()){
                    CRUDOperation e = i.next();
                    if(e.getEmpno() == empno){
                        i.remove();
                        found = true;
                    }
                    
                }
               
                if(!found){
                    System.out.println("Record is not found");
                }
                else{
                    System.out.println("Record deleted successfully");
                }
                System.out.println("----------------------------------");
                break;

                case 5:
                found = false;
               System.out.println("Enter the Employee number to Update: ");
               empno = s.nextInt();
               ListIterator<CRUDOperation> li = c. listIterator();
               while(li.hasNext()){
                   CRUDOperation e = li.next();
                   if(e.getEmpno() == empno){
                       System.out.print("Enter the new Name: ");
                       ename = s1.nextLine();
                       System.out.print("Enter the salary: ");
                       salary = s.nextInt();
                       li.set(new CRUDOperation(empno, ename, salary));
                       found = true;
                   }
                   
               }
              
               if(!found){
                   System.out.println("Record is not found");
               }
               else{
                   System.out.println("Record updated  successfully");
               }
               break;
            }
        } while (ch!=0);
    }
}