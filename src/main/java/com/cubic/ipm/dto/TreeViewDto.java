package com.cubic.ipm.dto;

import java.util.ArrayList;
import java.util.List;

public class TreeViewDto {

	private String label;
	private List<TreeViewDto> children;

	public TreeViewDto(String name) {
		this.label = name;
		this.children = new ArrayList<>();
	}

	public void addChild(TreeViewDto node) {
		children.add(node);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<TreeViewDto> getChildren() {
		return children;
	}

	public void setChildren(List<TreeViewDto> children) {
		this.children = children;
	}
	
	
	

}
