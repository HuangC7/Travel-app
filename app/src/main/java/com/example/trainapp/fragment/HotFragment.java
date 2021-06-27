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
 * 热点页面的Fragment
 * */

public class HotFragment extends BaseFragment {

    private List<Activity> activityList = new ArrayList<>();
    private RecyclerView flHot;

    private static final String TAG = "HotFragment";

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

        flHot = (RecyclerView) view.findViewById(R.id.fl_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        flHot.setLayoutManager(layoutManager);
        Text2Adapter text2Adapter = new Text2Adapter(mContext,activityList);
        flHot.setAdapter(text2Adapter);

        return view;
    }

    private void initActivity() {
        for (int i=0;i<1;i++) {
            Activity hot1 = new Activity("hot1", R.drawable.hot1,
                    "近期，重庆又有一批景区被批准为国家4A级旅游景区。其中包括重庆黔江官村景区、重庆江津中山古镇旅游景区、重庆开州龙头嘴森林公园、重庆万州三峡平湖旅游区、重庆潼南陈抟故里景区、重庆武隆芙蓉江景区、重庆石柱西沱古镇景区、重庆奉节青龙镇大窝景区。",
                    "重庆新晋一批国家4A级旅游景区",
                    "2021-01-09",
                    "近期，重庆又有一批景区被批准为国家4A级旅游景区。",
                    "   其中包括重庆黔江官村景区、重庆江津中山古镇旅游景区、重庆开州龙头嘴森林公园、重庆万州三峡平湖旅游区、重庆潼南陈抟故里景区、重庆武隆芙蓉江景区、重庆石柱西沱古镇景区、重庆奉节青龙镇大窝景区。\n" +
                            "\n" +
                            "重庆江津中山古镇旅游景区\n" +
                            "　　中山古镇位于重庆市江津区南部的笋溪河畔，地处渝、川、黔三省（市）交界处，是“中国历史文化名镇”、“中国最美小镇”、“重庆市特色景观旅游名镇”。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　这里有西南地区保存最完好的明清商业老街；有享誉全国“十大经典爱情故事”的爱情天梯；有参禅朝圣的四面山少林寺；有石板糍粑、烟熏豆腐、咂酒等为代表的古镇名小吃；还有“千米长宴”、“石板糍粑节”、“七夕东方爱情节”等特色民俗文化活动，享誉国内外。\n" +
                            "\n" +
                            "位置：江津中山镇\n" +
                            "自驾：主城—内环快速—重庆绕城高速—江习高速—中山古镇\n" +
                            "周边：江津四面山、爱情天梯、清溪沟\n" +
                            "\n" +
                            "重庆潼南陈抟故里景区\n" +
                            "　　陈抟故里景区位于我区崇龛镇，这是一座千年古镇，是道教至尊陈抟老祖的故里。境内历史古迹众多，旅游资源丰富，有八角井、陈抟塑像、睡仙楼、太极塔、太极古镇、千佛岩、玉佛寺等自然、人文景观。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　清澈的琼江穿境而过，36.9米高的陈抟老祖铜像巍然屹立，春天漫天金黄的油菜花海尤为著名。\n" +
                            "位置：潼南崇龛镇\n" +
                            "自驾：主城—渝遂高速—潼南下道—双江镇—陈抟故里景区\n" +
                            "周边：双江古镇、大佛寺\n" +
                            "\n" +
                            "重庆武隆芙蓉江景区\n" +
                            "　　芙蓉江景区以规模宏大的“U”形峡谷为主，是一个江峡型小尺度大容量喀斯特地貌和原始水上森林型风景区。这里江水碧绿发蓝，两岸苍劲树根千姿百态、水鸟飞舞、钟乳垂挂、飞泉流瀑、绿影婆娑，自然风光尤其独特，融山、水、洞、林、泉、峡一体，集雄、奇、险、秀、幽、绝于一身。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　原始植被密植两岸，泉水瀑布高挂飞流，令峡谷显出一个\"秀\"字来。两岸的山峰，奇特伟岸，或群中酷似伟人，或单立如笋直入云峰，叫人思绪万千。\n" +
                            "位置：武隆江口镇\n" +
                            "自驾：主城—内环快速—包茂高速—厦成线—芙蓉江\n" +
                            "周边：仙女山、天生三硚、龙水峡地缝\n" +
                            "\n" +
                            "重庆石柱西沱古镇景区\n" +
                            "　　西沱古镇，位于石柱千野草场之下、长江南岸，与长江明珠——石宝寨隔江相望。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　西沱古镇，因为整条街都是沿着一条巨大的青石，依山就势，蜿蜒而上，直上云霄，状如云梯，所以又叫“云梯街”，又称为云梯式场镇，迄今还保存有完好的汉砖和罕见的第三冰川世纪巨大的古树化石群。\n" +
                            "位置：石柱西沱镇\n" +
                            "自驾：主城—沪渝南线高速—银百高速—西沱镇\n" +
                            "周边：黄水镇、千野草场   \n" +
                            "\n" +
                            "重庆黔江官村景区\n" +
                            "　　官村景区，位于黔江区冯家街道，面积1.58平方公里，是阿蓬江国家湿地公园核心景观区。景区主要包括中坝家园、阿蓬江湿地、阿蓬江花卉园、桃花溪、植裕生态观光园、官村坝等景观景点。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　官村景区自然人文景观资源富集，百户所、大堡文化遗址、官村古寨、寨子旧乡、石鸡坨土陶、黔江县志、土家婚俗、苗族民族服饰、土家族民族服饰、寨子麻糖、寨子苕粉，不胜枚举。\n" +
                            "位置：黔江冯家街道寨子社区\n" +
                            "自驾：主城—内环快速—包茂高速—洞塘隧道—正阳隧道—正舟路—管村景区\n" +
                            "周边：爱莉丝庄园、濯水古镇\n" +
                            "\n" +
                            "重庆开州龙头嘴森林公园\n" +
                            "　　重庆龙头嘴森林公园位于开州区西北部紫水乡境内，属大巴山脉支脉，是万达开川渝统筹发展示范区的地理中心。景区海拔高度1200-1600m，四季有四景，春天山花烂漫、夏季林海苍翠、秋末彩叶绚丽、隆冬玉树琼花，令人流连忘返。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　景区内现已打造真人CS、山地车赛场、飞拉达拓展基地、攀岩基地、露营基地和川主庙等众多景点和体验性项目，想要赏雪耍雪的你，不妨抽空去游玩一下。\n" +
                            "位置：开州紫水乡\n" +
                            "自驾：主城—沪渝高速—沪蓉高速—恩广高速—青秀街—X035—龙头嘴森林公园\n" +
                            "周边：仙女洞、雪宝山、汉丰湖\n" +
                            "\n" +
                            "重庆万州三峡平湖旅游区\n" +
                            "　　万州山水相连，逶迤的山脉、宁静的湖面，让平湖万州格外惹人陶醉。\n" +
                            "　　三峡平湖旅游区被中央电视台评为新三峡“十大旅游新景观”之一，是典型的山水相依、湖城相融的城市型旅游区。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "　　说到万州三峡平湖旅游区不得不提的还有三峡移民纪念馆。馆内既展现三峡移民精神的《伟大壮举辉煌历程》，又布展了从万州旧石器时期到民国时期的社会发展脉络的《万川汇流》。\n" +
                            "位置：万州南滨大道\n" +
                            "自驾：主城—沪渝高速—沪蓉高速—沪蓉线—三峡平湖旅游区\n" +
                            "周边：万州大瀑布\n" +
                            "\n" +
                            "重庆奉节青龙镇大窝景区\n" +
                            "　　龙镇大窝社区，曾为奉节原一磺厂所在地。现一磺厂经过转型改造，依靠工业遗址和当地独有的自然风光，吸引了众多游客前来游览观赏。\n" +
                            "　　天蓝、地绿、水清、宁静……如今的大窝社区看到的没有荒山，而是满目的翠绿。院落鲜花遍植，道路干净整洁，群众安居乐业。\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "位置：奉节青龙镇\n" +
                            "自驾：主城—沪渝高速—分界梁隧道—诗城西路—奉利路—大窝景区\n" +
                            "周边：白帝城、瞿塘峡、天坑地缝");
            activityList.add(hot1);
            Activity hot2 = new Activity("hot2", R.drawable.hot2,
                    "8月，夏尽秋来，高温持久不下，根据气象预测，这个周末气温将超37度。日前，重庆市气候中心和气象服务中心通过气温检测，选出了100个清凉乡镇（街道），秀山涌洞乡川河盖上榜，这个周末我们一起到川河盖避暑、露营、看星星去！",
                    "周末到川河盖露营看星星去！",
                    "2020-08-26",
                    "8月，夏尽秋来，高温持久不下，根据气象预测，这个周末气温将超37度。",
                    "   日前，重庆市气候中心和气象服务中心通过气温检测，选出了100个清凉乡镇（街道），秀山涌洞乡川河盖上榜，这个周末我们一起到川河盖避暑、露营、看星星去！\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　这里有春冬，无夏秋，已成为贵州、湖南、湖北、避暑休闲生态旅游游的新选择。川河盖平均海拔1200米，高悬云际，视野开阔，站在山巅之上，观日出云海，神奇的自然风光，目之所及，郁郁葱葱，宛如大草原。被称为“武陵第一盖”、“世界最大的桌山”，是渝东南唯一一片草场、花海特色兼具的大型高山型生态景观区，全年平均气温12.1°C，当前盖上白天温度不超出26℃，晚上下降到20℃以下，景区内的酒店都没有配置空调，晚上睡觉还盖铺盖。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　曾经只在迪士尼乐园才有的快感，就在川河盖。放飞自我，自由自在，享受风驰电掣，急速直下的超长230m滑道、宽度20m、坡度比13%、落差30m、50迈速度，超速、超爽、超刺激体验“七彩滑道”。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　农家乐好吃好玩又凉爽。到了川河盖，景区内设有一处美食区，许多当地居民在此开设了小吃摊，售卖秀山当地特色小吃米豆腐、油粑粑，绿豆粉，还有手工冰凉粉等消暑甜品供游客品尝。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　森林小屋农家乐美食更是你无二的选择，食材都是杨胜友自己亲手种养的新鲜蔬菜和土猪，土鸡，收费不高，每餐收费40元/人，因菜品味道好、价格公道，得到众多游客的青睐。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "出行路线\n" +
                            "自驾：1.重庆（413公里））渝湘高速秀山县城水源头快速通道川河盖（索道）\n" +
                            "2.重庆（413公里）渝湘高速洪安高速出口洪安乡道-新田沟村川河盖（45道拐）\n" +
                            "温馨提示：川河盖景区公路（包括平川公路45道拐）限9座以下车辆通行");
            activityList.add(hot2);
            Activity hot3 = new Activity("hot3", R.drawable.hot3,
                    "受双晒效应+恢复跨省市团队旅游+避暑季的三重利好刺激，上周刚刚完成“双晒直播”的石柱县，旅游人气“热”了起来。\n" +
                            "　　连日来，万寿山、大风堡、西沱古镇、千野草场、云中花都等不同属性的风景区，客流量明显优于疫情期间；而黄水镇、冷水镇及中益乡，前来避暑的游客和长租客也多了起来。",
                    "多重利好提振旅游人气， “康养石柱”人气比天“热”",
                    "2020-08-06",
                    "受双晒效应+恢复跨省市团队旅游+避暑季的三重利好刺激，上周刚刚完成“双晒直播”的石柱县，旅游人气“热”了起来。",
                    "   多重利好提振旅游人气\n" +
                            "　　石柱县委副书记、县政府县长左军的双晒直播，热效应正在释放。在双晒直播中，左军“空降”虚拟演播室，将万寿山与明末清初女将军秦良玉的佳话、男女石柱的传说，进行了精彩的解说和推荐。\n" +
                            "　　这一力荐，吸引了游客的目光。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　相关负责人表示，阶段性的数据还没有出来，不过，通过门票销售情况来看，“打卡”人数明显增多。这要归结于双晒的热效应，重庆市内游客多了；另外方面，随着跨省市团队旅游的恢复，来自周边省市的游客量增长也比较明显。\n" +
                            "　　云中花都景区负责人证实了这一说法，该景区既有高空玻璃栈桥，也有夏天耍水的项目，花卉绿植也是卖点之一，还有民宿和露营，游客主要来自渝鄂川三省市，除了湖北游客多了，达州等川东北地区的游客也明显增多。\n" +
                            "　　西沱古镇的情况也差不多，随着游客的增长，景区商业恢复明显，带动了工艺品和美食的销售。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "一个中益乡就囊括“六养”\n" +
                            "　　“风情土家，康养石柱”，是石柱双晒的推广语。近年来，石柱县大力围绕“康养”二字做文章，并通过双晒这个窗口，向世人展示了在大康养、大健康产业方面的成果。\n" +
                            "　　石柱县将康养细分为“六养”。围绕高山、森林、草场、湖泊、田园、古镇、湿地公园等景观，打造“观养”山水画卷。围绕中药材精深加工、中医药医疗机构、养老设施建设，打造“疗养”健康福地。围绕莼菜、乌天麻、蜂蜜、牛肉干、辣椒等食品，打造“食养”风味长廊。围绕现代公共文化服务体系建设、土家文化资源挖掘、节庆活动举办等，打造“文养”心灵驻地。围绕丰富多彩的运动赛事、地方特色户外体育运动、全民健身活动等，打造“动养”竞技乐园。围绕康养特色小镇、休闲旅游地产、改善乡村民居等方面，打造“住养”世外桃源。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　在石柱中益乡，上述“六养”，在这个深度贫困乡镇都能一一找到注解。“观养”有中华蜜蜂谷和湿地公园；“住养”有高山村组建峰村的农家乐；“动养”有慢行步道；“文养”有民俗、民宿点；“食养”有蜂蜜和中药材；“疗养”亦有背靠大风堡的养身好去处。\n" +
                            "　　石柱县文旅委相关负责人说，接下来，文旅委将趁着这股热度，在县委、县政府的领导下，在各职能部门的配合下，集中全力，将“风情土家，康养石柱”在全市乃至全国范围内叫响，让更多游客一想到康养，就首选石柱。\n" +
                            "\n" +
                            "避暑客增多玩法也更多\n" +
                            "　　上周末，黄水镇街上的避暑房已“一房难求”。沿街店铺生意红火，饭馆夜宵店更是热闹得不行。人气最旺的，莫过于黄水大剧院广场。想要体验这里的摩天轮、碰碰车、蹦床等游乐设施，游客都得排队。在此避暑的罗明珍女士说，就连菜市场的人，都比前些日子多了。她是半月前来黄水避暑的，而这几天人来得特别多。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　黄水游客中心的工作人员表示，今年遇到汛情，重庆主城可能也不是很热，所以前阵子来黄水避暑的重庆（主城）人不如往年。他查看了天气趋势，近期天气延续了前端时间的特点，但来黄水的避暑客逐渐多了起来，且大多数来自重庆主城。\n" +
                            "　　“游客中心增加了公交（摆渡）车的数量，农贸市场和超市也增加了供应量，安防的警力也增加了。”黄水镇相关负责人说，随着双晒带来的口碑效应，短、中、长期避暑游客还会相辅相成地增长；另一方面，石柱县正在黄水镇、冷水镇和中益乡打造“旅游环线”，使之完成“康养石柱”的“闭环”，从远期看，黄水的避暑康养经济，还会有很大的成长空间。");
            activityList.add(hot3);
            Activity hot4 = new Activity("hot4", R.drawable.hot4,
                    "在重庆这片美丽的山水之地也流传着许多爱情佳话，巴山渝水间，山川是爱情的见证，一草一木都诉说着重庆爱情故事。巫山的神女千年守望，幻化了云海；6000级台阶的天梯见证着50年不渝的爱恋；巴渝版的孔雀东南飞是土家族儿女对爱情的坚贞……爱情故事融于山水之中，除去品味故事的悠远流长，山水间也成为情侣们互表心意、共诉爱意的祈愿圣地。",
                    "重庆发布爱情故事地图，你知道哪些？",
                    "2020-08-26",
                    "　七夕，中国人“最浪漫”的传统节日。中国民间一直流传着许多爱情故事，牛郎织女的相思相望，梁祝的生死不渝，孟姜女的海枯石烂，寄托在传统文化里的爱情故事，让我们感受到古人对于爱情的向往和守护，金风玉露一相逢，便胜却人间无数。",
                    "   重庆市规划和自然资源局、重庆市地理信息和遥感应用中心，本期“每周一图”为大家推出了《重庆爱情故事地图》，请大家跟随地图，品读故事，感受巴渝爱情。\n" +
                            "\n" +
                            "江津·爱情天梯\n" +
                            "　　为了让爱人徐朝清出行安全，生活在江津中山古镇的刘国江一辈子都在悬崖峭壁上凿石梯通向外界，如今已有6208级，被称为“爱情天梯”。两位老人都已相继去世，但他们坚贞不渝的爱情故事世世代代传为佳话。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "云阳·龙缸\n" +
                            "　　云阳龙缸是重庆有名的风景旅游区，雄险俊秀的自然风光吸引无数游客前往。传说龙缸是盘古开天地时就已经存在，缸内有水，龙王的小女儿就住在这里。一日，有樵夫打柴经过此地，见一曼妙女子坐在龙缸边沿，身受重伤，樵夫心地善良，将女子接回家中医治，两人日久生情。一天风云突变，狂风巨浪将女子卷走。原来女子正是龙王小女，龙王得知其与凡人相恋，遂卷走龙女。樵夫追至龙缸，发现龙缸水空，苦等日久，化作岩石。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "武隆·仙女恋歌\n" +
                            "　　《仙女恋歌》是继《印象武隆》大型实景演出的又一台别开生面具有很强动感震撼力的大型3D全息音画演出。根据民间传说改编，讲述了在王母寿宴上，仙女飞琼欲寻玉兔悄然离开寿宴，落入民间与小伙李保结缘，朝夕相处最终结为恩爱夫妻，随后引发了王母大怒、山妖五龙为祸人间、五仙女下凡收复五龙的故事，李保为情而亡化身为白马山，而飞琼更为爱化身为仙女山与白马山永世对望。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "巫山·神女峰\n" +
                            "　　巫山云雨一词最初源自战国时楚人宋玉的《高唐赋》，叙述了楚怀王在梦中与一位热情美丽、自由奔放、大胆追求爱情的神女相遇并且相爱的故事，故事中神女形态不定，可幻化为云雨。神女峰是巫山十二峰之最，除了古老的故事传说，其景色也令人神往，是秋天赏红叶的好去处。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "石柱•男女石柱\n" +
                            "　　在石柱万寿山上，有一对遥遥相望的巨石，当地人称之为“男女石柱”。相传很久以前，一对自由相爱的年轻男女，因为女孩被恶霸看上，在恶霸伤害男孩时，女孩为保护男孩而祈求山神将自己变为石柱，男孩知道后也祈求山神将自己变为石柱与女孩相对而立的凄美故事。这对难舍难分的情侣终于在一起了，任凭风吹雨打，烈日暴晒。");
            activityList.add(hot4);
            Activity hot5 = new Activity("hot5", R.drawable.hot5,
                    "8月25日，正值“七夕”传统节日，首届重庆涪陵绣球花节在武陵山国家森林公园圆满落幕。涪陵区人大常委会副主任冉义明、区政协副主席唐勇、相关单位负责人、客商、媒体记者及游客等500余人参加闭幕式。",
                    "绣球花儿开·情定武陵山 首届重庆涪陵绣球花节圆满落幕",
                    "2020-08-26",
                    "8月25日，正值“七夕”传统节日，首届重庆涪陵绣球花节在武陵山国家森林公园圆满落幕。",
                    "   闭幕式上，举行了“绣摄涪陵”摄影比赛颁奖仪式、“武陵山2020年度最美休闲避暑农家乐”授牌仪式和“黄金武陵山避暑产品”等3个文旅项目战略合作签约仪式。\n" +
                            "　　同时，绣球花节两大主题活动“浪漫旅拍”的2对新人代表、“幸福专线”活动的游客和导游代表也来到了现场，用朴实真切的话语向大家分享了参与主题活动的幸福时刻和难忘记忆，以及对涪陵美景美食的喜爱与眷恋，将闭幕式推向高潮。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　伴随着歌舞《一朵绣球花》，本届绣球花节圆满落幕！\n" +
                            "　　当天，涪陵团区委在活动现场开展了“绣球花开，情定七夕”交友活动，来自涪陵各企事业的80余名单身男女，相约美丽武陵山，寻找属于自己的幸福与浪漫。\n" +
                            "　　回顾本届绣球花节，自5月15日以来，围绕“绣球花开·情起涪陵”、“浪漫之旅·情迷涪陵”、“奔向幸福·情定涪陵”三大主题，历时103天，开展了成渝双城经济圈文旅合作签约、“绣摄涪陵”摄影比赛、脱贫攻坚产品展销、网络大V晒涪陵、绣球花直播分享会、成渝幸福专线、趣味彩虹跑、浪漫旅拍等10余项活动。\n" +
                            "\n" +
                            "\n" +
                            " \n" +
                            "\n" +
                            "　　活动涉及文化、旅游、体育、婚庆、园林等多个产业，旨在以节会经济拉动文化消费，吸引了60余万人次参与，可谓是亮点纷呈、收获满满。\n" +
                            "　　下一步，涪陵将以绣球花节的成功举办为契机，努力将绣球花节打造成为在全市、全国有影响力的文旅品牌和巴蜀文化旅游走廊的靓丽名片，为加快建设高质量发展、高品质生活的美丽涪陵、幸福涪陵增添新动力，进而推动涪陵在成渝地区双城经济圈建设和“一区两群”协调发展中作出新的贡献。");
            activityList.add(hot5);

        }
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.hot_lunbo1, R.drawable.hot_lunbo2,
                R.drawable.hot_lunbo3, R.drawable.hot_lunbo4,R.drawable.hot_lunbo5
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