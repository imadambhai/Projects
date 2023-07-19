package org.jsp.OTM.uni.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.OTM.uni.DTO.Answer;
import org.jsp.OTM.uni.DTO.Question;

public class SaveAnsWithQues {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Question q=new Question();
		q.setQuestion("Waht is hibernate");
		q.setQuestionedBy("Sathish");
		
		Answer a1=new Answer();
		a1.setAnswer("It's an ORM Tool");
		a1.setAnsweredBy("Adam");
		
		Answer a2=new Answer();
		a2.setAnswer("It's an Open source software");
		a2.setAnsweredBy("Gokul");
		
		Answer a3=new Answer();
		a3.setAnswer("It's an Non-invasive frameword");
		a3.setAnsweredBy("Vicky");
		
		q.setAnswers(new ArrayList<Answer>(Arrays.asList(a1,a2,a3)));
		
		EntityTransaction t=manager.getTransaction();
		
		manager.persist(q);
		t.begin();t.commit();
		
		
		
	}

}
