package com.cy.pj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	
	@RequestMapping("doMainPageUI")
	public String doMainPageUI() {
		return "mainPage";
	}
	@RequestMapping("doTrainQueryUI")
	public String doTrainQueryUI() {
		return "train_query";
	}
	@RequestMapping("doTrainQueryOneUI")
	public String doTrainQueryOneUI() {
		return "train_queryOne";
	}
}
