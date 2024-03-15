package jp.ac.fgrope.Money.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.fgrope.Money.model.MoneyBook;
import jp.ac.fgrope.Money.model.UserBook;
import jp.ac.fgrope.Money.service.MoneyBookService;

@Controller
public class MoneyController {
	@Autowired
	private MoneyBookService MoneyBookService;
 
	@GetMapping("/top/")
	public String index(Model model, @AuthenticationPrincipal UserBook UserBook) {
		model.addAttribute("list",this.MoneyBookService.getMoneyList(UserBook));
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
 
	@GetMapping("/add/")
	public ModelAndView add(MoneyBook MoneyBook, ModelAndView model) {
		model.addObject("MoneyBook", MoneyBook);
		model.setViewName("form");
		return model;
	}
 
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull MoneyBook MoneyBook, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.MoneyBookService.save(MoneyBook);
			redirectAttributes.addFlashAttribute("exception", "");
 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/top/";
	}
	
		
	@GetMapping("/detail/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, MoneyBook MoneyBook, ModelAndView model) {
		model.addObject("detaillist", this.MoneyBookService.get(id));
		model.setViewName("detail");
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, MoneyBook MoneyBook, ModelAndView model) {
		this.MoneyBookService.delete(id);
		model.setViewName("delete");
		return model;
	}
}