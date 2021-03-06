package org.adastraeducation.liquiz;

import java.util.ArrayList;

import org.adastraeducation.liquiz.util.Util;

public class Essay extends Question {
	private String defaultText;
	public Essay() {
		defaultText = "";
	}

	public Essay(int id, int level, int points,
				String defaultText) {
		super(id, level, points, (ArrayList<Answer>) null);
		this.defaultText = defaultText;
	}
	
	/*******************Added getter and setter for serialization*************************/
	public String getdefaultText(){
		return defaultText;
	}
	
	public void setdefaultText(){
		this.defaultText = "";
	}

	public String getDefaultText() {
		return defaultText;
	}

	public void setDefaultText(String defaultText) {
		this.defaultText = defaultText;
	}

	public String getTagName() {
		return "Essay";
	}

	public void writeHTML(DisplayContext dc ){		
		dc.append("<textarea name='' rows='10' cols='50' form='quizForm' class='essay'>");
		//TODO: check that this text is properly escaped for HTML
		dc.append(defaultText);
		dc.append("</textarea>");
 	}
	
	public void writeJS(StringBuilder b ) {
		b.append("essay('").append(Util.escapeJS(defaultText))
			.append("')");
	}
	public void writeXML(StringBuilder b ) {
		b.append("<essay>").append(Util.escapeXML(defaultText))
			.append("</essay>");
	}
	
	@Override
	public double grade(String[] s) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isAutomaticGrading() {
		return false;
	}
}
