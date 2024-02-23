package com.origemite.authserver.cmm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyFormatter {

    private static DateTimeFormatter type1 = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

    public static String yyyyMMdd(){
        return LocalDateTime.now().format(type1);
    }

}
