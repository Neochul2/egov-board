package egovframework.example.sample.board.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.example.sample.board.service.BoardService;
import egovframework.example.sample.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

    @Resource(name="boardMapper")
    private BoardMapper boardDAO;

    public String selectLoginCheck(BoardVO searchVO) throws Exception {
        return boardDAO.selectLoginCheck(searchVO);
    }
}