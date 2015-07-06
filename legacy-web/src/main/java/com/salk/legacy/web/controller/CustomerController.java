package com.salk.legacy.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salk.legacy.booking.service.ImportService;
import com.salk.legacy.booking.service.ItemService;
import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.Item;
import com.salk.legacy.web.dto.ImportFacetdto;
import com.salk.legacy.web.dto.ImportSize;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
	@Autowired
	private ImportService importService;
	@Autowired
	private ItemService itemService;

	@RequestMapping("/query.html")
	public String queryForHandler(Model model, String importType) {
		List<Item> queryItems = itemService.queryItems(new Item());
		model.addAttribute("items", queryItems);
		appendSizeOptions(model);
		if (StringUtils.isBlank(importType) && CollectionUtils.isNotEmpty(queryItems)) {
			importType = queryItems.get(0).getTypeName();
		}
		List<Import> queryImportsByFacet = importService.queryImportsByFacet(importType);
		List<ImportFacetdto> convert = convert(queryImportsByFacet);
		model.addAttribute("importType", importType);

		model.addAttribute("facetList", convert);
		return "customer/query";
	}

	private List<ImportFacetdto> convert(List<Import> imports) {
		Map<String, ImportFacetdto> dtosMaps = new HashMap<String, ImportFacetdto>();
		List<ImportFacetdto> dtos = new ArrayList<ImportFacetdto>();
		for (Import i : imports) {
			if ("631064012".equals(i.getImportProdId() + "")) {
				System.out.println("123");
			}
			if (!dtosMaps.containsKey(i.getImportProdId() + "")) {
				ImportFacetdto importFacet = new ImportFacetdto();
				importFacet.setImportName(i.getImportName());
				importFacet.setProdNo(i.getImportProdId() + "");

				ImportSize importSize = new ImportSize(i.getImportSize(), i.getNums());
				importFacet.addSizes(importSize);
				importFacet.setTotal(i.getNums());
				importFacet.setImportType(i.getImportType());
				dtosMaps.put(i.getImportProdId() + "", importFacet);
			} else {
				ImportFacetdto importFacetdto = dtosMaps.get(i.getImportProdId() + "");
				ImportSize importSize = null;
				if (importFacetdto.getSizes().containsKey(i.getImportSize())) {
					importSize = importFacetdto.getSizes().get(i.getImportSize());
					importSize.setCount(importSize.getCount() + i.getNums());
				} else {
					importSize = new ImportSize(i.getImportSize(), i.getNums());
					importFacetdto.addSizes(importSize);

				}
				importFacetdto.setTotal(importFacetdto.getTotal() + i.getNums());
				importFacetdto.setImportType(i.getImportType());

			}

		}
		for (Map.Entry<String, ImportFacetdto> entry : dtosMaps.entrySet()) {
			dtos.add(entry.getValue());
		}
		return dtos;
	}
}
