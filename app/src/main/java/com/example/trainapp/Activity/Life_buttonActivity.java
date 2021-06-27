package com.example.trainapp.Activity;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainapp.R;
import com.example.trainapp.adapter.ListDemoAdapter;
import com.example.trainapp.adapter.Text2Adapter;
import com.example.trainapp.adapter.Text2_contentAdapter;
import com.example.trainapp.entity.Activity;
import com.example.trainapp.fragment.ActivityFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Life_buttonActivity  extends AppCompatActivity implements  View.OnClickListener{


    //实例
    private TextView tv_City, tv_Class;
    //菜单显示PopupWindow
    private PopupWindow mPopWindow;
    private List<Map<String, Object>> CityList = null;
    private List<Map<String, Object>> ClassList = null;

    private TextView title;
    private ImageButton life_buttonBack;

    private RecyclerView fllife_button;
    private List<Activity> activityList = new ArrayList<>();
    private Activity life_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.life_button);

        title = (TextView) findViewById(R.id.life_button_title);

        Intent intent_title = getIntent();
        title.setText(intent_title.getStringExtra("title"));

        life_buttonBack = (ImageButton) findViewById(R.id.life_button_back);
        life_buttonBack.setOnClickListener(this);


        tv_City= findViewById(R.id.tv_City);
        tv_Class = findViewById(R.id.tv_Class);
        //绑定点击事件
        tv_City.setOnClickListener(this);
        tv_Class.setOnClickListener(this);

        fllife_button = (RecyclerView)findViewById(R.id.fl_life_button);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        fllife_button.setLayoutManager(layoutManager);
        initActivity();
        Text2Adapter text2Adapter = new Text2Adapter(activityList);
        fllife_button.setAdapter(text2Adapter);

    }

    /*  String name, int imageId, String content, String title */
    private void initActivity() {
        for (int i=0;i<1;i++) {
            Activity canting1 = new Activity("canting1", R.drawable.canting1,
                    "都说北方人过冬靠暖气，南方人过冬靠一身正气。那么，小编过冬靠的是——合川网红早餐美食地图。热气腾腾、香味四溢的早餐，是开启美好一天的第一步！…",
                    "合川网红早餐地图 | 米粉、羊杂、肥肠汤……直接收藏！");
            activityList.add(canting1);
            Activity canting2 = new Activity("canting2", R.drawable.canting2,
                    "辣椒是土家人一年四季的一道家常菜，蒸、炒、煮、卤、拌，均要放辣椒，“红油辣子”更是常用的调料。鲊辣椒是以石柱红辣椒和玉米面为主要原料加工而成，将鲊海椒在锅中焙熟后与土家腊肉一起炒食…",
                    "重庆石柱美食---鲊海椒炒腊肉");
            activityList.add(canting2);
            Activity canting3 = new Activity("canting3", R.drawable.canting3,
                    "高山多产玉米、豆类，所以土家人除米饭外，以包谷饭最为常见，也吃豆饭，将绿豆、豌豆掺在饭中，或蒸或煮。“洋芋”就是土豆。…",
                    "重庆石柱特色美食---洋芋饭");
            activityList.add(canting3);
            Activity canting4 = new Activity("雪糕", R.drawable.canting4,
                    "腊蹄子是土家特色菜之一。最正宗的腊蹄子是每年冬季，土家人把自家的年猪“肢解”后趁着余热，洒上佐料淹上3~4天，让其味完全渗入猪肉中。…",
                    "重庆石柱美食---腊蹄子");
            activityList.add(canting4);
            Activity canting5 = new Activity("雪糕", R.drawable.canting5,
                    "在金佛山吃方竹笋可谓五花八门，可以说有多少家庭主妇就有多少种吃法。但大体上离不开烫、炒、炖、蒸、泡5大类别。…",
                    "重庆南川美食---方竹笋菜肴");
            activityList.add(canting5);

        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tv_City:
                showCityPopupWindow();
                break;
            case R.id.tv_Class:
                showClassPopupWindow();
                break;
            case R.id.life_button_back:
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                Life_buttonActivity.this.finish();
                break;
            default:
                break;
        }
    }

    //PopupWindow菜单详细内容显示
    //城市
    private void showCityPopupWindow() {
        //设置contentView
        View contentView = View.inflate(this, R.layout.popup_demo, null);
        //适配7.0版本
        mPopWindow = new Solve7PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, 300);
//        mPopWindow = new PopupWindow(contentView,
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);

        //获取实例，设置各个控件的点击响应
        //注意：PopupWindow中各个控件的所在的布局是contentView，而不是在Activity中，所以，要在findViewById(R.id.tv)前指定根布局
        //类别列表加载

        ListView lv_City = (ListView)contentView.findViewById(R.id.lv_Popup);

        CityList = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        for(int i=1; i<11; i++)
        {
            map = new HashMap<String, Object>();
            switch (i){
                case 1:
                    map.put("tv_City", "万州");
                    CityList.add(map);
                    break;
                case 2:
                    map.put("tv_City", "合川");
                    CityList.add(map);
                    break;
                case 3:
                    map.put("tv_City", "壁山");
                    CityList.add(map);
                    break;
                case 4:
                    map.put("tv_City", "永川");
                    CityList.add(map);
                    break;
                case 5:
                    map.put("tv_City", "铜梁");
                    CityList.add(map);
                    break;
                case 6:
                    map.put("tv_City", "潼南");
                    CityList.add(map);
                    break;
                case 7:
                    map.put("tv_City", "大足");
                    CityList.add(map);
                    break;
                case 8:
                    map.put("tv_City", "荣昌");
                    CityList.add(map);
                    break;
                case 9:
                    map.put("tv_City", "江津");
                    CityList.add(map);
                    break;
                case 10:
                    map.put("tv_City", "綦江");
                    CityList.add(map);
                    break;
            }
//            map.put("tvSortItem", i + "类");
//            riskSortList.add(map);
        }

        ListDemoAdapter listDemoAdapter = new ListDemoAdapter(this, CityList, R.layout.popup_list_item, new String[] { "tv_City"},new int[] { R.id.tv_PopupItem});
        lv_City.setAdapter(listDemoAdapter);

        //解决5.0以下版本点击外部不消失问题
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示方式
        mPopWindow.showAsDropDown(tv_City);

        backgroundAlpha(0.4f);

        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });

    }
    //类别
    private void showClassPopupWindow() {
        //设置contentView
        View contentView = View.inflate(this, R.layout.popup_demo, null);
        //适配7.0版本
        mPopWindow = new Solve7PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, 300);
//        mPopWindow = new PopupWindow(contentView,
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);


        //获取实例，设置各个控件的点击响应
        //注意：PopupWindow中各个控件的所在的布局是contentView，而不是在Activity中，所以，要在findViewById(R.id.tv)前指定根布局
        //类别列表加载

        ListView lv_Class = (ListView)contentView.findViewById(R.id.lv_Popup);
        ClassList = new ArrayList<Map<String, Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        for(int i=1; i<4; i++)
        {
            map = new HashMap<String, Object>();
            switch (i){
                case 1:
                    map.put("tv_Class", "麻辣风味");
                    ClassList.add(map);
                    break;
                case 2:
                    map.put("tv_Class", "乡村风味");
                    ClassList.add(map);
                    break;
                case 3:
                    map.put("tv_Class", "土家风味");
                    ClassList.add(map);
                    break;
            }
//            map.put("tvSortItem", i + "类");
//            riskSortList.add(map);
        }

        ListDemoAdapter listDemoAdapter = new ListDemoAdapter(this, ClassList, R.layout.popup_list_item, new String[] { "tv_Class"},new int[] { R.id.tv_PopupItem});
        lv_Class.setAdapter(listDemoAdapter);

        //解决5.0以下版本点击外部不消失问题
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示方式
        mPopWindow.showAsDropDown(tv_Class);

        backgroundAlpha(0.4f);



        mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1.0f);
            }
        });

    }


    // 设置屏幕透明度
    public void backgroundAlpha(float bgAlpha) {

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0~1.0
        getWindow().setAttributes(lp);

    }



    public class Solve7PopupWindow extends PopupWindow {

        public Solve7PopupWindow(View mMenuView, int matchParent, int matchParent1) {
            super(mMenuView, matchParent,matchParent1);
        }

        @Override
        public void showAsDropDown(View anchor) {
            if (Build.VERSION.SDK_INT == 24) {
                Rect rect = new Rect();
                anchor.getGlobalVisibleRect(rect);
                int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                setHeight(h);
            }
            super.showAsDropDown(anchor);
        }
    }


}
