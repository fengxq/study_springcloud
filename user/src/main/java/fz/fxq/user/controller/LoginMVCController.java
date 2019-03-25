package fz.fxq.user.controller;

import fz.fxq.user.vo.LoginResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login/mvc")
public class LoginMVCController {

    @GetMapping("login1")
    public String loginJSP() {

        System.out.println("000000000000000000000000000000000000000000");
        return "login";
    }

    @GetMapping("login2")
    public ModelAndView login2() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("name", "abc");
        return mav;
    }

    @GetMapping("login3")
    @ResponseBody
    public LoginResultVO login3() {
        LoginResultVO loginResultVO = new LoginResultVO();
        loginResultVO.setCode(1);
        loginResultVO.setMsg("SUCCESS");
        return loginResultVO;
    }

    @GetMapping("login4")
    public ModelAndView login4() {
        ModelAndView mav = new ModelAndView("login4");

        LoginResultVO loginResultVO = new LoginResultVO();
        loginResultVO.setCode(1);
        loginResultVO.setMsg("SUCCESS");
        mav.addObject("name", loginResultVO);
        return mav;
    }
}
