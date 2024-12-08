package com.thigas.quack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    
    private static final Logger logger = LoggerFactory.getLogger(QuackApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(QuackApplication.class, args);
    }
    
    static TypeFilter removeModelAndEntitiesFilter() {
        return (MetadataReader mr, MetadataReaderFactory mrf) -> {
            boolean result = !mr.getClassMetadata().getClassName().endsWith("Model");
            logger.debug("Applying removeModelAndEntitiesFilter to class: {}, result: {}", mr.getClassMetadata().getClassName(), result);
            return result;
        };
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
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            boolean result = mr.getClassMetadata().getClassName().equals(QuackApplication.class.getName());
            logger.debug("Excluding QuackApplication class: {}, result: {}", mr.getClassMetadata().getClassName(), result);
            return result;
        });
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            boolean result = className.startsWith("com.thigas.quack.Domain.Entity");
            logger.debug("Excluding Domain.Entity class: {}, result: {}", className, result);
            return result;
        });
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            boolean result = className.startsWith("com.thigas.quack.Domain.Utils");
            logger.debug("Excluding Domain.Utils class: {}, result: {}", className, result);
            return result;
        });
        beanDefinitionScanner.addExcludeFilter((MetadataReader mr, MetadataReaderFactory mrf) -> {
            String className = mr.getClassMetadata().getClassName();
            boolean result = className.startsWith("com.thigas.quack.Adapter.Entity");
            logger.debug("Excluding Adapter.Entity class: {}, result: {}", className, result);
            return result;
        });
        beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
        beanDefinitionScanner.scan("com.thigas.quack");
    }
}