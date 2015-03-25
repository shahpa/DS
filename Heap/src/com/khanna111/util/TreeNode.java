package com.khanna111.util;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    final String name;
    final List<TreeNode> children;

    public TreeNode(String name, List<TreeNode> children) {
        this.name = name;
        this.children = children;
    }

    public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + name);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1).print(prefix + (isTail ?"    " : "│   "), true);
        }
    }
    
    public static void main(String[] args) {
	TreeNode child8 = new TreeNode("8", new ArrayList<TreeNode>());
	TreeNode child9 = new TreeNode("9", new ArrayList<TreeNode>());
	List<TreeNode> childsOf4 = new ArrayList<TreeNode>();
	childsOf4.add(child8);
	childsOf4.add(child9);
	
	TreeNode child10 = new TreeNode("10", new ArrayList<TreeNode>());
	TreeNode child11 = new TreeNode("11", new ArrayList<TreeNode>());
	List<TreeNode> childsOf5 = new ArrayList<TreeNode>();
	childsOf5.add(child10);
	childsOf5.add(child11);
	
	
	TreeNode child12 = new TreeNode("12", new ArrayList<TreeNode>());
	TreeNode child13 = new TreeNode("13", new ArrayList<TreeNode>());
	List<TreeNode> childsOf6 = new ArrayList<TreeNode>();
	childsOf6.add(child12);
	childsOf6.add(child13);
	
	
	TreeNode child14 = new TreeNode("14", new ArrayList<TreeNode>());
	TreeNode child15 = new TreeNode("15", new ArrayList<TreeNode>());
	List<TreeNode> childsOf7 = new ArrayList<TreeNode>();
	childsOf7.add(child14);
	childsOf7.add(child15);
	
	
	TreeNode child4 = new TreeNode("4", childsOf4);
	TreeNode child5 = new TreeNode("5", childsOf5);
	TreeNode child6 = new TreeNode("6", childsOf6);
	TreeNode child7 = new TreeNode("7", childsOf7);
	
	List<TreeNode> childsOf2 = new ArrayList<TreeNode>();
	childsOf2.add(child4);
	childsOf2.add(child5);
	
	List<TreeNode> childsOf3 = new ArrayList<TreeNode>();
	childsOf3.add(child6);
	childsOf3.add(child7);
	
	TreeNode child2 = new TreeNode("2", childsOf2);
	TreeNode child3 = new TreeNode("3", childsOf3);
	
	List<TreeNode> childsOf1 = new ArrayList<TreeNode>();
	childsOf1.add(child2);
	childsOf1.add(child3);
	
	TreeNode child1 = new TreeNode("1", childsOf1);
	
	
	
	child1.print();
	
	
	
    }
}