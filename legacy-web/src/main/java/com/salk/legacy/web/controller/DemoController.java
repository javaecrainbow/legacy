package com.salk.legacy.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salk.legacy.booking.service.BookingService;
import com.salk.legacy.booking.service.ExportService;
import com.salk.legacy.domain.Booking;
import com.salk.legacy.domain.Export;

@Controller
@RequestMapping("/demo/legacy-sport")
public class DemoController {
	@Autowired
	private ExportService exportService;
@RequestMapping("/export.html")
public String exportForHandler(Model model, Export export,
		HttpServletRequest request) {
	boolean status = exportService.addExport(export);
	model.addAttribute("status", status);
	return listForHandler(model, export, request);
}


@RequestMapping("list.html")
public String listForHandler(Model model, Export export,
		HttpServletRequest request) {
	List<Export> exports = exportService.getExports();
	model.addAttribute("exports", exports);
	return "list.jsp";
}



@InitBinder
public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(
            dateFormat, false));
}
}
