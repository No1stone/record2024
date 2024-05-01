package com.origemite.jdbcclinentexame.vo;

import java.time.LocalDate;

public record Mytest1(String id,
                      String title,
                      String slug,
                      LocalDate date,
                      int timeToRead,
                      String tags) {
}
