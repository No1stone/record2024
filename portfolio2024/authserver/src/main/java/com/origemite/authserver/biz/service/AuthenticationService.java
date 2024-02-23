package com.origemite.authserver.biz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.origemite.authserver.advice.excep.CustomBadRequestException;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignin;
import com.origemite.authserver.biz.controller.auth.vo.ReqSignup;
import com.origemite.authserver.config.ConfigPasswordEncoder;
import com.origemite.authserver.data.db.entity.TbUser;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TbUserRepo tbUserRepo;
    private final ConfigPasswordEncoder passwordEncoder;


    public String signin(ReqSignin request) throws JsonProcessingException {
        var user = tbUserRepo.findByUsrEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsrId(), request.getPassword()));
        var jwt = jwtService.signin(user.getUsrId());
        return jwt;
    }

    @Transactional
    public String signup(ReqSignup dto) throws CustomBadRequestException, JsonProcessingException {
        String result = "";
//        log.info("signup = {}", new Gson().toJson(dto.toUserRepoSave(passwordEncoder)));
        if (tbUserRepo.existsByUsrEmail(dto.getUsrEmail())) {
            throw new CustomBadRequestException("이미 가입한 이메일입니다.");
        }
        TbUser user = tbUserRepo.save(dto.toUserRepoSave(passwordEncoder));
        var jwt = jwtService.signin(user.getUsrId());

        return jwt;
    }
}
