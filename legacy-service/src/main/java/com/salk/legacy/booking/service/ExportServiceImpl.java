package com.salk.legacy.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salk.legacy.domain.Export;
import com.salk.legacy.domain.ExportExample;
import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.Page;
import com.salk.legacy.product.dao.ExportMapper;
import com.salk.legacy.product.dao.ImportMapper;

@Service
public class ExportServiceImpl implements ExportService {
	@Autowired
	private ExportMapper exportMapper;
	@Autowired
	private ImportMapper importMapper;

	@Override
	public boolean addExport(Export e) throws Exception {
		exportMapper.insert(e);
		return true;
	}

	@Override
	public List<Export> getExports(Export e) {
		// example.setOrderByClause("or");

		List<Export> selectByExample = exportMapper.selectByExample(getExportExample(e));
		return selectByExample;
	}

	private ExportExample getExportExample(Export e) {
		ExportExample example = new ExportExample();
		com.salk.legacy.domain.ExportExample.Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(e.getExportNo())) {
			createCriteria.andExportNoEqualTo(e.getExportNo());
		}
		if (StringUtils.isNotBlank(e.getExportProdId())) {
			createCriteria.andExportProdIdEqualTo(e.getExportProdId());
		}
		if (StringUtils.isNotBlank(e.getExportColor())) {
			createCriteria.andExportColorEqualTo(e.getExportColor());
		}
		if (StringUtils.isNotBlank(e.getExportSize())) {
			createCriteria.andExportSizeEqualTo(e.getExportSize());
		}
		if (StringUtils.isNotBlank(e.getExportName())) {
			createCriteria.andExportNameLike("%" + e.getExportName() + "%");
		}
		if (StringUtils.isNotBlank(e.getExportType())) {
			createCriteria.andExportTypeEqualTo(e.getExportType());
		}
		return example;
	}

	@Override
	public Export findExport(String id) {
		Integer it_id = Integer.parseInt(id);
		Export selectByPrimaryKey = exportMapper.selectByPrimaryKey(it_id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean deleteExport(String ids) {
		if (StringUtils.isBlank(ids)) {
			return false;
		}

		int updateCount = exportMapper.deleteByPrimaryKeys(ids.split(","));

		return updateCount > 0 ? true : false;
	}

	@Override
	public boolean updateByKey(Export e) throws Exception {
		// TODO Auto-generated method stub
		return exportMapper.updateByPrimaryKey(e) > 0 ? true : false;
	}

	@Override
	public long getTotalExports(Export e) {
		return exportMapper.countByExample(getExportExample(e));
	}

	@Override
	public List<Export> getExportsByPage(Export e, Page page) {
		ExportExample example = getExportExample(e);
		example.setPage(page);
		String orderField = page.getOrderField();
		String orderDirection = page.getOrderDirection();
		if (StringUtils.isBlank(orderField)) {
			orderField = "update_time";
		}
		if (StringUtils.isBlank(orderDirection)) {
			orderDirection = "desc";
		}
		example.setOrderByClause(orderField + " " + orderDirection);

		List<Export> selectByExample = exportMapper.getExportsByPage(example);
		return selectByExample;
	}

	@Override
	public int txExport(Export export) throws Exception {

		Import i = importMapper.selectByPrimaryKey(export.getImportId());
		if (i != null) {
			Integer nums = export.getNums();
			Integer ori_nums = i.getNums();
			if (nums > ori_nums) {
				return 0;
			} else {
				i.setNums(ori_nums - nums);
				if (nums == ori_nums) {
					i.setStatus("E");

				}
				// importService.updateByKey(i);
				importMapper.updateByPrimaryKey(i);
			}

		}
		boolean status = false;
		if (export.getId() != null && export.getId() != 0) {
			status = updateByKey(export);
		} else {
			status = addExport(export);
		}
		return 1;
	}

}
