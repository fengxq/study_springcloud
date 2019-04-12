package fz.fxq.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user/mvc")
public class UserMVCController {

    @RequestMapping("list")
    public ModelAndView userList() {
        ModelAndView mav = new ModelAndView("userList");
        mav.addObject("userTest", "userTest1");
        List<Map<String, String>> userList = new ArrayList<>();
        userList.add(new HashMap<String, String>() {
            {
                put("userId", "userId1");
                put("userName", "userName1");
            }
        });
        userList.add(new HashMap<String, String>() {
            {
                put("userId", "userId2");
                put("userName", "userName2");
            }
        });
        mav.addObject("userList", userList);
        return mav;
    }
}
