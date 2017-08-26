package com.e3mall.pagehelper;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.e3mall.mapper.TbItemMapper;
import com.e3mall.pojo.TbItem;
import com.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class PageHelperTest {

	@Test
	public void testPageHelper(){

		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		PageHelper.startPage(1, 10);
		TbItemExample example=new TbItemExample();
		List<TbItem> list = mapper.selectByExample(example);
		PageInfo<TbItem> page=new PageInfo<>(list);
		System.out.println(page.getTotal());
		System.out.println(page.getPages());
		System.out.println(page.getPageNum());
		System.out.println(page.getPageSize());
		
		
		
		
	}
}
