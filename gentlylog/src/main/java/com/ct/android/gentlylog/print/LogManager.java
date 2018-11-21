package com.ct.android.gentlylog.print;
import android.util.Log;
/**
 * <p>主要功能 ： 日志管理者.
 * <p>创建时间 ： 2016/6/29.
 */
public class LogManager
{
    private PrinterExecutor printerExecutor;
    /**
     * 打印日志时候用的标志---默认TAG
     */
    private boolean isLog = false;
    /**
     * 打印日志时候用的标志---默认TAG
     */
    private String tag_default = "GLOG";
    public LogManager()
    {
        printerExecutor = PrinterExecutor.getInstance();
    }
    /**
     * 日志的debug输出操作(默认TAG)
     *
     * @param msg 输出内容
     */
    public void d(String msg)
    {
        d(tag_default,msg);
    }
    /**
     * 日志的debug输出操作
     *
     * @param tag 自定义tag
     * @param msg 输出内容
     */
    public void d(String tag,String msg)
    {
        if(!isLog)return;
        printerExecutor.debug(tag,msg);
    }
    /**
     * 日志的info输出操作
     *
     * @param msg 输出内容
     */
    public void i(String msg)
    {
        i(tag_default,msg);
    }
    /**
     * 日志的info输出操作
     *
     * @param msg 输出内容
     */
    public void i(String tag,String msg)
    {
        if(!isLog)return;
        printerExecutor.info(tag,msg);
    }
    /**
     * 日志的error输出操作
     *
     * @param msg 输出内容
     */
    public void e(String msg)
    {
        e(tag_default,msg);
    }
    /**
     * 日志的error输出操作
     *
     * @param msg 输出内容
     */
    public void e(String tag,String msg)
    {
        if(!isLog)return;
        printerExecutor.error(tag,msg);
    }
    /**
     * 日志的json输出操作(默认TAG)
     *
     * @param msg 输出内容
     */
    public void j(String msg)
    {
        j(tag_default,msg);
    }
    /**
     * 日志的json输出操作(默认TAG)
     *
     * @param msg 输出内容
     */
    public void j(String tag,String msg)
    {
        if(!isLog)return;
        printerExecutor.json(tag,msg);
    }
    /**
     * 日志的xml输出操作(默认TAG)
     *
     * @param msg 输出内容
     */
    public void x(String msg)
    {
        x(tag_default,msg);
    }
    /**
     * 日志的xml输出操作(默认TAG)
     *
     * @param msg 输出内容
     */
    public void x(String tag,String msg)
    {
        if(!isLog)return;
        printerExecutor.xml(tag,msg);
    }
    /**
     * 设置日志输出的TAG
     *
     * @param tag 打印TAG
     */
    public void setTag(String tag)
    {
        tag_default = tag;
    }
    /**
     * 设置是否打印日志
     *
     * @param isLog 是否打印标识
     */
    public void setIsLog(boolean isLog)
    {
        this.isLog = isLog;
    }
    public void ctDebug(String msg)
    {
        if(!isLog)return;
        Log.d("CCTV", msg);
    }
}