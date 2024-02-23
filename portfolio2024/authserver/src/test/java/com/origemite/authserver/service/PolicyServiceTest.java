package com.origemite.authserver.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.biz.service.PolicyService;
import com.origemite.authserver.data.db.entity.TbPolicy;
import com.origemite.authserver.data.db.repo.TbPolicyRepo;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PolicyServiceTest {
    @Mock
    private TbPolicyRepo tbPolicyRepo;

    @InjectMocks
    private PolicyService policyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("정책 저장 Vo convert 테스트")
    void testPolociSaveConvertTest() throws JsonProcessingException {
        // Given
        ReqPolicySave dto = ReqPolicySave.builder()
                .ctmId("CTMID1234")
                .plcName("PLCID1234")
                .build(); // Set properties accordingly
        // When
        TbPolicy tbPolicy = dto.toPolicy();
        // Then
        assertNotNull(tbPolicy.getPlcId());
        assertNotEquals(tbPolicy.getPlcId(), "");
        assertEquals(tbPolicy.getCtmId(), dto.getCtmId());
        assertEquals(tbPolicy.getPlcName(), dto.getPlcName());

    }

    @Test
    @DisplayName("정책 저장 Repo테스트")
    void testPolociSaveJPARepoTest() throws JsonProcessingException {
        //given
        ReqPolicySave dto = ReqPolicySave.builder()
                .ctmId("CTMID1234")
                .plcName("PLCID1234")
                .build(); // Set properties accordingly
        TbPolicy tbPolicy = dto.toPolicy();
        given(tbPolicyRepo.save(tbPolicy)).willReturn(tbPolicy);
        // When

        when(tbPolicyRepo.save(tbPolicy)).thenReturn(tbPolicy);

        // Then
        TbPolicy save = tbPolicyRepo.save(tbPolicy);
        String result = tbPolicy.getPlcId();
        assertEquals(result, save.getPlcId());
        tbPolicyRepo.findById(result);
    }

    @Test
    @DisplayName("정책 조회 실패 Repo테스트")
    void testPolociSelectFailJPARepoTest() throws JsonProcessingException {
        //given

        // When

        // Then
        assertThrows(CustomNotFoundException.class
                , () -> policyService.PolicySelect("abc"),
                "존재하지 않는 정책 id 입니다. 예외가 발생해야 합니다.");
    }

}
