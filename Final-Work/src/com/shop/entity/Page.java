package com.shop.entity;

import java.util.List;



import org.springframework.stereotype.Component;


@Component
public class Page<T> {
	private List<Product> list;

    private List<LoginUser> list1;
    
    private List<Order> list2;
    private int totalRecords;
    private int pageSize;
    private int pageNo;
    
    public int getTotalPages(){
        return (totalRecords+pageSize-1)/pageSize;
    }
    

    public int countOffset(int currentPage,int pageSize){
        int offset = pageSize*(currentPage-1);
        return offset;
    }
    

    public int getTopPageNo(){
        return 1;
    }
    

    public int getPreviousPageNo(){
        if(pageNo<=1){
            return 1;
        }
        return pageNo-1;
    }
    

    public int getNextPageNo(){
        if(pageNo>=getBottomPageNo()){
            return getBottomPageNo();
        }
        return pageNo+1;
    }
    

    public int getBottomPageNo(){
        return getTotalPages();
    }
    
    
    
    
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public List<LoginUser> getList1() {
		return list1;
	}
	public void setList1(List<LoginUser> list1) {
		this.list1 = list1;
	}
	public List<Order> getList2() {
		return list2;
	}
	public void setList2(List<Order> list2) {
		this.list2 = list2;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
		
    
    
		
		
}
