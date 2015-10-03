package com.taoqibao.entity;

import java.util.List;

public class StuffCategories {

	public int id;
	public String measureUnit;
	public List<Node> nodes;
	public String text;
	public int typeId;

	public class Node {
		public int id;
		public String measureUnit;
		public List<String> nodes;
		public String text;
		public int typeId;
	}

}
