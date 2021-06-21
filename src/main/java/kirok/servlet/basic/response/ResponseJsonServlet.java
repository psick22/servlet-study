package kirok.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.basic.HelloData;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")

public class ResponseJsonServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("kgirok");

        // helloData -> json 변환
        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);

    }
}
