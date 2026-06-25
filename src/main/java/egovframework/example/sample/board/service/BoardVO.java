package egovframework.example.sample.board.service;

import egovframework.example.sample.service.SampleDefaultVO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO extends SampleDefaultVO {
    private String userId;
    private String userNm;
    private String password;
    private String useYn;
    private String idx;
    private String title;
    private String contents;
    private String count;
    private String writer;
    private String writerNm;
    private String indate;
    private String seq;
    private String reply;
    private String filename;
}