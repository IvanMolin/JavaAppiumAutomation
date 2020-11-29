import org.junit.Assert;
import org.junit.Test;

public class MainTest extends CoreTestCase
{


    @Test
    public void FirstTest ()
    {
   this.assertFail();

    }
    private void assertFail ()
    {
        Assert.fail("This message will be printed");

    }

}
