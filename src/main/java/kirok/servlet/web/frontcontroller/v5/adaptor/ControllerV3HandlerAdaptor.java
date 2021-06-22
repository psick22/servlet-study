package kirok.servlet.web.frontcontroller.v5.adaptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.v3.ControllerV3;
import kirok.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControllerV3HandlerAdaptor implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler;
        Map<String, String> paramMap = createParamMap(request);
        return controller.process(paramMap);
    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
            paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
