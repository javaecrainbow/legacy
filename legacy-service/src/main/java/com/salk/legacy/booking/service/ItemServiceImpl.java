package com.salk.legacy.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salk.legacy.domain.Item;
import com.salk.legacy.domain.ItemExample;
import com.salk.legacy.product.dao.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMappter;

	@Override
	public boolean addItem(Item item) {
		return itemMappter.insert(item) > 0 ? true : false;
	}

	@Override
	public boolean editItem(Item item) {
		// TODO Auto-generated method stub
		return itemMappter.updateByPrimaryKey(item) > 0 ? true : false;
	}

	@Override
	public Item findItem(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteItem(String ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> queryItems(Item item) {
		ItemExample example = new ItemExample();
		// example.setOrderByClause("or");
		com.salk.legacy.domain.ItemExample.Criteria createCriteria = example
				.createCriteria();
		// if (StringUtils.isNotBlank(i.getImportNo())) {
		// createCriteria.andImportNoEqualTo(i.getImportNo());
		// }
		// if (StringUtils.isNotBlank(i.getImportColor())) {
		// createCriteria.andImportColorEqualTo(i.getImportColor());
		// }
		// if (StringUtils.isNotBlank(i.getImportSize())) {
		// createCriteria.andImportSizeEqualTo(i.getImportSize());
		// }
		// if (StringUtils.isNotBlank(i.getImportType())) {
		// createCriteria.andImportTypeLike(i.getImportType());
		// }
		List<Item> selectByExample = itemMappter.selectByExample(example);
		return selectByExample;
	}

	@Override
	public long countItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

}
