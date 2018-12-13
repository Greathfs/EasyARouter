package com.hfs.easyarouter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hfs.easyarouter.utils.FragmentUtil;

import java.util.ArrayList;

/**
 *
 * @author HuangFusheng
 * @date 2018/12/13
 * @description 主入口
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mMViewPager;
    private TabLayout mToolbarTab;
    /**
     * 图标
     */
    private int[] tabIcons = {
            R.drawable.tab_home,
            R.drawable.tab_weichat,
            R.drawable.tab_recommend,
            R.drawable.tab_user
    };
    private String[] tabArray;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
//         给viewpager设置适配器
        setViewPagerAdapter();
        setTabBindViewPager();
        setItem();
    }

    private void initData() {
        tabArray = getResources().getStringArray(R.array.tab_main);
        fragments.clear();
        fragments.add(FragmentUtil.getHomeFragment());
        fragments.add(FragmentUtil.getChatFragment());
        fragments.add(FragmentUtil.getRecomFragment());
        fragments.add(FragmentUtil.getMeFragment());
    }

    private void initView() {
        mMViewPager = (ViewPager) findViewById(R.id.vp_main);
        mToolbarTab = (TabLayout) findViewById(R.id.toolbar_tab);

    }

    private void setViewPagerAdapter() {
        DemandAdapter demandAdapter = new DemandAdapter(getSupportFragmentManager());
        mMViewPager.setAdapter(demandAdapter);
    }

    private void setTabBindViewPager() {
        mToolbarTab.setupWithViewPager(mMViewPager);
    }

    private void setItem() {
        /**
         * 一定要在设置适配器之后设置Icon
         */
        for (int i = 0; i < mToolbarTab.getTabCount(); i++) {
            mToolbarTab.getTabAt(i).setCustomView(getTabView(i));
        }
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        ImageView tabImage = view.findViewById(R.id.tab_image);
        TextView tabText = view.findViewById(R.id.tab_text);
        tabImage.setImageResource(tabIcons[position]);
        tabText.setText(tabArray[position]);
        return view;
    }

    /**
     * 适配器
     */
    public class DemandAdapter extends FragmentStatePagerAdapter {


        public DemandAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
