package com.origemite.authserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.annotation.FilterMvcConfiguration;
import com.origemite.authserver.biz.controller.auth.AuthController;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignin;
import com.origemite.authserver.biz.controller.policy.PolicyController;
import com.origemite.authserver.biz.controller.policy.vo.ReqPolicySave;
import com.origemite.authserver.biz.controller.policy.vo.ResPolicySelect;
import com.origemite.authserver.biz.service.PolicyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PolicyController.class)
@FilterMvc
public class PolicyControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FilterMvcConfiguration filterMvcConfiguration;

    @MockBean
    private PolicyService policyService;

    private ResultActions policySaveApi(ReqPolicySave req) throws Exception {
        return mockMvc.perform(post("/api/v1/policy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );
    }

    private ResultActions policySelectApi(String s) throws Exception {
        return mockMvc.perform(get("/api/v1/policy/"+s)
                .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );
    }

    @Test
    @DisplayName("정책 저장 200 테스트")
    public void testPolociSave200() throws Exception {
        ReqPolicySave req = new ReqPolicySave();
        given(policyService.PolociSave(req)).willReturn("PLCID");
        policySaveApi(req)
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("정책 조회 200 테스트")
    public void testPolicySelect200() throws Exception {
        String plcId = "PLCID1234";
        given(policyService.PolicySelect(plcId)).willReturn(ResPolicySelect.builder()
                .build());
        policySelectApi(plcId)
                .andExpect(status().isOk());
    }

}
