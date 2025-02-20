package lld1.designPatterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    Map<String, Student> studentMap = new HashMap<>();

    public Student get(String key){
        return studentMap.get(key);
    }

    public void register(String key, Student student){
        studentMap.put(key, student);
    }
}
