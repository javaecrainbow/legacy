package com.salk.legacy.booking.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.ImportExample;
import com.salk.legacy.domain.ImportExample.Criteria;
import com.salk.legacy.product.dao.ImportMapper;

@Service
public class ImportServiceImpl implements ImportService {
	@Autowired
	private ImportMapper importMapper;

	@Override
	public boolean addImport(Import i) {
		try {
			importMapper.insert(i);
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Import> getImports(Import i) {
		ImportExample example = getImportExample(i);
		List<Import> selectByExample = importMapper.selectByExample(example);
		return selectByExample;
	}

	private ImportExample getImportExample(Import i) {
		ImportExample example = new ImportExample();
		// example.setOrderByClause("or");
		Criteria createCriteria = example.createCriteria();
		if (StringUtils.isNotBlank(i.getImportNo())) {
			createCriteria.andImportNoEqualTo(i.getImportNo());
		}
		if (StringUtils.isNotBlank(i.getImportColor())) {
			createCriteria.andImportColorEqualTo(i.getImportColor());
		}
		if (StringUtils.isNotBlank(i.getImportSize())) {
			createCriteria.andImportSizeEqualTo(i.getImportSize());
		}
		if (StringUtils.isNotBlank(i.getImportName())) {
			createCriteria.andImportNameLike(i.getImportName());
		}
		if (StringUtils.isNotBlank(i.getImportType())) {
			createCriteria.andImportTypeEqualTo(i.getImportType());
		}
		return example;
	}

	@Override
	public Import findImport(String id) {
		Integer it_id = Integer.parseInt(id);
		Import selectByPrimaryKey = importMapper.selectByPrimaryKey(it_id);
		return selectByPrimaryKey;
	}

	@Override
	public boolean deleteImport(String ids) {
		if (StringUtils.isBlank(ids)) {
			return false;
		}

		int updateCount = importMapper.deleteByPrimaryKeys(ids.split(","));

		return updateCount > 0 ? true : false;
	}

	@Override
	public boolean updateByKey(Import e) {
		// TODO Auto-generated method stub

		return importMapper.updateByPrimaryKey(e) > 0 ? true : false;
	}

	@Override
	public long getTotalImports(Import i) {
		ImportExample example = getImportExample(i);
		return importMapper.countByExample(example);
	}

	@Override
	public Import findImportByExportNo(String exportNo) {
		Import i = new Import();
		i.setImportNo(exportNo);
		ImportExample importExample = getImportExample(i);
		List<Import> selectByExample = importMapper
				.selectByExample(importExample);
		if (CollectionUtils.isEmpty(selectByExample)) {
			return null;
		}
		return selectByExample.get(0);
	}

	@Override
	public List<Import> queryImportsByFacet(String importType) {
		List<Import> select4Facet = importMapper.select4Facet(importType);
		return select4Facet;
	}
}
