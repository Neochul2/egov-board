package egovframework.example.sample.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping(value = "/mainList.do")
	public String list(ModelMap model) throws Exception {
		System.out.println("===== BoardController 진입 =====");
		return "board/mainList";
		
	}
	
	@RequestMapping(value = "/mgmt.do")
	public String mgmt(ModelMap model) throws Exception {
	    return "board/mgmt";
	}
	
	@RequestMapping(value = "/view.do")
	public String view(ModelMap model) throws Exception {
	    return "board/view";
	}
}