package dagger2.firesoft.de.dagger_DI;

import android.app.Application;
import android.content.Context;

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

    // Damit wir auf alle Anfragen den gleichen ExampleManager zurückbekommen, muss die Instanz zwischengespeichert werden.
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
    ExampleManager provideSettingsManager(Context context) {

        if (mExampleManager == null) {
            mExampleManager = new ExampleManager(context);
        }

        return mExampleManager;
    }


    /**
     * Weiteres Beispiel für die Variablenverknüpfung
     * Dagger verknüpft automatisch die in provideSettingsManager bereitgestellte Instanz von ExampleManager mit dem benötigten Input für diese Methode.
     * @param exampleManager ExampleManager von dem die ID geholt werden soll
     * @return Die ID des Managers
     */
    @Provides
    int provideSettingsManagerId(ExampleManager exampleManager) {
        return exampleManager.getId();
    }

    @Provides
    SecondClass provideSecondClass(ExampleManager exampleManager) {
        return new SecondClass(exampleManager);
    }

}
