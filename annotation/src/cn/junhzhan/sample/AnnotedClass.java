package cn.junhzhan.sample;

/**
 * Created by junhzhan on 3/17/17.
 */
@CustomAnnotationClass(date = "test")
public class AnnotedClass {

    @CustomAnnotationMethod(date = "2017-03-17", description = "testmethod")
    public String annotatedMethod() {
        return null;
    }
}
