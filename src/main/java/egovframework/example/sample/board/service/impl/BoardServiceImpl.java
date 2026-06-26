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

	// 게시글의 모든 댓글 삭제 (게시글 삭제 시 제약조건)
	public void deleteReplyByIdx(BoardVO vo) throws Exception {
		boardDAO.deleteReplyByIdx(vo);
	}

	// 댓글 등록
	public void insertReply(BoardVO vo) throws Exception {
		boardDAO.insertReply(vo);
	}

	// 댓글 목록 조회
	public List<?> selectReplyList(BoardVO vo) throws Exception {
		return boardDAO.selectReplyList(vo);
	}

	// 댓글 단건 삭제
	public void deleteReply(BoardVO vo) throws Exception {
		boardDAO.deleteReply(vo);
	}

	// 조회수 증가
	public void updateCount(BoardVO vo) throws Exception {
		boardDAO.updateCount(vo);
	}

	public int selectBoardListTotCnt(BoardVO vo) throws Exception {
		return boardDAO.selectBoardListTotCnt(vo); // 전체 게시글 수 반환
	}

}