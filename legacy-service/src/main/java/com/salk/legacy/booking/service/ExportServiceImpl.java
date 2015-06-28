package com.salk.legacy.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salk.legacy.domain.Export;
import com.salk.legacy.domain.ExportExample;
import com.salk.legacy.product.dao.ExportMapper;

@Service
public class ExportServiceImpl implements ExportService {
	@Autowired
	private ExportMapper exportMapper;

	@Override
	public boolean addExport(Export e) {
		try {
			exportMapper.insert(e);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Export> getExports(Export e) {
		// example.setOrderByClause("or");

		List<Export> selectByExample = exportMapper
				.selectByExample(getExportExample(e));
		return selectByExample;
	}

	private ExportExample getExportExample(Export e) {
		ExportExample example = new ExportExample();
		com.salk.legacy.domain.ExportExample.Criteria createCriteria = example
				.createCriteria();
		if (StringUtils.isNotBlank(e.getExportNo())) {
			createCriteria.andExportNoEqualTo(e.getExportNo());
		}
		if (StringUtils.isNotBlank(e.getExportColor())) {
			createCriteria.andExportColorEqualTo(e.getExportColor());
		}
		if (StringUtils.isNotBlank(e.getExportSize())) {
			createCriteria.andExportSizeEqualTo(e.getExportSize());
		}
		if (StringUtils.isNotBlank(e.getExportName())) {
			createCriteria.andExportNameLike(e.getExportName());
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
	public boolean updateByKey(Export e) {
		// TODO Auto-generated method stub
		return exportMapper.updateByPrimaryKey(e) > 0 ? true : false;
	}

	@Override
	public long getTotalExports(Export e) {
		return exportMapper.countByExample(getExportExample(e));
	}

}
