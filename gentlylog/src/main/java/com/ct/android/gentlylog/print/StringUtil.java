package com.ct.android.gentlylog.print;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.StringWriter;
/**
 * <p>主要功能 ： 字符串处理.
 * <p>创建时间 ： 2016/6/29.
 */

public class StringUtil
{
    /**
     * 字符串格式化成json格式
     * @param jsonStr 要格式化的字符串
     * @return 格式化后的字符串
     * */
    public static String formatJson(String jsonStr) throws Exception
    {
        int          level         = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int i = 0; i < jsonStr.length(); i++)
        {
            char c = jsonStr.charAt(i);
            if(level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1))
            {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch(c)
            {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();

    }
    private static String getLevelStr(int level) throws Exception
    {
        StringBuffer levelStr = new StringBuffer();
        for(int levelI = 0; levelI < level; levelI++)
        {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
    /**
     * 字符串格式化成xml格式
     * @param str 要格式化的字符串
     * @return 格式化后的字符串
     * */
    public static String formatXml(String str) throws Exception {
        Document document = null;
        document = DocumentHelper.parseText(str);
        // 格式化输出格式
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        StringWriter writer = new StringWriter();
        // 格式化输出流
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        // 将document写入到输出流
        xmlWriter.write(document);
        xmlWriter.close();
        return writer.toString();
    }
}
/*
 * 修改者：  崔铁
 * 修改时间：2016/6/29 11:06
 * 代码版本：1.0
 */