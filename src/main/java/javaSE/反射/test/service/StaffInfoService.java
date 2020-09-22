package javaSE.反射.test.service;
import javaSE.反射.test.entity.StaffInfo;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class StaffInfoService {

    public static final Map<String,String> map = new HashMap(){{
        put("cnName", "姓名");
        put("positionName", "岗位");
        put("id","id");
        put("workLocationId","地域");
        put("onboardDate","入场时间");
    }};

    public static void main(String[] args){
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setCnName("ygc");
        staffInfo.setPositionName("开发");
        staffInfo.setWorkLocationId(3);
        staffInfo.setOnboardDate(new Date());
        System.out.println(checkFieldeEmpty(map,staffInfo));
    }

    public static String checkFieldeEmpty(String[] fields, Object object){
        Class clzz = object.getClass();
        String field = null;
        for(int i=0;i<fields.length;i++){
            field = fields[i].substring(0,1).toUpperCase()+fields[i].substring(1);
            try {
                Method method = clzz.getMethod("get"+field);
                if(method.invoke(object) == null){
                    return fields[i] +"不能为空";
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return "OK";
    }

    /**
     * 利用反射技术获得javabean中属性字段对应的get方法
     * @param map
     * @param object
     * @return
     */
    public static String checkFieldeEmpty(Map<String,String> map, Object object){
        Class clzz = object.getClass();
        String field = null;

        for(Map.Entry<String,String> item : map.entrySet()){
            field = item.getKey();
            field = "get"+field.substring(0,1).toUpperCase()+field.substring(1);
            try {
                Method method = clzz.getMethod(field);
                if(method.invoke(object)==null || StringUtils.isBlank(method.invoke(object).toString())){
                    return item.getValue()+"不能为空";
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return "OK";
    }
}
