package kirok.servlet.web.frontcontroller.v3.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.MyView;
import kirok.servlet.web.frontcontroller.v2.ControllerV2;
import kirok.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
