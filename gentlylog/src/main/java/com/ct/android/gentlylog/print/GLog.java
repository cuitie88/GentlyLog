package com.ct.android.gentlylog.print;
/**
 * <p>创建时间 ： 2016/6/29.
 * <p>主要功能 ： 打印管理.
 */
public class GLog
{
    /**
     * 日志管理者.
     */
    public static final LogManager log;
    /**
     * 静态块，初始化日志管理者
     */
    static
    {
        log = new LogManager();
    }
    /**
     * <p>创建时间：2018/9/5 11:06
     * <p>创建者：  崔铁
     * <p>功能描述：设置是否开启日志打印功能
     * @param isLog 是否开启打印
     */
    public static void isLog(boolean isLog)
    {
        log.setIsLog(isLog);
    }
    /**
     * <p>创建时间：2018/9/5 11:07
     * <p>创建者：  崔铁
     * <p>功能描述：设置打印TAG
     */
    public static void setTag(String tag)
    {
        log.setTag(tag);
    }
}
/*
 * 修改者：  崔铁
 * 修改时间：2018/9/5 11:06
 * 代码版本：1.1
 */