package vistana.challenge.domain;

public class Pair<Q, A> {
	
	private Q question;
	private A answer; 
	
	public Pair(Q question, A answer) {
		this.question = question;
		this.answer = answer;
	}

	public Q getQuestion() {
		return question;
	}

	public A getAnswer() {
		return answer;
	}

}
