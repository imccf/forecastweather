package com.utu.weather.presenter;

import com.utu.weather.Util.Global;
import com.utu.weather.Util.NetWork;
import com.utu.weather.contracts.IContracts;
import com.utu.weather.model.OneCallWeatherData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Charlie(Chunfeng).
 * Created on 6/2/2021
 */

public class OneCallPresenter implements IContracts.IPresenter {
  IContracts.IView iView;

  public OneCallPresenter(IContracts.IView iView) {
    this.iView = iView;
  }

  /**
   * realDataApi API
   *
   * @param lat Geographical coordinates of the location (latitude).
   * @param lon Geographical coordinates of the location (longitude)
   * @param exclude By using this parameter you can exclude some parts of the weather data  from the API response.
   * It should be a comma-delimited list (without spaces).
   * @param appid Key, created by account
   * @return OneCallWeatherData type.
   */

  @Override public void realDataApi(String lat, String lon, String exclude, String appid) {
    Call<OneCallWeatherData> result =
        NetWork.getServiceInstance().getDataByOneCall(lat, lon, exclude, appid);
    result.enqueue(new Callback<OneCallWeatherData>() {
      @Override
      public void onResponse(Call<OneCallWeatherData> call, Response<OneCallWeatherData> response) {
        iView.onResponse(response.body());
      }
      @Override public void onFailure(Call<OneCallWeatherData> call, Throwable t) {
        iView.onFailure(t.getMessage());
      }
    });
  }

  /**
   * getDataByCity API is used to call related API by the city name
   *
   * @param currentCity the current city name
   * @return void
   */

  public void getDataByCity(String currentCity) {

    if (currentCity != null && currentCity.equals("Melbourne")) {
      realDataApi(Global.melbourneLat, Global.melbourneLon, Global.exclude,
          Global.appid);
    } else if (currentCity != null && currentCity.equals("Sydney")) {
      realDataApi(Global.syndeyLat, Global.syndeyLon, Global.exclude,
          Global.appid);
    } else if (currentCity != null && currentCity.equals("Perth")) {
      realDataApi(Global.perthLat, Global.perthLon, Global.exclude,
          Global.appid);
    } else if (currentCity != null && currentCity.equals("Hobart")) {
      realDataApi(Global.hobartLat, Global.hobartLon, Global.exclude,
          Global.appid);
    }
  }

  /*
   * mockDataApi API
   * To get mock data
   * @return void
   */

  @Override public void mockDataApi() {
    Call<OneCallWeatherData> result = NetWork.getMockDataServiceInstance().getMockData();
    result.enqueue(new Callback<OneCallWeatherData>() {
      @Override
      public void onResponse(Call<OneCallWeatherData> call, Response<OneCallWeatherData> response) {
        iView.onResponse(response.body());
      }
      @Override public void onFailure(Call<OneCallWeatherData> call, Throwable t) {
        iView.onFailure(t.getMessage());
      }
    });
  }

  /**
   * getSimulatedData API
   *
   * @return void
   */
  public void getSimulatedData() {
    mockDataApi();
  }
}
