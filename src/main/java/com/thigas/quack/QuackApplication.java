package com.thigas.quack;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

@SpringBootApplication
public class QuackApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuackApplication.class, args);
    }

    @Bean
    BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
        return beanFactory -> {
            if (beanRegistry instanceof AnnotationConfigServletWebServerApplicationContext) {
                genericApplicationContext((BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry).getBeanFactory());
            } else {
                throw new IllegalStateException("ApplicationContext is not of type AnnotationConfigServletWebServerApplicationContext");
            }
        };
    }

    void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> mr.getClassMetadata().getClassName().equals(QuackApplication.class.getName()));
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            return className.startsWith("com.thigas.quack.Domain.Entity");
        });
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            return className.startsWith("com.thigas.quack.Domain.Utils");
        });
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            return className.startsWith("com.thigas.quack.Adapter.Entity");
        });
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("com.thigas.quack");
    }

    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
                .getClassName()
                .endsWith("Model");
    }
}