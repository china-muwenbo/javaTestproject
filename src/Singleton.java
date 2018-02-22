import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
public class Singleton {
    public static Map m;
    static{
        m = new HashMap();
    }
    public    static Singleton singleton = new Singleton();
    private Singleton(){
        initM();
    }
    public static void initM(){
            if(null == m){
            System.out.println("m 为空");
            m = new HashMap();
        }else {
                System.out.println("m 不为空");
            }
        m.put("1", "郑");
        m.put("2", "陈");
    }
    public static Singleton getInstance(){
        return singleton;
    }
}