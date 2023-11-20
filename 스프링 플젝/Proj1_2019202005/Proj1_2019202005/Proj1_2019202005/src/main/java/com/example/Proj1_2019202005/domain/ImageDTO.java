package com.example.Proj1_2019202005.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {
    private Long id;           //이미지 ID
    private String title;      //이미지 제목
    private String contents;   //이미지 내용
    private String filename;   //파일명
    private String filepath;   //파일 경로
}
