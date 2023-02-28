package org.msy.boot.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import java.util.Arrays;

/**
 * @author 11612
 * @date 2023/2/28
 */
@Configuration
public class FilterConfig{

    @Bean
    public FilterRegistrationBean filterRegistration() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);  // 同时设置request和response
        bean.setFilter(filter);
        String[] urls = {"/*"};
        bean.setUrlPatterns(Arrays.asList(urls));
        return bean;
    }
}
