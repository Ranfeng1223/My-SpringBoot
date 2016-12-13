package vv.cc.publicCtr;


import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by melo on 2016/12/13.
 */
@RestController
public abstract class LkBaseController {

    public void sendJsonResult(HttpServletResponse response,int code,String message,Object data) throws IOException {
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if(data != null){
           out.write(JSON.toJSONString(sendResult(code,message,data)));
        }else{
            out.write(JSON.toJSONString(sendResult(code,message)));
        }
    }

    private Map<String,Object> sendResult(int code,String message){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("message",message);
        return map;
    }

    private Map<String,Object> sendResult(int code,String message,Object data){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("message",message);
        map.put("data",data);
        return map;
    }

}
