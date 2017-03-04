package randomQA;

import javax.swing.*;
import java.awt.event.*;

public class QA {
	private Answers answer;
	private Questions question;
	private MyPanel panel;
	private JFrame frame;
	private boolean q=false,a=false;
	public static void main(String args[]){
		QA qa = new QA();
		qa.go(qa);
	}
	public class LoadQActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser ();
			fileOpen.showOpenDialog(frame);
			question = new Questions (fileOpen.getSelectedFile());
			q=true;
			int min=0;
			int max=question.getQuestionList().size();
			panel.setHelper(new Helper (min,max));
			panel.getQtext().setText(null);
		}
	}
	public class loadAActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			JFileChooser fileOpen = new JFileChooser ();
			fileOpen.showOpenDialog(frame);
			answer = new Answers (fileOpen.getSelectedFile());
			a=true;
			panel.getAtext().setText(null);
		}
	}
	public void go(QA qa){
//		panel = new MyPanel (question,answer);
		panel = new MyPanel (qa);
		frame = new JFrame ("Random:Q&A");
		JMenuBar menubar = new JMenuBar ();
		JMenu fileMenu = new JMenu ("file");
		JMenuItem loadQ = new JMenuItem ("Load Q");
		JMenuItem loadA = new JMenuItem ("Load A");
		loadQ.addActionListener(new LoadQActionListener());
		loadA.addActionListener(new loadAActionListener());
		fileMenu.add(loadQ);
		fileMenu.add(loadA);
		menubar.add(fileMenu);
//		frame.setLayout(null);
//		panel.setSize(1200,500);
		frame.add(panel);
//		panel.repaint();
		frame.setJMenuBar(menubar);
		frame.setSize(1200,400);
		frame.setLocation(400, 400);
		frame.setVisible(true);
		
	}
	public Answers getAnswer() {
		return answer;
	}
	public Questions getQuestion() {
		return question;
	}
	public boolean isQ() {
		return q;
	}
	public boolean isA() {
		return a;
	}
}
