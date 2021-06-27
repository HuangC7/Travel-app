package com.example.trainapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.trainapp.R;


public class BaiduMapActivity extends AppCompatActivity implements View.OnClickListener {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private RadioButton rb_btn1, rb_btn2;
    private CheckBox checkBox1, checkBox2;
    private ImageButton baidu_map_back;

    private LocationClient mLocationClient = null;
    // 是否是第一次定位
    private boolean isFirstLocate = true;
    // 当前定位模式
    private MyLocationConfiguration.LocationMode locationMode;

    //    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baidu_map);
        initView();
        initEvent();
        LocationClient();
        // 得到地图
        mBaiduMap = mMapView.getMap();
        // 开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mLocationClient = new LocationClient(this);

        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        // 可选，设置地址信息
        option.setIsNeedAddress(true);
        //可选，设置是否需要地址描述
        option.setIsNeedLocationDescribe(true);

        //设置locationClientOption
        mLocationClient.setLocOption(option);

        //注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
        //开启地图定位图层
        mLocationClient.start();


    }

    private void LocationClient() {
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(BaiduMapActivity.this,CateActivity.class);
//                startActivity(intent);
//                finish();
//                Toast.makeText(BaiduMapActivity.this,"back",Toast.LENGTH_SHORT).show();
//            }
//        });
        rb_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //普通地图 ,mBaiduMap是地图控制器对象
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
            }
        });
        rb_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //卫星地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox1.isChecked()) {
                    //开启交通图
                    mBaiduMap.setTrafficEnabled(true);
                } else {
                    mBaiduMap.setTrafficEnabled(false);
                }

            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBox2.isChecked()) {
                    // 开启热力图
                    mBaiduMap.setBaiduHeatMapEnabled(true);
                } else {
                    mBaiduMap.setBaiduHeatMapEnabled(false);
                }
            }
        });
    }

    private void initView() {
        rb_btn1 = findViewById(R.id.rd_btn1);
        rb_btn2 = findViewById(R.id.rd_btn2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
//        back = findViewById(R.id.iv_back);
        mMapView = findViewById(R.id.bmapView);

        baidu_map_back = (ImageButton) findViewById(R.id.train_back);
        baidu_map_back.setOnClickListener(this);


    }

    private void initEvent() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        BaiduMapActivity.this.finish();
    }

    // 继承抽象类BDAbstractListener并重写其onReceieveLocation方法来获取定位数据，并将其传给MapView
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }

            // 如果是第一次定位
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            if (isFirstLocate) {
                isFirstLocate = false;
                //给地图设置状态
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newLatLng(ll));
            }

            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
        }
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

}
