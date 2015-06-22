package com.salk.legacy.booking.service;

import java.util.List;

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
	public List<Export> getExports() {
		ExportExample example = new ExportExample();
		//example.setOrderByClause("or");
		List<Export> selectByExample = exportMapper.selectByExample(example);
		return selectByExample;
	}
	@Override
	public Export findExport(String id) {
		Integer it_id=Integer.parseInt(id);
		Export selectByPrimaryKey = exportMapper.selectByPrimaryKey(it_id);
		return selectByPrimaryKey;
	}

}
