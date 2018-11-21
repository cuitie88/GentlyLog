package com.ct.android.gentlylog.sample;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ct.android.gentlylog.print.GLog;
public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置是否显示打印
        GLog.isLog(true);
        //设置打印Tag
        GLog.setTag("GGG");

        String tag= "AAA";

        String msg = "你好";
        GLog.log.d(msg);
        GLog.log.i(msg);
        GLog.log.e(msg);
        GLog.log.d(tag,msg);
        GLog.log.i(tag,msg);
        GLog.log.e(tag,msg);

        String json = "{\"name\":\"JSON中国\",\"url\":\"http://www.json.org.cn\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"浙大路38号.\",\"city\":\"浙江杭州\",\"country\":\"中国\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]}";
        GLog.log.j(json);
        GLog.log.j(tag,json);

        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<!-- Edited by XMLSpyÂ® -->\n" + "<breakfast_menu>\n" + "\t<food>\n" + "\t\t<name>Belgian Waffles</name>\n" + "\t\t<price>$5.95</price>\n" + "\t\t<description>Two of our famous Belgian Waffles with plenty of real maple syrup</description>\n" + "\t\t<calories>650</calories>\n" + "\t</food>\n" + "\t<food>\n" + "\t\t<name>Strawberry Belgian Waffles</name>\n" + "\t\t<price>$7.95</price>\n" + "\t\t<description>Light Belgian waffles covered with strawberries and whipped cream</description>\n" + "\t\t<calories>900</calories>\n" + "\t</food>\n" + "\t<food>\n" + "\t\t<name>Berry-Berry Belgian Waffles</name>\n" + "\t\t<price>$8.95</price>\n" + "\t\t<description>Light Belgian waffles covered with an assortment of fresh berries and whipped cream</description>\n" + "\t\t<calories>900</calories>\n" + "\t</food>\n" + "\t<food>\n" + "\t\t<name>French Toast</name>\n" + "\t\t<price>$4.50</price>\n" + "\t\t<description>Thick slices made from our homemade sourdough bread</description>\n" + "\t\t<calories>600</calories>\n" + "\t</food>\n" + "\t<food>\n" + "\t\t<name>Homestyle Breakfast</name>\n" + "\t\t<price>$6.95</price>\n" + "\t\t<description>Two eggs, bacon or sausage, toast, and our ever-popular hash browns</description>\n" + "\t\t<calories>950</calories>\n" + "\t</food>\n" + "</breakfast_menu>\n";
        GLog.log.x(xml);
        GLog.log.x(tag,xml);
    }
}