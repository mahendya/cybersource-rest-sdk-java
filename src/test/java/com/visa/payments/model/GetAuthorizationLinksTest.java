package com.visa.payments.model;

import com.visa.payments.ApiException;
import com.visa.payments.JSON;
import com.visa.payments.TypeRef;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Thread;
import java.net.URISyntaxException;
import java.nio.file.Files;


public class GetAuthorizationLinksTest {

    String serialized;

    @Before
    public void setup() throws URISyntaxException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Thread.currentThread().getContextClassLoader().getResource("GetAuthorizationLinks.json").toURI());
        serialized = new String(Files.readAllBytes(file.toPath())); 
    }

    @Test
    public void testDeserialize() throws ApiException, IllegalAccessException, InvocationTargetException {
        TypeRef typeRef = new TypeRef<com.visa.payments.model.GetAuthorizationLinks>() {};
        JSON json = new JSON();
        GetAuthorizationLinks instanceOfGetAuthorizationLinks = json.deserialize(serialized, typeRef);
        Method[] methods = GetAuthorizationLinks.class.getMethods();

        for(Method method : methods){
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            if (method.getDeclaringClass() == GetAuthorizationLinks.class && method.getName().startsWith("get")) {
                assertTrue(method.invoke(instanceOfGetAuthorizationLinks) != null);
            }
        }
	}
}
