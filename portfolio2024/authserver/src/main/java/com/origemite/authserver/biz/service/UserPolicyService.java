package com.origemite.authserver.biz.service;

import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicyDelete;
import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicySave;
import com.origemite.authserver.biz.controller.user.vo.ResUserPolicySelect;
import com.origemite.authserver.data.db.entity.TbUserPolicy;
import com.origemite.authserver.data.db.repo.TbUserPolicyRepo;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import com.origemite.authserver.data.db.repo.dsl.vo.UserPolicyDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPolicyService {

    private final TbUserPolicyRepo tbUserPolicyRepo;
    private final TbUserRepo tbUserRepo;

    @Transactional
    public void UserPolicyServiceSave(ReqUserPolicySave dto) {
        tbUserPolicyRepo.save(dto.toUserPolicy());
    }

    public List<ResUserPolicySelect> UserPolicyServiceSelect(String usrId) {
       return tbUserPolicyRepo.findByUsrId(usrId).stream().map(TbUserPolicy::toUserPolicySelect)
                .collect(Collectors.toList());
    }

    public void UserPolicyServiceDelete(ReqUserPolicyDelete dto) {
        tbUserPolicyRepo.deleteById(dto.toUserPolicy());
    }

    public List<UserPolicyDto> UserToPolicy(String usrId){
       return tbUserRepo.UserPolicySelect(usrId);
    }

}
