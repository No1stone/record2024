package com.origemite.authserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.annotation.FilterMvcConfiguration;
import com.origemite.authserver.biz.controller.policy.PolicyGroupController;
import com.origemite.authserver.biz.controller.user.UserController;
import com.origemite.authserver.biz.controller.user.vo.ResUser;
import com.origemite.authserver.biz.service.AuthenticationService;
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
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

@WebMvcTest(UserController.class)
@FilterMvc
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FilterMvcConfiguration filterMvcConfiguration;

    @MockBean
    private UserPolicyService userPolicyService;




    @Test
    @DisplayName("유저 컨트롤러 조회 200 테스트 ")
    public void userSelect200Api() throws Exception {

//        given(userPolicyService.selectUser("testUserId")).willReturn(ResUser.builder()
//                .usrId("testUserId")
//                .build());

        mockMvc.perform(get("/api/v1/user/" + "testUserId")
                .contentType(MediaType.APPLICATION_JSON)
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        ).andExpect(status().isOk());
    }

}
