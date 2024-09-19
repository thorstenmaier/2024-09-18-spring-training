package com.accenture.spring.user;

import com.accenture.spring.user.service.MyAutowired;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before: " + bean.getClass().getSimpleName());

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAutowired.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, context.getBean(field.getType()));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return bean;
    }
}
