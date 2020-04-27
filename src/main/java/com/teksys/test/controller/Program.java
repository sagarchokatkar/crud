package com.teksys.test.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Program {
	String name;
	
	public Program(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return -1;
	}
//	@Override
//	public boolean equals(Object obj) {
////		if (this == obj) {
////			return true;
////		}
////		if (!(obj instanceof Program)) {
////			return false;
////		}
////		Program other = (Program) obj;
////		return Objects.equals(name, other.name);
//		return true;
//	}
	
	@Override
	public String toString() {
		return "Program [name=" + name + "]";
	}
	public static void main(String[] args) {
		
		Map<Program, String> programMap=new  HashMap<Program, String>();
		String s1 = "sagar1";
		Program p1= new Program(s1);
		Program p2= new Program(s1);
		Program p3= new Program("sagar1");
		Program p4= new Program("sagar4");
		Program p5= new Program("sagar5");
		
		programMap.put(p1, "sagar1");
		programMap.put(p1, "sagar1");
		programMap.put(p3, "sagar3");
		programMap.put(p4, "sagar4");
		programMap.put(p5, "sagar5");
		programMap.put(p2, "sagar2");
		System.out.println(programMap);
		System.out.println(programMap.get(p1));
		System.out.println(programMap.size());
		
		
	}
}