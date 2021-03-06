package org.adastraeducation.liquiz;

/*
 * author: Yingzhu
 * This is for Fillin question
 * I decide the merge regexQuestion and NumberQuestion with Fillin instead of extending it. 
 * I will temporarily save the original class. If it is proved that they are useless, 
 * I will delete them at last.
 */
/*
 * Regex Questions and Number Questions are now merged with Fillin Questions.
 */
/*
 * for ApproximateNumber Question, only 1 number is allowed to appear in the question.
 * For instance, "12 fadasd" is right. However, "13 KJKAJD 24" is wrong. Only 13 may be detected and 24 may be ignored. 
 */

import java.util.ArrayList;

public class FillIn extends Question {
	boolean caseSensitive;
	
	public FillIn(int id, int points, int level, ArrayList<Answer> answers) {
		super(id, points, level, answers);
	}
	
	// the new constructor including all of the elements
	public FillIn(int id, int points, int level, Answer answer){
		super(id, points, level, answer);
	}

	// the new constructor including all of the elements
	public FillIn(int points, int level, Answer answer){
		super(points, level, answer);
	}
	
	public FillIn(int id, int points, int level) {
		super (id, points, level);
	}

	/**
	 * Convenience Constructor: create a fillin question with a 
	 * single (correct) string answer (and convert to internal Answer)
	 * @param id
	 * @param points
	 * @param level
	 * @param answer
	 */
	
	public FillIn(){}
	
	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public void setCaseSensitive(boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
	}

	/*
	 * Returns true if typed answer exactly matches a correct answer
	 */
	@Override
	public double grade(String[] s) {
		for (Answer a : getAns()) {
			if(caseSensitive) {
				if(s[0].equals(a.getName())) {
					return (double) getPoints();
				}
			} else {
				if(s[0].equalsIgnoreCase(a.getName())) {
					return (double) getPoints();
				}
			}
		}
		return 0;
	}

	@Override
	//<input name='123' class='fillin' type='text' onblur='showNumberWarning(this, "\\d\\d\\d")'/> 
	public void writeHTML(DisplayContext dc) {
		if(dc.isDisplayAnswers()) {
			dc.append("<textarea disabled>");
			// TODO: get student's answer?
			dc.append("Your answer here");
			dc.append("</textarea><br>");

			dc.append("Possible answers:<br>");
			for (Answer ans : getAns()) {
				ans.writeHTML(dc);
				dc.append("<br>");
			}
		} else if (dc.isDisplayResponses()) {
			dc.append("<textarea disabled>");
			// TODO: get student's answer?
			dc.append("Your answer here");
			dc.append("</textarea><br>");
			
			dc.append("Teacher's comment:<br>");
			Response res = getResponseFor("Your answer here");
			if (res != null) { 
				writeHTML(dc);
			}
		} else {
			dc.append("<input name='").append(getId()).append("' class='fillin' type='text' />");
		}
	}

	@Override
	public void writeJS(StringBuilder b) {
		b.append("fillin()");
	}

	@Override
	public void writeXML(StringBuilder b) {
		b.append("<fillin/>");
	}

}
