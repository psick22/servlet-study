package kirok.servlet.web.frontcontroller.v5.adaptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.MyView;
import kirok.servlet.web.frontcontroller.v3.ControllerV3;
import kirok.servlet.web.frontcontroller.v4.ControllerV4;
import kirok.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControllerV4HandlerAdaptor implements
    MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws ServletException, IOException {

        ControllerV4 controller = (ControllerV4) handler;
        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;

    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator().forEachRemaining(
            paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
