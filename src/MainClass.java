public class MainClass
{

    public int getLocalNumber ()
    {
        return 14;
    }

    public int getClassnumber ()
    {
        return this.class_number();
    }

    private int class_number ()
    {
        return 20;
    }



    public String getClassString ()
    {
        return this.class_string();
    }

    private String class_string ()
    {
        return "Hello,world";
    }
}
