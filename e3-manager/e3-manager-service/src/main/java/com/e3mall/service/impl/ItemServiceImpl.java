package com.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e3mall.common.DataGridResult;
import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.e3mall.pojo.TbItemExample.Criteria;
import com.e3mall.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private TbItemMapper tbItemMapper;
	
	public TbItem getItemById(Long itemId){
		//TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if (list != null && list.size() >0) {
			return list.get(0);
		}
		return null;
	}
	
	public DataGridResult getItemList(int pageNum,int pageSize){
		DataGridResult result=new DataGridResult();
		PageHelper.startPage(pageNum, pageSize);
		TbItemExample example=new TbItemExample();
		List<TbItem> list = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}
}
