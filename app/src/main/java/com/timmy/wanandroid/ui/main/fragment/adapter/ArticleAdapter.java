package com.timmy.wanandroid.ui.main.fragment.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.timmy.wanandroid.model.bean.home.DatasBean;

import java.util.List;

/**
 * 首页列表适配器
 */
public class ArticleAdapter extends BaseQuickAdapter<DatasBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId, @Nullable List<DatasBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DatasBean item) {

    }
}
