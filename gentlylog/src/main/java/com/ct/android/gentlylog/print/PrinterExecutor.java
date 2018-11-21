package com.ct.android.gentlylog.print;
import android.util.Log;
/**
 * <p>创建时间：2018/11/21 0021 13:27
 * <p>功能描述：打印执行者
 *
 * <p>修改时间：2018/11/21 0021 13:27
 * <p>代码版本：1.0
 *
 */
public class PrinterExecutor
{
    /*******使用静态内部类方式实现单利模式【start】*******/
    /**
     * 私有化构造方法
     */
    private PrinterExecutor() {}
    /**
     * <p>创建时间：2018/3/16 11:17
     * <p>功能描述：静态内部类（避免了线程不安全，延迟加载，效率高。）
     */
    private static class PrinterExecutorInstance
    {
        private static final PrinterExecutor INSTANCE = new PrinterExecutor();
    }
    /**
     * <p>创建时间：2018/3/16 11:18
     * <p>功能描述：获取实例
     * @return
     */
    public static PrinterExecutor getInstance()
    {
        return PrinterExecutorInstance.INSTANCE;
    }
    /*******使用静态内部类方式实现单利模式【end】*********/
    /**
     * 打印日志默认分割长度
     */
    private int log_max_length = 4000;
    /**
     * 日志的debug输出操作
     *
     * @param tag_default TAG
     * @param msg 输出内容
     */
    public void debug(String tag_default, String msg)
    {
        try
        {
            if(msg == null)
            {
                Log.d(tag_default, "打印内容为空!");
                return;
            }
            if(msg.length() < log_max_length)
            {
                Log.d(tag_default, msg);
                return;
            }
            debugSection(tag_default, msg, log_max_length);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.d(tag_default, "debug打印异常!");
        }
    }
    /**
     * 日志的info输出操作
     *
     * @param tag_default TAG
     * @param msg 输出内容
     */
    public void info(String tag_default, String msg)
    {
        try
        {
            if(msg == null)
            {
                Log.i(tag_default, "打印内容为空!");
                return;
            }
            if(msg.length() < log_max_length)
            {
                Log.i(tag_default, msg);
                return;
            }
            infoSection(tag_default, msg, log_max_length);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.d(tag_default, "info打印异常!");
        }
    }
    /**
     * 日志的error输出操作
     *
     * @param tag_default TAG
     * @param msg 输出内容
     */
    public void error(String tag_default, String msg)
    {
        try
        {
            if(msg == null)
            {
                Log.e(tag_default, "打印内容为空!");
                return;
            }
            if(msg.length() < log_max_length)
            {
                Log.e(tag_default, msg);
                return;
            }
            errorSection(tag_default, msg, log_max_length);
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.d(tag_default, "error打印异常!");
        }
    }
    /**
     * 日志的debug分割输出操作(有效防止打印不全情况，默认分段长度为log_max_length)
     *
     * @param tag_default TAG
     * @param msg 输出内容
     * @param length 分割长度
     */
    private void debugSection(String tag_default, String msg, int length) throws Exception
    {
        Log.d(tag_default, "———【分割打印】——【start】—————————————————————————————————————————————————————————————————————————————————————");
        int strLength = msg.length();
        int start = 0;
        int end = length;
        for(int i = 0; i < 100; i++)
        {
            if(strLength > end)
            {
                Log.d(tag_default, msg.substring(start, end));
                start = end;
                end = end + length;
            }else
            {
                Log.d(tag_default, msg.substring(start, strLength));
                break;
            }
        }
        Log.d(tag_default, "———【分割打印】——【end】—————————————————————————————————————————————————————————————————————————————————————");
    }
    /**
     * 日志的info分割输出操作(有效防止打印不全情况，默认分段长度为log_max_length)
     *
     * @param tag_default TAG
     * @param msg 输出内容
     * @param length 分割长度
     */
    private void infoSection(String tag_default, String msg, int length) throws Exception
    {
        Log.i(tag_default, "———【分割打印】——【start】—————————————————————————————————————————————————————————————————————————————————————");
        int strLength = msg.length();
        int start = 0;
        int end = length;
        for(int i = 0; i < 100; i++)
        {
            if(strLength > end)
            {
                Log.i(tag_default, msg.substring(start, end));
                start = end;
                end = end + length;
            }else
            {
                Log.i(tag_default, msg.substring(start, strLength));
                break;
            }
        }
        Log.i(tag_default, "———【分割打印】——【end】—————————————————————————————————————————————————————————————————————————————————————");
    }
    /**
     * 日志的error分割输出操作(有效防止打印不全情况，默认分段长度为log_max_length)
     *
     * @param tag_default TAG
     * @param msg 输出内容
     * @param length 分割长度
     */
    private void errorSection(String tag_default, String msg, int length) throws Exception
    {
        Log.e(tag_default, "———【分割打印】——【start】—————————————————————————————————————————————————————————————————————————————————————");
        int strLength = msg.length();
        int start = 0;
        int end = length;
        for(int i = 0; i < 100; i++)
        {
            if(strLength > end)
            {
                Log.e(tag_default, msg.substring(start, end));
                start = end;
                end = end + length;
            }else
            {
                Log.e(tag_default, msg.substring(start, strLength));
                break;
            }
        }
        Log.e(tag_default, "———【分割打印】——【end】—————————————————————————————————————————————————————————————————————————————————————");
    }
    /**
     * 日志的json输出操作
     *
     * @param tag_default TAG
     * @param msg 输出内容
     */
    public void json(String tag_default,String msg)
    {
        try
        {
            String json_format = StringUtil.formatJson(msg);
            String[] jsons = json_format.split("\n");
            Log.d(tag_default,"———【JSON打印】——【start】—————————————————————————————————————————————————————————————————————————————————————");
            for(String json : jsons)
            {
                debug(tag_default,json);
            }
            Log.d(tag_default,"———【JSON打印】——【end】—————————————————————————————————————————————————————————————————————————————————————");
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.d(tag_default, "json打印异常!");
        }
    }
    /**
     * 日志的xml输出操作(默认TAG)
     *
     * @param tag_default TAG
     * @param msg 输出内容
     */
    public void xml(String tag_default,String msg)
    {
        try
        {
            String xml_format = StringUtil.formatXml(msg);
            String[] xmls = xml_format.split("\n");
            Log.d(tag_default,"———【XML打印】——【start】—————————————————————————————————————————————————————————————————————————————————————");
            for(String xml : xmls)
            {
                debug(tag_default,xml);
            }
            Log.d(tag_default,"———【XML打印】——【end】—————————————————————————————————————————————————————————————————————————————————————");
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.d(tag_default, "xml打印异常!");
        }
    }
}
