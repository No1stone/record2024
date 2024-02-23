package com.origemite.authserver.biz.controller.svc;

import com.origemite.authserver.biz.controller.svc.vo.ResSVC;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/svc")
@CrossOrigin
public class SvcController {

    @GetMapping({"","/"})
    public List<ResSVC> SVCList(){
        return ResSVC.toVO();
    }

}
