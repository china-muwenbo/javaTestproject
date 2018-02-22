package anno;

public class AnnotationTest2 {

    @MyAnnotation(value1="abc1")
    public void execute(){
        System.out.println("method");
    }
}