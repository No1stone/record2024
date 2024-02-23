package com.origemite.authserver.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.annotation.FilterMvcConfiguration;
import com.origemite.authserver.biz.controller.policy.PolicyGroupController;
import com.origemite.authserver.biz.controller.policy.vo.*;
import com.origemite.authserver.biz.service.PolicyGroupService;
import com.origemite.authserver.cmm.ServiceCode;
import com.origemite.authserver.data.db.entity.TbPolicyGroup;
import com.origemite.authserver.data.db.repo.TbPolicyGroupRepo;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PolicyGroupController.class)
@FilterMvc
public class PolicyGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FilterMvcConfiguration filterMvcConfiguration;

    @MockBean
    private PolicyGroupService policyGroupService;

    private ResultActions policyGroupSaveApi(ReqPolicySave req) throws Exception {
        return mockMvc.perform(post("/api/v1/policy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );
    }


    @DisplayName("정책그룹 컨트롤러 저장 200 테스트")
    @ParameterizedTest
    @EnumSource(ServiceCode.class)
    public void PolicyGroupSave200Test(ServiceCode sc) throws Exception {
        ReqPolicyGroupSave dto = ReqPolicyGroupSave.builder()
                .plcId("PLCTESTID")
                .svcId(sc.name())
                .svcRole(99)
                .build();

        given(policyGroupService.PolociGroupSave(dto)).willReturn("PLCIDTESTID");

        mockMvc.perform(post("/api/v1/policy-group")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isCreated());
    }

    @DisplayName("정책그룹 컨트롤러 조회 200 테스트")
    @ParameterizedTest
    @EnumSource(ServiceCode.class)
    public void PolicyGroupSelect200Test(ServiceCode sc) throws Exception {
        ReqPolicyGroupSelect dto = ReqPolicyGroupSelect.builder()
                .plcId("TESTPLCID")
                .svcId(sc.name())
                .build();

        given(policyGroupService.PolicyGroupSelect(dto)).willReturn(Arrays.asList(
                ResPolicyGroupSelect.builder()
                        .plcId("TESTPLCID")
                        .svcId(sc.name())
                        .svcRole(99)
                        .build()
        ));

        mockMvc.perform(get("/api/v1/policy-group")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("svcId",sc.name())
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isOk());
    }

    @DisplayName("정책그룹 컨트롤러 벌크 저장 200 테스트")
    @Test
    public void PolicyGroupSBulkave200Test() throws Exception {

        HashMap<String, Set<Integer>> policyRole = new HashMap<>();

        for(String e: ServiceCode.LIST.stream().map(e -> e.name()).toList()){
            Set<Integer> data = new HashSet<>();
            data.add(1);
            data.add(2);
            policyRole.put(e, data);
        }

        ReqPolicyGroupBulkSave dto = ReqPolicyGroupBulkSave.builder()
                .plcId("PLCTESTID")
                .policyRole(policyRole)
                .build();

        mockMvc.perform(put("/api/v1/policy-group")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isCreated());
    }

    @DisplayName("정책그룹 컨트롤러 삭제 200 테스트")
    @ParameterizedTest
    @EnumSource(ServiceCode.class)
    public void PolicyGroupDelete200Test(ServiceCode sc) throws Exception {
        ReqPolicyGroupDelete dto = ReqPolicyGroupDelete.builder()
                .plcId("PLCTESTID")
                .svcId(sc.name())
                .svcRole(99)
                .build();

        mockMvc.perform(delete("/api/v1/policy-group")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto))
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(status().isNoContent());
    }


}
