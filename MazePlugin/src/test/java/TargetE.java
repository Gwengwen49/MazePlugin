import java.lang.reflect.InvocationTargetException;

public class TargetE
{


    public TargetE() throws InstantiationException, IllegalAccessException, InvocationTargetException {
       Handler.executeMethod(TargetE.class);

    }

}
