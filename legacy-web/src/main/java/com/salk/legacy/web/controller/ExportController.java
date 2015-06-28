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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.salk.legacy.booking.service.ExportService;
import com.salk.legacy.booking.service.ImportService;
import com.salk.legacy.domain.Export;
import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.User;
import com.salk.legacy.web.dto.AjaxResult;

@Controller
@RequestMapping("/export/")
public class ExportController extends BaseController {
	@Autowired
	private ExportService exportService;
	@Autowired
	private ImportService importService;

	@RequestMapping("/export.html")
	@ResponseBody
	public String exportForHandler(Model model, Export export,
			HttpServletRequest request) {
		boolean status = false;
		User loginUser = getLoginUser(request);
		export.setAdderName(loginUser == null ? "" : loginUser.getUsername());
		export.setUpdaterName(loginUser == null ? "" : loginUser.getUsername());

		if (export.getId() != null && export.getId() != 0) {
			status = exportService.updateByKey(export);
		} else {
			status = exportService.addExport(export);
			Import i = importService.findImportByExportNo(export.getExportNo());
			if (i != null) {
				i.setStatus("E");
				importService.updateByKey(i);
			}
		}
		if (status) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			result.setForward("/export/list.html");
			result.setForwardConfirm("ok");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@RequestMapping("list.html")
	public String listForHandler(Model model, Export export,
			HttpServletRequest request) {
		List<Export> exports = exportService.getExports(export);
		buildTotalPage(model, export);
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		model.addAttribute("exports", exports);
		return "export/export_list";
	}

	private void buildTotalPage(Model model, Export export) {
		long total = exportService.getTotalExports(export);
		model.addAttribute("totalPage", total);

	}

	@RequestMapping("add_home.html")
	public String addHomeForHandler(Model model) {
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		return "export/input";
	}

	@RequestMapping("edit/{id}.html")
	public String editForHandle(Model model, Export export,
			@PathVariable String id) {
		Export findExport = exportService.findExport(id);
		// getFormatDate
		findExport.setStrExportDate(getFormatDate(findExport.getExportDate()));
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		if (findExport != null) {
			model.addAttribute("exports", findExport);
		}
		return "export/input";
	}

	@RequestMapping("delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Export export, String delids) {
		if (StringUtils.isBlank(delids)) {
			return null;
		}
		boolean deleteExport = exportService.deleteExport(delids);
		if (deleteExport) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
}
