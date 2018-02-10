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


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    IFragmentCallback fragmentCallback;

    @Inject
    ExampleManager exampleManager;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // DI vornehmen
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
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        Button firstButton = view.findViewById(R.id.firstFragmentButton1);
        Button secondButton = view.findViewById(R.id.firstFragmentButton2);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exampleManager.publishID();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentCallback.switchFragment(1);
            }
        });

        return view;
    }
}
