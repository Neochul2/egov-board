package egovframework.example.sample.board.service;

import java.util.List;

public interface BoardService {

    String selectLoginCheck(BoardVO vo) throws Exception;       // 로그인 체크

    List<?> selectBoardList(BoardVO vo) throws Exception;       // 게시글 목록 조회
    Object selectBoard(BoardVO vo) throws Exception;            // 게시글 단건 조회

    void insertBoard(BoardVO vo) throws Exception;              // 게시글 등록
    void updateBoard(BoardVO vo) throws Exception;              // 게시글 수정
    void deleteBoard(BoardVO vo) throws Exception;              // 게시글 삭제
    void deleteReplyByIdx(BoardVO vo) throws Exception;         // 게시글의 모든 댓글 삭제

    void insertReply(BoardVO vo) throws Exception;              // 댓글 등록
    List<?> selectReplyList(BoardVO vo) throws Exception;       // 댓글 목록 조회
    void deleteReply(BoardVO vo) throws Exception;              // 댓글 단건 삭제

    void updateCount(BoardVO vo) throws Exception;              // 조회수 증가

}