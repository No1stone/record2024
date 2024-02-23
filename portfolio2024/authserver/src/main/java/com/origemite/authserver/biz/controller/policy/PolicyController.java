package com.origemite.authserver.biz.controller.policy;


import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicyId;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.biz.service.PolicyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/policy")
@CrossOrigin
public class PolicyController {

    private final PolicyService policyService;

    @PostMapping({"","/"})
    public ResponseEntity PolociSave(@RequestBody ReqPolicySave dto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResPolicyId.builder().plcId(policyService.PolociSave(dto)).build());
    }

    @GetMapping("/{plcId}")
    public ResPolicySelect PolicySelect(@PathVariable(name = "plcId")String plcId) throws CustomNotFoundException {
        return policyService.PolicySelect(plcId);
    }

}
