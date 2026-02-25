/*
Name: Karrar Mahmood
Student ID: n01641132
*/
package karrar.mahmood.tabslayout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.*;
import android.widget.*;

public class LeftKa extends Fragment {

    public LeftKa(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RadioGroup karRadioGroup = view.findViewById(R.id.karRadioGroup);
        Button karSubmitBTN = view.findViewById(R.id.karSubmitBTN);

        karSubmitBTN.setOnClickListener(v -> {

            int selectedId = karRadioGroup.getCheckedRadioButtonId();
            RadioButton selectedRB = view.findViewById(selectedId);
            String selectedColor = selectedRB.getText().toString();

            Toast.makeText(getContext(), selectedColor, Toast.LENGTH_LONG).show();

            Bundle result = new Bundle();
            result.putString("color", selectedColor);
            getParentFragmentManager().setFragmentResult("requestKey", result);
        });

        return view;
    }
}