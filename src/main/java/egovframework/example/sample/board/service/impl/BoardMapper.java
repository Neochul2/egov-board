package egovframework.example.sample.board.service.impl;

import egovframework.example.sample.board.service.BoardVO;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardMapper")
public interface BoardMapper {

    String selectLoginCheck(BoardVO vo) throws Exception;

}