package com.icom.naswebhook.icomnaswebhook.biz.svc;

import com.google.gson.Gson;
import com.icom.naswebhook.icomnaswebhook.biz.conf.ConfRestCilent;
import com.icom.naswebhook.icomnaswebhook.biz.conf.ConfRestTemplate;
import com.icom.naswebhook.icomnaswebhook.biz.vo.Nas;
import com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.Gitea;
import com.icom.naswebhook.icomnaswebhook.biz.vo.gitea.child.Commit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebHookService {

    private final ConfRestCilent confRestCilent;
    private final ConfRestTemplate restTemplate;

    public void sendNas() {
        NasSendMessage("test!!!!");
    }

    public void giteaForNas(Gitea dto){
        StringBuffer sb = new StringBuffer();
        for(Commit e : dto.getCommits()){
            sb.append(e.getId().substring(0,7)+":"+e.getMessage().split("\n")[0] +" - "+ e.getAuthor().username + "\n");
        }
        NasSendMessage(dto.getRepository().full_name +":"+ dto.getRef() +" "+ dto.getCommits().size() + " new commit pushed by "+ dto.getPusher().username + "\n"
                + dto.getRepository().getHtml_url() + "\n"
                + sb.toString()
        );
    }

    private void NasSendMessage(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String apiUrl = "https://192-168-0-2.icomsysnas.direct.quickconnect.to:5001/webapi/entry.cgi?api=SYNO.Chat.External&method=incoming&version=2&token=KiOl8r02kMpB70psuq5yWUOSfv9CzF6mWOhHnIuqSjkkawgusF9qhqCh191HdcCK";
        MultiValueMap<String, String> mvm = new LinkedMultiValueMap();
        mvm.add("payload", new Gson().toJson(Nas.builder().text(message).build()));
        HttpEntity requestEntity = new HttpEntity<>(mvm, headers);
        ResponseEntity<String> responseEntity = restTemplate.restTemplate().postForEntity(apiUrl, requestEntity, String.class);
//        HttpStatusCode statusCode = responseEntity.getStatusCode();
//        String responseBody = responseEntity.getBody();
    }

}
