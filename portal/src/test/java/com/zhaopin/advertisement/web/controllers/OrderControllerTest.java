package test.java.com.zhaopin.advertisement.web.controllers;

import com.zhaopin.advertisement.thirdPartyClient.RDApi;
import com.zhaopin.advertisement.web.services.Api;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static jersey.repackaged.com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class OrderControllerTest {

    @Mock
    private Api api;
    @Mock
    private RDApi rdApi;
    @Mock
    private HttpSession session;
    private OrderController controller;

    @Before
    public void setUp() {
        initMocks(this);
        session = mock(HttpSession.class);
        controller = new OrderController(api);
    }

    @Test
    public void should_create_orders_for_user() throws Exception {
        HttpServletResponse httpServletResponse = mock(HttpServletResponse.class);
        Response response = mock(Response.class);
        HashMap<String, Object> ordersMap = getOrdersMap();
        ordersMap.put("orderNumber", "123");
        given(response.readEntity(Map.class)).willReturn(ordersMap);
        when(session.getAttribute(anyString())).thenReturn("buser");
        when(session.getAttribute("userType")).thenReturn(null);
        when(api.createOrdersFor(eq("buser"), Matchers.<Entity<Object>>any()))
                .thenReturn(response);

        String result = controller.createOrder(new LinkedMultiValueMap<String, String>(), session, httpServletResponse);
        assertThat(result, is(notNullValue()));
    }

    @Test
    public void should_not_found_when_get_orders_for_user() throws Exception {

        when(session.getAttribute(anyString())).thenReturn("ThoughtWorks");
        HashMap<String, Object> ordersMap = getOrdersMap();
        when(api.getOrdersFor(eq("ThoughtWorks"), anyInt(), anyInt(), any(Date.class), any(Date.class), eq(0))).thenReturn(ordersMap);

        ModelAndView result = controller.getOrderList(0, session);
        assertThat(result.getViewName(), is("notfound"));
        assertThat(result.getModel().get("orders"), is(nullValue()));
    }

    @Test
    public void should_return_orders() throws Exception {
        when(session.getAttribute(anyString())).thenReturn("ThoughtWorks");
        Map<String, Object> ordersMap = getOrdersMap();
        ordersMap.put("count", 100);
        when(api.getOrdersFor(eq("ThoughtWorks"), anyInt(), anyInt(), any(Date.class), any(Date.class), eq(0))).thenReturn(ordersMap);

        ModelAndView result = controller.getOrderList(1, session);
        assertThat(result.getViewName(), is("order/list"));
        assertThat(result.getModel().get("orders"), is(notNullValue()));
    }

    private HashMap<String, Object> getOrdersMap() {
        HashMap<String, Object> ordersMap = new HashMap<>();
        ordersMap.put("orders", newArrayList());
        ordersMap.put("count", 0);
        ordersMap.put("start", 1);
        return ordersMap;
    }
}
