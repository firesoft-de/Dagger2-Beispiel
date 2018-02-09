package dagger2.firesoft.de.dagger_DI;


import dagger.Component;
import dagger2.firesoft.de.FirstFragment;
import dagger2.firesoft.de.MainActivity;
import dagger2.firesoft.de.SecondFragment;


/**
 * In diesem Interface wird für den Dagger Pre-Prozessor definiert für welche Klassen er Methoden für die DI bereistellen soll.
 */
@Component(modules = {ModuleDI.class})
public interface ComponentDI {

    //Bedeutung: Implementiere eine Methode, die die in der Klasse ModuleDI bereitgestellten Elemente in die Klasse MainActivity injecten kann.
    void inject(MainActivity mainActivity);

    // Wir möchten auch etwas in ein Fragment injecten können
    void inject(SecondFragment secondFragment);

    // Und in einem anderen Fragment soll das auch möglich sein
    void inject(FirstFragment firstFragment);

    // Und wir werden wahrscheinlich in der Applicationklasse eine Injection brauchen
    void inject(ApplicationDI applicationDi);

}