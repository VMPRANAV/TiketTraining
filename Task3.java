import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.time.LocalDate.*;

class Employee {
    public String name;
    private String id;
    private int age;
    private LocalDate Doj;

    public Employee(String id, String name, int age, LocalDate doj) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.Doj = Doj;
    }

}
    public class Task3 {
    public static void main(String[] args) {
MyListGeneric<Employee>emplList= new MyListGeneric<>(5);
Employee e1= new Employee("Tkt1","Pranav",20, of(2026,9,21));
Employee e2= new Employee("Tkt2","Shivam",20, of(2026,9,21));
Employee e3= new Employee("Tkt3","Maha",22, of(2026,8,1));
Employee e4= new Employee("Tkt4","Jawakar",27, of(2022,12,15));
Employee e5= new Employee("Tkt5","Dhruv",30, of(2025,11,15));
emplList.add(e1);
        emplList.add(e1);
        emplList.add(e2);
        emplList.add(e3);
        emplList.add(e4);
        emplList.add(e5);
        emplList.printArray();
        System.out.println(emplList.getByIdx(4).name);

    }
}

