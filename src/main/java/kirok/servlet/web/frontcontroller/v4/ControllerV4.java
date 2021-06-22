package kirok.servlet.web.frontcontroller.v4;

import java.util.Map;
import kirok.servlet.web.frontcontroller.ModelView;


public interface ControllerV4 {

    String process(Map<String, String> paramMap, Map<String, Object> model);

}
