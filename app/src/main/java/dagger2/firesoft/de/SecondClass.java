package dagger2.firesoft.de;

import javax.inject.Inject;

import dagger2.firesoft.de.manager.ExampleManager;

/**
 * Diese Klasse demonstriert wie eine Dependecy in eine Klasse injeziert werden kann die keinen direkten Zugriff auf getApplication() hat.
 */
public class SecondClass {

    ExampleManager exampleManager;

    // Der Injectbefehl vor dem Klassenkonstruktor sorgt dafür, dass alle  Abhängigkeiten die zur Instanzierung gebraucht werden, automatisch durch Dagger gestellt werden
    // Entnommen aus https://stackoverflow.com/questions/29617086/adding-non-activity-classes-to-dagger-2-graph-android/29618828#29618828
    @Inject
    public SecondClass(ExampleManager exampleManager) {
        this.exampleManager = exampleManager;
    }

    /**
     * Testaufruf um zu Überprüfen ob die Injection funktioniert
     */
    public void callTheSettingsManager() {
        exampleManager.publishID();
    }

}
