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

import com.salk.legacy.booking.service.ImportService;
import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.User;
import com.salk.legacy.web.dto.AjaxResult;

@Controller
@RequestMapping("/import/")
public class ImportController extends BaseController {
	@Autowired
	private ImportService importService;

	@RequestMapping("import.html")
	@ResponseBody
	public String exportForHandler(Model model, Import imports,
			HttpServletRequest request) {
		User loginUser = getLoginUser(request);
		imports.setAdderName(loginUser == null ? "" : loginUser.getUsername());
		imports.setUpdaterName(loginUser == null ? "" : loginUser.getUsername());

		boolean status = false;
		if (imports.getId() != null && imports.getId() != 0) {
			status = importService.updateByKey(imports);
		} else {
			status = importService.addImport(imports);
		}
		if (status) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			result.setCloseCurrent(true);
			result.setForward("/import/list.html");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	@RequestMapping("add_home.html")
	public String addHomeForHandler(Model model) {
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		return "import/input";
	}

	@RequestMapping("list.html")
	public String listForHandler(Model model, Import i,
			HttpServletRequest request) {
		List<Import> imports = importService.getImports(i);
		buildTotalPage(model, i);
		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		model.addAttribute("imports", imports);
		return "import/import_list";
	}

	private void buildTotalPage(Model model, Import i) {
		long total = importService.getTotalImports(i);
		model.addAttribute("totalPage", total);
	}

	@RequestMapping("lookup/list.html")
	public String lookupForHandler(Model model, Import i,
			HttpServletRequest request) {
		List<Import> imports = importService.getImports(i);
		buildTotalPage(model, i);
		model.addAttribute("imports", imports);
		return "export/import_getData";
	}

	@RequestMapping("edit/{id}.html")
	public String editForHandle(Model model, Import i, @PathVariable String id) {
		Import findImport = importService.findImport(id);
		findImport.setStrImportDate(getFormatDate(findImport.getImportDate()));

		appendItemOptions(model);
		appendSizeOptions(model);
		appendColorOptions(model);
		if (findImport != null) {
			model.addAttribute("import", findImport);
		}
		return "import/input";
	}

	@RequestMapping("delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Import i, String delids,
			HttpServletRequest request) {
		if (StringUtils.isBlank(delids)) {
			return null;
		}

		boolean deleteExport = importService.deleteImport(delids);
		if (deleteExport) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			try {
				result.setMessage("success");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
