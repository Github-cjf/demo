package org.sang.demo;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.*;

/**
 * Created by CJF on 2018-7-25.
 */
public class TestClass {

    @Autowired
    MongoTemplate mongoTemplate;

    static Map<String, Object> map;
    static List<Map<String, Object>> finalList = new ArrayList<>();

    static Map<String, String> repeatFieldLMap = new HashMap<>();

    @Test
    public void simple(){
        System.out.println(0b101>>2 == 1);
        Criteria criteria =new Criteria();
//        criteria.and("_id").is(new ObjectId("59feb0a75a3d13586d16f636"));
        Query q = new Query(criteria);
        q.skip(200000).limit(50000);
//        List list = mongoTemplate.find(q, Object.class, "drgs_report_data");
        for (int i = 0; i < 5; i++) {
            finalList = new ArrayList<>();
            repeatFieldLMap = new HashMap<>();
            q.skip(i * 50000).limit(50000);
            List list = mongoTemplate.find(q, Object.class, "drgs_draft_box");

            System.out.println("查询总条数："+list.size());

            long t1 = System.currentTimeMillis();
            for(Object o : list){
                map = new TreeMap<>();
                if(o instanceof Map){
                    map.put("_id", ((Map) o).get("_id"));
                    Object listMap = ((Map) o).get("reportContent");
                    ObjectUtil.transfer(listMap, map, "", repeatFieldLMap);

                    finalList.add(map);
                }else{

                }
            }
            long t2 = System.currentTimeMillis();
            System.out.println("执行时间："+(t2-t1));
            System.out.println("finalList:"+finalList.size());
            System.out.println("重复字段==="+repeatFieldLMap.toString());
            System.out.println("重复条数==="+repeatFieldLMap.size());
        }

    }
}

class ObjectUtil{
    static Set radioSet = new HashSet(){{
        this.add("a");
        this.add("b");
        this.add("c");
        this.add("d");
        this.add("e");
        this.add("f");
        this.add("g");
        this.add("h");
        this.add("i");
        this.add("j");
        this.add("k");
        this.add("l");
        this.add("m");
        this.add("n");

        this.add("o");
        this.add("p");
        this.add("q");
        this.add("r");
        this.add("s");
        this.add("t");
        this.add("u");
        this.add("v");
        this.add("w");
        this.add("x");
        this.add("y");
        this.add("z");
    }};

    public static void transfer(Object o, Map<String, Object> map, String parenKey, Map<String, String> repeatFieldLMap){


        try {
            if(o instanceof Map){
                Map<String, Object> objectMap = (Map<String, Object>) o;

                if ((objectMap.keySet().stream().anyMatch(key1 -> radioSet.contains(key1)))) {
                    map.put(parenKey,objectMap.values());
                    return;
                }

                Iterator it=((Map) o).entrySet().iterator();
                while (it.hasNext()){
                    Map.Entry<String, Object> entry = (Map.Entry) it.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();

                    if(value instanceof Map){
                        transfer(value, map, key, repeatFieldLMap);
                    }else {
                        if(map.containsKey(key)){
                            ObjectId id = (ObjectId) map.get("_id");
                            System.out.println("重复数据：_id:"+id.toString()+",重复字段："+key);
                            repeatFieldLMap.put(key, id.toString());
                        }
                        map.put(key, value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
