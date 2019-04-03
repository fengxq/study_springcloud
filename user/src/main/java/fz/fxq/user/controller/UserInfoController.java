package fz.fxq.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/info")
public class UserInfoController {

    @GetMapping("get/{userId}")
    public String getUserInfo(@PathVariable String userId) {
        return "get user " + userId + " info ...";
    }
}
