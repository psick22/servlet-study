package kirok.servlet.basic.request;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 쿼리 파라미터 http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        System.out.println("전체 파라미터 조회 start ");

        request.getParameterNames().asIterator().forEachRemaining(
            paramName -> System.out.println(paramName + " = " + request.getParameter(paramName)));

        String age = request.getParameter("age");
        String username = request.getParameter("username");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        // 복수 파라미터
        String[] usernames = request.getParameterValues("username");
        for (String s : usernames) {
            System.out.println("username = " + s);
        }

    }
}
