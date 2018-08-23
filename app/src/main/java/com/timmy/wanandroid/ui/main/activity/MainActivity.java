package com.timmy.wanandroid.ui.main.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.timmy.wanandroid.R;
import com.timmy.wanandroid.contract.main.MainContract;
import com.timmy.wanandroid.core.activity.BaseActivity;
import com.timmy.wanandroid.model.bean.BannerItemInfo;
import com.timmy.wanandroid.presenter.main.MainPresenter;
import com.timmy.wanandroid.ui.main.adapter.MainPagerAdapter;
import com.timmy.wanandroid.ui.main.entity.TabEntity;
import com.timmy.wanandroid.ui.main.fragment.HomeFragment;
import com.timmy.wanandroid.ui.main.fragment.KnowledgeHierarchyFragment;
import com.timmy.wanandroid.ui.main.fragment.MineFragment;
import com.timmy.wanandroid.ui.main.fragment.NavigationFragment;
import com.timmy.wanandroid.ui.main.fragment.ProjectFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.IView {

    private final String[] mTitles = {
            "首页", "知识体系", "导航", "项目", "我的"};
    private final int[] mIconUnselectIds = {
            R.drawable.icon_home_pager_not_selected, R.drawable.icon_knowledge_hierarchy_not_selected,
            R.drawable.icon_navigation_not_selected, R.drawable.icon_project_not_selected,
            R.drawable.icon_me_not_selected};
    private final int[] mIconSelectIds = {
            R.drawable.icon_home_pager_selected, R.drawable.icon_knowledge_hierarchy_selected,
            R.drawable.icon_navigation_selected, R.drawable.icon_project_selected,
            R.drawable.icon_me_selected};
    private final List<Fragment> mFragments = new ArrayList<>();
    private final ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @BindView(R.id.viewpager_main)
    ViewPager mViewPager;
    @BindView(R.id.commont_tab_layout_main)
    CommonTabLayout mCommonTabLayout;

    private HomeFragment mHomeFragment;
    private KnowledgeHierarchyFragment mKnowledgeHierarchyFragment;
    private NavigationFragment mNavigationFragment;
    private ProjectFragment mProjectFragment;
    private MineFragment mMineFragment;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEventAndData(Bundle savedInstanceState) {
        //mPresenter.getBanner();
        //stateLoading();
        initFragments();
        initUI();
    }

    private void initFragments() {
        if (mHomeFragment == null) {
            mHomeFragment = HomeFragment.newInstance("", "");
        }
        if (mKnowledgeHierarchyFragment == null) {
            mKnowledgeHierarchyFragment = KnowledgeHierarchyFragment.newInstance("", "");
        }
        if (mNavigationFragment == null) {
            mNavigationFragment = NavigationFragment.newInstance("", "");
        }
        if (mProjectFragment == null) {
            mProjectFragment = ProjectFragment.newInstance("", "");
        }
        if (mMineFragment == null) {
            mMineFragment = MineFragment.newInstance("", "");
        }

        mFragments.add(mHomeFragment);
        mFragments.add(mKnowledgeHierarchyFragment);
        mFragments.add(mNavigationFragment);
        mFragments.add(mProjectFragment);
        mFragments.add(mMineFragment);

    }

    private void initUI() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
        mCommonTabLayout.setTabData(mTabEntities);
        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }


    @Override
    public void showBanner(List<BannerItemInfo> bannerItemInfos) {
        stateMain();
    }


}
