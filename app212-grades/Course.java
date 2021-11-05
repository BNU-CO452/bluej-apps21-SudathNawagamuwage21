import java.util.ArrayList;
import java.util.*;

/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author modifie Peacock and Nicholas Day
 * @modified by Sudath Nawagamuwage
 * @version 2021-10-23
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    //arry list for studnet
    public ArrayList<Student> students;
    
       
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    public Course()
    {
        this("BT1CWD1", "BSc Computing & Web");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        createModules();
        students = new ArrayList<Student>();
              
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module co452 = new Module ("CO452", "Programming Concepts  ");
        addModule(co452);  
        
        Module co450 = new Module ("CO450", "Computer Architectures ");
        addModule(co450);
        
        Module co456 = new Module ("CO456", "Web Development Prog  ");
        addModule(co456);
        
        Module co455 = new Module ("CO455", "Digital Technologies  ");
        addModule(co455);
    
    }   
    
    public void addStudents(Student student)
    {
        students.add(student);
    }
        
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**The student mark calculated and return
     * grade value
     */
    public Grades convertToGrade(int mark)
    {
        Grades grade = Grades.NS;
        
         if(mark <= Grades.A.getValue()
                    && mark > Grades.B.getValue())
        {
            return Grades.A;
        }
         else if(mark <=  Grades.B.getValue() 
                    && mark > Grades.C.getValue())
        {
            return Grades.B;
        }
        else if(mark <=  Grades.C.getValue() 
                    && mark > Grades.D.getValue())
        {
            return Grades.C;
        }
        else if(mark <=  Grades.D.getValue() 
                    && mark > Grades.F.getValue())
        {
            return Grades.D;
        }
        if(mark <= Grades.F.getValue()
                    && mark > Grades.NS.getValue())
        {
            return Grades.F;
        }
        else
            return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        int averageMark = 0;
        
        for (ModuleMark mark : marks)
        {
            total = total + mark . getValue();
        }
        
        averageMark = total / MAXN_MODULES;
        
        finalGrade = convertToGrade(averageMark);
        
        return finalGrade;
        
        //return Grades.NS;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules. 
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        //System.out.println();
        
        printModules();
    }
    
    /**
     * Print the course's four modules and the credit
     */
    public void printModules()
    {
        System.out.println("        Course Modules");
        System.out.println("        --------------");
        //System.out.println();
        
        for(Module module : modules)
        {
            //System.out.println(module.getCode());
            //System.out.println(module.getTitle());
            module.print();
            module.printCredit();
        }
    }
    public void prinListStudentEnroll()
    {
        
        System.out.println("        Enroll Students List");
        System.out.println("        ---------------------");
             
        for(Student student: students)
        {   
           student.print();
        }
    }
}
