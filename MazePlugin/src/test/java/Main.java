import java.lang.reflect.InvocationTargetException;

public class Main
{


    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Handler.add(InjectorExample.class);

        new TargetE();

    }
}
