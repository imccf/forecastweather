package com.utu.weather.Util;

/**
 * Created by Charlie.
 * Created on 6/2/2021
 */

public class Global {
  // Base url
  public static String baseUrl = "https://api.openweathermap.org";

  // This is the appid created by the account
  public static String appid =
      "84f3c17fb2301f7def623438374507ff";

  // This is the appid created by the account
  public static String[] cityWeatherList = { "Melbourne", "Sydney", "Perth", "Hobart" };

  // This is the exclude parameter
  public static String exclude = "hourly,minutely,alerts";

  // Melbourne city coordinate
  public static String melbourneLat = "-37.813999";
  public static String melbourneLon = "144.963318";

  // Syndey city coordinate
  public static String syndeyLat = "-33.867851";
  public static String syndeyLon = "151.207321";

  // Hobart city coordinate
  public static String hobartLat = "-42.87936";
  public static String hobartLon = "147.329407";

  // Perth city coordinate
  public static String perthLat = "-31.933331";
  public static String perthLon = "115.833328";

  // Temp unit
  public static char tmpUnit = 0x00B0;

  // Mock data basic url
  public static String simulatedDataUrl = "http://topblockchaininfo.com";
}
