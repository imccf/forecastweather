package com.utu.weather.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.utu.weather.R;
import com.utu.weather.Util.Global;
import com.utu.weather.Util.UtilLib;
import com.utu.weather.contracts.IContracts;
import com.utu.weather.model.OneCallWeatherData;
import com.utu.weather.presenter.OneCallPresenter;
import com.utu.weather.view.activity.ForecastActivity;
import com.utu.weather.view.adapter.ForecastRecycleViewAdapter;

public class CommonWeatherFragment extends Fragment
    implements IContracts.IView, View.OnClickListener {

  public static final String ARGUMENT = "argument";
  private OneCallPresenter oneCallPresenter;
  private View view;
  private RecyclerView weatherRVList;
  private TextView weatherNameCity;
  private TextView weatherTempLow;
  // Current temp
  private TextView weatherTemperature;
  private TextView weatherTempHeight;
  private TextView weatherInfo;
  private String mArgument;

  private ForecastRecycleViewAdapter forecastRecycleViewAdapter;
  private LinearLayout weatherForecast15days;
  private ImageView weatherLocationIcon;
  private TextView weatherTempSlash;
  private TextView loadingNotice;

  public static CommonWeatherFragment newInstance(String argument) {
    Bundle bundle = new Bundle();
    bundle.putString(ARGUMENT, argument);
    CommonWeatherFragment contentFragment = new CommonWeatherFragment();
    contentFragment.setArguments(bundle);
    return contentFragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle bundle = getArguments();
    if (bundle != null) {
      mArgument = bundle.getString(ARGUMENT);
    }
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable
          Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.fragment_main_layout, container, false);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    oneCallPresenter = new OneCallPresenter(this);
    initData();
  }

  @Override public void onResume() {
    super.onResume();
    loadingNotice.setVisibility(View.VISIBLE);
    oneCallPresenter.getDataByCity(mArgument);
  }
  @Override public void onResponse(OneCallWeatherData bean) {

    loadingNotice.setVisibility(View.GONE);

    if (bean != null && bean.getCurrent() != null) {
      fillData(bean);
    } else {
      Toast.makeText(getContext(), "No data!", Toast.LENGTH_SHORT).show();
    }
  }

  @Override public void onFailure(String error) {
    Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
  }

  void initData() {

    weatherNameCity = (TextView) view.findViewById(R.id.weather_name_city);
    weatherLocationIcon = (ImageView) view.findViewById(R.id.weather_location_icon);
    weatherTempSlash = (TextView) view.findViewById(R.id.weather_temp_slash);
    loadingNotice = (TextView) view.findViewById(R.id.loading_notice);


    weatherTemperature = (TextView) view.findViewById(R.id.weather_temperature);
    weatherTempLow = (TextView) view.findViewById(R.id.weather_temp_low);
    weatherTempHeight = (TextView) view.findViewById(R.id.weather_temp_height);
    weatherInfo = (TextView) view.findViewById(R.id.weather_info);
    weatherRVList = (RecyclerView) view.findViewById(R.id.weather_rv_list);
    weatherForecast15days = (LinearLayout) view.findViewById(R.id.forecast15days);
    weatherForecast15days.setOnClickListener(this);
    forecastRecycleViewAdapter = new ForecastRecycleViewAdapter(view.getContext());
    weatherRVList.setLayoutManager(new LinearLayoutManager(view.getContext()));
    weatherRVList.setAdapter(forecastRecycleViewAdapter);

  }

  void fillData(OneCallWeatherData bean) {
    weatherLocationIcon.setVisibility(View.VISIBLE);
    weatherTempSlash.setVisibility(View.VISIBLE);

    // Set city name
    weatherNameCity.setText(bean.getTimezone().substring(bean.getTimezone().indexOf("/") + 1));

    // Set current temp
    weatherTemperature.setText(Long.toString(Math.round(UtilLib.K2C(bean.getCurrent().getTemp()))));

    // Set highest temp
    weatherTempHeight.setText(
        Long.toString(Math.round(UtilLib.K2C(bean.getDaily().get(0).getTemp().getMax())))
            + Global.tmpUnit);

    // Set lowest temp
    weatherTempLow.setText(
        Long.toString(Math.round(UtilLib.K2C(bean.getDaily().get(0).getTemp().getMin())))
            + Global.tmpUnit);

    // Set weather condition
    weatherInfo.setText(bean.getCurrent().getWeather().get(0).getMain());

    // Set forecast data
    forecastRecycleViewAdapter.setData(bean.getDaily(), 4);
    forecastRecycleViewAdapter.notifyDataSetChanged();
    // Disable recyclerView scrolling event, just use it to display items
    weatherRVList.setLayoutFrozen(true);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.forecast15days:
        Intent intent = new Intent(getActivity(), ForecastActivity.class);
        intent.putExtra("city_name", weatherNameCity.getText().toString());
        startActivity(intent);
    }
  }
}
