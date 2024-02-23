package com.origemite.authserver.biz.controller.user;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.user.vo.ResUser;
import com.origemite.authserver.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping("/{usrId}")
    public ResUser selectUser(@PathVariable(name = "usrId") String usrId) throws CustomNotFoundException {
        return userService.selectUser(usrId);
    }
}
