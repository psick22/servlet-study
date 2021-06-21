package kirok.servlet.web.frontcontroller.v3.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.domain.member.Member;
import kirok.servlet.domain.member.MemberRepository;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.MyView;
import kirok.servlet.web.frontcontroller.v2.ControllerV2;
import kirok.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");

        mv.getModel().put("member", member);
        return mv;
    }
}
