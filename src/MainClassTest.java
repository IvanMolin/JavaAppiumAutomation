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
        if (b < 45)
        {
           Assert.fail("b < 45");
        }
    }


    @Test
    public void testGetClassString ()
    {
       String greet = Main.getClassString();


         Assert.assertTrue("Hello|hello is not found in the string",greet.contains("Hello") | greet.contains("hello"));


       }
    }

