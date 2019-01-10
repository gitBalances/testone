package com.tansuo365.test1.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/*Spring上下文工具*/
@Component  
public class SpringContextUtils implements ApplicationContextAware {  
    private static ApplicationContext context;  
  
    public void setApplicationContext(ApplicationContext context)  
            throws BeansException {  
        SpringContextUtils.context = context;  
    }  
  
    public static ApplicationContext getContext(){  
        return context;  
    }  
}  