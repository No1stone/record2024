package com.origemite.authserver.cmm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum ServiceCode {

    AUTHSERVER("권한서버","권한서버를 사용할수 있는 권한")
    , CUSTOMERSERVER("고객사서버","고객사서버를 사용할수 있는 권한");
    private final String displayName;
    private final String desc;

    public static List<ServiceCode> LIST = Arrays.asList(
            AUTHSERVER
            , CUSTOMERSERVER
    );

    public static boolean isName(String s){
        return ServiceCode.LIST.stream().map(Enum::name).toList().contains(s);
    }

    public static Map<String, Set<Integer>> policyBaseInstance(){
        Map<String, Set<Integer>> result = new HashMap<>();
        for(String e :ServiceCode.LIST.stream().map(Enum::name).toList()){
            result.put(e, new HashSet<Integer>());
        }
        return result;
    }
}
