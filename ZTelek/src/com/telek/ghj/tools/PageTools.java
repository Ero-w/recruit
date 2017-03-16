package com.telek.ghj.tools;

public class PageTools { 
	private long page=0;//当前页
	private long rows=0;//每页最大行
	private long total=0;//总行数
	private long pages=0;//总页数
	private long begin=0;//当前页开始行
	private long end=0;//当前页结束行

	/**
	 * 构造函数
	 * @param page 当前页
	 * @param rows 每页最大行
	 * @param total 总行数
	 */
	public PageTools(long page,long rows,long total) { 
		this.page=page;
		this.rows=rows;
		this.total=total;
		
		//校验查询分页数据-总行数
		if (this.total>0) { 
			//校验查询分页数据-每页最大行
			if (this.rows<1) {
				this.rows=10;
			}
			
			//计算查询分页的总页数
			this.pages=this.total/this.rows;
			if (this.total%this.rows>0) {
				this.pages=this.pages+1;
			}
			
			//校验查询分页数据-当前页
			if (this.page<1) {
				this.page=1;
			} else if (this.page>this.pages) {
				this.page=this.pages;
			}
			
			//计算分页查询的开始行和结束行
			this.begin=(this.page-1)*this.rows+1;
			this.end=this.page*this.rows;
		} else {
			this.page=0;
			this.rows=0;
			this.total=0;
			this.pages=0;
			this.begin=0;
			this.end=0;
		}
	}

	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}

	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public long getPages() {
		return pages;
	}
	public void setPages(long pages) {
		this.pages = pages;
	}

	public long getBegin() {
		return begin;
	}
	public void setBegin(long begin) {
		this.begin = begin;
	}

	public long getEnd() {
		return end;
	}
	public void setEnd(long end) {
		this.end = end;
	}
}