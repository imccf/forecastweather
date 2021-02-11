package com.utu.weather.Util;

import com.utu.weather.presenter.GetDataService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Charlie.
 * Created on 6/2/2021
 */

public class NetWork {
  private static final OkHttpClient okHttpClient = new OkHttpClient();
  private static GetDataService getDataService;
  private static GetDataService getSimulatedDataService;

  /**
   * getServiceInstance API
   *
   * @return GetDataService type.
   */

  public static GetDataService getServiceInstance() {
    if (getDataService == null) {
      Retrofit retrofit = new Retrofit.Builder()
          .client(okHttpClient)
          .baseUrl(Global.baseUrl)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      getDataService = retrofit.create(GetDataService.class);
    }
    return getDataService;
  }

  /**
   * getMockDataServiceInstance API
   *
   * @return GetDataService type.
   */

  public static GetDataService getMockDataServiceInstance() {
    if (getSimulatedDataService == null) {
      Retrofit retrofit = new Retrofit.Builder()
          .client(okHttpClient)
          .baseUrl(Global.simulatedDataUrl)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      getSimulatedDataService = retrofit.create(GetDataService.class);
    }
    return getSimulatedDataService;
  }
}
