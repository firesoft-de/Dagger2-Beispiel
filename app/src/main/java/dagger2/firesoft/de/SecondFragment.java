package dagger2.firesoft.de;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.inject.Inject;

import dagger2.firesoft.de.dagger_DI.ApplicationDI;
import dagger2.firesoft.de.work_classes.ExampleManager;
import dagger2.firesoft.de.work_classes.SecondClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    IFragmentCallback fragmentCallback;

    // Zwei Injections durchführen
    @Inject
    ExampleManager exampleManager;

    @Inject
    SecondClass secondClass;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DI vornehmen
        ((ApplicationDI) getActivity().getApplication()).getComponent().inject(this);

        // Callback einrichten
        try {
            fragmentCallback = (IFragmentCallback) getActivity();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        Button firstButton = view.findViewById(R.id.secondFragmentButton1);
        final Button secondButton = view.findViewById(R.id.secondFragmentButton2);
        Button thirdButton = view.findViewById(R.id.secondFragmentButton3);
        Button fourthButton = view.findViewById(R.id.secondFragmentButton4);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleManager.publishID();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCallback.switchFragment(0);
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondClass.callExampleManager();
            }
        });

        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondClass.callThirdClass();
            }
        });

        return view;
    }

}
