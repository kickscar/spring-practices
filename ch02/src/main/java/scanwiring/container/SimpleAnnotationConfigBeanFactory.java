package scanwiring.container;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.ResolvableType;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleAnnotationConfigBeanFactory implements BeanFactory {
    private Map<String, Object> mapBeans = new ConcurrentHashMap<>();
    private Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>();

    public SimpleAnnotationConfigBeanFactory(String basePackage) {
        try {
            autowiredAnnotationTypes.add(Autowired.class);
            doScan(basePackage);
            doAutowiring();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void doScan(String packageName) throws ClassNotFoundException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
        scanner.addIncludeFilter(new AssignableTypeFilter(Component.class));

        // for only one depth package
        Set<BeanDefinition> beanDefinitions = scanner.findCandidateComponents(packageName);

        for (BeanDefinition beanDefinition : beanDefinitions) {
            Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
            if (clazz.getAnnotation(Component.class) != null) {
                Object bean = BeanUtils.instantiateClass(clazz);

                String clazzName = clazz.getSimpleName();
                mapBeans.put(Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1), bean);
            }
        }
    }

    private void doAutowiring() throws BeanCreationException {
        for (String beanName : mapBeans.keySet()) {
            Object bean = mapBeans.get(beanName);
            Class<?> clazz = bean.getClass();

            // AutowiredAnnotationBeanPostProcessor 클래스의 processInjection()를 분석하여 작성.
            // new AutowiredAnnotationBeanPostProcessor().processInjection(bean);

            if (!AnnotationUtils.isCandidateClass(clazz, autowiredAnnotationTypes)) {
                continue;
            }

            ReflectionUtils.doWithLocalFields(clazz, new ReflectionUtils.FieldCallback() {
                @Override
                public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                    MergedAnnotation<?> ann = null;
                    MergedAnnotations annotations = MergedAnnotations.from(field);

                    for (Class<? extends Annotation> type : autowiredAnnotationTypes) {
                        MergedAnnotation<?> annotation = annotations.get(type);
                        if (annotation.isPresent()) {
                            ann = annotation;
                            break;
                        }
                    }

                    if (ann == null) {
                        // 지원하는 Wiring Annotation 이 없음
                        // autowiredAnnotationTypes 참고
                        return;
                    }

                    if (Modifier.isStatic(field.getModifiers())) {
                        // static 필드
                        return;
                    }

                    AnnotationAttributes aa = (AnnotationAttributes) ann.asMap(mergedAnnotation -> new AnnotationAttributes(mergedAnnotation.getType()));
                    boolean required = (!aa.containsKey("required") || true == aa.getBoolean("required"));

                    // wiring 하기
                    DependencyDescriptor desc = new DependencyDescriptor(field, required);
                    desc.setContainingClass(bean.getClass());

                    Object value = mapBeans.get(desc.getDependencyName());
                    if (value == null) {
                        // 주입할 빈이 컨테이너에 없다.
                        throw new UnsatisfiedDependencyException(null, beanName, new InjectionPoint(field), "Unsatisfied Dependency Exception");
                    }

                    // Inject 하기
                    ReflectionUtils.makeAccessible(field);
                    field.set(bean, value);
                }
            });
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return mapBeans.get(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType requiredType) {
        return null;
    }

    @Override
    public boolean containsBean(String name) {
        return false;
    }

    @Override
    public boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isPrototype(String name) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String name, ResolvableType typeToMatch) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String name, Class<?> typeToMatch) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public Class<?> getType(String name, boolean allowFactoryBeanInit) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];
    }
}
