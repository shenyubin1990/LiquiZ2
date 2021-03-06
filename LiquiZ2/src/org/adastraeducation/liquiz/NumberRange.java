package org.adastraeducation.liquiz;

import java.util.ArrayList;

/**
 * Accept a range of numerical answers
 * @author yijinkang
 *
 */
public class NumberRange extends FillIn {
	private double min;	
	private double max;
	
	public NumberRange(int id, int points, int level, double min, double max){
		super(id,points,level,(ArrayList<Answer>) null);
		this.min = min;
		this.max = max;
	}
	
	public NumberRange(int id, int points, int level){
		super(id,points,level,(ArrayList<Answer>) null);
	}
	
	/*
	 * Returns true if typed number is within correct range
	 */
	public double grade(String[] s) {
		try {
			double d = Double.parseDouble(s[0]);
			if(min<=d && d<=max) {
				return getPoints();
			}
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
	
	public void writeHTML(DisplayContext dc) {
		if(dc.isDisplayAnswers()) {
			dc.append("<textarea disabled>");
			// TODO: get student's answer?
			dc.append("Your answer here");
			dc.append("</textarea><br>");

			dc.append("Possible answers:<br>Any number from ").append(min).append(" to ").append(max);
		} else if (dc.isDisplayResponses()) {
			dc.append("<textarea disabled>");
			// TODO: get student's answer?
			dc.append("Your answer here");
			dc.append("</textarea><br>");
			
			// TODO no Answer, thus no Response?
		} else {
			dc.append("<input name='").append(getId()).append("' class='fillin' type='text' />");
		}
	}
}
