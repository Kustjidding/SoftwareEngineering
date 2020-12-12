package tongji.edu.common.lang;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
// 后端返回结果封装类
public class Result implements Serializable {
    private String msg;
    private Object data;
    public static Map<String,Object> succ(String msg,Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("state",true);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
    public static Map<String,Object> succ(String msg){
        return succ(msg,null);
    }
    public static Map<String,Object> succ(Object data){
        return succ("操作成功！",data);
    }
    public static Map<String,Object> fail(String msg,Object data){
        Map<String,Object> map = new HashMap<>();
        map.put("state",false);
        map.put("msg",msg);
        map.put("data",data);
        return map;
    }
    public static Map<String,Object> fail(String msg){
        return fail(msg,null);
    }
}
