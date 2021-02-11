package com.utu.weather.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.utu.weather.R;
import com.utu.weather.contracts.IContracts;
import com.utu.weather.model.OneCallWeatherData;
import com.utu.weather.presenter.OneCallPresenter;
import com.utu.weather.view.adapter.ForecastRecycleViewAdapter;

public class ForecastActivity extends Activity implements IContracts.IView, View.OnClickListener {

  private ForecastRecycleViewAdapter forecastRecycleViewAdapter;
  private RecyclerView weatherRvList;
  private OneCallPresenter oneCallPresenter;
  // Current temp
  private String cityName;
  private TextView cityNameTV;
  private LinearLayout mockData;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    cityName = getIntent().getStringExtra("city_name");
    setContentView(R.layout.activity_forecast);
    oneCallPresenter = new OneCallPresenter(this);
    iniView();
  }
  void iniView() {

    weatherRvList = (RecyclerView) findViewById(R.id.weather_rv_list_15);
    cityNameTV = (TextView) findViewById(R.id.city_name_tv);
    mockData = (LinearLayout) findViewById(R.id.mock_data);
    mockData.setOnClickListener(this);
    forecastRecycleViewAdapter = new ForecastRecycleViewAdapter(getApplication());
    weatherRvList.setLayoutManager(new LinearLayoutManager(getApplication()));
    weatherRvList.setAdapter(forecastRecycleViewAdapter);
  }

  @Override public void onResume() {
    super.onResume();
    oneCallPresenter.getDataByCity(cityName);
  }

  @Override public void onResponse(OneCallWeatherData bean) {
    if (bean != null && bean.getCurrent() != null) {
      fillData(bean);
    } else {
      Toast.makeText(getApplication(), "No data!", Toast.LENGTH_SHORT).show();
    }
  }
  @Override public void onFailure(String error) {

  }

  void fillData(OneCallWeatherData bean) {
    // Set forecast data
    cityNameTV.setText(cityName);
    forecastRecycleViewAdapter.setData(bean.getDaily(), 0);
    forecastRecycleViewAdapter.notifyDataSetChanged();
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.mock_data:
        oneCallPresenter.getSimulatedData();
    }
  }
}