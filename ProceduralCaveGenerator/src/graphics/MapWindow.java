package graphics;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MapWindow extends JFrame{

	private JPanel panel;
	private JTextArea mapa;
	private JScrollPane scrollPane;
	
	
	public MapWindow(String s) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		panel = new JPanel(new GridLayout(1, 1));
		mapa = new JTextArea();
		scrollPane = new JScrollPane(mapa);
		mapa.setEditable(false);
		panel.add(scrollPane);
		printMapa(s);
		//panel.add(mapa);
		add(panel);
		pack();
	}
	
	private void printMapa(String s) {
		mapa.setText("patata");
		mapa.setText(s);
	}
}
