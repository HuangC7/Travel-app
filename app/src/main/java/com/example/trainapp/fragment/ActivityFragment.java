package com.example.trainapp.fragment;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.trainapp.R;
import com.example.trainapp.adapter.ListDemoAdapter;
import com.example.trainapp.adapter.Text1Adapter;
import com.example.trainapp.base.BaseFragment;
import com.example.trainapp.entity.Activity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 活动页面的Fragment
 * */

public class ActivityFragment extends BaseFragment implements View.OnClickListener{


    //实例
    private TextView tv_City, tv_Class;
    //菜单显示PopupWindow
    private PopupWindow mPopWindow;
    private List<Map<String, Object>> CityList = null;
    private List<Map<String, Object>> ClassList = null;


    private List<Activity> activityList = new ArrayList<>();
    private RecyclerView flActivity;

    private static final String TAG = "ActivityFragment";

    private boolean mIsTouch = false;



    private LinearLayout mLinearLayout;

    private RollPagerView mRollViewPager;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.activity_fragment, null);

        tv_City= view.findViewById(R.id.tv_City);
        tv_Class = view.findViewById(R.id.tv_Class);
        //绑定点击事件
        tv_City.setOnClickListener(this);
        tv_Class.setOnClickListener(this);

        initActivity();

        // 2. 初始化轮播图
        mRollViewPager = view.findViewById(R.id.mRollViewPager);
        mRollViewPager.setPlayDelay(2000); // 设置播放时间间隔
        mRollViewPager.setAnimationDurtion(500); // 设置透明度
        mRollViewPager.setAdapter(new TestNormalAdapter()); //  设置适配器
        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.shape_bg_point_enable, R.drawable.shape_bg_point_disable));
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));

        flActivity = (RecyclerView) view.findViewById(R.id.fl_activity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        flActivity.setLayoutManager(layoutManager);
        Text1Adapter text1Adapter = new Text1Adapter(mContext, activityList);
        flActivity.setAdapter(text1Adapter);

        return view;
    }


    //菜单绑定点击事件
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
            default:
                break;
        }
    }

    //PopupWindow菜单详细内容显示
    //城市
    private void showCityPopupWindow() {
        //设置contentView
        View contentView = View.inflate(mContext, R.layout.popup_demo, null);
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

        ListDemoAdapter listDemoAdapter = new ListDemoAdapter(mContext, CityList, R.layout.popup_list_item, new String[] { "tv_City"},new int[] { R.id.tv_PopupItem});
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
        View contentView = View.inflate(mContext, R.layout.popup_demo, null);
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
                    map.put("tv_Class", "一类");
                    ClassList.add(map);
                    break;
                case 2:
                    map.put("tv_Class", "二类");
                    ClassList.add(map);
                    break;
                case 3:
                    map.put("tv_Class", "三类");
                    ClassList.add(map);
                    break;
            }
//            map.put("tvSortItem", i + "类");
//            riskSortList.add(map);
        }

        ListDemoAdapter listDemoAdapter = new ListDemoAdapter(mContext, ClassList, R.layout.popup_list_item, new String[] { "tv_Class"},new int[] { R.id.tv_PopupItem});
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

        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0~1.0
        getActivity().getWindow().setAttributes(lp);

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


    /* String name, int imageId, int image_detailedID1, int image_detailedID2, int image_detailedID3, String content, String title,
               String time, String place, String content_detailed */
    private void initActivity() {
        for (int i=0;i<1;i++) {
            Activity huodong1 = new Activity("huodong1", R.drawable.huodong1, R.drawable.huodong1_1 ,R.drawable.huodong1_2, R.drawable.huodong1_3,
                    "4月9日上午，以“乘上春天列车，共享诗和远方”为主题的第25届重庆都市文化旅游节暨城际旅游交易会（简称“一会一节”）在渝中区拉开序幕。为期三天（4月9日—12日）的“一会一节”相关活动将在解放碑和观音桥步行街同步举行。活动旨在展现重庆“都市旅游”亮点，发挥“一会一节”平台聚合作用，带动全域文旅消费，促成全国各地文旅行业与重庆的亲密对话。",
                    "第25届重庆都市文化旅游节暨城际旅游交易会今日开幕",
                    "2021-04-09",
                    "渝中区",
                    "   4月9日上午，以“乘上春天列车，共享诗和远方”为主题的第25届重庆都市文化旅游节暨城际旅游交易会（简称“一会一节”）在渝中区拉开序幕。为期三天（4月9日—12日）的“一会一节”相关活动将在解放碑和观音桥步行街同步举行。活动旨在展现重庆“都市旅游”亮点，发挥“一会一节”平台聚合作用，带动全域文旅消费，促成全国各地文旅行业与重庆的亲密对话。\n" +
                            "\n" +
                            "　　本届“一会一节”邀请到日本国驻重庆总领事馆、意大利驻重庆总领事馆、埃塞俄比亚驻重庆总领事馆、巴基斯坦驻成都总领事馆、乌拉圭驻重庆总领事馆、匈牙利驻重庆总领事馆、日本一般财团法人大阪国际经济振兴中心上海代表处等7个外国领事机构、国际商协会驻国内办事机构；北京市、江苏省、浙江省、湖北省、广东省、四川省、贵州省、云南省、陕西省、新疆维吾尔族自治区等10余个国内省区市文旅主管部门；万州、涪陵、渝中、大渡口、江北、九龙坡、巴南、长寿、合川、大足、璧山、潼南、开州、梁平、武隆、城口、忠县、垫江、云阳、石柱、秀山、万盛共22个市内区县文旅主管部门，江北国际机场、轨道集团、渝中母城文化公司、山城巷、十八梯、四姑娘山、九寨沟、西江千户苗寨等300余家文旅企业、旅游景区景点参展参会。\n" +
                            "\n" +
                            "节会场景化、主题化创新\n" +
                            "　　本届“一会一节”结合母城文化、“城门”元素，围绕中外多元文化、渝中特色非遗文化展示，打造一条创意艺术互动体验长廊。以“老城门”为设计原型，选取彩虹色彩打造“焕彩城门”，并运用可旋转设计生动演绎老城门“九开八闭”之景，同时联动自贡灯会打造团队融入灯会风格的主题场景元素。\n" +
                            "　　在创意主题场景中设置展览展示空间，同时融入国际文化元素，展示日本国、意大利、埃塞俄比亚、巴基斯坦、乌拉圭、匈牙利等国家人文风貌。\n" +
                            "\n" +
                            "川渝旅游合作 服务两地经济\n" +
                            "　　为深入推动川渝两地旅游产业发展，规范两地旅游交通标志设置，健全道路旅游交通服务功能，提升旅游交通服务保障水平，服务旅游经济发展，川渝两地共同编制《旅游交通标志设置规范》的战略合作协议在本届“一会一节”上正式签署。\n" +
                            "\n" +
                            "城际旅游交易会 汇聚文旅大咖\n" +
                            "　　2021城际旅游交易会围绕新型文化旅游业态、文旅发展新格局、红色旅游发展创新等方面进行深入探讨，加快推动区域文化旅游合作。\n" +
                            "　　交易会上，重庆渝中区、四川省攀枝花市米易县、红岩联线、长江索道分别开展了文旅推介，同期还将举行全国旅游产品（重庆）采购会，邀请全国百家旅行社代表对重庆旅游产品进行集中采购。\n" +
                            "\n" +
                            "精彩轮番上映 尽领各地风情\n" +
                            "　　活动期间，组办方组织了阿克苏、遵义、昭通、迪庆藏族自治州等20余地，带来民俗文化演艺、互动情景展演、沉浸氛围推介等20多场精彩纷呈的展演活动。\n" +
                            "　　开幕当天，在解放碑中心舞台开展了“大巴山•大巴峡”文化旅游发展联盟——万达开川渝统筹发展示范区文化旅游展演、“剑门蜀道 女皇故里 熊猫家园 红色广元”四川广元文化旅游重庆推介、2021春季“丝路古龟兹 神奇阿克苏”新疆阿克苏文化旅游重庆宣传推介、渝中特色文旅专场推介等10余场展演。\n" +
                            "　　4月10日，在解放碑中心舞台和观音桥广场舞台，将上演四川首批“天府旅游名县”宜宾市长宁县旅游、理好•重庆2021“藏羌走廊 吉祥理县”四川理县文化旅游推介和“世界的香格里拉”云南香格里拉文化旅游宣传推介等10余场特色展演。\n" +
                            "\n" +
                            "渝中特色活动 持续畅玩\n" +
                            "　　本届“一会一节”，还联动湖广会馆、白象街、十八梯、高力国际等渝中特色文旅景区景点和旅游企业开展多项活动，包括正式启动第六届渝中区文化旅游（春夏）惠民消费季活动，本次消费季以“弘扬传统文化•保护非遗传承”为主题，历时5个月，涵盖传统非遗、艺术展演、线上文旅营销、文旅载体、文旅节会、文旅大赛等6大板块；“人文渝中”公共文化服务示范典范评选活动发布；高力国际围绕“国际视野下，重庆文旅消费的升级之路”进行主题分享；4月10日—11日，将在国泰广场举办“雾集”文化集市活动，通过线上线下一体化平台为地区音乐、舞蹈、喜剧、美食等文化产品提供面向全国、全世界的平台；开展“丈量”母城渝中特色景区考察及踩线活动，邀请旅行商、全国各大旅行社、市内外媒体代表等，实地考察湖广会馆、白象街、戴家巷、十八梯、山城步道、周公馆、红岩村等渝中特色文旅景点；4月10日，还将开展“中国体彩杯”2021重庆佛图古关全民健身登山比赛，组织区级各部门、管委会、街道办事处、企事业单位以及辖区社会单位、社群参与登山活动。\n" +
                            "\n" +
                            "旅游惠民 优惠折扣力度大\n" +
                            "　　节会期间，各大景区景点、旅游机构及旅行社均推出优惠折扣、半价钜惠、免费游等大力度折扣回馈广大市民游客，如：甘孜州内所有收费景区6月1日前对重庆游客（凭身份证）门票均5折优惠；宜宾七洞沟景区，3月6日-4月30日期间，转发七洞沟微信公众号文章，可免费获得门票1张且景区内各单个项目半价优惠（喊泉、观光车除外）；大关山海洞景区，试运营期间景区原价188元的门票活动特价4.8折优惠，仅售90元/人；开州汉丰湖、举子园、刘伯承同志纪念馆活动期间均免门票，石宝寨现场发放门票5折优惠券；蚩尤九黎城+摩围山终生卡特价299元。");
            activityList.add(huodong1);
            Activity huodong2 = new Activity("huodong2", R.drawable.huodong2, R.drawable.huodong2_1 ,R.drawable.huodong2_2, R.drawable.huodong2_3,
                    "11月6日，第三届长江三峡（梁平）国际柚博会开幕，这场金秋时节的“柚乡之约”，聚焦了区内外的目光和期待，中央人民广播电台、光明日报、重庆日报等20余家中央、市级媒体，纷纷来梁集中采访报道柚博会盛况，共同探访柚海之美，为梁平柚发声，助力乡村振兴。",
                    "第三届长江三峡（梁平）国际柚博会开幕",
                    "2020-11-08",
                    "梁平",
                    "   柚博会开幕式上，共有中央人民广播电台、光明日报、农民日报、中新社、中国旅游报、人民网、新华网、国际在线等中央媒体，重庆日报、重庆电视台、华龙网、上游新闻、重庆交广、都市热报市级媒体，今日头条、网易重庆、大渝网等网络媒体，以及区内媒体在内共计20余家媒体集中采访和报道了柚博会相关新闻，并通过网络直播、网络专题、小视频推送、微博等不同形式为梁平柚发声，让全国的市民足不出户就能看到柚博会现场，感受梁平柚丰收的喜悦和柚海之美。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　开幕式结束后，媒体记者一行还来到中华·梁平柚海参观和采访，打探柚产业发展情况，了解梁平柚知识，感受“柚时尚”“柚生活”“柚美景”。\n" +
                            "　　“本届柚博会的成功举办，必将进一步促进梁平柚产业高质量发展，带动更多农民增收奔小康。”人民网重庆频道记者谢佳洁说，针对此次柚博会，他们开设了梁平柚博会网络专题，集纳了图片、新闻、视频和文字等相关信息，包括活动内容、采摘路线等，让人们可以“一站式”全方位了解梁平柚，更加方便购买梁平柚。\n" +
                            "　　除了人民网推出柚博会网络专题宣传外，柚博会上，新华网还策划设计了梁平柚动画作品。华龙网对柚博会开幕式作了图文直播报道，并推出海报、15秒短视频、抖音等新媒体作品。同时，各大媒体用消息、通讯、图片、视频、美文、H5等各种形式，在各自平台宣传柚博会相关活动。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　据悉，长江三峡（梁平）国际柚博会，已连续成功举办两届，得到了社会各界广泛关注。在重庆日报记者彭瑜看来，长江三峡（梁平）国际柚博会办得越来越好，越来越专业，越来越现代和时尚。他说，今年的柚博会通过采取“线上+线下”相结合的方式进行，利用大数据、云智能等科技手段，充分展现了梁平科技农业、数字农业、智慧农业的发展成果；同时，邀请国家级科研院士、国际柑橘协会专家、柚产业领军人物、知名电商企业代表，以及中国三大名柚主产区参与线上、线下活动，实现了跨区域协作、多渠道合作和各方共赢，增强了辐射带动效应，做大拓宽了柚博会“朋友圈”，做强了以梁平柚为核心的柚博会品牌影响力。\n" +
                            "　　“后续，我们将持续关注梁平柚产业发展，深入挖掘、及时报道梁平在农文旅商融合发展过程中的亮点和成果，发挥平台优势，进一步提升梁平柚知名度、关注度，促进梁平柚销售，助力梁平乡村振兴。”彭瑜说。");
            activityList.add(huodong2);
            Activity huodong3 = new Activity("huodong3", R.drawable.huodong3,R.drawable.huodong3_1 ,R.drawable.huodong3_2, R.drawable.huodong3_3,
                    "10月15日，以“爱尚重庆•惠生活”为主题，由重庆市有关部门支持举办的重庆秋冬品牌服装博览会暨羊绒皮草全国土特产展在陈家坪会展中心启幕。作为2020年“百城万企促消费”全国消费促进月“爱尚重庆”金秋消费节活动之一，展会规模达1.5万平米，300多家企业厂商参展，集中展示了秋冬品牌服装服饰、生活家居、优质食品、特色农产品等上万种商品。",
                    "购冬衣，逛美食 ，捡“趴活”，2020重庆秋冬服博会15日启幕",
                    "2020-10-16",
                    "陈家坪",
                    "   秋冬时装荟萃，羊绒皮草上新\n" +
                            "　　展会组织了一大拨秋冬季品牌服装展示展销，包括内蒙羊绒、香港皮草、精品羊绒衫、针织衫等，包括恒派彩羊、蒙昭隆、蒙后、仟僖佳人等羊绒羊毛服饰品牌，北欧国度、德绒37度发热内衣、洛斯美尔等内衣品牌、以及大连梦青服饰、九尾羊服饰、上海女装等均有参展。此外，还有各类优质皮鞋、运动休闲鞋、男女包包、旅行箱、泰国乳胶枕等精品床用也将精彩亮相。厨房小家电、家用小百货也是应有尽有。因为绝大部分是厂商参展，省掉了中间商环节，价格普遍比市场上便宜30%-50%。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "川渝特产大惠，突出优质食材\n" +
                            "　　同期举办的全国土特产展，为重庆市民搭建从产地直达餐桌的高效直销平台。四川土特产抱团赴渝！包括蜀南竹海的嫩筒笋、青川的木耳、山妹子蜂蜜、马边云雾茶和跑山鸡、彭山生态黑猪肉、彭州九尺板鸭、思奇香手撕牦牛肉、自贡冷吃兔、成都刀口辣子、丹棱椒麻油、德阳老缸酿造酱油、古蔺手工面、通江银耳、剑门土鸡和羊角豆腐干等等；重庆本地特产同台竞香！包括梁平豆筋、火锅底料、合川桃片、江津米花糖、涪陵榨菜、彭水苗家土鸡、黔江米豆腐等等；此外，还有云南的野生菌和普洱茶、威海鱼罐头、大连墨鱼、舟山带鱼、宣威火腿、内蒙现磨亚麻籽油、河北大名府小磨香油、宁夏中宁枸杞、河南铁棍山药、新疆天山蓝莓、海南椰子粉、西藏野生黑燕麦、老北京年糕、大庆黑豆浆粉等等全国各地名优土特产，万千家乡味道，总有一种是你的味道。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "活动丰富实在，送送送送不停\n" +
                            "　　开展首日，将举办金秋生态鲜肉节！除了现场推介、品尝、特价购外，还有抽奖活动等你来，奖品是冰箱和洗衣机等，着实让人心跳。鲜肉节连搞三天，随后还会有山城调味品节、秋冬健康食材节等活动陆续展开。届时，你可以在现场详细了解并品尝到东北大米、卤料、肉制品等。而来自东望集团的舞蹈演员们，也将为大家献上精彩的歌舞。展会期间，还有惠民欢乐购互动游戏，参加游戏赢取各种好礼。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　据悉，重庆秋冬品牌服装博览会暨羊绒皮草全国土特产展将持续至11月3日，感兴趣的市民朋友可前往陈家坪会展中心逛展购物。\n" +
                            "\n" +
                            "交通线路：\n" +
                            "坐公交：109、118、138、139、148、231、325、341、364、365、404、421、429、464、466、469、504、806、815、823可达科园四路-陈家坪展览中心。");
            activityList.add(huodong3);
            Activity huodong4 = new Activity("huodong4", R.drawable.huodong4,R.drawable.huodong4_1 ,R.drawable.huodong4_2, R.drawable.huodong4_3,
                    "10月15日，2020重庆国际文化旅游产业博览会（以下简称“重庆文旅会”）线下展览将在重庆国际博览中心北展馆盛大开幕。据2020重庆文旅会组委会消息，本届展会上特设“双晒”成果展示专馆，重庆各大区县文旅“双晒”成果悉数亮相。届时，市民将品尝到各大区县美食，欣赏到各种特色歌舞表演，淘到多种优惠旅游产品，好看好玩耍事超多。",
                    "晒旅游精品·晒文创产品 | 百花齐放竞“双晒” 文旅会上展芳容",
                    "2020-10-14",
                    "重庆国际博览中心",
                    "   看非遗｜麦秆画、棕编小龙等悉数亮相\n" +
                            "　　一根小小麦秆能干什么呢？在能人巧匠手里，这平常的原料却可化腐朽为神奇，经过割、漂、刮、碾、烫、熏、雕、烙等十多道工序，就可成为让人叹为观止的艺术品。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　此届文旅会上，丰都麦秆雕刻画将亮相现场。作为中国民间剪贴画的一种，麦秆雕刻画色彩逼真，制作出来的古典人物系列、动物系列、花鸟系列麦雕工艺品栩栩如生，给人古朴自然、高贵典雅之美。\n" +
                            "　　除麦秆画以外，另一件重庆市级非物质文化遗产——丰都瓢画也将亮相展会。据悉，每一件瓢画作品都要经过手艺人挖瓢、打磨、绘画等几十道工序制作而成，制作一幅木瓢画，至少需要三到五天的时间。\n" +
                            "　　如果你来到万盛非遗文化展区，一定得感受一下棕编非遗文化。棕编，是汉族传统手工艺之一，采用老棕叶和棕叶芯为原料，经过传统工艺加工处理，制作出各种工艺制品经久不变形，可永久保存。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　据万盛经开区相关负责人介绍，此次展会将展出两款非遗文化产品——棕编小龙和火烧糯米酒。市民到达现场，不仅可以看到棕编小龙，还有棕编长颈鹿、乌龟等几十种动物造型工艺制品。值得一提的是，现场还有两款本地特色茶文化代表产品——黑山红和定青银毫，你既能在现场观赏到茶艺表演秀，感受万盛茶文化的精髓，还可参与丰富的抽奖活动，棕编小龙、黑山谷门票、青年汇巅峰乐园门票等礼品等你来拿。\n" +
                            "　　来到垫江展区，你肯定会被精湛的雕刻技术所吸引。据介绍，展会期间垫江角雕大师龙显国将在现场展演雕刻技术，还有非遗大石竹编工艺师将在现场展演精湛的竹编技术，除此，还能在现场看到渝中展区的葫芦烙画非遗产品制造工艺，这些悠久的历史和独特的艺术风格，值得你前去感受一番。\n" +
                            "\n" +
                            "畅玩耍｜博物馆镇馆之宝将亮相现场\n" +
                            "　　来到本届文旅会，除了打卡各种非遗文化，颇多的耍事儿可不要错过。\n" +
                            "　　你可以体验两江新区云上文旅馆，感受虚拟生态骑行的乐趣、虚拟畅游各个知名景点、体验欢乐谷摩天轮参与抽奖等，还有复古还原民国时期的霓虹灯创意墙，和通过光影配合营造的一种穿越时空之感的时空长廊，这些都能让你感受科技带来的无限体验。\n" +
                            "　　除此，在沙坪坝展区，你将能欣赏到手斫古琴的唯美，体会到木梳的精湛技艺和精彩的刺绣表演，同时，现场还设有抽奖环节，只要参与就有机会获得融创文旅城、融汇温泉城等热门景点门票，特别是在现场还设有拍照区域，市民既能拍照合影，还能将“美景 ”带回家。\n" +
                            "　　来到渝中展区，千万不要错过“渝中记忆”国画表演，感受一番国画精粹。同时，还能现场观看文创产品的展示，看点颇多。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　特别是丰都展区上演的戏牛舞，值得期待。它是民间传统舞蹈，主要模仿人或者牛日常生活特性进行的歌舞表演，热闹又好看。\n" +
                            "　　如此好玩好看的展会，自然少不了拍照打卡点。据介绍，身高3.5米的“巴南文旅形象大使”巴巴虎气模将亮相文旅会，将会成为现场的一大热门打卡点，同时，市民还可以在现场购买到巴巴虎咖啡杯、手袋、树叶画、四合胡豆等。\n" +
                            "　　说起龙泉剑，可能大家还不太熟悉，可说起古代皇帝赐给大臣们的“尚方宝剑”，那几乎是人人皆知了。制作工艺高超的龙泉剑，就是“尚方宝剑”的式样。龙泉剑，又名龙渊剑，始于春秋战国时期，距今有二千六百多年历史，是中国古代名剑，诚信高洁之剑。传说是由欧冶子和干将两大剑师联手所铸。\n" +
                            "　　文旅会上，由南滨路龙泉剑瓷博物馆珍藏的一些宝剑以及镇馆之宝——沈新培大师亲手创作的《乾坤陨铁剑》宝剑，将亮相南岸展区。这些工艺美术大师的作品，定会让你对铸剑与艺术更为了解，让我们一起“江湖论剑”。\n" +
                            "\n" +
                            "探美食｜提前打探“康熙最爱巧克力”\n" +
                            "　　喝一杯咖啡很普通，但手捧一杯“康熙最爱巧克力”，倒增添了不少文化韵味。位于故宫博物院神武门西隅的故宫角楼咖啡，是故宫博物院官方授权并且独立运营的咖啡店。自2018年12月1日官宣开业以来，每日开门即排队，顾客络绎不绝，成为神武门外一道亮丽的风景，持续位列北京咖啡厅热门排行榜第一位。\n" +
                            "　　此刻的你，不用去到紫禁城，也无须“入宫”，在文旅会南岸展区就能一睹故宫角楼咖啡“芳容”，还可买到故宫角楼咖啡文创产品。记者也了解到，故宫角楼咖啡也是此届文旅会上最大的亮点之一。\n" +
                            "　　除此，来到文旅会，你还可尝尽各大区县美食。如沙坪坝的歌乐山辣子鸡、千张（豆腐）、溶洞泉水豆芽；涪陵的榨菜、油醪糟；垫江的酱板鸭、牛肉；丰都的桑葚干、麻辣鸡等，麻麻辣辣，酸酸甜甜，只需来到文旅会现场，就能品尝各种美味。\n" +
                            "\n" +
                            "享旅游｜各大区县旅游帮你规划\n" +
                            "　　周末两日假期怎么玩？不妨去到重庆各大区县玩一玩，在文旅会现场，就有好多旅游打卡点推荐。\n" +
                            "　　比如，今年秋季，垫江主要推出拥有着灯光秀、菊花展和国际大马戏活动的牡丹樱花世界，还有可以体验虹滑道、攀爬乐园等项目的恺之峰旅游区，以及引进国内莫干山顶级的民宿运营商入驻运营管理的巴谷.宿集民宿等。\n" +
                            "　　金秋也可去到涪陵，畅游美心红酒小镇、万松里石磨纪以及沙溪温泉。也可以开启“武陵秘境”神奇之旅，游武陵山大裂谷，品石锅豆腐，玩武陵山国家森林公园等。\n" +
                            "　　说到巴南，自然少不了“打卡巴南七件事”，这其实也可作为游览巴南的“七个一”体闲体验活动，分别是泡一回康养温泉、品一壶巴南清茶、住一晚乡野民宿、赶一次原乡市集、采一篮田园瓜果、爽一把乘风破浪、嗨一场文体活动，想想，都觉得愉悦和舒畅。\n" +
                            "　　据巴南区相关负责人介绍，为了让市民感受“爽一把乘风破浪”，还将把三角翼飞机和沙滩车带进现场，让市民尽情感受“户外体验”。\n" +
                            "　　同时，在文旅会上，还将为市民准备了各种抽奖活动和优惠活动，只要你前去现场，就有机会手捧大奖满载而归哟。\n" +
                            "\n" +
                            "展会信息\n" +
                            "时间：10月15日~18日\n" +
                            "地点：重庆国际博览中心北展馆\n" +
                            "交通：\n" +
                            "    ①公共交通：到重庆国际博览中心可乘轨道交通国博线至“国博中心站4口”下车即可步行到达。\n" +
                            "    ②自驾：渝北区悦来大道66号");
            activityList.add(huodong4);
            Activity huodong5 = new Activity("huodong5", R.drawable.huodong5,R.drawable.huodong5_1 ,R.drawable.huodong5_2, R.drawable.huodong5_3,
                    "在习近平总书记和党中央的正确领导下，全国上下共同努力，疫情防控形势持续向好、生产生活秩序加快恢复，统筹推进疫情防控和经济社会发展工作取得积极成效。为进一步普及科学健身知识，提高科学健身素养，丰富体育文化生活，引导人民群众加强锻炼，提高免疫力，降低感染风险，通过参与体育活动进一步提振士气，以科学健身的生活方式迎接一个崭新开始，特举行2020年“文旅杯”大足区首届亲子定向运动赛，现将竞赛规程公布如下。",
                    "2020年“文旅杯”大足区首届亲子定向运动赛竞赛规程正式发布",
                    "2020-10-01",
                    "大足区体育中心",
                    "   主办单位\n" +
                            "重庆市大足区文化和旅游发展委员会（体育局）\n" +
                            "重庆市大足区教育委员会\n" +
                            "重庆大足城乡建设投资集团有限公司\n" +
                            "\n" +
                            "承办单位\n" +
                            "重庆市大足区体育发展中心\n" +
                            "\n" +
                            "运营单位\n" +
                            "重庆足智汇体育文化发展有限公司\n" +
                            "\n" +
                            "协办单位\n" +
                            "大足智跑公益跑团\n" +
                            "\n" +
                            "技术指导\n" +
                            "重庆市无线电定向运动协会\n" +
                            "\n" +
                            "支持单位\n" +
                            "详见补充通知\n" +
                            "\n" +
                            "比赛时间\n" +
                            "日期：2020年10月7日\n" +
                            "时间：上午9:00—12:00\n" +
                            "\n" +
                            "比赛地点\n" +
                            "大足区体育中心、大足游乐场\n" +
                            "\n" +
                            "比赛项目和组别\n" +
                            "比赛项目：积分定向赛\n" +
                            "亲子组  100组 \n" +
                            "A组【8岁（不含）以下年龄组】\n" +
                            "B组【8岁-12岁年龄组】\n" +
                            "（注：如有一名以上儿童参赛则以年龄最大儿童进行报名，每组只发放一大一小号码布）\n" +
                            "个人组  100人 \n" +
                            "A组【18岁（不含）以下青少年组】\n" +
                            "B组【18岁以上成年人组】\n" +
                            "每组别A、B分组，由组委会根据报名信息分组。\n" +
                            "\n" +
                            "参赛资格\n" +
                            "1、大足区域内学校、机关团体、企事业单位、各级各类健身组织及个人均可报名参赛。\n" +
                            "2、以下疾病患者不得报名参赛：\n" +
                            "高血压和脑血管疾病患者，心脏病和心肌炎患者，血糖过低或过高的糖尿病患者，冠状动脉病患者和严重心率不齐者，以及其他不适合运动的人员。\n" +
                            "\n" +
                            "参赛要求\n" +
                            "1、竞赛按《中国徒步定向运动竞赛规则》执行。\n" +
                            "2、参赛选手必须佩带规定的号码布，在限定时间内完成比赛。\n" +
                            "3、参赛选手出发方式由裁委会决定，出发顺序由赛事系统随机决定。\n" +
                            "4、比赛途中选手因伤、病不能完成竞赛时，可自行退赛，退赛后应尽快向终点裁判报告并及时交回比赛用图。\n" +
                            "\n" +
                            "奖励办法\n" +
                            "每个组别录取前八名\n" +
                            "一等奖：1名，奖励800元等价值奖品和证书\n" +
                            "二等奖：2名，奖励500元等价值奖品和证书\n" +
                            "三等奖：5名，奖励200元等价值奖品和证书\n" +
                            "所有完赛选手均可获得赛事奖牌，其它奖励办法详见补充通知。\n" +
                            "\n" +
                            "报名流程（请详细阅读）\n" +
                            "1、此次比赛所有选手免报名费参赛（但必须缴纳参赛指卡保证金100元，详见本文第6条）。\n" +
                            "2、比赛报名时间自2020年10月1日起至10月6日中午12时止。\n" +
                            "3、报名请填写真实个人信息，便于组委会购买相应保险，如因个人填写信息错误，不能为其购买保险，造成伤害由其自行负责。\n" +
                            "4、报名成功后，参赛选手请于10月6日9:00-18:00，前往重庆足智汇体育文化发展有限公司（地址详见下方）进行”渝康码“审核。\n" +
                            "5、审核通过后，填写《赛事免责申明》，领取竞赛指卡和参赛包。\n" +
                            "6、定向赛计时采用专业电子计时系统，选手指卡独立编号，指卡属于高科技设备，每组参与选手缴纳保证金100元，现场缴纳后开具收据，比赛结束后交回指卡和收据后，进行退款（注：保证金只接受微信或支付宝电子支付）。\n" +
                            "\n" +
                            "联系方式\n" +
                            "伍老师：13608311577（微信同号）\n" +
                            "朱老师：17781449494（微信同号）\n" +
                            "\n" +
                            "足智汇体育地址\n" +
                            "重庆市大足区体育中心体育场1-5\n" +
                            "\n" +
                            "比赛流程\n" +
                            "1、8:00-9:00   参赛选手到达起点报到处检录，佩戴口罩，配合进行体温检测、消毒工作。\n" +
                            "2、9:00-9:30   举行开幕式。\n" +
                            "3、9:30-10:30 参赛选手按指定出发批次领取地图打卡出发。\n" +
                            "4、11:00-12:00统计成绩，举行颁奖仪式。\n" +
                            "\n" +
                            "裁判与仲裁\n" +
                            "1、裁判员和仲裁：由重庆市无线电定向运动协会委派。\n" +
                            "2、申诉：裁判委员会仅接受书面申诉。请在成绩公布1小时内将申诉书连同申诉费提交裁判委员会，情况属实，退还申诉费。\n" +
                            "\n" +
                            "疫情防控措施\n" +
                            "各参赛选手和单位应严格遵守大足区有关加强新型冠状病毒感染的肺炎预防控制工作的相关规定，遵守各公共场所疫情期间的管控措施，确保相关赛事工作安全、有序开展。\n" +
                            "1、严格配合承办单位、执行单位进行实名登记、体温检测，提供“渝康码”，科学佩戴口罩，参赛选手出现发热、干咳等症状及时报告。\n" +
                            "2、参赛选手个人物品，如比赛器械、装备、衣物、水杯、毛巾等，做好消毒工作，禁止与他人共用。\n" +
                            "3、保持安全的社交距离，避免人员聚集和近距离接触。\n" +
                            "4、不得带病参加，出现发热、干咳等症状时，应及时报告，并参照《大足区新型冠状病毒感染的肺炎预防控制应急方案》执行。\n" +
                            "5、参赛选手活动前十四日内有出入境或往来中高风险地区情况的，不得参加活动。\n" +
                            "\n" +
                            "比赛定向地图信息\n" +
                            "地图制作：黄义军  胥彪\n" +
                            "线路设计：伍斌\n" +
                            "地图修测：2020年10月\n" +
                            "比 例 尺：1:3000\n" +
                            "等 高 距：2.5米\n" +
                            "制图规范：ISSprOM 2019\n" +
                            "\n" +
                            "其它事宜\n" +
                            "本规程未尽事宜另行通知，最终解释权归赛事组委会所有。\n" +
                            "\n" +
                            "\n" +
                            "2020年“文旅杯”大足区首届亲子定向运动赛\n" +
                            "赛事组委会\n" +
                            "2020年10月1日");
            activityList.add(huodong5);

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.huodong_lunbo1, R.drawable.huodong_lunbo2,
                R.drawable.huodong_lunbo3, R.drawable.huodong_lunbo4,R.drawable.huodong_lunbo5
        };

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }
    }

}
