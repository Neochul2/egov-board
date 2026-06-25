package egovframework.example.sample.board.service.impl;

import java.util.List;
import egovframework.example.sample.board.service.BoardVO;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {

    String selectLoginCheck(BoardVO vo) throws Exception;
    List<?> selectBoardList(BoardVO vo) throws Exception;
    Object selectBoard(BoardVO vo) throws Exception;
    void insertBoard(BoardVO vo) throws Exception;
    void updateBoard(BoardVO vo) throws Exception;
    void deleteBoard(BoardVO vo) throws Exception;

}