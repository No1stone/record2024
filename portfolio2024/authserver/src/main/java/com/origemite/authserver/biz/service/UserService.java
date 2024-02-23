package com.origemite.authserver.biz.service;

import com.google.gson.Gson;
import com.origemite.authserver.advice.excep.CustomNotFoundException;
import com.origemite.authserver.biz.controller.user.vo.ResUser;
import com.origemite.authserver.data.db.entity.TbUser;
import com.origemite.authserver.data.db.repo.TbUserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final TbUserRepo tbUserRepo;

    @Override
    public UserDetails loadUserByUsername(String usrId) throws UsernameNotFoundException {
        UserDetails a = tbUserRepo.findById(usrId)
                .map(this::createUserDetail)
                .orElseThrow(() -> new UsernameNotFoundException(usrId + " -> 데이터베이스에서 찾을 수 없습니다."));
        return a;
    }

    private UserDetails createUserDetail(TbUser dto) {
        //시스템 전체관리자인경우 권한이 여러개일수 있어 리스트로 구현
        List<String> authList = new ArrayList<>();
//        authList.add(dto.getRoleVal());
        log.info("authList - {}", new Gson().toJson(authList));
        List<SimpleGrantedAuthority> permission = authList.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return new User(String.valueOf(dto.getUsrId()), dto.getUsrPassword(), permission)
                ;
    }

    public ResUser selectUser(String usrId) throws CustomNotFoundException {
        return tbUserRepo.findById(usrId)
                .orElseThrow(() -> new CustomNotFoundException("아이디가 없습니다.")).toResUser();
    }

    public void UserPolicySelect(String usrId){


        log.info("", new Gson().toJson("a"));
    }

}

