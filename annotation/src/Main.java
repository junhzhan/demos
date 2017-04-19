import cn.junhzhan.sample.AnnotedClass;
import cn.junhzhan.sample.CustomAnnotationMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Class<AnnotedClass> object = AnnotedClass.class;

        Annotation[] annotations = object.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Method[] methods = object.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(CustomAnnotationMethod.class)) {
                Annotation annotation = method.getAnnotation(CustomAnnotationMethod.class);
                System.out.println(annotation);
            }
        }

    }
}
