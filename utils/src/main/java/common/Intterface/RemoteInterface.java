package common.Intterface;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class RemoteInterface {
    private static final String API_KEY = "32134db58c6a3ab92c541fe7f3c53d2f";

    public static String urlContent(String path){
        try {
            URL url = new URL(path+"?key="+API_KEY);
            URLConnection connection = url.openConnection();
            connection.connect();
            byte[] bytes = connection.getInputStream().readAllBytes();
            String data = new String(bytes, "utf-8");
            return data;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String httpClientContent(String path){
        try {
            path = path+"?key="+API_KEY;
            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(path);
            httpGet.setHeader("Connection","close");
            CloseableHttpResponse execute = client.execute(httpGet);
            if(execute.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                HttpEntity entity = execute.getEntity();
                InputStream content = entity.getContent();
                return new String(content.readAllBytes(),"utf-8");
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static String springTemplate(String path){
        path = path+"?key="+API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(path, String.class);
        String entityBody = entity.getBody();
        return entityBody;
    }

    public static String springRestTemplate(String path,Object data){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity(path, String.class,data);
        String entityBody = entity.getBody();
        return entityBody;
    }

}
