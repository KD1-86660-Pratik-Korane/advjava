package com.sunbeam.pojo;

public class Marks {
       String subject;
       double marks;
       
       public Marks() {
    	   
       }
       public Marks(String s,double m) {
    	   subject=s;
    	   marks=m;
       }
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
       
       
       
}