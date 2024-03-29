import java.util.*;
import java.util.ArrayList;
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @modified by Sudath Nawagamuwage
 * @version 2021-10-23
 */
public class Student
{
    // The student ID
    private int id;
    // The student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    // The marks awarded for the modules on the course
    private ArrayList<ModuleMark> marks;
    //private ArrayList<Student> students;
            
    /**
     * This constructor creates a new student with a
     * fixed name and id. 
     */
    public Student()
    {
        //Student sudath = new Student ("Sudath Nawagamuwage", 21428786);
        //Student saveyth = new Student ("saveyth Nawagamuwage", 21428789);
        //addStudents(sudath);
        this("Sudath Nawagamuwage", 21428786);
        //this("Derek Peacock", 21428659);
         
    }
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        //mark array list
        marks = new ArrayList<ModuleMark>();
    }

    public void addMark(ModuleMark mark)
    {
        marks.add(mark);
    }
    
    /**
     * Find the module by the moduleCode and
     * set its mark to the value
     */
    public void awardMark(String moduleCode, int value)
    {

    }
    
    /**
     * Set the student's course
     */
    public void enrol(Course course)
    {
        this.course = course;
        this.course. addStudents(this);
        awardTestMarks();
        
    }
    
    /**
     * Award a different pass mark for each of the
     * modules on the enrolled course
     */
    public void awardTestMarks()
    {
        int value = 75;
        
        for(Module module : course.modules)
        {
           ModuleMark mark = new ModuleMark(module);
           mark.setMark(value);
           
           value = value -10;
            
           addMark(mark);
        }    
    }
    /**
     * Print the student's name and ID number to the 
     * output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + ", " + name);
    }
    
    public void printCourse()
    {
        this.print();
        course.print();
    }
    
    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the student ID of this student.
     */
    public int getID()
    {
        return id;
    }
    
        /**
     * Print the student module mark for 
     * thaire modules.
     */
    private void printModules()
    {
       for(ModuleMark mark : marks) 
       {
           mark.print();
           System.out.println("\t" + course.convertToGrade(mark.getValue()));
       }
    }
    
    public void printTranscript()
    {
        System.out.println(" ------------------------------------");
        System.out.println(" App21-02: Exam Board Transcript 2021");
        System.out.println("        by Sudath Nawagamuwage");
        System.out.println(" ------------------------------------");
        
        printCourse();
        
        System.out.println();
        System.out.println();
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        System.out.println(" Code \t Module \t\tCredit\t Mark \t Grade");
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        
        printModules();
       
        Grades finalGrade = course.calculateGrade(marks);
        
        System.out.println();
        System.out.println();
        
        if(finalGrade == Grades.NS)
        {
            System.out.println(" No Final Course Grade Yet!");
        }
        else
        {
            System.out.println(" Final Course Grade = " + finalGrade);
        }
    }
}