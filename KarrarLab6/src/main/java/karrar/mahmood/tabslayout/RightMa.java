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

        karResultTV.setText("NO DATA");
        karResultTV.setTextColor(getResources().getColor(android.R.color.darker_gray));

        getParentFragmentManager().setFragmentResultListener(
                "requestKey",
                this,
                (requestKey, bundle) -> {

                    String color = bundle.getString("color");
                    karResultTV.setText(color);
                });

        karSportBTN.setOnClickListener(v -> {

            String selected = "";

            if (karHockeyCB.isChecked())
                selected += "Hockey\n";

            if (karBasketCB.isChecked())
                selected += "Basketball\n";

            if (karBaseballCB.isChecked())
                selected += "Baseball\n";

            if (selected.isEmpty())
                selected = "NO SPORT";

            new AlertDialog.Builder(getContext())
                    .setTitle("Selected Sports")
                    .setMessage(selected)
                    .setPositiveButton("OK", null)
                    .show();
        });

        return view;
    }
}