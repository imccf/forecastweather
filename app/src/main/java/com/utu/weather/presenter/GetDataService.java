package com.utu.weather.presenter;

import com.utu.weather.model.OneCallWeatherData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Charlie(Chunfeng).
 * Created on 6/2/2021
 */

public interface GetDataService {

  /**
   * getDataByOneCall Interface
   *
   * @param lat Geographical coordinates of the location (latitude).
   * @param lon Geographical coordinates of the location (longitude)
   * @param exclude By using this parameter you can exclude some parts of the weather data  from the API response.
   * It should be a comma-delimited list (without spaces).
   * @param appid Key, created by account
   * @return OneCallWeatherData type.
   */
  @GET("/data/2.5/onecall")
  Call<OneCallWeatherData> getDataByOneCall(@Query("lat") String lat,
      @Query("lon") String lon, @Query("exclude") String exclude, @Query("appid") String appid);

  /**
   * getMockData Interface
   * This is a mock data
   * There is no param to call this Api
   * the testdata.json file is got from http://topblockchaininfo.com/
   *
   * @return OneCallWeatherData type.
   */
  @GET("/testdata.json")
  Call<OneCallWeatherData> getMockData();
}


