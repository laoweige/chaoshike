package test.java.integration;

import com.zhaopin.advertisement.web.services.ApiClient;
import org.junit.Test;

import java.util.Date;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

public class ApiClientTest {
    private ApiClient apiClient = new ApiClient("http://localhost:8080/api");

    @Test
    public void should_get_user_orders() throws Exception {
        Map response = apiClient.getOrdersFor("buser", 1, 20, new Date(), new Date(), 0);
        assertNotNull(response.get("count"));
    }
}
