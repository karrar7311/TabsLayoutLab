/*
Name: Karrar Mahmood
Student ID: n01641132
*/
package karrar.mahmood.tabslayout;

import androidx.fragment.app.*;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final ArrayList<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentActivity fa, ArrayList<Fragment> list){
        super(fa);
        fragmentList = list;
    }

    @Override
    public Fragment createFragment(int position){
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount(){
        return fragmentList.size();
    }
}