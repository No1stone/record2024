package com.icom.naswebhook.icomnaswebhook.biz.cont;

import com.icom.naswebhook.icomnaswebhook.biz.svc.WebHookService;
import com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.Gitea;
import com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child.Commit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin("*")
public class WebHookController {

    private final WebHookService webHookService;

    @GetMapping("/1")
    public String init(Map<Object, Object> dto){

        webHookService.sendNas();
    return "Hello World!";
    }


    @PostMapping("/gitea")
    public void giteaForNas(@RequestBody Gitea dto){
       webHookService.giteaForNas(dto);
    }

    @GetMapping("/test")
    public String test(){
        return "ok";
    }



}
