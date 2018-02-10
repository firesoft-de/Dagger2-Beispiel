package dagger2.firesoft.de.dagger_DI;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger2.firesoft.de.SecondClass;
import dagger2.firesoft.de.manager.ExampleManager;

/**
 * Diese Klasse definiert die Instanzierung der Variablen
 * Hier werden die absolut minimalen Abhängigkeiten hinterlegt. Dies sind im aktuellen Fall, die MainActivity und der Context
 * Zwischen den einzelnen @Provide Methoden muss keine Verbindung bzgl. der eingegebenen Variablen hergestellt werden. Dies übernimmt Dagger
 */
@Module
public class ModuleDI {

    private final Application application;

    private ExampleManager mExampleManager;

    public ModuleDI(Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

    /**
     * Beispiel für die Variablenverknüpfung
     * Dagger verknüpft automatisch die in provideContext bereitgestellte Instanz von Context mit dem benötigten Input für diese Methode.
     * @param context Der benötigte Context
     * @return Eine Instanz von ExampleManager
     */
    @Provides
    @Singleton
    // Damit wir auf alle Anfragen den gleichen ExampleManager zurückbekommen, wird diese Annotation verwendet.
    // Sie definiert, dass in der Applicationscope nur einmal dieses Objekt erzeugt wird.
    ExampleManager provideSettingsManager(Context context) {
        return new ExampleManager(context);
    }

    /**
     * Weiteres Beispiel für die Variablenverknüpfung
     * Dagger verknüpft automatisch die in provideSettingsManager bereitgestellte Instanz von ExampleManager mit dem benötigten Input für diese Methode.
     * @param exampleManager ExampleManager von dem die ID geholt werden soll
     * @return Die ID des Managers
     */
    @Provides
    // Als Beispiel wird von der SecondClass jedes mal eine eigenständige Instanz ausgeführt.
    SecondClass provideSecondClass(ExampleManager exampleManager) {
        return new SecondClass(exampleManager);
    }
}
