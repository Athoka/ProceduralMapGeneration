package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import logic.MapGenerator;

@SuppressWarnings("serial")
public class MainWindow extends JFrame{
	
	private JCheckBox jCheckBoxRandomSeed;
	
    private JLabel jLabelHeight;
    private JLabel jLabelWidth;
    private JLabel jLabelCheckRandomSeed;
    private JLabel jLabelRandomSeed;
    private JLabel jLabelStepsNumber;
    private JLabel jLabelFilledPercent;
    
    private JPanel jPanelBase;
    //private JPanel jPanelOpciones;
    //private JPanel jPanelMapa;
    
    private JTextField jTextFieldHeight;
    private JTextField jTextFieldWidth;
    private JTextField jTextFieldRandomSeed;
    private JTextField jTextFieldStepsNumber;
    private JTextField jTextFieldFilledPercent;
    
    private JButton jButtonStart;
    private JTextArea mapa;

    public MainWindow() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Muestra la ventana en el centro del monitor.
		setTitle("Generación procedural de mapas");
        
		initComponents();
		pack();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	jPanelBase = new JPanel();
    	//setLayout(new GridLayout(7,2));
    	setPanelBase();
    	add(jPanelBase);
    	
    }

    private void setPanelBase() {
    	jPanelBase.setLayout(new GridLayout(7,2));
    	
    	//jPanelOpciones = new JPanel();
    	//jPanelMapa = new JPanel();
    	
    	jLabelHeight = new JLabel("Height");
    	jLabelWidth = new JLabel("Width");
    	jLabelCheckRandomSeed = new JLabel("Use random seed");
    	jLabelRandomSeed = new JLabel("Random seed(a positive number)");
    	jLabelStepsNumber = new JLabel("Number of steps");
    	jLabelFilledPercent = new JLabel("Percentaje of filled map");
    	
    	jTextFieldHeight = new JTextField(5);
    	jTextFieldWidth = new JTextField(5);
    	jTextFieldRandomSeed = new JTextField(5);
        jTextFieldStepsNumber = new JTextField(5);
        jTextFieldFilledPercent = new JTextField(5);
        
        jCheckBoxRandomSeed = new JCheckBox();
        
        jButtonStart = new JButton("Generate map");
    	
    	setPanelOpciones();
    	setPanelMapa();
    	
    	//jPanelBase.add(jPanelOpciones, BorderLayout.WEST);
    	//jPanelBase.add(jPanelMapa, BorderLayout.CENTER);
    }
    
    private void setPanelOpciones() {
    	//jPanelOpciones.setLayout(new GridLayout(7, 2));
    	
    	//Width
    	//jPanelOpciones.add(jLabelWidth);
    	jPanelBase.add(jLabelWidth);
    	jTextFieldWidth.setText("40");
    	//jPanelOpciones.add(jTextFieldWidth);
    	jPanelBase.add(jTextFieldWidth);
    	//Heigth
    	//jPanelOpciones.add(jLabelHeight);
    	jPanelBase.add(jLabelHeight);
    	jTextFieldHeight.setText("40");
    	//jPanelOpciones.add(jTextFieldHeight);
    	jPanelBase.add(jTextFieldHeight);
    	//RandomSeed
    	jPanelBase.add(jLabelCheckRandomSeed);
    	//jPanelOpciones.add(jLabelCheckRandomSeed);
    	//jPanelOpciones.add(jCheckBoxRandomSeed);
    	jPanelBase.add(jCheckBoxRandomSeed);
    	//Set a not random seed
    	jPanelBase.add(jLabelRandomSeed);
    	//jPanelOpciones.add(jLabelRandomSeed);
    	jTextFieldRandomSeed.setText("1234");
    	//jPanelOpciones.add(jTextFieldRandomSeed);
    	jPanelBase.add(jTextFieldRandomSeed);
    	//Number of steps
    	jPanelBase.add(jLabelStepsNumber);
    	//jPanelOpciones.add(jLabelStepsNumber);
    	jTextFieldStepsNumber.setText("5");
    	//jPanelOpciones.add(jTextFieldStepsNumber);
    	jPanelBase.add(jTextFieldStepsNumber);
    	//Percent
    	jPanelBase.add(jLabelFilledPercent);
    	//jPanelOpciones.add(jLabelFilledPercent);
    	jTextFieldFilledPercent.setText("47");
    	//jPanelOpciones.add(jTextFieldFilledPercent);
    	jPanelBase.add(jTextFieldFilledPercent);
    	//Button
    	//jPanelOpciones.add(jButtonStart);
    	jPanelBase.add(jButtonStart);
    	
    	jButtonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startActionPerformed(e);
			}
		});
    }
    
    private void setPanelMapa() {
    	mapa = new JTextArea();
    	mapa.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	mapa.setEditable(false);
    	//jPanelMapa.add(mapa);
    }
    
    void startActionPerformed(ActionEvent e) {
    	int width = Integer.parseInt(jTextFieldWidth.getText());
    	int height = Integer.parseInt(jTextFieldHeight.getText());
    	boolean randomSeed = jCheckBoxRandomSeed.isSelected();
    	int seed = Integer.parseInt(jTextFieldRandomSeed.getText());
    	int steps = Integer.parseInt(jTextFieldStepsNumber.getText());
    	int filledPercent = Integer.parseInt(jTextFieldFilledPercent.getText());
    	
    	MapGenerator map = new MapGenerator(width, height, randomSeed, seed, steps, filledPercent); 
    	
    	map.generateMap();
    	MapWindow mW = new MapWindow(map.toString());
    	//mW.printMapa(map.toString());
    	mW.setVisible(true);
    }
}
