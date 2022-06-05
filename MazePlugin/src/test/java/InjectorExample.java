public class InjectorExample
{

    @Injector(TargetedClass = TargetE.class)
    public void addWelcomeMessage() {
        System.out.print("first message");
    }

    @Injector(TargetedClass = TargetE.class)
    public void addAnotherMessage()
    {
        System.out.print("another fucking message to see all my time passed ! FUCK !");
    }

    @Injector(TargetedClass = TargetE.class)
    public void wrongWay()
    {
        System.out.print("winr,fsucsdjxhcsynvdhxjqbryhcvd");
    }
}
