package cn.com.felix.core.utils;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.MediaType;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ResponseUtils {


    public static void response(ServletResponse response, MediaType mediaType, int statusCode, String message) throws IOException {


        log.debug("[Response Utils] |- Write Response with Status : [{}], and Message : [{}]", statusCode, message);

        HttpServletResponse resp = WebUtils.toHttp(response);
        resp.setContentType(mediaType.toString());
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setStatus(statusCode);
        PrintWriter writer = resp.getWriter();
        writer.write(message);
        writer.flush();
    }

    public static void responseJson(ServletResponse response, int statusCode, Object message) throws IOException {
        response(response, MediaType.APPLICATION_JSON_UTF8, statusCode, JSON.toJSONString(message));
    }

    public static void responseInvalidLogin(ServletResponse response, int statusCode) throws IOException {
        response(response, MediaType.ALL, statusCode, "login state is invalid");
    }

    public static void responseInvalidPermission(ServletResponse response, int statusCode) throws IOException {
        response(response, MediaType.ALL, statusCode, "you have no enough permission to access");
    }

}
