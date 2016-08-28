package meituan;

import net.dongliu.requests.Requests;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.mortbay.util.ajax.JSON;


/**
 * Created by liang on 16/5/31.
 */
public class Apitest {
    public static void main(String[] args) {

    }
    @Test
    public void test_select_node()
    {

        String data = "{\"SID\":\"wuliangliang02\",\"data\":[{\"grp_name\":\"corp=meituan&owt=cos\",\"create_user\":\"yindashan\",\"come_from\":\"0\"}]}";
       // String jsonStr = "{\"SID\":\"wuliangliang02\",\"data\":[{\"id\":\"10\"}]}";
        String url = "http://10.32.56.157:5050/api/node/add/";
        String resp = Requests.post(url).body(data).send().readToText();
        System.out.println(resp);
    }


    public void printJson(JSON json)
    {
        System.out.println(json.toString());
    }
    public void test()
    {
        //1 json对象转换为字符串
        JSONObject subObject = new JSONObject();
        subObject.put("ooo", "***");
        subObject.put("ppp", "&&&");
        JSONObject object = new JSONObject();
        object.put("aaa", "111");
        object.put("bbb", "222");
        object.put("ccc", subObject);

        System.out.println(object.toJSONString());

        //2 json数组对象装换为字符串
        JSONArray array = new JSONArray();

        JSONObject object1 = new JSONObject();
        object1.put("aaa", "111");
        object1.put("bbb", "222");

        JSONObject object2 = new JSONObject();
        object2.put("aaa", "111");
        object2.put("bbb", "222");

        array.add(object1);
        array.add(object2);

        System.out.println(array.toJSONString());

        //3 字符串转换为json对象
        String jsonStr = "{\"aaa\":\"111\",\"ccc\":{\"ooo\":\"***\",\"ppp\":\"&&&\"},\"bbb\":\"222\"}";
        JSONParser parser = new JSONParser();
        try {
            JSONObject parseObject = (JSONObject)parser.parse(jsonStr);
            System.out.println("---->" + parseObject.toJSONString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //4 字符串转换为数组
        jsonStr = "[{\"aaa\":\"111\",\"bbb\":\"222\"},{\"aaa\":\"111\",\"bbb\":\"222\"}]";
        try {
            JSONArray parseObject = (JSONArray)parser.parse(jsonStr);
            System.out.println("---->" + parseObject.toJSONString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
