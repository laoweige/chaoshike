package test.java.com.zhaopin.advertisement.web.authority;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class AuthorityAnnotationInterceptorTest {

    private AuthorityAnnotationInterceptor authorityAnnotationInterceptor;
    private HandlerMethod mockHandler;
    private HttpServletRequest mockRequest;

    @Before
    public void setUp() {
        mockHandler = mock(HandlerMethod.class);
        mockRequest = mock(HttpServletRequest.class);
        authorityAnnotationInterceptor = new AuthorityAnnotationInterceptor();
        UserCookieCheck userCookieCheck = new UserCookieCheck();
        ReflectionTestUtils.setField(authorityAnnotationInterceptor, "userCookieCheck", userCookieCheck);
    }

    @Test
    public void should_return_true_when_need_to_ignore_authority() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(mock(IgnoreAuthority.class));

        assertTrue(authorityAnnotationInterceptor.preHandle(mock(HttpServletRequest.class),
                mock(HttpServletResponse.class), mockHandler));
    }

    @Test
    public void should_return_true_when_authority_correct() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(null);
        when(mockRequest.getCookies()).thenReturn((Cookie[]) asList(
                new Cookie("RDsUserInfo", "266120664E6155664061546644615F6" +
                        "63F612A664E6110661661176607615466456155664B615F662661" +
                        "2A664E6144397A2F5F66316120664E6153664A615D6647615566" +
                        "4261516645615F6631612A664E61CC050C3F173883320D66036" +
                        "10D661D612F0BA6EA08378B325F66276129664E615F66366129664" +
                        "E6110661661176607615466456155664B6124664261566640614A" +
                        "6610610B661E615F66206130664E61556648612566276159664A61" +
                        "496642614466426151664961566646615F66376120664E6153664A61" +
                        "5D66476155664261516645615F6637612A664E61CC050C3F17388332" +
                        "0D6603610D661D612F0BA6EA08378B325F663F6129664E615466436154" +
                        "6642615F66306120664E61516640615466486131662761596642615466" +
                        "42615F66306125664E612766306153664A615D664761556642615166456" +
                        "15C6648612066326159663061276644615D664A615066426155664661526" +
                        "64B615F66376127664E615466486137663A6159664B615F663A6134664E" +
                        "61556643614A664261556646615F66326128664E61546648614")).toArray());

        HttpSession mockSession = mock(HttpSession.class);
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute("userFrom")).thenReturn("IPIN");
        when(mockSession.getAttribute("companyId")).thenReturn("79941156");
        when(mockSession.getAttribute("companyName")).thenReturn("推广平台ipin测试公司");
        assertTrue(authorityAnnotationInterceptor.preHandle(mockRequest,
                mock(HttpServletResponse.class), mockHandler));
        verify(mockSession).setAttribute("companyName", "推广平台ipin测试公司");
        verify(mockSession).setAttribute("companyId", "79941156");
        verify(mockSession).setAttribute("userFrom", "IPIN");
    }

    @Test
    public void should_return_false_when_authority_incorrect() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(null);
        when(mockRequest.getCookies()).thenReturn((Cookie[]) asList(
                new Cookie("RDsUserInfo", "266120664E6155664061546644615F6" +
                        "63F612A664E611066166117660761546645615050C3F17388332" +
                        "0D6603610D661D612F0BA8B325F663F6129664E615466436154" +
                        "6642615F66306120664E61516640615466486131662761596642615466" +
                        "42615F66306125664E612766306153664A615D664761556642615166456" +
                        "15C6648612066326159663061276644615D664A615066426155664661526" +
                        "64B615F66376127664E615466486137663A6159664B615F663A6134664E" +
                        "61556643614A664261556646615F66326128664E61546648614")).toArray());

        HttpSession mockSession = mock(HttpSession.class);
        when(mockRequest.getSession()).thenReturn(mockSession);
        assertFalse(authorityAnnotationInterceptor.preHandle(mockRequest,
                mock(HttpServletResponse.class), mockHandler));
    }

    @Test
    public void should_return_true_when_authority_correct_rd() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(null);
        when(mockRequest.getCookies()).thenReturn((Cookie[]) asList(
                new Cookie("RDsUserInfo", "347320664E73556A47655861426457734467" +
                        "5C77516850735F663F73296A4A6500611664057307670577" +
                        "17683E73096612735C6A226526614E645" +
                        "D733D67247758685A73266637735A6A46655A61" +
                        "4364567344675A77566857735F663173296A4A65692E" +
                        "692AB720703967239511157301660073136A4665692E" +
                        "692AB720703967239511157301660073136A4565692E69" +
                        "2AB720703967239511157301660073136A446553612764" +
                        "2B734E675B7723685A7321663E735A6A1F650D61106412731" +
                        "C6718774B680C73056633731D6A1F6509611C6416731A67047" +
                        "74B6802730B661E73496A1465066148643573276757775468" +
                        "5A73256627735A6A406545614164557353675B775D685B735" +
                        "66642735C6A33652C614E64577343675A7755685173546643" +
                        "73506A4E655361376428734E67DF0975FD5B2CB51FF3116138" +
                        "1B34903248642A733E6757775568517354664273576A4765586" +
                        "142645D7330672E7758685473576643735C6A366524614E64567" +
                        "348673F7724685C735F663073266A4A652B613064577341675A7" +
                        "75568567354664073516A42655361376427734E67297726685073" +
                        "56664373576A406558614064507346672E775C6851735466437357" +
                        "6A476558614064567343675A775E68257327664E73526A41655361" +
                        "20642F734E6759775E68287334664E73556A43655A615D6457734267" +
                        "5A775E68347330664E73566A47655B6148641"),
                new Cookie("ddw", "8c0fa297909ab039c44ca473b91b3cc9997f9db2ac486e63"),
                new Cookie("crp", "zhaopin")
        ).toArray());

        HttpSession mockSession = mock(HttpSession.class);
        when(mockRequest.getSession()).thenReturn(mockSession);
        when(mockSession.getAttribute("userFrom")).thenReturn("RD");
        when(mockSession.getAttribute("companyId")).thenReturn("123456");
        when(mockSession.getAttribute("companyName")).thenReturn("test");
        assertTrue(authorityAnnotationInterceptor.preHandle(mockRequest,
                mock(HttpServletResponse.class), mockHandler));
        verify(mockSession).setAttribute("companyName", "纵锐强科技分公司");
        verify(mockSession).setAttribute("companyId", "100000079");
    }

    @Test
    public void should_return_true_when_both_ipin_rd() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(null);
        when(mockRequest.getCookies()).thenReturn((Cookie[]) asList(
                new Cookie("RDsUserInfo", "347320664E73556A47655861426457734467" +
                        "5C77516850735F663F73296A4A6500611664057307670577" +
                        "17683E73096612735C6A226526614E645" +
                        "D733D67247758685A73266637735A6A46655A61" +
                        "4364567344675A77566857735F663173296A4A65692E" +
                        "692AB720703967239511157301660073136A4665692E" +
                        "692AB720703967239511157301660073136A4565692E69" +
                        "2AB720703967239511157301660073136A446553612764" +
                        "2B734E675B7723685A7321663E735A6A1F650D61106412731" +
                        "C6718774B680C73056633731D6A1F6509611C6416731A67047" +
                        "74B6802730B661E73496A1465066148643573276757775468" +
                        "5A73256627735A6A406545614164557353675B775D685B735" +
                        "66642735C6A33652C614E64577343675A7755685173546643" +
                        "73506A4E655361376428734E67DF0975FD5B2CB51FF3116138" +
                        "1B34903248642A733E6757775568517354664273576A4765586" +
                        "142645D7330672E7758685473576643735C6A366524614E64567" +
                        "348673F7724685C735F663073266A4A652B613064577341675A7" +
                        "75568567354664073516A42655361376427734E67297726685073" +
                        "56664373576A406558614064507346672E775C6851735466437357" +
                        "6A476558614064567343675A775E68257327664E73526A41655361" +
                        "20642F734E6759775E68287334664E73556A43655A615D6457734267" +
                        "5A775E68347330664E73566A47655B6148641")
        ).toArray());

        HttpSession mockSession = mock(HttpSession.class);
        when(mockSession.getAttribute("userFrom")).thenReturn("RD");
        when(mockSession.getAttribute("companyId")).thenReturn("123456");
        when(mockSession.getAttribute("companyName")).thenReturn("test");
        when(mockRequest.getSession()).thenReturn(mockSession);
        assertTrue(authorityAnnotationInterceptor.preHandle(mockRequest,
                mock(HttpServletResponse.class), mockHandler));
        verify(mockSession).setAttribute("companyName", "纵锐强科技分公司");
        verify(mockSession).setAttribute("companyId", "100000079");
    }

    @Test
    public void should_return_false_when_authority_incorrect_rd() throws Exception {
        when(mockHandler.getMethodAnnotation(IgnoreAuthority.class)).thenReturn(null);
        when(mockRequest.getCookies()).thenReturn((Cookie[]) asList(
                new Cookie("RDsUserInfo", "1322546546464613232135464876465ad")
        ).toArray());

        HttpSession mockSession = mock(HttpSession.class);
        when(mockRequest.getSession()).thenReturn(mockSession);
        assertFalse(authorityAnnotationInterceptor.preHandle(mockRequest,
                mock(HttpServletResponse.class), mockHandler));
    }
}
