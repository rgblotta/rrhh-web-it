/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.oga.java.rrhh.web.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class TestClienteRestIT {
    
    public TestClienteRestIT() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testGetCliente() throws IOException {
        String MY_URL = "http://localhost:8080/rrhh-web/api/cliente";
        HttpGet httpget = new HttpGet(MY_URL);
        CloseableHttpClient cliente = HttpClients.createDefault();
        CloseableHttpResponse response1 = cliente.execute(httpget);
        HttpEntity entity1 = response1.getEntity();
        
        String resultado = entidadToString(entity1.getContent()); 
        assertEquals("GET",resultado.toUpperCase());
        EntityUtils.consume(entity1);
        response1.close();
    }
    
    private String entidadToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
   }
   
}
