import org.junit.Test;
public class MainClassTest
{
    MainClass Main = new MainClass();
    @Test
    public void getLocal ()
    {
        int a = Main.getLocalNumber();
        if (a == 14)
        {
            System.out.println("true");
        }
        else {
            System.out.println("False");
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
}
