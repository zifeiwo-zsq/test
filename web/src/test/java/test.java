import common.Intterface.RemoteInterface;
import org.junit.Test;

public class test {
    @Test
    public void test(){
        String path = "https://apis.tianapi.com/caihongpi/index";
        String str = "";
//        str = RemoteInterface.httpClientContent(path);
//        str = RemoteInterface.urlContent(path);
//        str = RemoteInterface.springTemplate(path);
        str = RemoteInterface.springRestTemplate("http://localhost:8080/testRest/{param}","aihfoiansdf");
        System.out.println(str);
    }
}
