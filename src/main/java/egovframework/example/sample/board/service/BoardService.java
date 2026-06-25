package egovframework.example.sample.board.service;

import java.util.List;

public interface BoardService {

    String selectLoginCheck(BoardVO vo) throws Exception;

    List<?> selectBoardList(BoardVO vo) throws Exception;

    BoardVO selectBoard(BoardVO vo) throws Exception;

    void insertBoard(BoardVO vo) throws Exception;

    void updateBoard(BoardVO vo) throws Exception;

    void deleteBoard(BoardVO vo) throws Exception;

}