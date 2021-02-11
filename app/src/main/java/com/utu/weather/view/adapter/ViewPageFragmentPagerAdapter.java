package com.utu.weather.view.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * ViewPage adapter
 *
 * @author Chunfeng
 */
public class ViewPageFragmentPagerAdapter extends FragmentPagerAdapter {

  //Fragment Array
  private ArrayList<Fragment> fragmentsList;

  public ViewPageFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList) {
    super(fm);
    this.fragmentsList = fragmentsList;
  }

  @Override
  public Fragment getItem(int position) {

    return fragmentsList.get(position);
  }

  @Override
  public int getCount() {
    return fragmentsList.size();
  }

  @Override
  public void destroyItem(ViewGroup container, int position, Object object) {
    super.destroyItem(container, position, object);
  }
}

