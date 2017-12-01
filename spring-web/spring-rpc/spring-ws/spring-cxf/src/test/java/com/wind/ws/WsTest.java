package com.wind.ws;

import com.wind.entity.User;
import com.wind.service.UserService;
import com.wind.entity.Person;
import com.wind.service.PersonService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

public class WsTest {

    @Test
    public void testRest(){
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost("http://192.168.1.44:8080/ws/rest/persons");
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("--------------------------------------");
                System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));
                System.out.println("--------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(response != null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭连接,释放资源
            if(httpclient != null){
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testJAXRs(){
        Client client = ClientBuilder.newClient().register(PersonService.class);
        Person person = client.target("http://localhost:8080/ws/rest/person")
                .path("/{name}")
                .resolveTemplate("name", "wind")
                .request(MediaType.APPLICATION_JSON).get(Person.class);
        System.out.println(person.getName() + "," + person.getAge());

        Person p = new Person();
        // generic type to wrap a generic list of persons
        GenericType<List<Person>> persons = new GenericType<List<Person>>() {};
        List<Person> personList = client.target("http://localhost:8080/ws/rest/persons")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(p, MediaType.APPLICATION_JSON), persons);

        System.out.println(personList.size());
    }

    @Test
    public void testSoap(){

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setAddress("http://localhost:8080/ws/user");
        factoryBean.setServiceClass(UserService.class);
        UserService userService = (UserService) factoryBean.create();
        User user = userService.getUser("hello");
        System.out.println(user.getUsername() + "," + user.getPassword());
    }
}
