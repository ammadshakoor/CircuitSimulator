import java.awt.*;
import javax.swing.*;
public class Main {
	int width=150;
	int height=30;
	
	static JCheckBox parallel,series;
	static JTextField capacitor_field,resistor_field;
	
	public static void main(String[] args) {
		Main m=new Main();
		JFrame frame=new JFrame("Project");
		frame.setSize(600, 345);
		frame.setResizable(false);
		
		Container con=frame.getContentPane();
		con.setLayout(null);
		
		JLabel resistor_label=new JLabel("No of Resistors: ");
		resistor_label.setBounds(160, 0, 100, 130);
		con.add(resistor_label);
		
		resistor_field=new JTextField();
		resistor_field.setBounds(270,50,m.width,m.height);
		con.add(resistor_field);
		
		JLabel capacitor_label=new JLabel("No of Capacitors: ");
		capacitor_label.setBounds(160, 30, 150, 150);
		con.add(capacitor_label);
		
		capacitor_field=new JTextField();
		capacitor_field.setBounds(270,90,m.width,m.height);
		con.add(capacitor_field);
		
		JLabel label_X=new JLabel("Series: ");
		label_X.setBounds(160, 70, 150, 150);
		con.add(label_X);
		
		series=new JCheckBox();
		series.setBounds(270,130,m.width,m.height);
		series.setSelected(false);
		con.add(series);
		
		parallel=new JCheckBox();
		parallel.setBounds(270,170,m.width,m.height);
		parallel.setSelected(true);
		con.add(parallel);
		
		JLabel label_Y=new JLabel("Parallel: ");
		label_Y.setBounds(160, 110, 150, 150);
		con.add(label_Y);
		
		ButtonGroup gbtn=new ButtonGroup();
		gbtn.add(series);
		gbtn.add(parallel);
		
		JButton btn=new JButton("Simulate");
		btn.setBounds(270, 210, 150, 30);
		btn.addActionListener(new Implementer());
		con.add(btn);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
