package org.adastraeducation.liquiz;


public class MultiAnswer extends MultiChoiceDropdown {
	private Answer [] answers;
	
	/**********************Added getter and setter for serialization********************************/
	public Answer[] getAnswer(){
		return answers;
	}
	
	public void setAnswer(Answer[] a){
		answers = a;
	}

	public MultiAnswer() {
	}

	public MultiAnswer(int id, int level, int points, 
			Answer[] answers) {
		super(id, level, points, answers);
	}
	public MultiAnswer(int level, int points, 
			Answer[] answers) {
		super(level, points, answers);
	}
	
	public MultiAnswer(int level, int points, String stdChoiceName, int [] rightAns) {
		// TODO Auto-generated constructor stub
		super(level, points);
		stdchoice = new StdChoice(stdChoiceName, rightAns);
	}

	public String getTagName() {
		return "MultiAnswer";
	}
	
	public Answer[] getAnswers() {
		return answers;
	}
	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}


	public void writeHTML(StringBuilder b ){	
		if (stdchoice != null) {

			stdchoice.writeHTMLMultiSelection(b);

		} else {

		
			b.append("<select multiple>");
			for (int i = 0; i < answers.length; i++){
				b.append("<option value= '" + answers[i].getAnswer() + "'>"+ answers[i].getAnswer() +"  </option> ");
			 }
			b.append("</select>");
			b.append("</br>");
		}
       
	}
	public void writeJS(StringBuilder b ){
		for (int i = 0; i < answers.length; i++){
			b.append("new MultipleChoice(" +answers[i].getAnswer() +")");
		}
	}	
}