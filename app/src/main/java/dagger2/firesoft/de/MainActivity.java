package dagger2.firesoft.de;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger2.firesoft.de.dagger_DI.ApplicationDI;
import dagger2.firesoft.de.dagger_DI.ComponentDI;
import dagger2.firesoft.de.manager.ExampleManager;

public class MainActivity extends AppCompatActivity implements IFragmentCallback {

    // Beim Compilieren wird Dagger die im ComponentDI Interface definierten Klassen durchsuchen, ob eine @Inject Annotation vorhanden ist.
    // So wie es hier der Fall ist
    @Inject
    ExampleManager exampleManager;

    // Um überhaupt erst etwas für die Injection zu haben, wird eine Instanz der ComponentDI benötigt. Den dort werden alle Dependencies definiert.
    private ComponentDI mComponent;

    // Wird für das Umschalten der Fragments benötigt
    private FragmentManager fManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Führt die eigentliche Injection durch
        ((ApplicationDI) getApplication()).getComponent().inject(this);

        // FragmentManager für das Umschalten der Fragments implementieren
        fManager = this.getSupportFragmentManager();

        //Fragment 1 anzeigen
        switchFragment(0);

        // Code generated by Android
        setContentView(R.layout.activity_main);
    }

    /**
     * Testaufruf um zu Überprüfen ob die Injection funktioniert
     */
    public void callTheSettingsManager() {
        exampleManager.publishID();
    }


    /**
     * Hilfsmethode mit der das Wechseln des angezeigten Fragments durchgeführt wird.
     */
    public void switchFragment(int fragmentId) {
        Fragment fragment;
        FragmentTransaction ft;
        String tag = String.valueOf(fragmentId);
        boolean newFragment = false;

        ft = fManager.beginTransaction();
        fragment = fManager.findFragmentByTag(tag);

        if (fragment == null) {
            newFragment = true;
        }

        switch (fragmentId) {

            case 0:
                if (newFragment) {
                    fragment = new FirstFragment();
                }
                break;

            case 1:
                if (newFragment) {
                    fragment = new SecondFragment();
                }
                break;

        }

        ft.replace(R.id.MainFrame, fragment, tag);
        ft.addToBackStack(tag);
        ft.commit();

    }


}