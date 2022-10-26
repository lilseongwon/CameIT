package com.example.cameit.domain.notice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
 
    OPEN("띵동! 성심당이 열렸습니다", "갓 구운 빵이 기다리고 있어요"),
    CLOSE("띵동! 성심당이 닫혔습니다", "맛있는 빵을 준비할게요");
 
    String title;
    String body;
}