package com.origemite.authserver.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.origemite.authserver.annotation.FilterMvc;
import com.origemite.authserver.annotation.FilterMvcConfiguration;
import com.origemite.authserver.biz.controller.auth.AuthController;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignin;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignup;
import com.origemite.authserver.biz.service.AuthenticationService;
import com.origemite.authserver.biz.service.JwtService;
import com.origemite.authserver.config.ConfigPasswordEncoder;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import org.hibernate.annotations.Filter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(AuthController.class)
@FilterMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FilterMvcConfiguration filterMvcConfiguration;

    @MockBean
    private AuthenticationService authenticationService;



    private ReqSignin reqSignin = new ReqSignin("user@example.com", "password123");
    private ReqSignup reqSignup = ReqSignup.builder()
            .ctmId("testctmid")
            .usrEmail("user@example.com")
            .usrPassword("test1234")
            .usrName("testname")
            .usrDesc("testdesc")
            .usrMobile("01057159987")
            .usrRole(1)
            .build();

    private BDDMockito.BDDMyOngoingStubbing<String> signinGiven(ReqSignin req) throws Exception {
        return given(authenticationService.signin(req)).willReturn("fake-token");
    }

    private BDDMockito.BDDMyOngoingStubbing<String> signupGiven(ReqSignup req) throws Exception {
        return given(authenticationService.signup(req)).willReturn("fake-token");
    }

    private ResultActions signinApi(ReqSignin req) throws Exception {
        return mockMvc.perform(post("/api/v1/token/signin")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );
    }

    private ResultActions signupApi(ReqSignup req) throws Exception {
        return mockMvc.perform(post("/api/v1/token/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req))
                .with(SecurityMockMvcRequestPostProcessors.csrf())
        );
    }

    @Test
    @DisplayName("사인인 200 테스트")
    public void testSignIn200() throws Exception {
        signinGiven(reqSignin);
        signinApi(reqSignin)
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("사인업 200 테스트")
    public void testSignUp200() throws Exception {
        signupGiven(reqSignup);
        signupApi(reqSignup)
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("사인인 400 테스트 이메일")
    public void testSignIn400Email() throws Exception {
        ReqSignin reqSignin400 = this.reqSignin;
        reqSignin400.setEmail("asdasdasd");
        signinGiven(reqSignin400);
        signinApi(reqSignin400)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("사인업 400 테스트 이메일 발리데이션")
    public void testSignUp400() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setUsrEmail("asdasdasd");
        reqSignup400.setCtmId("");

        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }


    @Test
    @DisplayName("사인업 400 테스트 이메일 null")
    public void testSignUp400null() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setUsrEmail(null);
        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("사인업 400 테스트 이메일 empty")
    public void testSignUp400empty() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setUsrEmail("");
        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("사인업 400 테스트 ctmId empty")
    public void testSignUpCtmId400empty() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setCtmId("");
        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("사인업 400 테스트 ctmId null")
    public void testSignUpCtmId400null() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setCtmId(null);
        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("사인업 400 테스트 ctmId length")
    public void testSignUpCtmId400length() throws Exception {
        ReqSignup reqSignup400 = this.reqSignup;
        reqSignup400.setCtmId("s123456789s123456789s123456789s123456789s123456789s123456789");
        signupGiven(reqSignup400);
        signupApi(reqSignup400)
                .andExpect(status().isBadRequest());
    }


}
