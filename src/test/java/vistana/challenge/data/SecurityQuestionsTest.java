//package vistana.challenge.data;
//
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//public class SecurityQuestionsTest {
//	
//	private static SecurityQuestionsTest securityQuestions;
//	
//	private Map<Integer, String> questions;
//
//	private SecurityQuestionsTest() {
//		this.questions = new HashMap<>();
//		this.questions.put(1, "What is your mother's maiden name?");
//		this.questions.put(2, "What is your favorite color?");
//		this.questions.put(3, "Who was you childhood friend?");
//		this.questions.put(4, "What is your favorite car?");
//		this.questions.put(5, "What is your favorite sport?");
//		this.questions.put(6, "What is your  favorite city?");
//	}
//	
//	private static SecurityQuestions getSecurityQuestions() {
//		if(securityQuestions == null) {
//			synchronized(SecurityQuestions.class) {
//				securityQuestions = new SecurityQuestionsTest();
//			}
//		}
//		return securityQuestions;
//	}
//
//	public static Map<Integer, String> getQuestions() {
//		return Collections.unmodifiableMap(getSecurityQuestions().questions);
//	}
//
//}
