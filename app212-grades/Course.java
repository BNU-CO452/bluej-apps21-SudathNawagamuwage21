import java.util.ArrayList;
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
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module co452 = new Module ("CO452", "Programming Concepts");
        addModule(co452);  
        
        Module co450 = new Module ("CO450", "Computer Architectures");
        addModule(co450);
        
        Module co456 = new Module ("CO456", "Web Development Prog");
        addModule(co456);
        
        Module co455 = new Module ("CO455", "Digital Technologies");
        addModule(co455);
    
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
        if(mark >= 0 && mark <= 39)
        {
            return Grades.F;
        }
        else if(mark >= 40 && mark <=49)
        {
            return Grades.D;
        }
        else if (mark >= 50 && mark <=59)
        {
            return Grades.C;
        }
        else if(mark >= 60 && mark <= 69)
        {
            return Grades.B;
        }
        else if(mark >= 70 && mark <= 100)
        {
            return Grades.A;
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
}
