package com.e3mall.service;

import com.e3mall.common.DataGridResult;
import com.e3mall.pojo.TbItem;

public interface ItemService {

	public TbItem getItemById(Long itemId);
	public DataGridResult getItemList(int pageNum,int pageSize);
}
