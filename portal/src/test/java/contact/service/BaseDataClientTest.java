package test.java.contact.service;

import com.zhaopin.advertisement.web.services.BaseDataClient;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BaseDataClientTest {

    @Test
    public void testGetJobTypeName() throws Exception {
        MatcherAssert.assertThat(BaseDataClient.getJobTypeName("100000"), is("农/林/牧/渔业"));
    }

    @Test
    public void testGetSubJobTypeName() throws Exception {
        assertThat(BaseDataClient.getSubJobTypeName("907"), is("行长/副行长"));
    }

    @Test
    public void testGetCityName() throws Exception {
        assertThat(BaseDataClient.getCityName("530"), is("北京"));
    }
}
