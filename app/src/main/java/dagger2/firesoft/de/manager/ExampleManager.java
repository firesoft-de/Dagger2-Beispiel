package dagger2.firesoft.de.manager;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.widget.Toast;

import javax.inject.Inject;

import dagger2.firesoft.de.MainActivity;

/**
 * Eine Beispielklasse die injected werden soll
 */
public class ExampleManager {

    private final String PREF = "pref_main";

    private SharedPreferences preferences;
    private Context context;

    // Dummy zum Demonstrieren der Variablenverknüpfung im Modul
    private int id;

    public ExampleManager(Context context) {
        preferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        this.context = context;

        //Zufallswert einfügen
        id = (int) (Math.random() * 1000 + 1);
    }


    public int getId() {
        return id;
    }

    public void publishID() {
        Toast.makeText(context,"Hier ist der ExampleManager mit der ID: " + String.valueOf(id),Toast.LENGTH_SHORT).show();
    }
}
