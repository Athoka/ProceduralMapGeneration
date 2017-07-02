package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logic.GeneradorMapa;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame{
	
	private JCheckBox jCheckBoxSemillaAleatoria;
	
    private JLabel jLabelAlto;
    private JLabel jLabelAncho;
    private JLabel jLabelComprobarSemillaAleatoria;
    private JLabel jLabelSemillaAleatoria;
    private JLabel jLabelNumeroVueltas;
    private JLabel jLabelPorcentajeLleno;
    
    private JPanel jPanelBase;
    
    private JTextField jTextFieldAlto;
    private JTextField jTextFieldAncho;
    private JTextField jTextFieldSemillaAleatoria;
    private JTextField jTextFieldNumeroVueltas;
    private JTextField jTextFieldPorcentajeRelleno;
    
    private JButton jButtonGenerarMapa;

    private VentanaMapa ventanaMapa;
    
    public VentanaPrincipal() {
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Muestra la ventana en el centro del monitor.
		setResizable(false);
		initComponents();
		pack();
    }

    private void initComponents() {
    	jPanelBase = new JPanel();
    	setPanelBase();
    	add(jPanelBase);
    }

    private void setPanelBase() {
    	jPanelBase.setLayout(new GridLayout(7,2));
    	
    	jLabelAlto = new JLabel("Alto");
    	jLabelAncho = new JLabel("Ancho");
    	jLabelComprobarSemillaAleatoria = new JLabel("Utilizar semilla aleatoria");
    	jLabelSemillaAleatoria = new JLabel("Semilla(numero positivo)");
    	jLabelNumeroVueltas = new JLabel("Numero de vueltas");
    	jLabelPorcentajeLleno = new JLabel("Porcentaje de mapa relleno");
    	
    	jTextFieldAlto = new JTextField(5);
    	jTextFieldAncho = new JTextField(5);
    	jTextFieldSemillaAleatoria = new JTextField(5);
        jTextFieldNumeroVueltas = new JTextField(5);
        jTextFieldPorcentajeRelleno = new JTextField(5);
        
        jCheckBoxSemillaAleatoria = new JCheckBox();
        
        jButtonGenerarMapa = new JButton("Generar mapa");
    	
        //Width
    	jPanelBase.add(jLabelAncho);
    	jTextFieldAncho.setText("40");
    	jPanelBase.add(jTextFieldAncho);
    	//Heigth
    	jPanelBase.add(jLabelAlto);
    	jTextFieldAlto.setText("40");
    	jPanelBase.add(jTextFieldAlto);
    	//RandomSeed
    	jPanelBase.add(jLabelComprobarSemillaAleatoria);
    	jPanelBase.add(jCheckBoxSemillaAleatoria);
    	//Set a not random seed
    	jPanelBase.add(jLabelSemillaAleatoria);
    	jTextFieldSemillaAleatoria.setText("1234");
    	jPanelBase.add(jTextFieldSemillaAleatoria);
    	//Number of steps
    	jPanelBase.add(jLabelNumeroVueltas);
    	jTextFieldNumeroVueltas.setText("5");
    	jPanelBase.add(jTextFieldNumeroVueltas);
    	//Percent
    	jPanelBase.add(jLabelPorcentajeLleno);
    	jTextFieldPorcentajeRelleno.setText("47");
    	jPanelBase.add(jTextFieldPorcentajeRelleno);
    	//Button
    	jPanelBase.add(jButtonGenerarMapa);
    	
    	jButtonGenerarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startActionPerformed(e);
			}
		});
    }
    
    void startActionPerformed(ActionEvent e) {
    	int ancho = Integer.parseInt(jTextFieldAncho.getText());
    	int alto = Integer.parseInt(jTextFieldAlto.getText());
    	boolean semillaAleatoria = jCheckBoxSemillaAleatoria.isSelected();
    	int semilla = Integer.parseInt(jTextFieldSemillaAleatoria.getText());
    	int numeroVueltas = Integer.parseInt(jTextFieldNumeroVueltas.getText());
    	int porcentaje = Integer.parseInt(jTextFieldPorcentajeRelleno.getText());
    	
    	GeneradorMapa map = new GeneradorMapa(ancho, alto, semillaAleatoria, semilla, numeroVueltas, porcentaje); 
    	
    	map.generarMapa();
    	if(ventanaMapa != null)
    		ventanaMapa.dispose();
    	ventanaMapa = new VentanaMapa(map.toString());
    	ventanaMapa.setVisible(true);
    }
}
