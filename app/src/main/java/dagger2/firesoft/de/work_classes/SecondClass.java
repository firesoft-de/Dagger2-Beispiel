package dagger2.firesoft.de.work_classes;


/**
 * Diese Klasse zeigt, dass es bei einfachen Klassen leichter ist, per normaler Injection über den Konstruktor zu arbeiten.
 */
public class SecondClass {

    ExampleManager exampleManager;
    ThirdClass thirdClass;

    /**
     * Klassenkonstruktor
     * @param exampleManager Instanz des ExampleManagers
     * @param thirdClass Instanz der ThirdClass
     */
    public SecondClass(ExampleManager exampleManager, ThirdClass thirdClass) {
        this.exampleManager = exampleManager;
        this.thirdClass = thirdClass;
    }

    /**
     * Testaufruf
     */
    public void callExampleManager() {
        exampleManager.publishID();
    }

    /**
     * Testaufruf
     */
    public void callThirdClass() {
        thirdClass.callExampleManager();
    }

}
