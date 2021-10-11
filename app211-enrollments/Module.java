
/**
 * This Module calss contains a BNU module which from part of a course
 *
 * @author Sudath Nawagamuwage
 * @version 08/10/2021
 */
public class Module
{
    // variables for Module class
    private String code;
    private String title;
    private int credit;
    private int mark;

    /**
     * Constructor for objects of class Module
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        this.credit = 15;
        this.mark = 0;
        
    }
    /**
     * Return the course code of the moudle.
     */
    public String getCode()
    {
        return this.code;
    }
    /**
     * Return the title name of the moudle.
     */
    public String getTitle()
    {
        return this.title;
    }
    /**
     * Return the crdite value of this moudle.
     */
    public int getCredit()
    {
        return this.credit;
    }
    /**
     * Set the the crdite value of this moudle.
     */
    public void setCredit(int credit)
    {
        this.credit = credit;
    }
    /**
     * Return mark for the moudle.
     */
    public int getMark()
    {
        return this.mark;
    }
    /**
     * Set the the marks for the this moudle.
     */
    public void setMark(int mark)
    {
        this.mark = mark;
    }
    /**
     * Print the details of the modules, the module
     * code and title
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": " 
                            + title + " Credit: "+credit);
        System.out.println();
    }
}
