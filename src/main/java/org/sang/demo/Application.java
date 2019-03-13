package org.sang.demo;

import org.bson.types.ObjectId;
import org.sang.demo.test.BaseValueInject;
import org.sang.demo.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
@RestController
//@ComponentScan
public class Application {

//    private final Person person;
//
//    @Autowired
//    public Application(Person person) {
//        this.person = person;
//    }
    @Autowired
    BaseValueInject value;

    @Autowired
    MongoTemplate mongoTemplate;


//    @Bean
//    public SpringUtil springUtil(){
//        SpringUtil s = new SpringUtil();
//        s.num = 10;
//        return s;
//    }

    @Bean
    public Person initPerson(){
        Person p = new Person();

        p.setName("王五");
        p.setSex(SexEnum.male);
        return p;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        SpringApplication.run(Application.class, args);

    }

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
    void index2() {
//        map.put("hello", "121");
//        map.put("bye", "saunala");
//        System.out.println(person.toString());
//        /*if(true){
//            throw new MyException(ErrorCode.nullCode, ErrorCode.nullCode.getMsg());
//        }*/
        Long startTime = System.currentTimeMillis();
        Criteria criteria =new Criteria();
        criteria.and("deleted").is("1");
//        criteria.and("_id").is(new ObjectId("5bd2829d879ab14819dbd4f7"));
        Query q = new Query(criteria);
        List<Object> list = mongoTemplate.find(q, Object.class, "drgs_template_report");
        list.forEach((Object obj) -> {
            if(obj instanceof Map){
                ObjectId id = (ObjectId) ((Map) obj).get("_id");
                Map reportContent = (Map)((Map) obj).get("reportContent");
                String title = reportContent.get("title").toString();
                List<Map<String, Object>> sonList = (List<Map<String, Object>>) reportContent.get("sonList");
                Set<String> set = new HashSet<>();
                sonList.forEach(row -> {
                    String colTitle = (String) row.get("title");
                    colTitle = colTitle.trim();
                    if(set.contains(colTitle)) {
                        System.out.println(id.toString()+"===="+title);
                        System.out.println("其中重复列名："+colTitle);
                        return;
                    }
                    set.add(colTitle);
                });
            }
        });
        System.out.println("time:"+(System.currentTimeMillis()-startTime));
    }
}
