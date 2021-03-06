package org.sang.demo;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.sang.demo.test.BaseValueInject;
import org.sang.demo.test.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
@RestController
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
//        Long startTime = System.currentTimeMillis();
        Criteria criteria =new Criteria();
        criteria.and("isUpload").is(false);
        Query q = Query.query(criteria);
////        criteria.and("_id").is(new ObjectId("5bd2829d879ab14819dbd4f7"));
//        Query q = new Query(criteria);
//        List<Object> list = mongoTemplate.find(q, Object.class, "drgs_template_report");
//        list.forEach((Object obj) -> {
//            if(obj instanceof Map){
//                ObjectId id = (ObjectId) ((Map) obj).get("_id");
//                Map reportContent = (Map)((Map) obj).get("reportContent");
//                String title = reportContent.get("title").toString();
//                List<Map<String, Object>> sonList = (List<Map<String, Object>>) reportContent.get("sonList");
//                Set<String> set = new HashSet<>();
//                sonList.forEach(row -> {
//                    String colTitle = (String) row.get("title");
//                    colTitle = colTitle.trim();
//                    if(set.contains(colTitle)) {
//                        System.out.println(id.toString()+"===="+title);
//                        System.out.println("其中重复列名："+colTitle);
//                        return;
//                    }
//                    set.add(colTitle);
//                });
//            }
//        });
//        System.out.println("time:"+(System.currentTimeMillis()-startTime));
    }


    @Value("${https.port}")
    private Integer port;

    @Value("${https.ssl.key-store-password}")
    private String key_store_password;

    @Value("${https.ssl.key-password}")
    private String key_password;


    /* --------------------请按照自己spring boot版本选择 start--------------------- */
    // 这是spring boot 1.5.X以下版本的 添加了这个，下一个就不用添加了
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
//        tomcat.addAdditionalTomcatConnectors(createSslConnector()); // 添加http
//        return tomcat;
//    }

    // 这是spring boot 2.0.X版本的 添加这个，上一个就不用添加了
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createSslConnector()); // 添加http
        return tomcat;
    }
    // 配置https
    private Connector createSslConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        try {
            File keystore = new ClassPathResource("sample.jks").getFile();
//            File truststore = new ClassPathResource("sample.jks").getFile();
            connector.setScheme("https");
            connector.setSecure(true);
            connector.setPort(port);
            protocol.setSSLEnabled(true);
            protocol.setKeystoreFile(keystore.getAbsolutePath());
            protocol.setKeystorePass(key_store_password);
            protocol.setKeyPass(key_password);
            return connector;
        }
        catch (IOException ex) {
            throw new IllegalStateException("can't access keystore: [" + "keystore"
                    + "] or truststore: [" + "keystore" + "]", ex);
        }
    }

}
