package kirok.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kirok.servlet.domain.member.Member;
import kirok.servlet.domain.member.MemberRepository;
import kirok.servlet.web.frontcontroller.MyView;
import kirok.servlet.web.frontcontroller.v2.ControllerV2;

public class MemberListControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");


    }
}
