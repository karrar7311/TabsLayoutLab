/*
Name: Karrar Mahmood
Student ID: n01641132
*/
package karrar.mahmood.tabslayout;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.*;

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
        karResultTV.setTextColor(Color.GRAY);

        getParentFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                (requestKey, bundle) -> {

                    String color = bundle.getString("color");

                    karResultTV.setText(getString(R.string.color_selected) + color);

                    if(color.equals("Green"))
                        karResultTV.setTextColor(Color.GREEN);
                    else if(color.equals("Yellow"))
                        karResultTV.setTextColor(Color.YELLOW);
                    else if(color.equals("Red"))
                        karResultTV.setTextColor(Color.RED);
                    else
                        karResultTV.setTextColor(Color.BLACK);
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