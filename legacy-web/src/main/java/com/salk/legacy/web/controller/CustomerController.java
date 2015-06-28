package com.salk.legacy.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salk.legacy.booking.service.ImportService;
import com.salk.legacy.domain.Import;
import com.salk.legacy.web.dto.ImportFacetdto;
import com.salk.legacy.web.dto.ImportSize;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
	@Autowired
	private ImportService importService;

	@RequestMapping("/query.html")
	public String queryForHandler(Model model, String importType) {
		appendItemOptions(model);
		appendSizeOptions(model);
		List<Import> queryImportsByFacet = importService
				.queryImportsByFacet(importType);
		List<ImportFacetdto> convert = convert(queryImportsByFacet);
		model.addAttribute("importType", importType);

		model.addAttribute("facetList", convert);
		return "customer/query";
	}

	private List<ImportFacetdto> convert(List<Import> imports) {
		Map<String, ImportFacetdto> dtosMaps = new HashMap<String, ImportFacetdto>();
		List<ImportFacetdto> dtos = new ArrayList<ImportFacetdto>();
		for (Import i : imports) {
			if (!dtosMaps.containsKey(i.getImportName())) {
				ImportFacetdto importFacet = new ImportFacetdto();
				importFacet.setImportName(i.getImportName());
				importFacet.addSizes(new ImportSize(i.getImportSize(), i
						.getCount()));
				importFacet.setTotal(i.getCount());
				importFacet.setImportType(i.getImportType());
				dtosMaps.put(i.getImportName(), importFacet);
			} else {
				ImportFacetdto importFacetdto = dtosMaps.get(i.getImportName());
				importFacetdto.addSizes(new ImportSize(i.getImportSize(), i
						.getCount()));
				importFacetdto.setTotal(importFacetdto.getTotal()
						+ i.getCount());
				importFacetdto.setImportType(i.getImportType());

			}

		}
		for (Map.Entry<String, ImportFacetdto> entry : dtosMaps.entrySet()) {
			dtos.add(entry.getValue());
		}
		return dtos;
	}
}
