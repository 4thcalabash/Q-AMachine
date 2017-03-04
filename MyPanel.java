package randomQA;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class MyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea getQtext() {
		return qtext;
	}
	public JTextArea getAtext() {
		return atext;
	}
	private JButton showQ,showA;
	private JTextArea qtext,atext;
	private QA qa;
	private Helper helper;
	private int random;
//	private int min,max;
	
	
//	public void setMin(int min) {
//		this.min = min;
//	}
//	public void setMax(int max) {
//		this.max = max;
//	}
	public MyPanel(QA qa){
		this.qa=qa;
//		helper = new Helper (min,max);
		qtext = new JTextArea (3,50);
		atext = new JTextArea (3,50);
		Font bigFont = new Font("sanserif",Font.BOLD,24);
		qtext.setFont(bigFont);
		atext.setFont(bigFont);
		qtext.setLineWrap(true);
		atext.setLineWrap(true);
		atext.setEditable(false);
		qtext.setEditable(false);
		add(qtext);
		add(atext);
		showQ = new JButton ("New Question");
		showQ.setFont(bigFont);
		showA = new JButton ("Show Answer");
		showA.setFont(bigFont);
		showQ.addActionListener(new ShowQActionListener(qa));
		showA.addActionListener(new ShowAActionListener(qa));
		add(showQ);
		add(showA);
	}
	public void setHelper(Helper helper) {
		this.helper = helper;
	}
	public Helper getHelper() {
		return helper;
	}
	public class ShowQActionListener implements ActionListener{
		private QA qa;
		public ShowQActionListener(QA qa){
			this.qa=qa;
		}
		public void actionPerformed(ActionEvent ev){
			if (qa.isA()&&qa.isQ()){}
			else{
				atext.setText(null);
				qtext.setText(null);
				if (!qa.isA()){
					atext.setText("The answers have not been loaded yet");
				}
				if (!qa.isQ()){
					qtext.setText("The questions have not been loaded yet");
				}
				return ;
			}
			atext.setText(null);
			random = helper.randomNumber();
			qtext.setText(qa.getQuestion().getQuestionList().get(random));
		}
	}
	public class ShowAActionListener implements ActionListener{
		private QA qa;
		public ShowAActionListener (QA qa){
			this.qa=qa;
		}
		public void actionPerformed(ActionEvent ev){
			if (qa.isA()&&qa.isQ()){}
			else{
				atext.setText(null);
				qtext.setText(null);
				if (!qa.isA()){
					atext.setText("The answers have not been loaded yet");
				}
				if (!qa.isQ()){
					qtext.setText("The questions have not been loaded yet");
				}
				return ;
			}
			atext.setText(qa.getAnswer().getAnswerList().get(random));
		}
	}
//	public void paintComponent(Graphics g){
////		removeAll();
//		
////		setLocation(0,0);
////		setVisible(true);
////		setSize(1200,400);
//	}
}
