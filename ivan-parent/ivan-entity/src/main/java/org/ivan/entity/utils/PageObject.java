package org.ivan.entity.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 该类为公共分页类,用于查询数据时用
 * @author 
 * @version 
 */
public class PageObject<T>
{
	/**
	 * 首页
	 */
	private final int firstPage = Common.FIRST_PAGE;
	
	/**
	 * 每页的数据量
	 */
	private int pageData = Common.PAGE_DATA;
	
	/**
	 * 当前页
	 */
	private int curPage = Common.FIRST_PAGE;
	
	/**
	 * 下一页
	 */
	private int nextPage;
	
	/**
	 * 上一页
	 */
	private int prePage;
	
	/**
	 * 最后一页
	 */
	private int endPage;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 总数据量
	 */
	private int totalData;
	
	/**
	 * 保存的数据
	 */
	@SuppressWarnings("unchecked")
    private List<T> dataList = Collections.EMPTY_LIST;
	
	/** 
	 * 页码
	 */
	private List<Integer> pageList = new ArrayList<Integer>();
	
	public PageObject() {
	}
	
	public PageObject(int totalData,int curPage){
		this.totalData = totalData;
		this.curPage = curPage;
		pageValue();
	}
	
	public PageObject(int totalData,int curPage,int pageData){
		this.totalData = totalData;
		this.curPage = curPage;
		this.pageData = pageData;
		pageValue();
	}
	
	private void pageValue(){
		pageList.add(Common.FIRST_PAGE);
		if (0 != totalData)
		{
			//得到总页数以及最后一页
			this.endPage = this.totalPage = totalData % pageData == 0 ? totalData / pageData : totalData / pageData + 1;
			for (int i = 2;i <= endPage;i ++)
			{
				pageList.add(i);
			}
			
			//判断当前页的页码是否合法
			this.curPage = curPage > totalPage ? totalPage : curPage;
			//得到前一页的页码
			this.prePage = curPage < 2 ? firstPage : curPage - 1;
			//得到后一页的页码
			this.nextPage = curPage == totalPage ? totalPage : curPage + 1;
		}
	}
	
	public int getFirstPage() {
		return firstPage;
	}

	public int getPageData() {
		return pageData;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getTotalData() {
		return totalData;
	}

	public List<T> getDataList() {
		return dataList;
	}
	
	public void setDataList(List<T> dataList)
	{
		if (null != dataList && !dataList.isEmpty())
		{
			this.dataList = dataList;
		}
	}

	public List<Integer> getPageList() {
		return pageList;
	}
}