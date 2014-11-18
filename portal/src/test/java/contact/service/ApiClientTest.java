package test.java.contact.service;

import com.zhaopin.advertisement.web.services.ApiClient;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import static javax.ws.rs.client.Entity.json;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ApiClientTest extends JerseyTest {

    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public static class MockApi {
        @POST
        @Path("/users/{userId}/orders")
        public Response createOrdersForUser(@PathParam("userId") String userId) throws URISyntaxException {
            return Response.created(new URI("/api/users/" + userId + "/orders/1")).build();
        }

        @GET
        @Path("/users/{userId}/orders")
        public Response getUserOrders(@PathParam("userId") String userId,
                                      @DefaultValue("1") @QueryParam("start") int start,
                                      @DefaultValue("20") @QueryParam("count") int count) {
            return Response.ok().entity("orders").build();
        }
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(MockApi.class);
    }

    @Test
    public void should_create_orders_for_user() {
        Response response = api().createOrdersFor("buser", json(new HashMap<String, String>()));

        assertThat(response.getStatus(), is(201));
        assertThat(response.getHeaderString("Location"), is(getBaseUri() + "api/users/buser/orders/1"));
    }


    private ApiClient api() {
        return new ApiClient(getBaseUri().toString());
    }
}