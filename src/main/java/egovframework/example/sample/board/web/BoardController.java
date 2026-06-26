package egovframework.example.sample.board.web;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import egovframework.example.sample.board.service.BoardService;
import egovframework.example.sample.board.service.BoardVO;

@Controller
public class BoardController {

	@Resource(name = "boardService")
	private BoardService boardService;

	// 메인 목록
	@RequestMapping(value = "/mainList.do")
	public String list(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		List<?> list = boardService.selectBoardList(boardVO);
		model.addAttribute("resultList", list);
		return "board/mainList";
	}

	// 등록/수정 화면 호출 (GET)
	@RequestMapping(value = "/mgmt.do", method = RequestMethod.GET)
	public String mgmt(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		if (boardVO.getIdx() != null && !"".equals(boardVO.getIdx())) {
			Object result = boardService.selectBoard(boardVO);
			model.addAttribute("boardVO", result);
		}
		return "board/mgmt";
	}

	// 등록/수정 처리 (POST)
	@RequestMapping(value = "/mgmt.do", method = RequestMethod.POST)
	public String mgmt2(@ModelAttribute("boardVO") BoardVO boardVO, @RequestParam("mode") String mode, ModelMap model,
			HttpServletRequest request) throws Exception {
		if ("add".equals(mode)) {
			boardVO.setWriter((String) request.getSession().getAttribute("userName")); // 세션에서 작성자 가져오기
			boardService.insertBoard(boardVO); // 게시글 등록
		} else if ("edit".equals(mode)) {
			boardService.updateBoard(boardVO); // 게시글 수정
		} else if ("del".equals(mode)) {
			List<?> replyList = boardService.selectReplyList(boardVO); // 댓글 수 확인
			if (replyList != null && replyList.size() > 0) {
				// 댓글 있으면 삭제 불가
				model.addAttribute("msg", "댓글이 있어 삭제할 수 없습니다.");
				model.addAttribute("boardVO", boardService.selectBoard(boardVO));
				model.addAttribute("replyList", replyList);
				return "board/view";
			}
			boardService.deleteBoard(boardVO); // 댓글 없으면 게시글 삭제
		}
		return "redirect:mainList.do";
	}

	// 상세 화면
	@RequestMapping(value = "/view.do")
	public String view(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		boardService.updateCount(boardVO); // 조회수 1 증가
		Object result = boardService.selectBoard(boardVO);
		List<?> replyList = boardService.selectReplyList(boardVO);
		model.addAttribute("boardVO", result);
		model.addAttribute("replyList", replyList);
		return "board/view";
	}

	// 로그인
	@RequestMapping(value = "/login.do")
	public String login(@RequestParam("user_id") String user_id, @RequestParam("password") String password,
			ModelMap model, HttpServletRequest request) throws Exception {

		BoardVO boardVO = new BoardVO();
		boardVO.setUserId(user_id);
		boardVO.setPassword(password);

		String user_name = boardService.selectLoginCheck(boardVO);

		if (user_name != null && !"".equals(user_name)) {
			request.getSession().setAttribute("userId", user_id);
			request.getSession().setAttribute("userName", user_name);
		} else {
			request.getSession().setAttribute("userId", "");
			request.getSession().setAttribute("userName", "");
			model.addAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
		return "redirect:mainList.do";
	}

	// 로그아웃
	@RequestMapping(value = "/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		request.getSession().invalidate();
		return "redirect:mainList.do";
	}

	// 댓글 등록
	@RequestMapping(value = "/insertReply.do")
	public String insertReply(@ModelAttribute("boardVO") BoardVO boardVO, HttpServletRequest request) throws Exception {
		boardVO.setWriter((String) request.getSession().getAttribute("userName"));
		boardService.insertReply(boardVO);
		return "redirect:view.do?idx=" + boardVO.getIdx();
	}

	// 댓글 삭제
	@RequestMapping(value = "/deleteReply.do")
	public String deleteReply(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception {
		boardService.deleteReply(boardVO);
		return "redirect:view.do?idx=" + boardVO.getIdx();
	}

}