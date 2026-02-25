/*
Name: Karrar Mahmood
Student ID: n01641132
*/
package karrar.mahmood.tabslayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;

public class KarrarActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new LeftKa());
        fragmentList.add(new RightMa());

        ViewPager2 viewPager = findViewById(R.id.karViewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, fragmentList));

        TabLayout tabLayout = findViewById(R.id.karTabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText("Tab " + (position + 1))
        ).attach();
    }
}