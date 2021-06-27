package com.example.trainapp.fragment;

import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.trainapp.R;
import com.example.trainapp.adapter.Text2Adapter;
import com.example.trainapp.base.BaseFragment;
import com.example.trainapp.entity.Activity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


/*
 * 专题页面的Fragment
 * */

public class SpecialFragment extends BaseFragment {

    private List<Activity> activityList = new ArrayList<>();
    private RecyclerView flNews;

    private static final String TAG = "SpecialFragment";
    private boolean mIsTouch = false;


    private LinearLayout mLinearLayout;

    private RollPagerView mRollViewPager;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.news_fragment, null);

        initActivity();


        // 2. 初始化轮播图
        mRollViewPager = view.findViewById(R.id.mRollViewPager);
        mRollViewPager.setPlayDelay(2000); // 设置播放时间间隔
        mRollViewPager.setAnimationDurtion(500); // 设置透明度
        mRollViewPager.setAdapter(new TestNormalAdapter()); //  设置适配器
        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.shape_bg_point_enable, R.drawable.shape_bg_point_disable));
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));

        flNews = (RecyclerView) view.findViewById(R.id.fl_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        flNews.setLayoutManager(layoutManager);
        Text2Adapter text2Adapter = new Text2Adapter(mContext,activityList);
        flNews.setAdapter(text2Adapter);

        return view;
    }

    private void initActivity() {
        for (int i=0;i<1;i++) {
            Activity special1 = new Activity("special1", R.drawable.special1,
                    "感受一场粉色花雨，置身浪漫摩围，尽情享受“天然氧吧”。明天周末了，一起去踏青吧，摩围山见，人间仙境。\n" +
                            "　　彭水摩围山景区地处重庆彭水县南部，平均海拔1500米，属于彭水南部“百里乌江画廊”的中下段，面积约十万亩，森林覆盖率达91%，年平均气候14.9℃，年均降水量1400MM，年均降雪日数40天，负氧离子含量高达11万个/cm³，距县城25公里，距主城约2.5小时车程。",
                    "踏青赏春，就到醉美摩围山！",
                    "2021-03-23",
                    "感受一场粉色花雨，置身浪漫摩围，尽情享受“天然氧吧”。明天周末了，一起去踏青吧，摩围山见，人间仙境。",
                    "   摩围山景区自然资源丰富，生态景观奇特，有一线天地缝、石窟溶洞、百里石林、千仞绝壁、万丈天坑等地质奇观;有云雾幻化、旭日升腾、彩霞缤纷等天象丽景；有名药山珍、奇腾异草、山花野果、千里碧海、古木参天等山林秀色。\n" +
                            "　　唐代诗人白居易曾写诗赞道：不醉黔中争去得，摩围山色正苍苍。摩围山的春天，到处一片翠绿，乘着春风，悄悄然花开漫野，在不经意间发现惊喜，尽享最美的春天。\n" +
                            "\n" +
                            "　　摩围山负氧离子含量极高，被称为“悬在天堂上的氧吧。经重庆林科院测试，解放碑负离子含量为300—500个/cm³左右，缙云山900个/ cm³，涪陵武陵山国家森林公园1000个/cm³，而摩围山最高竟达到了11万个／cm³，是解放碑的220倍之多。\n" +
                            "　　医学研究证明，空气负氧离子有强身、保健、防治疾病功能，增加血液中的氧含量。1000个／cm³以上有利于人体健康；在8000个／cm³以上可治疗哮喘、慢性支气管炎、偏头痛及冠心病、高血压等疾病。\n" +
                            "　　飞云口、罗曼谷、养生登山道、豹头崖、摩围石林、健身天梯、休闲花道、高山草场……一步一景，在摩围石林漫步，才能享受大自然带来的乐趣；在豹头崖呼吸，才能近距离感受原生态的美妙。\n" +
                            "\n" +
                            "　　一声清脆的鸟语，助您进入忘我境地，一片飘逸的落叶，让您滋生亲近大地之情；这里的每一幢木屋，都与参天松柏相伴，在森林地气的滋润中，点缀在林间，若隐若现，雾气缭绕，仿佛人间仙境，与摩围林海交融为一。\n" +
                            "　　摩围山，一座千古名山，苗家神山，郁郁森林，轮番上演金银花海、林涛送爽、彩林果香、无愧养生胜地美誉。\n" +
                            "\n" +
                            "旅游路线\n" +
                            "1、自驾车路线：主城-渝湘高速G65-彭水西-乌江四桥-摩围山景区\n" +
                            "2、长途汽车：四公里交通换乘枢纽-彭水汽车站-摩围山景区");
            activityList.add(special1);
            Activity special2 = new Activity("special2", R.drawable.special2,
                    "青草坝萝卜“多吃萝卜，少吃yo（药）”“冬吃萝卜夏吃姜”“青草坝，萝卜大，不放油盐吃得下”“青草坝的萝卜，（顺）带不得”勒些合川民间流传的谚语，很大程度上说明青草坝的萝卜是“砂罐萝卜”、个头大、食用价值高。作为重庆市市级非物质文化遗产名录的青草坝萝卜卷，有必要给大家普及一下它的前世今生。",
                    "非遗 ▏青草坝萝卜卷的前世今生",
                    "2019-04-08",
                    "作为重庆市市级非物质文化遗产名录的青草坝萝卜卷，有必要给大家普及一下它的前世今生。",
                    "   青草坝萝卜的前世\n" +
                            "　　青草坝种植盛产萝卜的历史悠久，他们自己也说不清楚是从什么时候开始大面积种植萝卜的。他们只晓得青草坝出产的优质萝卜，只能在青草坝生长，离开青草坝就会“入乡随俗”，会变异。上世纪90年代，原合川县蔬菜站在青草坝搞萝卜种“提纯扶壮”实验，即把青草坝的萝卜种在全县推广，结果试种仅两年，在别的地方长出来的萝卜，全变成了普通的萝卜，各种优良特性都没了。更神奇的是，青草坝的土地具有“兼容性”，外地萝卜在青草坝种上两年，也会变成正宗的“砂罐萝卜”。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　位置：青草坝上有一个美丽的村庄，名叫青坝村，原属合川码头乡，后合并到合川龙市镇管辖。\n" +
                            "　　传奇：传说当年曹操下江南，路过青草坝，83万人马行军困乏饥饿，幸缝青草坝萝卜成熟，他们也只是吃下了半个萝卜，剩下的半个萝卜化成水，沿河汹涌而下，把下江人淹得喊天叫地，洪水三天不退！\n" +
                            "　　据当地人说，抗战时期，重庆成为国民政府“陪都”，身在重庆的蒋介石点名要吃渠河二郎滩下青草坝的萝卜和萝卜卷，使之名声大噪，在重庆成为抢手货。很多上了岁数的人都知道青草坝的萝卜是萝卜中的极品，“青草坝，萝卜大，不放油盐吃得下”。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　据当地的百岁老人高百诚回忆，其祖上种植青草坝萝卜可能始于清乾隆41年左右。1924年，大户李九成，组织农民大力种植青草坝萝卜，用船运往周边及江浙一带贩卖，一举成为当地有名的富翁。\n" +
                            "　　民国时，青草坝年年都在禹王庙做庙会，庙会上就用青草坝萝卜做菜吃斋。同时还要评选“萝卜大王”，谁家的萝卜最大最重就是“萝卜大王”，要搭台唱戏以庆贺丰收，据说有位叫孔合川的保长家，就出了个10多斤重的大萝卜。\n" +
                            "\n" +
                            "青草坝萝卜的今生\n" +
                            "　　早在20世纪初，青草坝萝卜就远销四川、江浙等地。近年来，其相关产品“青草坝萝卜丝”和“青草坝萝卜卷”被乡人远带香港、台湾、新加坡等地，深受食客欢迎。而今，青草坝萝卜卷的制作技艺更是被列入重庆市市级非物质文化遗产名录。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "制作工艺\n" +
                            "　　选料：种子要过“体检”和“选美”两关。萝卜秧秧也要“竞争上岗”。\n" +
                            "　　清洗：严格的选料清洗。\n" +
                            "　　切片：萝卜切成片要用独门“鸳鸯刀法”将萝卜切成片——正切一刀，反切一刀，使片与片之间“首尾相连”，挂起来，形如猴子捞月亮。\n" +
                            "　　晾晒：将萝卜片挂在竹桩竹篾搭成的架子上，安放在阳光充足或通风的地方，晒干或阴干。\n" +
                            "　　腌码：到一定程度之时，再加适量的盐进行腌码。\n" +
                            "　　装坛：装在瓦制的坛子里面腌制两周左右。\n" +
                            "　　调料：萝卜卷的馅调料要选用生姜（必须是老姜，嫩姜要烂）、花椒和辣椒粉、上等芝麻粉、味精、麻油、香油、白糖、盐，可按照个人口味进行灵活改变。将所用调料均匀搅拌之后就可以开始包裹萝卜卷了。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　包卷：把一张腌制好的萝卜片适当用力展平，将调制好的适量姜丝整齐的放在萝卜皮上，再用力慢慢裹卷。最后，萝卜卷上还要系上一条绿色的“腰带”，由蒜苗制成，所用的蒜苗也有讲究，必须是青草坝的，要新鲜，颜色深绿无黄色并有一定的长度，事先还要加入少许盐腌一两个小时，待到蒜叶变软，有韧性能，能撕成丝条才行。\n" +
                            "　　二次装坛：将制作好的萝卜卷再次装坛。\n" +
                            "\n" +
                            "价值\n" +
                            "　　萝卜作为我国最古老的蔬菜之一，还具有客观的药用价值。传承人周克建嘴里还念叨着顺口溜“冬吃萝卜夏吃姜，不用医生开药方”，他说，立了冬的萝卜就是小人参！\n" +
                            "　　现代科学证明，萝卜含有多种人体必需的维生素和氨基酸，还有防癌、抗癌、补血、治痛风、减肥等功效。因此，萝卜成为大家餐桌上钟爱的菜肴也就是很正常的事情了，而独特的青草坝萝卜和青草坝的萝卜卷就更不例外了。难怪当地老百姓说，我们青草坝上百岁的老人都有，八九十岁的老人就多得很了。看来，青草坝的萝卜真能让人延年益寿！\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　而今，让更多人知道青草坝萝卜的，不仅是它特殊的生长环境，更重要的是青草坝萝卜卷的制作工艺，经过上百年的传承，它的清香和味道已经穿越了历史的时空，形成了一种独特的文化！");
            activityList.add(special2);
            Activity special3 = new Activity("special3", R.drawable.special3,
                    "春风微微一吹，粉红色的花瓣如雪般，伴随着阳光忽闪忽闪地落下，落在你肩头的发丝间，如此浪漫的景色，这辈子总要体验一次才行。\n" +
                            "　　春天的綦江很温柔，而置身这片樱花林，不仅让你少了往日的忙碌紧张，更容易让人沉醉于春风，享受片刻的慵懒轻松。悄悄告诉大家，这里赏花也免费。还不快约上朋友，一起在春日里燥起来吧筒子们！",
                    "藏在綦江老瀛山景区的这片樱花林，开得正好还不打挤",
                    "2019-04-09",
                    "四月伊始，綦江国家地质公园老瀛山景区的樱花花开正浓，粉白的樱花一朵、两朵，一簇、两簇连成片，汇成了花花世界。",
                    "   四月伊始，綦江国家地质公园老瀛山景区的樱花花开正浓，粉白的樱花一朵、两朵，一簇、两簇连成片，汇成了花花世界。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　春风微微一吹，粉红色的花瓣如雪般，伴随着阳光忽闪忽闪地落下，落在你肩头的发丝间，如此浪漫的景色，这辈子总要体验一次才行。\n" +
                            "　　春天的綦江很温柔，而置身这片樱花林，不仅让你少了往日的忙碌紧张，更容易让人沉醉于春风，享受片刻的慵懒轻松。悄悄告诉大家，这里赏花也免费。还不快约上朋友，一起在春日里燥起来吧筒子们！\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "交通攻略\n" +
                            "1、自驾路线：从重庆主城区出发，经江南立交上内环，沿渝黔高速行进，40余公里后到达綦江区，不用下道，继续往原万盛方向前进，在前方约10公里处的通惠下道，然后往三角镇方向行驶，约20公里就可到达老瀛山景区。\n" +
                            "2、 汽车交通：重庆菜园坝、汽车北站都均有到达綦江城区的长途公交车，然后在綦江二级车站乘坐到红岩坪的客车（老瀛山停车广场）下车，徒步10分钟到达景区游客中心。");
            activityList.add(special3);
            Activity special4 = new Activity("special4", R.drawable.special4,
                    "　近日，万州区文旅委主任熊刚、副主任肖智率规划产业科先后会同长滩镇、梨树乡、甘宁镇、瀼渡镇、太龙镇相关负责人一行深入潭獐峡、中华易温泉、大瀑布、新月湾景区、小桔灯生态文化旅游区等“一心六型”重点旅游项目，进行了现场指导和服务，重点从文旅融合、景区提质增效、加快建设等方面提出意见。",
                    "万州中华易温泉、大瀑布、新月湾景区……这些项目将有重大发展！",
                    "2019-04-09",
                    "近日，万州区文旅委主任熊刚、副主任肖智率规划产业科先后会...",
                    "   近日，万州区文旅委主任熊刚、副主任肖智率规划产业科先后会同长滩镇、梨树乡、甘宁镇、瀼渡镇、太龙镇相关负责人一行深入潭獐峡、中华易温泉、大瀑布、新月湾景区、小桔灯生态文化旅游区等“一心六型”重点旅游项目，进行了现场指导和服务，重点从文旅融合、景区提质增效、加快建设等方面提出意见。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "深挖文化，打造特色景区\n" +
                            "　　万州大瀑布景区要充分彰显甘宁将军和地方文化内涵，增强景区活力。新月湾景区加大獽人、伤兵梁、张光斗水电站、三峡库区全迁移民第一镇等巴楚文化、抗战文化、水电文化和移民文化融合，展示景区特色，切实做好24栋古民居和大佛寺迁建落户景区的项目前期土地征用和投资保障性工作。\n" +
                            "　　小桔灯生态文化旅游区要深入挖掘三峡文化，打造影响长江三峡的核心竞争力平台。\n" +
                            "\n" +
                            "规划先行，引领项目发展\n" +
                            "　　按照征求部门意见、专家行政组评审、区政府常务会议审议程序，区文旅委加强对新月湾总体规划、小桔灯生态文化旅游项目规划的指导，把好政策关、标准关、评审关，增强规划的实效性和落地性，进一步完善和提升项目规划的理念和创意，论证和研判产品的客源市场、投资回报的赢利点。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "守住底线，加快项目建设\n" +
                            "　　积极对接相关部门、镇乡，在建项目需严守生态红线、基本农田、三峡库区生态屏障、公益林、风景名胜区等政策底线，明确项目范围和边界，做好土地流转、土地征用、青苗补偿等前期工作，加快项目建设，力争早日对外营业。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "完善配套，提升景区质量\n" +
                            "　　重点做好旅游接待中心、停车场、标识标牌、特色餐饮、旅游厕所等配套设施建设。规范优化景区环境，重点治理摆摊设点、乱停乱放、垃圾广告、标识标牌、环境卫生等方面的乱象，提高游客满意度。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "抢抓机遇，打造拳头产品\n" +
                            "　　万州大瀑布以创建国家5A级旅游景区为契机，要加大投入，不断完善和提升景区核心竞争力，重点要调整营销和经营方式，拉长旅游消费链条，加快从门票经济向产业经济的转型发展。\n" +
                            "　　中华易温泉要加大资金投入，绿化美化亮化景区环境，突出易经文化特色，力争今年对外营业。\n" +
                            "　　新月湾景区要抢抓沿江快捷道路建设机遇，重点定准位，立准形，打准牌，对准标，抓引爆点，抓消费点，抓发展点，抓特色点，建设成为具有核心引爆力、吸引力的旅游精品景区");
            activityList.add(special4);
            Activity special5 = new Activity("special5", R.drawable.special5,
                    "近日，石柱再度登上荧屏，《康养胜地 秘境石柱》在发现之旅频道和香港卫视同时播出，30分钟完整版震撼来袭！这里地处神秘的北纬30度，是中国陆海版图的几何中心。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　这里是土家人世代生活的地方，拥有森林、草场、溪流、湖泊、奇峰、溶洞、峡谷等多种自然景观。壮美与柔情在此交融，狂野与恬静在此碰撞。这里重庆的后花园，长江边的康养胜地。视频里详细记录了石柱的美丽，其中是否有你熟悉的地方？",
                    "近日，重庆石柱同时登上央视和香港卫视",
                    "2019-04-09",
                    "近日，石柱再度登上荧屏，《康养胜地 秘境石柱》在发现之旅频道和香港卫视同时播出，30分钟完整版震撼来袭！这里地处神秘的北纬30度，是中国陆海版图的几何中心。",
                    "   近日，石柱再度登上荧屏，《康养胜地 秘境石柱》在发现之旅频道和香港卫视同时播出，30分钟完整版震撼来袭！这里地处神秘的北纬30度，是中国陆海版图的几何中心。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　这里是土家人世代生活的地方，拥有森林、草场、溪流、湖泊、奇峰、溶洞、峡谷等多种自然景观。壮美与柔情在此交融，狂野与恬静在此碰撞。这里重庆的后花园，长江边的康养胜地。视频里详细记录了石柱的美丽，其中是否有你熟悉的地方？\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "土家文化深厚　《太阳出来喜洋洋》在这唱响\n" +
                            "　　作为“中国民间艺术之乡”，石柱具备深厚的文化底蕴。这里拥有土家啰儿调、土家族吊脚楼营造技艺、土家族玩牛等3项国家级非物质文化遗产，以及14项市级非物质文化遗产。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　许多人来石柱，最先体验的就是原汁原味的土家文化。一曲悠扬高亢的“太阳出来喜洋洋”唱响世界；一场热情奔放的“摆手舞”，跳出了土家人的情和意；通俗有趣的玩牛表演，更是唤起了人们儿时的记忆……\n" +
                            "　　梦开始的地方，岁月绵长，梦也绵长。当红日之光铺向大地，世间万物勃发，石柱向全世界唱响了民歌中的绝唱。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "历史底蕴十足　英雄秦良玉曾在这封侯拜将\n" +
                            "　　秦良玉，我们既熟悉又陌生的名字。一位女性，出于爱国热情，能够万里请缨，抗击侵略，这行动无疑令人感动。她是黔东土司首领的一面旗帜，全心全意保护当地人民，使之安居乐业。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　在历史的岁月中，独具特色的“秦良玉文化”，以此为代表的辉煌史实，经过长期积淀，形成了宝贵的物质文化和非物质文化遗产，构成了石柱一道独特的风景线。如今古人已如尘埃般被风暴湮灭，但不朽的精神依旧存留者。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　在石柱万寿古寨、万寿山、秦良玉陵园等地方，你依旧能感受到感怀秦良玉这些奇女子的英姿飒爽、忠勇无畏。\n" +
                            "\n" +
                            "盐运闻名四方　千年前巴盐古道在这起点\n" +
                            "　　西沱古镇位于重庆市石柱县西北端长江边，是因古代商业发展而兴起的古镇。它曾与周庄乌镇齐名，第一批入选我国历史文化名镇。\n" +
                            "　　古镇中的云梯街是川盐济楚——巴盐古道的起点，街道沿山脊走向由长江岸边直达山顶，是唯一一条垂直于长江江岸的街道，故称万里长江第一街。\n" +
                            "　　历史上楚湘一带缺盐，而蜀地忠县的临江又盛产井盐，如何将临江的盐运到缺盐的楚湘之地呢？如果通过长江水运，上有乌江天险，下有三峡阻隔，当时条件有限，只能靠陆路运输。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　于是勇敢、彪悍、尚武、勤劳的古人披荆斩棘，在崇山峻岭之中，依崖凿道、伐木开路、遇水搭桥、以石为垒，开辟出了一条“川盐销楚”的巴盐古道。\n" +
                            "　　在西沱，成千上万吨的货物靠着一群群背夫们的双肩双脚，沿着1124步台阶的云梯街驮出了这大山。 如今徜徉在古镇里，顺着云梯街拾级而上，从江边码头一直蜿蜒前行通到古镇之巅，两旁林立着的是层层叠叠的穿木斗拱的渝东风格建筑。\n" +
                            "　　其间有紫云宫、禹王宫、万天宫、桂花宫等古建筑遗迹。\n" +
                            "\n" +
                            "著名康养圣地　山灵水秀如诗如画般存在\n" +
                            "　　说起重庆康养圣地，石柱应算得上是明星。这里有森林、有湖泊、有草场，自然犹如山水画般的秀丽。天蓝、云白、山青、草绿，这就是石柱给广大游客的第一印象。\n" +
                            "　　大风堡位于石柱县黄水镇，作为巴渝新十二景“黄水林海”，植被覆盖率达95%，负氧离子的含量最高达每立方厘米6000个以上，夏季平均温度21℃。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　境内山峦叠翠、绿波万顷，云蒸霞蔚、蔚然壮观，林涛阵阵、蝉鸣声声，山间沟壑泉水叮咚、流水潺潺，风景资源丰富，是久负盛名的“天然氧吧”。\n" +
                            "　　千野草场位于石柱县鱼池镇，平均海拔1300米，地势宽广平坦，空气负离子含量较高，夏季平均温度21℃，绝对是避暑纳凉的好地方。\n" +
                            "　　这里，久居两位可爱的主人——牛与羊，俯身一温柔的触摸亦或喂食，观牛羊遍地，感悟“天苍苍、野茫茫，风吹草低见牛羊”的南国草原美景，简单亦美好。\n" +
                            "　　云中花都位于石柱县冷水镇八龙村半仙花果山，园区面积3000亩，森林景观1700亩，果蔬采摘800亩，观赏花卉500亩。去年云中花都3D空中漂流、5D云端吊桥、花都飞舞等娱乐项目的对外开放，让云中花都一跃成为重庆著名旅游打卡景区。\n" +
                            "　　油草河、月亮河、佛莲洞、药用植物园......石柱美丽的地方实在太多太多，都值得你依次来打卡。\n" +
                            "\n" +
                            "物产美食众多　满满都是记忆中的味道\n" +
                            "　　石柱之美不仅仅只是这些，石柱黄连举世闻名，全国60%、全球40%的黄连产于这里，素有“中国黄连之乡”的美誉。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　土家族醇香的咂酒更是受到广大游客的青睐。目前，石柱已建成川渝最大的辣椒种植基地，有“中国辣椒之乡”之称，同时还拥有全世界最大的莼菜基地。\n" +
                            "　　除富饶物产外，石柱土家特色美食也是吸引游客的最大特色之一，更是石柱的一大点缀。腊猪蹄、野生菌、斑鸠叶豆腐、莼菜、都巴块......每一种都是你无法抵挡的诱惑。\n" +
                            "2019，来石柱，寻找你的诗与远方吧！\n");
            activityList.add(special5);

        }
    }


    private void selectedPoint(int realPosition) {

        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            View point = mLinearLayout.getChildAt(i);
            if (i == realPosition) {
                point.setBackgroundResource(R.drawable.shape_point_selected);
            } else {
                point.setBackgroundResource(R.drawable.shape_point_normal);
            }
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.special_lunbo1, R.drawable.special_lunbo2,
                R.drawable.special_lunbo3, R.drawable.special_lunbo4,R.drawable.special_lunbo5
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
