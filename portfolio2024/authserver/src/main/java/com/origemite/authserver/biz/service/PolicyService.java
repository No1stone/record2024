package com.origemite.authserver.biz.service;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.data.db.entity.TbPolicy;
import com.origemite.authserver.data.db.repo.TbPolicyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PolicyService {

    private final TbPolicyRepo tbPolicyRepo;

    public String PolociSave(ReqPolicySave dto) {
        return tbPolicyRepo.save(dto.toPolicy()).getPlcId();
    }


    public ResPolicySelect PolicySelect(String plcId) throws CustomNotFoundException {
        return tbPolicyRepo.findById(plcId).orElseThrow(() -> new CustomNotFoundException("존재하지 않는 정책 id 입니다.")).toResPolicySelect();
    }
}
