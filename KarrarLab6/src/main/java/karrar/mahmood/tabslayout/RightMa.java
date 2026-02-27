/*
Name: Karrar Mahmood
Student ID: n01641132
*/
package karrar.mahmood.tabslayout;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.*;
import androidx.core.content.ContextCompat;

public class RightMa extends Fragment {

    TextView karResultTV;
    CheckBox karHockeyCB, karBasketCB, karBaseballCB;
    Button karSportBTN;

    public RightMa(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        karResultTV = view.findViewById(R.id.karResultTV);
        karHockeyCB = view.findViewById(R.id.karHockeyCB);
        karBasketCB = view.findViewById(R.id.karBasketCB);
        karBaseballCB = view.findViewById(R.id.karBaseballCB);
        karSportBTN = view.findViewById(R.id.karSportBTN);

        karResultTV.setText(getString(R.string.no_data));
        karResultTV.setTextColor(
                ContextCompat.getColor(getContext(), android.R.color.darker_gray)
        );

        getParentFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                (requestKey, bundle) -> {

                    String color = bundle.getString("color");

                    karResultTV.setText(color);

                    if(color.equals(getString(R.string.green)))
                        karResultTV.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_green_dark));
                    else if(color.equals(getString(R.string.yellow)))
                        karResultTV.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_orange_light));
                    else if(color.equals(getString(R.string.red)))
                        karResultTV.setTextColor(ContextCompat.getColor(getContext(), android.R.color.holo_red_dark));
                    else
                        karResultTV.setTextColor(ContextCompat.getColor(getContext(), android.R.color.black));
                });

        karSportBTN.setOnClickListener(v -> {

            String selected = "";

            if (karHockeyCB.isChecked())
                selected += getString(R.string.hockey) + "\n";

            if (karBasketCB.isChecked())
                selected += getString(R.string.basketball) + "\n";

            if (karBaseballCB.isChecked())
                selected += getString(R.string.baseball) + "\n";

            if (selected.isEmpty())
                selected = getString(R.string.no_sport);

            new AlertDialog.Builder(getContext())
                    .setTitle(getString(R.string.selected_sports))
                    .setMessage(selected)
                    .setPositiveButton(getString(R.string.ok), null)
                    .show();
        });

        return view;
    }
}