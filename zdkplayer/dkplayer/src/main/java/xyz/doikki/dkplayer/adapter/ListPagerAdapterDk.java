package xyz.doikki.dkplayer.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import xyz.doikki.dkplayer.fragment.list.ListViewFragmentDk;
import xyz.doikki.dkplayer.fragment.list.RecyclerViewAutoPlayFragmentDk;
import xyz.doikki.dkplayer.fragment.list.RecyclerViewFragmentDk;
import xyz.doikki.dkplayer.fragment.list.RecyclerViewPortraitFragmentDk;
import xyz.doikki.dkplayer.fragment.list.SeamlessPlayFragmentDk;
import xyz.doikki.dkplayer.fragment.list.TikTokListFragmentDk;

import java.util.List;

/**
 * List主页适配器
 * Created by Doikki on 2018/1/3.
 */
public class ListPagerAdapterDk extends FragmentStatePagerAdapter {

    private List<String> mTitles;
    private SparseArrayCompat<Fragment> mFragments = new SparseArrayCompat<>();

    public ListPagerAdapterDk(FragmentManager fm, List<String> titles) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mTitles = titles;
    }

    @Override
    @NonNull
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);
        if (fragment == null) {
            switch (position) {
                default:
                case 0:
                    fragment = new ListViewFragmentDk();
                    break;
                case 1:
                    fragment = new RecyclerViewFragmentDk();
                    break;
                case 2:
                    fragment = new RecyclerViewAutoPlayFragmentDk();
                    break;
                case 3:
                    fragment = new TikTokListFragmentDk();
                    break;
                case 4:
                    fragment = new SeamlessPlayFragmentDk();
                    break;
                case 5:
                    fragment = new RecyclerViewPortraitFragmentDk();
                    break;
            }
            mFragments.put(position, fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
