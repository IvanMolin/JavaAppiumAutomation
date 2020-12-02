import org.junit.Assert;
import org.junit.Test;
public class MainClassTest
{
    MainClass Main = new MainClass();
    @Test
    public void getLocal ()
    {
        int a = Main.getLocalNumber();
        if (a != 14)
        {
           Assert.fail("a != 14");
        }
    }

@Test
    public void testGetClassNumber ()
    {
        int b = Main.getClassnumber();
        if (b > 45)
        {
            System.out.println("true");
        }
        else {
            System.out.println("False");
        }
    }


    @Test
    public void testGetClassString ()
    {
       String greet = Main.getClassString();
       String greet2 = "Hello";
       if (greet.toLowerCase().contains(greet2.toLowerCase()))
       {
           System.out.println("Hello is found in given string");
       } else

       {
           Assert.fail("Hello is not found in the string");
       }
    }
}
