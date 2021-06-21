package kirok.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.MyView;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);

}
