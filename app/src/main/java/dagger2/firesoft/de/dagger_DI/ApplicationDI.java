package dagger2.firesoft.de.dagger_DI;

import android.app.Application;

/**
 * Eigene Application Klasse welche zusätzliche Methoden für die DI bereitstellt.
 * Dies ist notwendig, damit die getComponent Methode in den Activity und Fragment Klassen abgerufen werden kann
 */
public class ApplicationDI extends Application {

    // Um überhaupt erst etwas für die Injection zu haben, wird eine Instanz der ComponentDI benötigt. Den dort werden alle Dependencies definiert.
    private ComponentDI mComponent;

    /**
     * Beim Erstellen der Application wird diese Methode aufgerufen und die von Dagger implementierte Component wird initalisiert
     */
    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerComponentDI
                .builder()
                .moduleDI(new ModuleDI(this))
                .build();

    }

    /**
     * Führt die Instanzierung der Component durch
     * @return Die Component
     */
    public ComponentDI getComponent() {

        // Falls noch keine Instanz vorhanden ist (was eigentlich der Fall sein sollte), muss diese erstellt werden
        if (mComponent == null) {

            // Component instanzieren
            mComponent = DaggerComponentDI.builder()
                    // Das Modul implementieren und mit den Basisabhängigkeiten versorgen (MainActivity)
                    .moduleDI(new ModuleDI(this))
                    .build();
        }

        return  mComponent;
    }
}
