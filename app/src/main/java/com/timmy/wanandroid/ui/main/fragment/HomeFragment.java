package com.timmy.wanandroid.ui.main.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.timmy.wanandroid.R;
import com.timmy.wanandroid.contract.main.HomeContract;
import com.timmy.wanandroid.core.fragment.BaseFragment;
import com.timmy.wanandroid.core.imageloader.GlideImageLoader;
import com.timmy.wanandroid.model.bean.BannerItemBean;
import com.timmy.wanandroid.model.bean.home.ArticleBean;
import com.timmy.wanandroid.model.bean.home.DatasBean;
import com.timmy.wanandroid.presenter.main.HomePresenter;
import com.timmy.wanandroid.ui.main.fragment.adapter.ArticleAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 *
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IView {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Banner mBanner;
    @BindView(R.id.rv_home)
    RecyclerView mRecyclerView;


    private List<String> mBannerTitleList;
    private List<String> mBannerUrlList;
    private List<DatasBean> mDatasBeans;
    private ArticleAdapter mArticleAdapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        initRecyclerView();
        stateLoading();
        mPresenter.loadData();

    }

    private void initRecyclerView() {
        mDatasBeans = new ArrayList<>();
        mArticleAdapter = new ArticleAdapter(R.layout.layout_article_item, mDatasBeans);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(_mActivity));
        // 刷新数据不计算大小
        mRecyclerView.setHasFixedSize(true);
        FrameLayout headerGroupView = (FrameLayout) LayoutInflater.from(_mActivity).inflate(R.layout.layout_home_banner, null);
        mBanner = headerGroupView.findViewById(R.id.banner_home);
        headerGroupView.removeView(mBanner);
        mArticleAdapter.addHeaderView(mBanner);
        mRecyclerView.setAdapter(mArticleAdapter);
    }

    @Override
    public void showBannerData(List<BannerItemBean> bannerData) {
        mBannerTitleList = new ArrayList<>();
        List<String> bannerImageList = new ArrayList<>();
        mBannerUrlList = new ArrayList<>();
        for (BannerItemBean bannerItemBean : bannerData) {
            mBannerTitleList.add(bannerItemBean.getTitle());
            bannerImageList.add(bannerItemBean.getImagePath());
            mBannerUrlList.add(bannerItemBean.getUrl());
        }
        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(bannerImageList);
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合（当banner样式有显示title时）
        mBanner.setBannerTitles(mBannerTitleList);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

//        mBanner.setOnBannerListener(i -> JudgeUtils.startArticleDetailActivity(_mActivity, null,
//                0, mBannerTitleList.get(i), mBannerUrlList.get(i),
//                false, false, true));
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    @Override
    public void showArticleData(ArticleBean articleData) {
        mArticleAdapter.replaceData(articleData.getDatas());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mBanner != null) {
            //开始轮播
            mBanner.startAutoPlay();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mBanner != null) {
            //结束轮播
            mBanner.stopAutoPlay();
        }
    }
}
