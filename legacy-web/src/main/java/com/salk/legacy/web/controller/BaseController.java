package com.salk.legacy.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.google.common.collect.Lists;
import com.salk.legacy.booking.service.ItemService;
import com.salk.legacy.domain.Item;
import com.salk.legacy.domain.Page;
import com.salk.legacy.domain.User;
import com.salk.legacy.web.component.PageStrategy;
import com.salk.legacy.web.dto.AjaxResult;

public abstract class BaseController {
	@Autowired
	private ItemService itemService;

	public String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public boolean validCheck(String page) {
		if (NumberUtils.isNumber(page)) {
			return false;
		}
		return true;
	}

	public Page buildPageCommand(HttpServletRequest request, String page) {
		Integer int_page = Integer.parseInt(page);
		Properties prop = new Properties();
		prop.setProperty("pageUrl", getRequestUrl(request));
		return new Page(int_page, PageStrategy.PRODUCT.getPageUrl(prop));
	}

	public String getRequestUrl(HttpServletRequest request) {

		String requestUrl = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getServletPath();
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			requestUrl.concat("?").concat(request.getQueryString());
		}
		return requestUrl;
	}

	protected void appendItemOptions(Model model) {
		List<Item> queryItems = itemService.queryItems(new Item());
		model.addAttribute("items", queryItems);
	}

	protected void appendColorOptions(Model model) {
		List<String> colors = Lists.newArrayList("彩藍", "白", "紅", "黃", "黑", "綠",
				"青", " 螢光綠", "紫", "保藍", "灰", "桃紅", "橙");
		model.addAttribute("colors", colors);

	}

	protected String getAjaxResult(String code, String msg) {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(code);
		result.setMessage(msg);
		result.setCloseCurrent(true);
		return net.sf.json.JSONObject.fromObject(result).toString();
	}

	protected void appendSizeOptions(Model model) {
		List<String> colors = Lists.newArrayList("XXS", "XS", "S", "M", "L",
				"XL", "2XL", "3XL", "4XL");
		model.addAttribute("sizes", colors);

	}

	public User getLoginUser(HttpServletRequest request) {
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		return attribute;
	}

	public String getFormatDate(Date d) {
		return DateUtil.formatDate(d, "yyyy-MM-dd");
	}
}
