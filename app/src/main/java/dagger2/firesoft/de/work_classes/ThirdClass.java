package dagger2.firesoft.de.work_classes;


/**
 * Klasse die in der SecondClass verwendet wird und eine Abhängigkeit vom ExampleManager besitzt *
 */
public class ThirdClass {

    ExampleManager exampleManager;

    /**
     * Klassenkonstruktor
     * @param exampleManager Instanz des ExampleManager
     */
    public ThirdClass(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }

    /**
     * Testaufruf
     */
    public void callExampleManager() {
        exampleManager.publishID();
    }

}
