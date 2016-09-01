import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liang on 16/5/25.
 */
public class test {
    public static void main(String[] args) {
//        b sb = new b(1,2);
//        System.out.println(sb);
//        d(sb);
//        System.out.println(sb);
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        String s4 ="Program";
        String s5 = "ming";
        String s6 = s4+s5;
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s2.intern());
        System.out.println(s1 == s6);
        System.out.println(s2.intern() ==s6.intern());

    }
    public static int b(int a){
        a=7;
        return a;
    }
    public static void d(b b){
        b.setA(3);
        b.setB(4);

    }
}


class b{
    private int a ;
    private int b ;

    public b(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public String toString(){
        return a+"==="+b;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;

//        CharBuffer bf = CharBuffer.allocate(20);
//        char[] b ={'d','d','f','g','y'};
//        bf.put(b);
//        System.out.println(bf.get(2));
//        System.out.println(bf.position());
//        bf.flip();
//        bf.get(2);
//        System.out.println(bf.position());
//        String str = new String("dgfdgd");
//        String str1 = new String("dgfdgd");
//        System.out.println(str.intern()==str1.intern());
//        System.out.println(str.equals(str1));
//        Map<String ,String> map =null;
//        map = Collections.synchronizedMap(new HashMap<String ,String>()).;
        Map<person,String> map1 = new HashMap<>(3);
        person p = new person(11,"sfsd");
        person p1 = new person(12,"sfsfdd");
        person p2 = new person(13,"sfsfdd");


        map1.put(p,"fdsf11");
        map1.put(p2,"fd1111sf");
        map1.put(p1,"fds1f");

        for(Map.Entry e :map1.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}

class person{
    private int age;
    private String name;
    public person(int age ,String name){
        this.age =age;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;

    }
}
