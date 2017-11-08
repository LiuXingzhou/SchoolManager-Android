package com.eachwang.school.schoolmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eachwang.school.schoolmanager.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 想法
 * Created by iswgr on 2017/11/7.
 */

public class ThroughFragment extends Fragment {
    @BindView(R.id.frag_thr_tab_page)
    TabLayout mTabPage;
    @BindView(R.id.frag_thr_pager_show)
    ViewPager mPager;
    Unbinder unbinder;
    private View mView;
    private MyAdapter mAdapter;
    private List<Fragment> mList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_through, container, false);
        unbinder = ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //添加布局
        addView();
        //设置适配器
        setAdapter();
    }


    /**
     * 设置适配器
     */
    private void setAdapter() {
        mAdapter = new MyAdapter(getChildFragmentManager());
        mPager.setAdapter(mAdapter);
        mTabPage.setupWithViewPager(mPager);
    }

    /**
     * 添加fragment布局
     */
    private void addView() {
        Fragment f1 = new LoveFragment();
        Fragment f2 = new SwFragment();
        mList.add(f1);
        mList.add(f2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 滑动适配器
     */
    private class MyAdapter extends FragmentStatePagerAdapter {


        private String[] str = new String[]{"表白墙", "失物招领"};

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return str[position];
        }
    }
}
