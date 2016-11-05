package com.xujun.funapp.view.main.fragment.picture;

import android.support.v4.app.Fragment;

import com.xujun.funapp.R;
import com.xujun.funapp.beans.PictureClassify;
import com.xujun.funapp.common.BaseFragmentAdapter;
import com.xujun.funapp.common.BaseViewPagerFragemnt;
import com.xujun.funapp.common.mvp.DefaultContract;
import com.xujun.funapp.common.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ explain:
 * @ author：xujun on 2016/10/17 21:48
 * @ email：gdutxiaoxu@163.com
 */
public class PictureFragment extends BaseViewPagerFragemnt<PicturePresenter>
        implements DefaultContract.View<PictureClassify> {

    private  final String[] mTitles= UIUtils.getStringArray(R.array.picture_titles);
    List<Fragment> mFragments;

    @Override
    protected BaseFragmentAdapter getViewPagerAdapter() {
        mFragments=new ArrayList<>();
        for(int i=0;i<mTitles.length;i++){
            PictureListFragment pictureListFragment = PictureListFragment.newInstance(mTitles[0],i+1);
            mFragments.add(pictureListFragment);

        }
        BaseFragmentAdapter baseFragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager
                (), mFragments,mTitles);
        return baseFragmentAdapter;
    }

    @Override
    protected PicturePresenter setPresenter() {
        return new PicturePresenter(this);
    }

    @Override
    protected void initListener() {
        super.initListener();
       /* mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                LUtils.i(this.getClass().getSimpleName()+"   position=      "+position);
            }
        });*/
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getPictureClassify();
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onSuccess(PictureClassify pictureClassify) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onLocal(PictureClassify pictureClassify) {

    }
}
