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
    
 // 기존 필드들 아래에 추가
    private int pageUnit;    // 한 페이지에 보여줄 게시글 수 (예: 10)
    private int pageSize;    // 페이지 번호 목록 수 (예: 10)
    private int firstIndex;  // 조회 시작 위치
    private int lastIndex;   // 조회 끝 위치
    private int recordCountPerPage; // 한 페이지 레코드 수
    private int currentPageNo;      // 현재 페이지 번호
    private int totalRecordCount;   // 전체 레코드 수
    
    
}