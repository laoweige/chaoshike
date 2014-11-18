package test.java.com.zhaopin.advertisement.web.controllers.products;

import com.zhaopin.advertisement.thirdPartyClient.RDClient;
import com.zhaopin.advertisement.thirdPartyClient.utils.DateTimeUtils;
import com.zhaopin.advertisement.web.services.Api;
import com.zhaopin.advertisement.web.services.UserSession;
import jersey.repackaged.com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class SearchPositionTopProductControllerTest {

    @Mock
    private Api api;
    @Mock
    private RDClient rdApi;
    @Mock
    private UserSession userSession;

    private SearchPositionTopProductController controller;

    @Before
    public void setUp() {
        initMocks(this);
        controller = new SearchPositionTopProductController(api, rdApi, userSession);
    }

    @Test
    public void should_get_positions_for_user() throws Exception {

        Response response = mock(Response.class);
        String buser = "buser";
        String productId = "1";

        HttpSession mockSession = mock(HttpSession.class);
        when(userSession.currentUser()).thenReturn(buser);
        when(userSession.currentLoginBUID()).thenReturn(buser);

        when(rdApi.getPositionsByEntryPoint(buser, buser)).thenReturn(response);
        when(api.getProduct(productId)).thenReturn(response);


        when(mockSession.getAttribute(anyString())).thenReturn("ThoughtWorks");
        when(mockSession.getAttribute("RDUserID")).thenReturn(null);
        given(response.getStatus()).willReturn(Response.Status.OK.getStatusCode());
        given(response.readEntity(List.class)).willReturn(Lists.newArrayList());
        given(response.readEntity(Map.class)).willReturn(new HashMap() {{
        }});

        ModelAndView result = controller.getPositions(productId, mockSession);

        assertThat(result.getViewName(), is("order/search/step2_positions"));
        assertThat(result.getModel().get("positions"), is(notNullValue()));
        assertThat(result.getModel().get("product"), is(notNullValue()));
    }

    @Test
    public void should_get_product_form() throws Exception {
        Response productResponse = mock(Response.class);
        Response priceResponse = mock(Response.class);
        Response hasCapacity = mock(Response.class);
        Response invoice = mock(Response.class);
        Response sellStrategies = mock(Response.class);
        Response startTime = mock(Response.class);
        Response sellerResponse = mock(Response.class);

        given(api.getProduct(anyString())).willReturn(productResponse);
        given(api.getProductPrice(anyString(), any(Form.class))).willReturn(priceResponse);
        given(api.getProductHasCapacity(anyString(), any(Form.class))).willReturn(hasCapacity);
        given(api.getLatestInvoice(anyString())).willReturn(invoice);
        given(api.getSellStrategies(anyString())).willReturn(sellStrategies);
        given(api.getOrderStartTime(anyString(), anyString(), anyString())).willReturn(startTime);
        given(api.getSellerByCompanyId(anyString())).willReturn(sellerResponse);

        given(hasCapacity.readEntity(Map.class)).willReturn(new HashMap() {{
            put("5", true);
            put("7", true);
            put("15", true);
            put("20", true);
        }});

        given(sellStrategies.readEntity(List.class)).willReturn(
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("productId", 1);
                        put("duration", 7);
                        put("discount", 0.95f);
                        put("unit", "day");
                        put("orderNumber", 1);
                        put("zone", "orders.seven_days");
                    }});
                }});

        given(sellStrategies.getStatus()).willReturn(Response.Status.OK.getStatusCode());

        given(startTime.readEntity(String.class)).willReturn(
                new DateTime(DateTimeUtils.tomorrow()).toString("yyyy-MM-dd"));

        HashMap<String, Object> positionMap = new HashMap<String, Object>() {{
            put("positionNumber", "12344");
            put("expireDate", DateTime.now().toString("yyyy-MM-dd"));
        }};

        given(rdApi.getPosition(anyString())).willReturn(positionMap);
        given(productResponse.getStatus()).willReturn(Response.Status.OK.getStatusCode());
        given(productResponse.readEntity(Map.class)).willReturn(new HashMap() {{
        }});
        given(priceResponse.readEntity(Map.class)).willReturn(new HashMap() {{
            put("price", "1000");
        }});

        given(invoice.readEntity(Map.class)).willReturn(new HashMap() {{
            put("orderStatus", new Integer(0));
            put("id", new Integer(1));
        }});
        given(sellerResponse.readEntity(Map.class)).willReturn(new HashMap() {{
        }});

        HttpSession mockSession = mock(HttpSession.class);
        when(mockSession.getAttribute("LoginBUID")).thenReturn("buser");
        when(mockSession.getAttribute("companyId")).thenReturn("buser");
        LinkedMultiValueMap<String, String> linkedMultiValueMap = new LinkedMultiValueMap<String, String>();
        linkedMultiValueMap.add("positionNumber", "CC120070365J90308047000");
        ModelAndView modelAndView = controller.getOrderForm(linkedMultiValueMap, mockSession);

        Assert.assertThat(modelAndView.getViewName(), is("order/search/step3_conditions"));
        Assert.assertThat(modelAndView.getModel().get("position"), is(notNullValue()));
        Assert.assertThat(modelAndView.getModel().get("product"), is(notNullValue()));
        Assert.assertThat(modelAndView.getModel().get("invoice"), is(notNullValue()));
    }

    @Test
    public void should_get_product_form_when_get_mode() throws Exception {
        Response productResponse = mock(Response.class);
        Response priceResponse = mock(Response.class);
        Response hasCapacity = mock(Response.class);
        Response invoice = mock(Response.class);
        Response sellStrategies = mock(Response.class);
        Response startTime = mock(Response.class);
        Response sellerResponse = mock(Response.class);

        given(api.getProduct(anyString())).willReturn(productResponse);
        given(api.getProductPrice(anyString(), any(Form.class))).willReturn(priceResponse);
        given(api.getProductHasCapacity(anyString(), any(Form.class))).willReturn(hasCapacity);
        given(api.getLatestInvoice(anyString())).willReturn(invoice);
        given(api.getSellStrategies(anyString())).willReturn(sellStrategies);
        given(api.getOrderStartTime(anyString(), anyString(), anyString())).willReturn(startTime);
        given(api.getSellerByCompanyId(anyString())).willReturn(sellerResponse);

        given(hasCapacity.readEntity(Map.class)).willReturn(new HashMap() {{
            put("5", true);
            put("7", true);
            put("15", true);
            put("20", true);
        }});

        given(sellStrategies.readEntity(List.class)).willReturn(
                new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        put("productId", 1);
                        put("duration", 7);
                        put("discount", 0.95f);
                        put("unit", "day");
                        put("orderNumber", 1);
                        put("zone", "orders.seven_days");
                    }});
                }});

        given(sellerResponse.readEntity(Map.class)).willReturn(new HashMap() {{
        }});

        given(sellStrategies.getStatus()).willReturn(Response.Status.OK.getStatusCode());

        given(startTime.readEntity(String.class)).willReturn(
                new DateTime(DateTimeUtils.tomorrow()).toString("yyyy-MM-dd"));

        HashMap<String, Object> positionMap = new HashMap<String, Object>() {{
            put("positionNumber", "12344");
            put("expireDate", DateTime.now().toString("yyyy-MM-dd"));
        }};

        given(rdApi.getPosition(anyString())).willReturn(positionMap);
        given(productResponse.getStatus()).willReturn(Response.Status.OK.getStatusCode());
        given(productResponse.readEntity(Map.class)).willReturn(new HashMap() {{
        }});
        given(priceResponse.readEntity(Map.class)).willReturn(new HashMap() {{
            put("price", "1000");
        }});

        given(invoice.readEntity(Map.class)).willReturn(new HashMap() {{
            put("orderStatus", new Integer(0));
            put("id", new Integer(1));
        }});
        HttpSession mockSession = mock(HttpSession.class);
        when(mockSession.getAttribute("userFrom")).thenReturn("IPIN");
        when(mockSession.getAttribute("LoginBUID")).thenReturn("buser");
        when(mockSession.getAttribute("companyId")).thenReturn("buser");
        ModelAndView modelAndView = controller.getOrderFormVL("1", "CC120070365J90308047000", "74B09A0075D964155B880D604AA9BE46", mockSession);

        Assert.assertThat(modelAndView.getViewName(), is("order/search/step3_conditions"));
        Assert.assertThat(modelAndView.getModel().get("position"), is(notNullValue()));
        Assert.assertThat(modelAndView.getModel().get("product"), is(notNullValue()));
        Assert.assertThat(modelAndView.getModel().get("invoice"), is(notNullValue()));
    }
}
