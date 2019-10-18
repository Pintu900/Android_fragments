package com.example.android.FragmentExample1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class simple extends Fragment {
    private static final int YES = 0;
    private static final int NO = 1;

    public simple() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        // Inflate the layout for this fragment
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView =
                        rootView.findViewById(R.id.fragment_header);
                switch (index) {
                    case YES: // User chose "Yes."
                        textView.setText(R.string.yes_message);

                        break;
                        case NO: // User chose "No."
                            textView.setText(R.string.no_message);
                            break;
                            default: // No choice made.
                                                                      // Do nothing.
                                break;
                }
            }
        });

        final RatingBar simpleRatingBar = (RatingBar) rootView.findViewById(R.id.simpleRatingBar);
           simpleRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

               @Override
               public void onRatingChanged(RatingBar ratingBar, float rating,
                                           boolean fromUser) {
                   // Do what you wa
                   String rating1 = "Rating :: " +rating;
                   Toast.makeText(getContext(), rating1, Toast.LENGTH_LONG).show();
               }});


        return rootView;
    }
    public static simple newInstance() {
        return new simple();
    }

}
