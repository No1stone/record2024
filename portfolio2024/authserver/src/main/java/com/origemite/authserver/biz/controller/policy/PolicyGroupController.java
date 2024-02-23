package com.origemite.authserver.biz.controller.policy;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.*;
import com.origemite.authserver.biz.service.PolicyGroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/policy-group")
@CrossOrigin
public class PolicyGroupController {

    private final PolicyGroupService policyGroupService;

    @PostMapping("")
    public ResponseEntity PolociGroupSave(@Validated @RequestBody ReqPolicyGroupSave dto) {
        policyGroupService.PolociGroupSave(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("")
    public List<ResPolicyGroupSelect> PolicyGroupSelect(@Validated @ModelAttribute(name = "dto") ReqPolicyGroupSelect dto) throws CustomNotFoundException {
        return policyGroupService.PolicyGroupSelect(dto);
    }


    @PutMapping("")
    public ResponseEntity PolicyGoroupBulkSave(@RequestBody ReqPolicyGroupBulkSave dto) throws CustomNotFoundException {
        policyGroupService.PolicyGoroupBulkSave(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("")
    public ResponseEntity PolicyGoroupDelete(@RequestBody ReqPolicyGroupDelete dto) throws CustomNotFoundException {
        policyGroupService.PolicyGoroupDelete(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
