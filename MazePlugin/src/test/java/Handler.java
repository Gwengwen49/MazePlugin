import net.md_5.bungee.chat.SelectorComponentSerializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Handler
{

    public static List<Method> METHODS = new ArrayList<>();

    public static void add(Class handler)
    {
        for(Method method : handler.getMethods())
        {
            if (method.isAnnotationPresent(Injector.class))
            {
                METHODS.add(method);
            }
            }
        }



    public static void executeMethod(Class classToInject) throws InstantiationException, IllegalAccessException, InvocationTargetException {

        for(Method method : METHODS) {
            if (method.isAnnotationPresent(Injector.class))
            {
                if (method.getAnnotation(Injector.class).TargetedClass().equals(classToInject))
                {
                    method.invoke(method.getDeclaringClass().newInstance());

                }
            }
        }
    }


}
