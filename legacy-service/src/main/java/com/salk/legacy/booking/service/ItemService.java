package com.salk.legacy.booking.service;

import java.util.List;

import com.salk.legacy.domain.Item;
import com.salk.legacy.domain.Page;

public interface ItemService {
	// 添加记录
	boolean addItem(Item item);

	// 修改记录
	boolean editItem(Item item);

	// 查找单条记录使用find
	Item findItem(String id);

	// 删除记录
	boolean deleteItem(String ids);

	// 查找记录列表
	List<Item> queryItems(Item item);

	// 获取数量
	long countItem(Item item);

	List<Item> getItemsByPage(Item i, Page buildPageCommand);
}
