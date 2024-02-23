package com.origemite.authserver.biz.service;

import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.advice.excep.CustomRuntimeException;
import com.origemite.authserver.biz.controller.policy.vo.*;
import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import com.origemite.authserver.data.db.repo.TbPolicyGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PolicyGroupService {

    private final TbPolicyGroupRepo tbPolicyGroupRepo;

    @Transactional
    public String PolociGroupSave(ReqPolicyGroupSave dto) {
        return tbPolicyGroupRepo.save(dto.toTbPolicyGroup()).getPlcId()
                ;
    }

    public List<ResPolicyGroupSelect> PolicyGroupSelect(ReqPolicyGroupSelect dto) throws CustomNotFoundException {
        boolean chkPlc = false;
        boolean chkSvc = false;
        List<ResPolicyGroupSelect> result = new ArrayList<>();
        if (dto.getPlcId() != null) {
            chkPlc = true;
        }
        if (dto.getSvcId() != null) {
            if (!ServiceCode.LIST.stream().map(e -> e.name()).collect(Collectors.toList()).contains(dto.getSvcId())) {
                throw new CustomNotFoundException("서비스 코드를 확인해주세요");
            }
            chkSvc = true;
        }
        if (chkPlc && chkSvc) {
            result = tbPolicyGroupRepo.findByPlcIdAndSvcId(dto.getPlcId(), dto.getSvcId())
                    .stream().map(TbPolicyGroup::toTbPolicyGroup).collect(Collectors.toList());
        } else {
            if (chkPlc) {
                result = tbPolicyGroupRepo.findByPlcId(dto.getPlcId())
                        .stream().map(TbPolicyGroup::toTbPolicyGroup).collect(Collectors.toList());
            }
            if (chkSvc) {
                result = tbPolicyGroupRepo.findBySvcId(dto.getSvcId())
                        .stream().map(TbPolicyGroup::toTbPolicyGroup).collect(Collectors.toList());
            }
        }
        return result;
    }

    @Transactional
    public void PolicyGoroupBulkSave(ReqPolicyGroupBulkSave dto) throws CustomNotFoundException {
        tbPolicyGroupRepo.saveAll(dto.toValidateTB());
    }

    @Transactional
    public void PolicyGoroupDelete(ReqPolicyGroupDelete dto) {
        tbPolicyGroupRepo.deleteById(dto.toTbPolicyGroupId());
    }
}
