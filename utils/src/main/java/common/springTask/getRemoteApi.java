package common.springTask;

import common.Intterface.RemoteInterface;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class getRemoteApi {
    public void getCaiHongPi(){
        String s = RemoteInterface.springTemplate("https://apis.tianapi.com/caihongpi/index");
        System.out.println("彩虹屁话接口执行了【"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) +"】："+s);
    }

    public void getTianGou(){
        String s = RemoteInterface.springTemplate("https://apis.tianapi.com/tiangou/index");
        System.out.println("舔狗日记接口执行了【"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) +"】："+s);
    }

}
