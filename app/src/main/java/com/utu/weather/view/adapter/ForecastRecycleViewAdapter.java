package com.utu.weather.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.utu.weather.R;
import com.utu.weather.Util.Global;
import com.utu.weather.Util.UtilLib;
import com.utu.weather.model.OneCallWeatherData;
import java.util.ArrayList;
import java.util.List;

public class ForecastRecycleViewAdapter
    extends RecyclerView.Adapter<ForecastRecycleViewAdapter.ViewHolder> {

  private final Context context;

  private ArrayList<OneCallWeatherData.DailyBean> dailyList;

  private int specifiedDisplayItemNum = 0;

  public ForecastRecycleViewAdapter(Context context) {
    this.context = context;
  }

  public void setData(List<OneCallWeatherData.DailyBean> dailyBeanList, int displayItemNum) {
    if (dailyList == null) {
      dailyList = new ArrayList<>();
    }
    dailyList.clear();
    dailyList.addAll(dailyBeanList);
    this.specifiedDisplayItemNum = displayItemNum;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(context).inflate(R.layout.item_weather_forecast_list, parent, false);
    ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, final int position) {

    // Because only forecast the incoming three days weather info
    // there is no need to get the current date weather info
    // when position == 0, it means the data is current date weather info

    if (specifiedDisplayItemNum > 0 && position == 0) {
      return;
    }

    // Set data

    holder.forecastDate.setText(UtilLib.Unix2Date(dailyList.get(position).getDt()));
    // Load image
    String iconUrl =
        UtilLib.getIconUrlById(dailyList.get(position).getWeather().get(0).getIcon());
    Glide.with(holder.itemView.getContext())
        .load(iconUrl)
        .into(holder.forecastStateImg);

    // Set highest temp
    holder.forecastMaxTemp.setText(
        Long.toString(Math.round(UtilLib.K2C(dailyList.get(position).getTemp().getMax())))
            + Global.tmpUnit);

    // Set lowest temp
    holder.forecastMinTemp.setText(
        Long.toString(Math.round(UtilLib.K2C(dailyList.get(position).getTemp().getMin())))
            + Global.tmpUnit);
    // Set slash visible
    holder.forecastTempSlash.setVisibility(View.VISIBLE);
  }

  @Override
  public int getItemCount() {
    if (this.specifiedDisplayItemNum > 0 && dailyList != null) {
      // Display specified items
      return this.specifiedDisplayItemNum;
    } else if (dailyList != null && specifiedDisplayItemNum == 0) {
      // Display all items
      return dailyList.size();
    } else {
      return 0;
    }
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView forecastTempSlash;
    private final ImageView forecastStateImg;
    private final TextView forecastMaxTemp;
    private final TextView forecastMinTemp;
    private final TextView forecastDate;
    public ViewHolder(View itemView) {
      super(itemView);
      forecastDate = itemView.findViewById(R.id.forecast_date);
      forecastStateImg = itemView.findViewById(R.id.forecast_weather_state);
      forecastMaxTemp = itemView.findViewById(R.id.forecast_temp_height);
      forecastMinTemp = itemView.findViewById(R.id.forecast_temp_low);
      forecastTempSlash = itemView.findViewById(R.id.forecast_temp_slash);
    }
  }
}
