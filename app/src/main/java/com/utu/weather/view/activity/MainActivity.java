package com.utu.weather.view.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.utu.weather.R;
import com.utu.weather.view.adapter.ViewPageFragmentPagerAdapter;
import com.utu.weather.view.fragment.CommonWeatherFragment;
import java.util.ArrayList;

import static com.utu.weather.Util.Global.cityWeatherList;

public class MainActivity extends AppCompatActivity {

  private ViewPager vpager;

  private ViewPageFragmentPagerAdapter mAdapter;

  private ArrayList<Fragment> fragmentsList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getSupportActionBar().hide();
    setContentView(R.layout.activity_main_layout);

    fragmentsList = new ArrayList<>();

    for (int i = 0; i < cityWeatherList.length; i++) {
      fragmentsList.add(CommonWeatherFragment.newInstance(cityWeatherList[i]));
    }

    mAdapter = new ViewPageFragmentPagerAdapter(getSupportFragmentManager(), fragmentsList);

    initViews();
  }

  private void initViews() {

    vpager = findViewById(R.id.vPager);
    vpager.setAdapter(mAdapter);
    vpager.setCurrentItem(0);
  }

  @Override
  public void onPointerCaptureChanged(boolean hasCapture) {
  }
}