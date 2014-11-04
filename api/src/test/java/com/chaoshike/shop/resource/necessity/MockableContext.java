package com.chaoshike.shop.resource.necessity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class MockableContext extends XmlWebApplicationContext {

    @Override
    protected DefaultListableBeanFactory createBeanFactory() {
        return new MockableBeanFactory();
    }

    private class MockableBeanFactory extends DefaultListableBeanFactory {
        @Override
        public <T> T getBean(Class<T> requiredType) throws BeansException {
            T bean = (T) TestBeans.get(requiredType);
            if (bean == null) {
                super.getBean(requiredType);

            }
            return bean;
        }

        @Override
        public Object getBean(String name) throws BeansException {
            Object bean = TestBeans.get(name);
            if (bean != null) {
                return bean;
            }
            return super.getBean(name);
        }

        @Override
        public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
            return (T) getBean(name);
        }
    }

}