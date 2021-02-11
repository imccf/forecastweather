package com.utu.weather;

import com.utu.weather.Util.NetWork;
import com.utu.weather.Util.UtilLib;
import com.utu.weather.model.OneCallWeatherData;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.fail;

public class TestAPI {

  @Before
  public void setUp() throws Exception {
    System.out.println("***start test***");
  }
  @After
  public void tearDown() throws Exception {
    System.out.println("***end test***");
  }
  @Test
  public void OneCallApi() {
    String lat = "33.441792";
    String lon = "-94.037689";
    String exclude = "hourly,current,minutely,alerts";
    String appid = "84f3c17fb2301f7def623438374507ff";
    Call<OneCallWeatherData> result =
        NetWork.getServiceInstance().getDataByOneCall(lat, lon, exclude, appid);
    try {
      Response<OneCallWeatherData> response = result.execute();
      Assert.assertEquals(200, response.code());
      OneCallWeatherData business = response.body();
      Assert.assertNotNull(business);
      System.out.println("*** OneCallApi Test Pass ***");
    } catch (IOException e) {
      fail();
    }
  }

  @Test
  public void Unix2Date() {
    long unixTimestamp = 1612818802;
    //if your system is English, please use English, depend on your system language
    // Or else , use your system language
    Assert.assertEquals("Tue, 9 Feb", UtilLib.Unix2Date(unixTimestamp));
    System.out.println("*** Unix2Date Test Pass ***");
  }

  @Test
  public void K2C() {
    Assert.assertEquals(36.59, UtilLib.K2C(310.09), 0.001);
    System.out.println("*** K2C Test Pass ***");
  }

  @Test
  public void getIconUrlById() {
    String expected = "http://openweathermap.org/img/wn/01d@2x.png";
    Assert.assertEquals(expected, UtilLib.getIconUrlById("01d"));
    System.out.println("*** getIconUrlById Test Pass ***");
  }

  @Test
  public void simulatedDataApi() {
    Call<OneCallWeatherData> result = NetWork.getMockDataServiceInstance().getMockData();
    try {
      Response<OneCallWeatherData> response = result.execute();
      Assert.assertEquals(200, response.code());
      OneCallWeatherData business = response.body();
      Assert.assertNotNull(business);
      System.out.println("*** simulatedDataApi Test Pass ***");
    } catch (IOException e) {
      fail();
    }
  }
}