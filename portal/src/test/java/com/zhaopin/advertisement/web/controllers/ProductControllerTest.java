package test.java.com.zhaopin.advertisement.web.controllers;

import com.zhaopin.advertisement.web.services.Api;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

import static jersey.repackaged.com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductControllerTest {

    @Mock
    private Api api;

    private ProductController productController;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        productController = new ProductController(api);
    }

    @Test
    public void should_get_product_list() throws Exception {
        Response response = mock(Response.class);
        HttpSession mockSession = mock(HttpSession.class);
        when(mockSession.getAttribute(anyString())).thenReturn("ThoughtWorks");
        given(api.getProductList()).willReturn(response);
        given(response.readEntity(List.class)).willReturn(newArrayList(new HashMap<String, String>()));

        ModelAndView modelAndView = productController.getProductList(mockSession);

        assertThat(modelAndView.getViewName(), is("product/list"));
        assertThat(modelAndView.getModel().get("products"), is(notNullValue()));
    }

    @Test
    public void dem() {
        String s = "12345|ThoughtWorks";
        String[] split = s.split("\\|");
    }


}