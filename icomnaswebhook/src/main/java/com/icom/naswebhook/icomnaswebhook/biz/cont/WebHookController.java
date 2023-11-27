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
    public void giteaForSlack(@RequestBody Gitea dto){
        StringBuffer sb = new StringBuffer();
        for(Commit e : dto.getCommits()){
            sb.append(e.getId().substring(0,7)+":"+e.getMessage().split("\n")[0] +" - "+ e.getAuthor().username + "\n");
        }
        webHookService.NasSendMessage(dto.getRepository().full_name +":"+ dto.getRef() +" "+ dto.getCommits().size() + " new commit pushed by "+ dto.getPusher().username + "\n"
        + dto.getRepository().getHtml_url() + "\n"
        + sb.toString()
        );
    }



}
