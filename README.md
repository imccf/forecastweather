

### **Weather App**
   Introduce: This App is used to show current city weather data and forecast incoming days weather
   Tech framework: It is based on MVP design pattern
   Network technology: Use retrofit lib
   Mock data: Because the app require to show 15 days weather data, but you need pay to get more than 7 days data from the https://openweathermap.org/, to solve this problem, a mock data is saved in the third server http://topblockchaininfo.com/, the mock data json structure is same as real data.

### **Environmental requirements**
    Android Studio 4.12
    Java SDK 8
    Gradle Version 6.5
    Android Gradle plug in 4.1.2

### **Third party lib**

  1. PageIndicatorView  This lib is used to show cycle icon when page scroll left and right
  
  2. Glide   This lib is used to show cycle icon when page scroll left and right

  3. Retrofit This lib is used to internet request



### **Demonstrate how to do API call and refine the data**

--1. Get real Data
      call "One Call API" to get real data from https://openweathermap.org/

      API model https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}

      Example to ge Melbourne weather data

      https://api.openweathermap.org/data/2.5/onecall?lat=-37.813999&lon=144.963318&exclude=hourly,minutely,alerts&appid=84f3c17fb2301f7def623438374507ff


  1.1  Parse Data, After get json data, parse the json data
     Use retrofit lib to get data and auto parse json data

  1.2  Fill data, once finish to parse data, update UI
     Callback View.onResponse() function and transform data to UI view
     and then call fillData() function to update data

--2. Get mock Data

  2.1. Get real Data
      get mock data from http://topblockchaininfo.com/testdata.json

      API model http://topblockchaininfo.com/testdata.json

      Example to ge mock Melbourne weather data, same as Perth, Sydney, Hobart

      http://topblockchaininfo.com/testdata.json


  2.2 Parse Data, After get json data, parse the json data
     Use retrofit lib to get data and auto parse json data

  2.3 Fill data, once finish to parse data, update UI
     Callback View.onResponse() function and transform data to UI view
     and then call fillData() function to update data


### **Demonstrate how to implement the UI layout and components**

                ***activity_main_layout.xml***

  1. Layout activity_main_layout.xml
   This is main layout file, root is RelativeLayout, it include widget ViewPager and a third widget
   that is used to show page indicator

  2. Widget ViewPager
    It is used to implement scroll left and right to switch city

  3. Widget PageIndicatorView
    It is used to show page indicator when scroll left and right to switch city


                ***fragment_main_layout.xml***
  1. Layout fragment_main_layout.xml
   This is layout file is used to show the main weather info, such as city name, max/min temp
   the root layout is ConstraintLayout layout
  2. In this layout, there are two key point
     1. Use a widget RecyclerView to show the incoming 3 days weather data
     2. A TextView is used to show "loading", it will be shown, when it start to request data from server, and gone after finishing data request

  3. Use TextView to show city name, max/min temp, weather condition, current temp

  4. Use LinearLayout to show "15days>>"


                  ***item_weather_forecast_list.xml***

    1. Layout item_weather_forecast_list.xml
     This layout file is item layout for recycle view list, root is LinearLayout

    2. In this layout, it include TextView , ImageView and LinearLayout
       1. TextView is used to date
       2. ImageView is used to show icon
       3. LinearLayout include two TextView is used to Max/Min temp

                  ***activity_forecast.xml***

    1. Layout activity_forecast.xml
     This layout is used to show incoming 15days data, root is ConstraintLayout

    2. In this layout, it include 3 LinearLayout


       1. TextView in the first LinearLayout to show city name
       2. RecyclerView in the second LinearLayout to show 15 days data
       2. TextView in the third LinearLayout to show notice, once click, it will load mock data to show 15 days data


### **Test Note**

    1. TestAPI.class is the test file used to test basic function
    2. Test Unix2Date() function, depend on your system language

### **Release Note**

See release notes on https://github.com/imccf/Weather

### **README File**
   README file is under root folder in project


### **License**

    Copyright 2021 Charlie(Chunfeng)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
