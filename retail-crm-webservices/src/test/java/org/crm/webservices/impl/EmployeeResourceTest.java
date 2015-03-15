package org.crm.webservices.impl;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import javax.ws.rs.core.Application;

import static org.junit.Assert.fail;

/**
 * Created by Dachuan Zhao on 2015/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:app-context.xml"})
@Transactional
public class EmployeeResourceTest extends JerseyTest {
    public static final String PACKAGE_NAME = "org.crm.webservices";
    public static final String CONTEXT_PATH = "webservices";

    public EmployeeResourceTest() throws Exception {
        super(new WebAppDescriptor.Builder(PACKAGE_NAME)
                .contextPath(CONTEXT_PATH).build());
    }
    @Test
    public void findAllEmployeesSortedByNameShould() {
        WebResource webResource = resource();

        try {
            String responseMsg = webResource.path("_resources/Employees").get(String.class);
            fail("NPW should be thrown");
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
