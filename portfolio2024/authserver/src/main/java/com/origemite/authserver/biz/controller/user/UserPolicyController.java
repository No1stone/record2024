package com.origemite.authserver.biz.controller.user;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicyDelete;
import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicySave;
import com.origemite.authserver.biz.controller.user.vo.ResUserPolicySelect;
import com.origemite.authserver.biz.service.UserPolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/user-policy")
@CrossOrigin
public class UserPolicyController {

    private final UserPolicyService userPolicyService;

    @PostMapping("")
    public ResponseEntity UserPolicyServiceSave(@RequestBody ReqUserPolicySave dto){
        userPolicyService.UserPolicyServiceSave(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{usrId}")
    public List<ResUserPolicySelect> UserPolicyServiceSelect(@PathVariable(name = "usrId")String usrId) throws CustomNotFoundException {
        return userPolicyService.UserPolicyServiceSelect(usrId);
    }
    @DeleteMapping("")
    public ResponseEntity UserPolicyServiceDelete(@RequestBody ReqUserPolicyDelete dto){
        userPolicyService.UserPolicyServiceDelete(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
