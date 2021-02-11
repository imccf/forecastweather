package com.utu.weather.contracts;

import com.utu.weather.model.OneCallWeatherData;

/**
 * Created by Charlie(Chunfeng).
 * Created on 6/2/2021
 */

public class IContracts {
  public interface IView {
    /**
     * onResponse Interface
     * pass success data to View layer
     *
     * @return void
     */
    void onResponse(OneCallWeatherData bean);

    /**
     * onFailure Interface
     * pass error data to View layer
     *
     * @return void
     */

    void onFailure(String error);
  }

  public interface IPresenter {
    /**
     * realDataApi Interface
     *
     * Api model     https://api.openweathermap.org/data/2.5/onecall?
     * lat={lat}&lon={lon}&exclude={part}&appid={API key}
     *
     * @param lat Geographical coordinates of the location (latitude).
     * @param lon Geographical coordinates of the location (longitude)
     * @param exclude By using this parameter you can exclude some parts of the weather data  from the API response.
     * It should be a comma-delimited list (without spaces).
     * @param appid Key, default or created by account
     * @return OneCallWeatherData type.
     */

    void realDataApi(String lat, String lon, String exclude, String appid);

    /**
     * mockDataApi Interface
     *
     * Api model     http://topblockchaininfo.com/testdata.json
     *
     * @return void
     */
    void mockDataApi();
  }
}
