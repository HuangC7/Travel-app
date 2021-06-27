package com.example.trainapp.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.trainapp.Activity.BaiduMapActivity;
import com.example.trainapp.Activity.CalculatorActivity;
import com.example.trainapp.R;
import com.example.trainapp.adapter.Text2Adapter;
import com.example.trainapp.base.BaseFragment;
import com.example.trainapp.entity.Activity;
import com.example.trainapp.finalassignment.WeatherActivity;
import com.example.trainapp.fun.FunActivity;
import com.example.trainapp.gestureoverlayview.GestureActivity;
import com.example.trainapp.signdate.DateActivity;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/*
 * 首页页面的Fragment
 * */

public class HomeFragment extends BaseFragment implements View.OnClickListener{

    private List<Activity> activityList = new ArrayList<>();
    private RecyclerView flHome;

    private static final String TAG = "MainActivity";

    private boolean mIsTouch = false;



    private LinearLayout mLinearLayout;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    private RollPagerView mRollViewPager;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.home_fragment, null);

        btn1 = (Button) view.findViewById(R.id.btn1);
        btn2 = (Button) view.findViewById(R.id.btn2);
        btn3 = (Button) view.findViewById(R.id.btn3);
        btn4 = (Button) view.findViewById(R.id.btn4);
        btn5 = (Button) view.findViewById(R.id.btn5);
        btn6 = (Button) view.findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);


        initActivity();

        // 2. 初始化轮播图
        mRollViewPager = view.findViewById(R.id.mRollViewPager);
        mRollViewPager.setPlayDelay(2000); // 设置播放时间间隔
        mRollViewPager.setAnimationDurtion(500); // 设置透明度
        mRollViewPager.setAdapter(new TestNormalAdapter()); //  设置适配器
        mRollViewPager.setHintView(new IconHintView(getContext(), R.drawable.shape_bg_point_enable, R.drawable.shape_bg_point_disable));
        mRollViewPager.setHintView(new ColorPointHintView(getContext(), Color.YELLOW, Color.WHITE));

        flHome = (RecyclerView) view.findViewById(R.id.fl_home);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        flHome.setLayoutManager(layoutManager);
        Text2Adapter text2Adapter = new Text2Adapter(mContext,activityList);
        flHome.setAdapter(text2Adapter);


        return view;
    }

    /*  String name, int imageId, String content, String title, String time, String t_abstract, String content_detailed  */
    private void initActivity() {
        for (int i=0;i<1;i++) {
            Activity home1 = new Activity("home1", R.drawable.home1,
                    " 重庆石家花园，既是抗战时期中国美术学院旧址，也是重庆徐悲鸿美术馆所在地。 抗日战争爆发后，徐悲鸿于1937年底随国立中央大学从南京迁址于陪都重庆，落户于原重庆大学松林坡，暂住于沙坪坝，执教于中央大学艺术系。石家花园主人石荣廷（原为抗战时期重庆市商会会长、川东慈善...",
                    "《重庆自由行攻略》2020漫步重庆徐悲鸿美术馆",
                    "2021-06-24 08:00",
                    "重庆 石家花园，既是抗战时期 中国 美术学院旧址，也是 重庆 徐悲鸿美术馆所在地。 抗日战争爆发后，徐悲鸿于1937年底随国立中央大学从 南京 迁址于陪都 重庆 ，落户于原 重庆 大学松林坡，暂住于沙坪坝，执教于中央大学艺术系。",
                    "   关于导游，本姑娘不是忘恩负义之人，作为本片的最大支持者，这里稍微费点笔墨。在网上看了很多的攻略，各式各样的都有，五花八门，因为对于 重庆 并不熟悉，不想跟团走，我在网上找了很多攻略，看了很多评价，最后在朋友的推荐下给我介绍了 重庆 小哥，小哥这个人评价还是挺不错的，人缘也比较好，他只做 重庆 旅行的高端高品质差异化的旅行，通俗点讲就是旅行界中的战斗机，这儿总有一款适合你的旅行方式。他们提供梦幻套餐(两人便可独立成团的），每一份梦幻套餐都是一次绝美的旅行体验。我们选择了小哥，省了不少心，而且重点是服务态度很好，一路上走到哪个景点直到玩够了才走，从来不催我们，会依我们想要玩的几个景点根据天气情况来进行转换制定，性价比很高，不 会安 排我们去各种购物店，全程是一个导游带着我们4个人游玩，相对OK! 而且现在他们这边在搞活动针对于多人家庭或者亲子同事出行 有不同的价格优惠或者免门票等优惠\n" +
                            "而且行程价格相对于平时旺季都更加低\n" +
                            "出发之前，出发前和他交流了解了很多关于自由行的细节问题，以前出外旅游都是跟团走的，初次选择自由行，自然是有很多的问题要问了，不过小哥童鞋人很好，总是不厌其烦的为我解答各个问题，他在我出行前给了我许多详实的建议和路线规划。写完游记，很多小伙伴问我小哥童鞋的联系方式，我把小哥推荐给大家：（电话）V:15680532526\n" +
                            "徐悲鸿故居向右侧继续下阶梯，几分钟后到达徐悲鸿当年办公和会客的石家花园 二层小楼属原国营 江陵 机器厂所有，该厂将房子提供给职工暂住，目前江北区已启动徐悲鸿旧居改造工程，暂住居民很快就会搬走。按照 重庆 文物部门及江北区官方的规划， 重庆 几年内将在石家花园建设“徐悲鸿旧居陈列馆”和“ 重庆 抗战美术史陈列馆”，以图片、资料、实物等形式重现徐悲鸿在 重庆 的生活、作画场景，同时还会展出张大千、吴作人等画家旅居 重庆 时的资料等，目前展馆的陈列大纲已通过审核。徐悲鸿居住过的二层小楼将按照修旧如旧的原则保持原貌，其旧居庭院中的亭子、景观等曾因日军大轰炸时毁坏，文物保护部门将尽可能地还原\n" +
                            "\n" +
                            "在盘溪居住的日子过得非常艰苦，屋内除必要的生活用品外，主要是绘画用具和绘画资料。廖静文在《徐悲鸿一生》有这样的描述：清晨，徐悲鸿步行到嘉陵江畔，在小摊上买两个烤白薯当早餐，然后坐渡船过江，再步行至沙坪坝中央大学上课，直到中午才返回。午饭后，它从来不睡午觉，时间总是用于作画，既是晚上在昏暗的煤油灯下，埋头作画，就像那上足了发条的种摆，一刻也不停息\n"+
                            "石家花园位于 重庆 江北区大石坝街道石门社区渝江村1号，1996年被列为 重庆 市文物保护单位。徐悲鸿夫人廖静文曾在《徐悲鸿一生》书中回忆这里：这是一所建筑在山上的房屋。房屋分为两层，下面一层全部是石室，用石头砌成，沿梯而上，有宽阔的院落，中间有一座亭子，内置石家的祖宗牌位，两侧是两座两层小楼，隔亭相对而立。小楼全部为木质结构，制作粗糙，甚至连玻璃也没有，但在战时的 重庆 ，这已是难觅的佳园了。。周围有黄葛苍松，梅竹掩映，十分幽静\n"+
                            "徐悲鸿与妻子廖静文在石家花园居住了4年，于1946年离开 重庆 。廖静文在《徐悲鸿一生》中回忆1946年离别 重庆 的心情时，这样写道：“别了，盘溪！我们此生也许不会再来看望你了，但是，你是我们的患难之交，你的名字不仅被悲鸿写在他的作品里，更写在我和悲鸿的心上，你是永远不会被我们遗忘的！”\n" +
                            "\n" +
                            "\n" +
                            "悲鸿和我急急忙忙返回磐溪，匆匆收拾行装。我们原本过着极其简单的生活，没有什么急需处理和变卖的东西，只有悲鸿的四十多箱书画是个沉重的负担。他捡出了其中最重要的一部分，装在一只长达三米的大铁箱中和几只 樟木 箱中，准备随身携带。其余的箱子，留给美术学院筹备处的工作人员暂管，以后再运往 南京 。这天夜里，我们筹备处的人都坐在楼前那块宽阔的平地上，依依话别。这是大家过去经常在夏夜纳凉的地方。在那些月明之夜，悲鸿曾和大家一起坐在这里漫谈，谈时局，谈文艺，谈见闻，但谈得最多的还是美术。悲鸿的话总是那样引人入胜他从 埃及 、 希腊 的绘画雕塑，谈到十九世纪各个不同画派，他详细讲了现实主义、浪漫主义和印象派，还讲了他所反对的、风靡西方的一些形式主义新派美术家。他能列举几百人的名字、叙述他们的代表作、风格、特点以及有关轶事和历史掌故。他的头脑似乎是贮藏世界艺术的一座宝库。对于 中国 画，他也能如数家珍地叙述历代名家及其作品。他的谈话生动、诙谐，富于风趣。在月光溶溶、繁星闪闪之下，往往不知不觉地谈到夜深，我们映在地上的影子渐渐溶成了一片。现在回想起来，那些美妙的夜晚是多么令人迷恋呵！在筹备处的工作人员、画家齐振杞曾写了许多日记，记录悲鸿当时那些谈话，打算以《月下清谈》为题发表。但后来齐振杞先生不幸早逝，这些日记也就不知下落了。次日清晨，悲鸿和我便向磐溪依依告别了。大家送我们到嘉陵江边。一路上，悲鸿和我都再三回头遥望那座“石家祠堂”— 中国 美术学院筹备处。那两幢简陋的木板楼房仍高高地屹立在山坡上。那些敞开的窗户就像睁大了的眼睛一样，在默默地凝视和送别我们。——廖静文《徐悲鸿一生》");
            activityList.add(home1);
            Activity home2 = new Activity("home2", R.drawable.home2,
                    "每年暑假刚开始时，我都雄心万丈，以为可以做很多很多事情。 实际上，除了呆在空调房里玩电脑和葛优躺外，就无其它了。 这才明白：像我这样过于慵懒的人，就要像大豆一样，提前安排各种事情，把自己压榨得死死滴，才会出油 于是每年暑假出游成了我的必修课，今年选择了成都 ...",
                    "·重庆 ＆ 成都 ▎一场斜风细雨的夏日之旅",
                    "2021-03-10 10:13",
                    "每年暑假刚开始时，我都雄心万丈，以为可以做很多很多事情。\n" +
                            "实际上，除了呆在空调房里玩电脑和葛优躺外，就无其它了。",
                    "   这才明白：像我这样过于慵懒的人，就要像大豆一样，提前安排各种事情，把自己压榨得死死滴，才会出油  \n" +
                            "于是每年暑假出游成了我的必修课，今年选择了 成都 重庆 还有 贵州 ，想着先体验 成都 重庆 这两个城市的火热，再去 贵州 消消暑儿  \n" +
                            "实际出行后基本每天都下雨，有时大雨有时小雨， 成都 重庆 的火热是没有体会到，斜风细雨的诗意倒是不缺。\n"+
                            "来 成都 之前，已预料到 成都 会很热，很晒，做好了每天大汗淋漓的准备。结果去了后天天下雨  ，看来 成都 今年入夏失败了。\n" +
                            "幸运的是在车上还是瓢泼大雨，下车玩时就成了蒙蒙细雨，不耽误游玩嘻嘻嘻（不过就算大雨也没问题，毕竟我可是在暴雨天玩过山车的人   ）\n" +
                            "在这样的细雨中，漫步杜甫草堂，文殊院许个愿，大慈寺里喝杯清茶，把各种烦恼全丢掉，享受当下，才是正事儿。\n"+
                            "1、宽窄巷子和锦里，个人觉得白天比夜晚更上镜。\n" +
                            "2、如果你对吃很感兴趣，建议不去宽窄和锦里，改去奎星楼街(临近宽窄巷子，有 成都 地道的小面店——纯阳馆鱼香排骨面，还有几家神店，像卖串串的冒椒火辣、主打新派川菜的 成都 吃客）、东糠市街（太古里附近，小食店很多，）十一街（只有短短的100米，却集结了茶馆、串串、甜皮鸭、幺鸡面等美食，和 成都 人搓麻将、吃宵夜的日常生活。）\n" +
                            "3、 成都 拍照凹造型可以去春熙路（打卡IFS大熊猫，远远就会看到熊猫的胖屁屁，上到 IFS 的7楼，就可以和熊猫来个正面认证照）、太古里（去新派概念的方所书店看本书、去隐藏在闹市的大慈寺里品下茶）。\n" +
                            "如果去春熙路可以多走两步去天府广场旁边的 成都 博物馆，不用门票刷身份证即可进入。\n"+
                            "4、杜甫草堂不适 合阳 光灿烂的日子，蒙蒙细雨才是最好的搭配。好雨知时节，当春乃发生，雨后的草堂气质清冷，格外迷人。\n" +
                            "\n" +
                            "\n" +
                            "杜甫草堂博物馆\n" +
                            "5、洪崖洞：只是适合在一层马路对面看一眼夜景。楼里面饭馆小吃特别多，通风又做得不好，导致烟熏火燎的，没法儿逛，也没啥好玩的。\n" +
                            "6、 四川 美院总共有两个校区，一是位于黄桷坪的老校区，二是位于虎溪的新校区。两个校区各具特色，大家可以网上查询下，挑感兴趣的去。\n" +
                            "7、 重庆 建议住距离解放碑一两个地铁站的地方，晚上睡觉不会太吵，去长江索道，洪崖洞啥的也方便，附近好吃的火锅也不少。\n" +
                            "8、 重庆 出行要穿运动鞋，不要穿有跟的，不舒适的鞋，因为你走的每一步几乎都是在爬坡。\n" +
                            "9、 重庆 的小面不用找网上说的那些，那些菜市场或者旧的街里的往往味道很好！ 比如 我此行吃了好几家小面，但记忆最好的还是在宋庆龄故居附近的那家，名字叫啥不记得了，就记得干拌豌杂面超香。\n" +
                            "\n" +
                            "\n" +
                            "10、不管是 成都 还是 重庆 ，不要相信店家的微辣！因为重辣和微辣的区别对于不太能吃辣的人来说就是2斤辣椒和1斤辣椒的区别。\n" +
                            "11、在 重庆 一定要试下一只酸奶牛的饮品，它家的酸奶紫米露 消暑解腻又解辣，你值得拥有。记住是叫一只酸奶牛，后来我还有看到叫一只酸牛奶 的店铺，差点搞错了。\n" +
                            "\n" +
                            "\n" +
                            "一只酸奶牛\n" +
                            "12、 重庆 是一座3D魔幻城市， 重庆 打车的时候千万不要相信定位和你距离50米，可能你在十一楼，司机在一楼的50米外。高德地图很好用，记得开立面地图！");
            activityList.add(home2);
            Activity home3 = new Activity("home3", R.drawable.home3,
                    "热爱旅行至今，走过很多的城市，看过很多的海，也听见不同的风诉说着不同的故事。 旅行和旅游对我来说存在很大的差别，旅游更多的是视觉和味觉的享受，放松身体和神经。而旅行，却是一场心灵的旅程，随着痕迹去寻找那些失落在时光里的故事。 巷子里孩子们在追跑打闹嬉戏，树荫...",
                    "重庆攻略，走进3D魔幻之城重庆，解锁全新小众玩法",
                    "2021-06-23 22:33",
                    "热爱旅行至今，走过很多的城市，看过很多的海，也听见不同的风诉说着不同的故事。",
                    "   旅行和旅游对我来说存在很大的差别，旅游更多的是视觉和味觉的享受，放松身体和神经。而旅行，却是一场心灵的旅程，随着痕迹去寻找那些失落在时光里的故事。\n" +
                            "巷子里孩子们在追跑打闹嬉戏，树荫下老大爷坐在躺椅上摇着蒲扇乘凉，看起来破败的砖瓦下三五成群的妇女唠着家常，这些鲜活的人们不正是生活该有的样子吗？\n" +
                            "深山里的一处庭院，急流上空飞跃的索道，隐藏在繁华都市中的古老小镇，都有一圈圈的年轮，记录着被人们遗忘的故事，仿佛那些曾经发生过的故事，随着这场旅行慢慢的刻画进我的皮肤，和我内心深处。这才是旅行的意义。\n" +
                            "而 重庆 对我来说，就是这样的一个存在。\n" +
                            "都说他依山傍水，有着湿润宜人的气候，也有着大自然丰富的馈赠，是绝佳的旅游城市。而他却曾经交通闭塞，环境险要，山里的人走不出去，山外的人走不进来，所以曾经的他一切都是非常匮乏的。看着 重庆 现在的模样，难以想象这里的人们付出了怎样的努力，换来今天的 重庆 ，坚毅如斯。\n" +
                            "所以这次我来了，让早就埋在内心的那颗种子终于在这个七月发了芽结了果。\n" +
                            "山城 重庆 ，我来了。\n"+
                            "这样街景，带给我们的不只是视觉上的震撼，更多的是来自这里普通居 民和 学生一起守护艺术的初心带来的感动。\n" +
                            "校园和街道融为一体，成为 重庆 独一无二的艺术作品。\n" +
                            "鹅岭二厂| 重庆 最文艺的拍照圣地\n" +
                            "时间走了，把万物都惹老\n" +
                            "有的销声匿迹了，有的还傲骨屹立\n" +
                            "重庆 这座城市，从来都不缺故事\n" +
                            "鹅岭二厂的故事，也以自身不可比拟的存在\n" +
                            "见证了 重庆 这座城市的百年沧海桑田与变迁\n" +
                            "多少峥嵘岁月的印记，都刻在了它的骨子里\n" +
                            "如今走进它，仍旧能看见它旧时的模样\n" +
                            "它就那么安然又静默地伫立在那里\n" +
                            "一言不发，像极了一个疲惫的老人\n" +
                            "在这平淡的日子中，岁月在它身上雕琢出过往\n" +
                            "岁月薄情，但它却有自己最深情的厚重\n" +
                            "这些不起眼的建筑群，不只有斑驳与惋惜\n" +
                            "它反而营造出了浓郁的怀念氛围\n" +
                            "斑驳脱落的外墙，老旧的木制楼梯\n" +
                            "鹅岭二厂的一切像是从上个世纪穿越而来\n" +
                            "\n" +
                            "这是曾经看到过的有关鹅岭二厂的句子，说出了这里现在和过往。"
                                    );
            activityList.add(home3);
            Activity home4 = new Activity("home4", R.drawable.home4,
                    "重庆从这里开始。 这是第二个，专门跑来二刷的国内城市（在我写下这句话的时候，是“第一个”，然后意识到草稿箱里还有一篇宁波游记...）。第一次来是在18年底、19年元旦，第二次是20年端午。一楼和九楼出门都是马路、导航的路根本不知道在哪个平面上的体验让我们这种生在平原...",
                    "《重庆自由行攻略》重庆，在楼宇间、在巷子里",
                    "2021-06-24 08:06",
                    "这是第二个，专门跑来二刷的国内城市（在我写下这句话的时候，是“第一个”，然后意识到草稿箱里还有一篇 宁波 游记...）。",
                    "   第一次来是在18年底、19年元旦，第二次是20年端午。一楼和九楼出门都是马路、导航的路根本不知道在哪个平面上的体验让我们这种生在平原的人惊叹不已。如果把三维的地面压成二维，总觉得 重庆 老楼和它们之间的巷子跟 香港 有几分相似。\n" +
                            "\n" +
                            "重庆 人很热心，而且是一脸严肃的热心。很多次遇到路边的人主动跟我们说话，一开始语速快没听懂总感觉人家要图我们什么东西，交流两句听明白才发现，都是看到我们似乎需要帮助主动给我们指路。想想自己当时一脸警惕的样子，会不会让人觉得江浙来的人就是有股小家子气。\n" +
                            "\n" +
                            "二刷这次主要集中在渝中，每次移动去下个地点，基本都有个800900m的距离很尴尬，打车太近，走路又吃力，还没有自行车/共享单车。加上夏天的 重庆 是真的热，第一天我们就崩溃了。所以夏天来 重庆 ，是需要勇气的。\n" +
                            "\n" +
                            "关于导游，本姑娘不是忘恩负义之人，作为本片的最大支持者，这里稍微费点笔墨。在网上看了很多的攻略，各式各样的都有，五花八门，因为对于 重庆 并不熟悉，不想跟团走，我在网上找了很多攻略，看了很多评价，最后在朋友的推荐下给我介绍了 重庆 小哥，小哥这个人评价还是挺不错的，人缘也比较好，他只做 重庆 旅行的高端高品质差异化的旅行，通俗点讲就是旅行界中的战斗机，这儿总有一款适合你的旅行方式。他们提供梦幻套餐(两人便可独立成团的），每一份梦幻套餐都是一次绝美的旅行体验。我们选择了小哥，省了不少心，而且重点是服务态度很好，一路上走到哪个景点直到玩够了才走，从来不催我们，会依我们想要玩的几个景点根据天气情况来进行转换制定，性价比很高，不 会安 排我们去各种购物店，全程是一个导游带着我们4个人游玩，相对OK! 而且现在他们这边在搞活动针对于多人家庭或者亲子同事出行 有不同的价格优惠或者免门票等优惠\n" +
                            "而且行程价格相对于平时旺季都更加低\n" +
                            "出发之前，出发前和他交流了解了很多关于自由行的细节问题，以前出外旅游都是跟团走的，初次选择自由行，自然是有很多的问题要问了，不过小哥童鞋人很好，总是不厌其烦的为我解答各个问题，他在我出行前给了我许多详实的建议和路线规划。写完游记，很多小伙伴问我小哥童鞋的联系方式，我把小哥推荐给大家：（电话）V:15680532526/n"+
                            "写在最后\n" +
                            "（只是强行加一段首尾呼应罢了）\n" +
                            "\n" +
                            "哪怕是二刷，也还是有好多原本在行程里的地方没去。想去朝东路拍路尽头的高楼，去北滨一路找个码头坐着看对面沿江的轻轨来来回回，也想从钟楼广场下废弃观景楼的门洞里望着来福士发呆。\n" +
                            "\n" +
                            "这个城市不仅仅是空间上多了一个维度，时间上似乎也有重叠——高楼之间还能看到庙宇，古典和现代的建筑碰撞在一起，很震撼。（最近一次行程之前我尝试了，但是实在没有找到合适的拍摄角度....只能留到下次了...）"
                    );
            activityList.add(home4);
            Activity home5 = new Activity("home5", R.drawable.home5,
                    "亘古以来武隆被视为人间奥境，但由于自然地理环境屏障的缘故，所以一直不被大众所知。后因张艺谋执导的一部电影《满城尽带黄金甲》正式走进了人们的视线，而后又作为美国好莱坞大片《变形金刚4》的取景地之一而闻名世界，唤起了更多人对武隆的好奇与兴趣，从而掀起了武隆游热潮~那怎样才能玩转武隆呢，就让我来为你一一解读吧！",
                    "《变4》中国唯一取景地，重庆武隆玩法大揭秘",
                    "2016-08-24",
                    "这原本是一座默默无名的小城，地处重庆东南边缘，乌江下游，因为一部名导的电影《满城尽带黄金甲》正式走进了群众的视线。它距离重庆170公里，约两小时车程。",
                    "   外部大交通\n" +
                            "武隆县城没有机场，只有火车站和汽车站。因此乘机的游客只能降落重庆江北国际机场，然后转乘轻轨3号线到四公里交通枢纽站（这真的是汽车站的名字）或重庆火车北站，再乘长途汽车或火车到武隆县城。不过虽然到了武隆县城，但是县城离景区还有33公里路程，还需再转车到景区。下面详细说一下长途车、火车以及自驾和旅行社拼车位四种出行方式：\n" +
                            "【长途汽车】\n" +
                            "重庆市出发，需到南坪四公里汽车枢纽站乘坐发往武隆的汽车，时程约3-4小时，发车时间为6:00-18:00，每隔半小时发一班，全程票价50-60元/人，途径湘渝高速公路到达。\n" +
                            "到达地址：柏杨路22号（武隆汽车站）\n" +
                            "【火车】\n" +
                            "武隆县只有一个火车站，所经列车均为过路车。从重庆出发的仅有重庆北站，发往武隆共7次列车，发车时间分别为：07:30、09:32、12:20、14:18、18:10、20:10、20:56，时程约2小时，硬座为24.5元，硬卧80元起。\n" +
                            "到达地址：芙蓉东路东端靠高速边上（乌江三桥桥头）\n" +
                            "【自驾车】\n" +
                            "自驾的路线和长途汽车走的线路大致相同，从重庆到武隆约二百多公里，往返过路费约170元。可选择走渝涪高速，重庆到涪凌高速段全长110公里，涪凌到武隆的319国道一马平川，2-3个小时即可。\n" +
                            "【景区直达交通】\n" +
                            "当地旅社有运营从重庆市区直达武隆仙女山镇游客中心的旅游巴士，无需转车。发车时间与地点：早7点30分在南坪会展中心。费用单程50元/人，往返99元/人。车上有行车助理全程服务，网上购买的时候可以提前选择座位。和长途车比，省去了当地交通的问题。  \n" +
                            "武隆县当地交通\n" +
                            "【汽车】\n" +
                            "如果坐长途车抵达的武隆县城，那就还需要转车才能到达各景区，县城离武隆游客中心还有21公里的路程，具体各景区的转车方式如下：\n" +
                            "仙女山景区：县城汽车站有直达仙女山国家森林公园的客运大巴，票价17元/人，班次较多。\n" +
                            "天生三桥、龙水峡地缝：在县城汽车站乘坐开往仙女山镇的客运大巴到达游客接待中心，票价9元/人，约40分钟车程。\n" +
                            "芙蓉洞：去芙蓉洞芙蓉江的游客需要在汽车站外面的公交站坐公交到江口镇（费用4元/人），然后到镇上的汽车站换乘到芙蓉洞景区的车（费用5元/人）约一个小时的车程。\n" +
                            "【出租车】\n" +
                            "在武隆乘出租车很便宜，起步价4元，超过1.0公里跳价，6:00-22:00为1.4元/公里，22:00-6:00为1.8元/公里。可包出租车到各个景区，每辆车副驾驶位前都贴有武隆县发改委制定的包车价格，可议价。\n" +
                            "武隆应该看什么？\n" +
                            "01. 天生三桥\n" +
                            "02. 龙水峡地缝\n" +
                            "03. 芙蓉洞\n" +
                            "04. 仙女山\n" +
                            "05. 天坑寨子");
            activityList.add(home5);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            /* 每日签到 */
            case R.id.btn1:
                Intent intent1 = new Intent(mContext, DateActivity.class);
                mContext.startActivity(intent1);
//                Toast.makeText(v.getContext(),"你点击了btn1",Toast.LENGTH_SHORT).show();
                break;
            /* 计算器 */
            case R.id.btn2:
                Intent intent2 = new Intent(mContext, CalculatorActivity.class);
                mContext.startActivity(intent2);
//                Toast.makeText(v.getContext(),"你点击了btn2",Toast.LENGTH_SHORT).show();
                break;
            /* 天气预报 */
            case R.id.btn3:

                Intent intent3 = new Intent(mContext, WeatherActivity.class);
                mContext.startActivity(intent3);
//                Toast.makeText(v.getContext(),"你点击了btn3",Toast.LENGTH_SHORT).show();
                break;
            /* 地图 */
            case R.id.btn4:
                Intent intent4 = new Intent(mContext, BaiduMapActivity.class);
                mContext.startActivity(intent4);
//                Toast.makeText(v.getContext(),"你点击了btn4",Toast.LENGTH_SHORT).show();
                break;
            /* 手势识别 */
            case R.id.btn5:
                Intent intent5 = new Intent(mContext, GestureActivity.class);
                mContext.startActivity(intent5);
//                Toast.makeText(v.getContext(),"你点击了btn5",Toast.LENGTH_SHORT).show();
                break;
            /* 趣味娱乐 */
            case R.id.btn6:
                Intent intent6 = new Intent(mContext, FunActivity.class);
                mContext.startActivity(intent6);
//                Toast.makeText(v.getContext(),"你点击了btn6",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }

    private class TestNormalAdapter extends StaticPagerAdapter {
        private int[] imgs = {
                R.drawable.home_lunbo1, R.drawable.home_lunbo2,
                R.drawable.home_lunbo3, R.drawable.home_lunbo4,R.drawable.home_lunbo5
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
