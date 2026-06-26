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
			boardVO.setWriter((String) request.getSession().getAttribute("userName"));
			boardService.insertBoard(boardVO);
		} else if ("edit".equals(mode)) {
			boardService.updateBoard(boardVO);
		} else if ("del".equals(mode)) {
			boardService.deleteBoard(boardVO);
		}
		return "redirect:mainList.do";
	}

	// 상세 화면
	@RequestMapping(value = "/view.do")
	public String view(@ModelAttribute("boardVO") BoardVO boardVO, ModelMap model) throws Exception {
		Object result = boardService.selectBoard(boardVO);
		model.addAttribute("boardVO", result);
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
}