package fz.fxq.user.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JsonHelp {
    private static Logger log = LoggerFactory.getLogger(JsonHelp.class);

    public JsonHelp() {
    }

    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    public static HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static Cookie[] getCookies() {
        return getRequest().getCookies();
    }

    public static String getCookieVal(String key) {
        Cookie[] cookies = getCookies();
        if (cookies == null) {
            return "";
        } else {
            String val = "";

            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(key)) {
                    val = cookie.getValue();

                    try {
                        val = val != null ? URLDecoder.decode(val, "utf-8") : "";
                    } catch (UnsupportedEncodingException var6) {
                        val = "";
                    }
                }
            }

            return val;
        }
    }

    public static boolean delCookie(String key) {
        Cookie[] cookies = getCookies();
        if (cookies == null) {
            return true;
        } else {
            for (int i = 0; i < cookies.length; ++i) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(key)) {
                    cookie.setValue((String) null);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    getResponse().addCookie(cookie);
                    return true;
                }
            }

            return false;
        }
    }

    public static Map getReqFormMap() {
        Map<String, Object> map = new HashMap();
        Map<String, String[]> paramMap = getRequest().getParameterMap();
        Iterator var2 = paramMap.entrySet().iterator();

        while (var2.hasNext()) {
            Map.Entry<String, String[]> entry = (Map.Entry) var2.next();
            String[] vals = (String[]) entry.getValue();
            map.put(entry.getKey(), vals.length <= 1 ? vals[0] : vals);
        }

        return map;
    }


    public static String getIpAddr() {
        return getIpAddr(getRequest());
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip) && ip.indexOf(",") != -1) {
            ip = ip.split(",")[0];
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static ServletContext getServletContext() {
        return getRequest().getServletContext();
    }

    public static String encodeURIComponent(String str) {
        return URLEncoder.encode(str);
    }

    public static String decodeURIComponent(String jsEncodeUrl) {
        try {
            return URLDecoder.decode(jsEncodeUrl, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            log.error(var2.getMessage());
            return "";
        }
    }
}
