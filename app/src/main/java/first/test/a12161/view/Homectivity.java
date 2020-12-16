package first.test.a12161.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import first.test.a12161.R;
import first.test.a12161.fragment.ClasFragment;
import first.test.a12161.fragment.SchoolFragment;

public class Homectivity extends AppCompatActivity {

    private ViewPager mViewpager;
    private TabLayout mTablayout;
    private ArrayList<Fragment> fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homectivity);
        mViewpager =findViewById(R.id.viewpager);
        mTablayout =findViewById(R.id.tablayout);
        fragment = new ArrayList<>();
        fragment.add(new SchoolFragment());
        fragment.add(new ClasFragment());
        mViewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }
        });
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.getTabAt(0).setText("学校新闻");
        mTablayout.getTabAt(1).setText("班级信息");
    }
}