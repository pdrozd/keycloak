package org.keycloak.testsuite.rest.resource;

import org.keycloak.testsuite.rest.TestingResourceProvider;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author mhajas
 */
public class TestJavascriptResource {

    @GET
    @Path("/js/keycloak.js")
    @Produces("application/javascript")
    public String getJavascriptAdapter() throws IOException {
        return resourceToString("/javascript/keycloak.js");
    }

    @GET
    @Path("/index.html")
    @Produces(MediaType.TEXT_HTML)
    public String getJavascriptTestingEnvironment() throws IOException {
        return resourceToString("/javascript/index.html");
    }

    @GET
    @Path("/keycloak.json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getKeycloakJSON() throws IOException {
        return resourceToString("/javascript/keycloak.json");
    }

    private String resourceToString(String path) throws IOException {
        InputStream is = TestingResourceProvider.class.getResourceAsStream(path);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
    }
}
