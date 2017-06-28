package com.ivan.web.controller.weixin.controller;

import org.apache.commons.lang3.StringUtils;
import org.ivan.entity.weixin.utils.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	@RequestMapping("/xfpay")
	public String xfPay(Model model){
		
		String rateStr = SystemConfig.getRateKey();
		Double rate = 1.0;
		if(StringUtils.isNotBlank(rateStr)){
			rate = 1.0 + new Double(rateStr);
		}
		
		model.addAttribute("rate", rate);
		
		return "/xfpay";
	}
}
