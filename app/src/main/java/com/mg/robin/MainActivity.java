package com.mg.robin;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mg.robin.fragment.ButlerFragment;
import com.mg.robin.fragment.GirlFragment;
import com.mg.robin.fragment.UserFragment;
import com.mg.robin.fragment.WechatFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Tablayout
    private TabLayout mTabLayout;
    //ViewPager
    private ViewPager mViewPager;
    //Title
    private List<String> mTitle;
    //Fragment
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉阴影
        getSupportActionBar().setElevation(0);

        //初始化数据
        initData();

        //初始化View
        initView();
    }

    //初始化数据
    private void initData() {
        mTitle =new ArrayList<>();
        mTitle.add("服务管家");
        mTitle.add("微信精选");
        mTitle.add("美女社区");
        mTitle.add("个人中心");

        mFragment=new ArrayList<>();
        mFragment.add(new ButlerFragment());
        mFragment.add(new WechatFragment());
        mFragment.add(new GirlFragment());
        mFragment.add(new UserFragment());
    }

    //初始化View
    private void initView() {
        mTabLayout=(TabLayout) findViewById(R.id.mTabLayout);
        mViewPager=(ViewPager) findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());

        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }
            //返回item个数
            @Override
            public int getCount() {
                return mFragment.size();
            }
            //设置标题
            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });
        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
