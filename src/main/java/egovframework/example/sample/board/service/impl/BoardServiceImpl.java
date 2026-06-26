package egovframework.example.sample.board.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import egovframework.example.sample.board.service.BoardService;
import egovframework.example.sample.board.service.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardMapper")
	private BoardMapper boardDAO;

	// 로그인 체크
	public String selectLoginCheck(BoardVO vo) throws Exception {
		return boardDAO.selectLoginCheck(vo);
	}

	// 게시글 목록 조회
	public List<?> selectBoardList(BoardVO vo) throws Exception {
		return boardDAO.selectBoardList(vo);
	}

	// 게시글 단건 조회
	public Object selectBoard(BoardVO vo) throws Exception {
		return boardDAO.selectBoard(vo);
	}

	// 게시글 등록
	public void insertBoard(BoardVO vo) throws Exception {
		boardDAO.insertBoard(vo);
	}

	// 게시글 수정
	public void updateBoard(BoardVO vo) throws Exception {
		boardDAO.updateBoard(vo);
	}

	// 게시글 삭제
	public void deleteBoard(BoardVO vo) throws Exception {
		boardDAO.deleteBoard(vo);
	}
	
	
	public void insertReply(BoardVO vo) throws Exception {
	    boardDAO.insertReply(vo);
	}
	public List<?> selectReplyList(BoardVO vo) throws Exception {
	    return boardDAO.selectReplyList(vo);
	}
	public void deleteReply(BoardVO vo) throws Exception {
	    boardDAO.deleteReply(vo);
	}
}