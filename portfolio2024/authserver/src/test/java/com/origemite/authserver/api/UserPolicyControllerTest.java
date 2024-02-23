package com.origemite.authserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.annotation.FilterMvcConfiguration;
import com.origemite.authserver.biz.controller.user.UserController;
import com.origemite.authserver.biz.controller.user.UserPolicyController;
import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicyDelete;
import com.origemite.authserver.biz.controller.user.vo.ReqUserPolicySave;
import com.origemite.authserver.biz.controller.user.vo.ResUserPolicySelect;
import com.origemite.authserver.biz.service.UserPolicyService;
import com.origemite.authserver.biz.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@WebMvcTest(UserPolicyController.class)
@FilterMvc
public class UserPolicyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FilterMvcConfiguration filterMvcConfiguration;

    @MockBean
    private UserPolicyService userPolicyService;

    @Test
    @DisplayName("유저 정책 컨트롤러 저장 200 테스트 ")
    public void userPolicySave200Api() throws Exception {

        ReqUserPolicySave dto = ReqUserPolicySave.builder()
                .plcId("PLCTESTID")
                .usrId("USRTESTID")
                .build();

        mockMvc.perform(post("/api/v1/user-policy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        ).andExpect(status().isCreated());

        verify(userPolicyService).UserPolicyServiceSave(any(ReqUserPolicySave.class));

    }

    @Test
    @DisplayName("유저 정책 컨트롤러 조회 200 테스트 ")
    public void userPolicySelect200Api() throws Exception {
        mockMvc.perform(get("/api/v1/user-policy" + "/testid")
                .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        ).andExpect(status().isOk());

    }

    @Test
    @DisplayName("유저 정책 컨트롤러 삭제 200 테스트 ")
    public void userPolicyDelete200Api() throws Exception {
        ReqUserPolicyDelete dto = ReqUserPolicyDelete.builder()
                .plcId("PLCTESTID")
                .usrId("USERTESTID")
                .build();
        mockMvc.perform(delete("/api/v1/user-policy")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        ).andExpect(status().isNoContent());

    }

}
