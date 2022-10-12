package com.yk.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author Tang
 * @Tate 2022/10/6-10:04
 * @Version 1.0
 */
public class MyLocaleConfig implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();  //如果没有就是用默认的国际解析器
        //如果就进行定制化创建Locale对象
        if(!StringUtils.isEmpty(language)){
            String[] s = language.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
