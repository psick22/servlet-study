package kirok.servlet.web.frontcontroller.v4.controller;

import java.util.List;
import java.util.Map;
import kirok.servlet.domain.member.Member;
import kirok.servlet.domain.member.MemberRepository;
import kirok.servlet.web.frontcontroller.ModelView;
import kirok.servlet.web.frontcontroller.v3.ControllerV3;
import kirok.servlet.web.frontcontroller.v4.ControllerV4;

public class MemberListControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "members";
    }
}
