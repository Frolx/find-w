package com.spring.test.frlx;

import java.util.ArrayList;
import java.util.List;

public class SiteLink <T>{
	
	private T link;
	
	private List<SiteLink<T>> linkChilds;
	
	public SiteLink() {
		linkChilds = new ArrayList<SiteLink<T>>();
	}
	
	public SiteLink(T data) {
		this.link = data;
	}
	
	public T getLink() {
		return link;
	}

	public void setLink(T link) {
		this.link = link;
	}

	public List<SiteLink<T>> getLinkChilds() {
		return linkChilds;
	}

	public void setLinkChilds(List<SiteLink<T>> linkChilds) {
		this.linkChilds = linkChilds;
	}
	
	public int getLinkChildrenNumber() {
		return linkChilds.size();
	}
	
	public boolean hasLinkChildrens() {
		return (getLinkChildrenNumber() > 0);
	}
	
	public void addChildLink(SiteLink<T> childLink) {
		linkChilds.add(childLink);
	}
	
	public void removeChildAt(int index) throws IndexOutOfBoundsException {
		linkChilds.remove(index);
	}
}
