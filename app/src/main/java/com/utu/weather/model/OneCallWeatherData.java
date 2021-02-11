package com.utu.weather.model;

import java.util.List;

/**
 * Created by Charlie(Chunfeng).
 * Created on 6/2/2021
 */

public class OneCallWeatherData {

  /**
   * Created by Charlie(Chunfeng).
   * Created on 6/2/2021
   * OneCallWeatherData Class is the data bean of one-call-api
   * please refer to https://openweathermap.org/api/one-call-api
   */

  private Double lat;
  private Double lon;
  private String timezone;
  private Integer timezone_offset;
  private CurrentBean current;
  private List<DailyBean> daily;

  public Double getLat() {
    return lat;
  }
  public void setLat(Double lat) {
    this.lat = lat;
  }
  public Double getLon() {
    return lon;
  }
  public void setLon(Double lon) {
    this.lon = lon;
  }
  public String getTimezone() {
    return timezone;
  }
  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }
  public Integer getTimezone_offset() {
    return timezone_offset;
  }
  public void setTimezone_offset(Integer timezone_offset) {
    this.timezone_offset = timezone_offset;
  }
  public CurrentBean getCurrent() {
    return current;
  }
  public void setCurrent(CurrentBean current) {
    this.current = current;
  }
  public List<DailyBean> getDaily() {
    return daily;
  }
  public void setDaily(List<DailyBean> daily) {
    this.daily = daily;
  }

  public static class CurrentBean {

    private Integer dt;
    private Integer sunrise;
    private Integer sunset;
    private Double temp;
    private Double feels_like;
    private Integer pressure;
    private Integer humidity;
    private Double dew_point;
    private Double uvi;
    private Integer clouds;
    private Integer visibility;
    private Double wind_speed;
    private Integer wind_deg;
    private List<WeatherBean> weather;
    public Integer getDt() {
      return dt;
    }
    public Integer getSunrise() {
      return sunrise;
    }
    public Integer getSunset() {
      return sunset;
    }
    public Double getTemp() {
      return temp;
    }
    public Double getFeels_like() {
      return feels_like;
    }
    public Integer getPressure() {
      return pressure;
    }
    public Integer getHumidity() {
      return humidity;
    }
    public Double getDew_point() {
      return dew_point;
    }
    public Double getUvi() {
      return uvi;
    }
    public Integer getClouds() {
      return clouds;
    }
    public Integer getVisibility() {
      return visibility;
    }
    public Double getWind_speed() {
      return wind_speed;
    }
    public Integer getWind_deg() {
      return wind_deg;
    }
    public List<WeatherBean> getWeather() {
      return weather;
    }

    public static class WeatherBean {

      private Integer id;
      private String main;
      private String description;
      private String icon;

      public String getMain() {
        return main;
      }
    }
  }

  public static class DailyBean {

    private Integer dt;
    private Integer sunrise;
    private Integer sunset;
    private TempBean temp;
    private FeelsLikeBean feels_like;
    private Integer pressure;
    private Integer humidity;
    private Double dew_point;
    private Double wind_speed;
    private Integer wind_deg;
    private List<WeatherBean> weather;
    private Integer clouds;
    private Double pop;
    private Double uvi;
    private Double rain;
    public Integer getDt() {
      return dt;
    }
    public TempBean getTemp() {
      return temp;
    }
    public List<WeatherBean> getWeather() {
      return weather;
    }

    public static class TempBean {
      private Double day;
      private Double min;
      private Double max;
      private Double night;
      private Double eve;
      private Double morn;
      public Double getDay() {
        return day;
      }
      public Double getMin() {
        return min;
      }
      public Double getMax() {
        return max;
      }
      public Double getNight() {
        return night;
      }
      public Double getEve() {
        return eve;
      }
      public Double getMorn() {
        return morn;
      }
    }

    public static class FeelsLikeBean {

      private Double day;
      private Double night;
      private Double eve;
      private Double morn;
    }

    public static class WeatherBean {

      private Integer id;
      private String main;
      private String description;
      private String icon;
      public String getIcon() {
        return icon;
      }
    }
  }
}
