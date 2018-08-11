import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Implementer extends Main implements ActionListener{
	Container con;
	JFrame frame;
	Images i=new Images();
	
	void frameVisible(boolean f,String msg){
		if (f==false){
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			JOptionPane.showMessageDialog(con,msg);
		}
		else{
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
	}
	
	void frameVisible(boolean f){
		if (f==true){
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
	}
	
	//Series Calc
	void getSourcePic(){
		JLabel src_img=new JLabel(i.source);
		src_img.setBounds(130, 150, 50, 150);
		con.add(src_img);
	}
	void getVerticallLayer(int x,int y){
		JLabel lr1_img=new JLabel(i.vertical_layer);
		lr1_img.setBounds(x, y, 50, 128);
		con.add(lr1_img);
	}
	void getHorizontalLayer(int x,int y){
		JLabel lr2_img=new JLabel(i.horizontal_layer);
		lr2_img.setBounds(x, y, 100, 20);
		con.add(lr2_img);
	}
	void getResistorPic(int x,int y){
		JLabel res_img=new JLabel(i.resistor);
		res_img.setBounds(x, y, 100, 100);
		con.add(res_img);
	}
	void getCapacitorPic(int x,int y){
		JLabel cap_img=new JLabel(i.capacitor);
		cap_img.setBounds(x, y, 100, 100);
		con.add(cap_img);
	}
	void getpCapacitorPic(int x,int y){
		JLabel pcap_img=new JLabel(i.pcapacitor);
		pcap_img.setBounds(x, y, 100, 200);
		con.add(pcap_img);
	}
	void getpResistorPic(int x,int y){
		JLabel pres_img=new JLabel(i.presistor);
		pres_img.setBounds(x, y, 100, 200);
		con.add(pres_img);
	}
	
	int arr[]=new int[500];
	void align_Repeater(int a){
		int res=a;
		int z=156;
		for(int x=0;x<=res;x++,z+=100){
			arr[0]=156;
			arr[x+1]=z;
		}
	}
	
	void eo_Repeater(int cap_val, int res_val){
		if (cap_val > res_val){
			for(int r=res_val+1;r<=cap_val;r++){
				getHorizontalLayer(arr[r],151);
			}
			getVerticallLayer(arr[cap_val+1]-26,162);
		}
		else{
			for(int r=cap_val+1;r<=res_val;r++){
				getHorizontalLayer(arr[r],151+130);
			}
			getVerticallLayer(arr[res_val+1]-26,162);
		}
	}
	// For Resistor R/C 0/0, 1/0, 2/0, 3/0 etc...
	void x_Repeater(int res_val){
		if(res_val==1){
			getResistorPic(156,110);
			getVerticallLayer(230,162);
			getHorizontalLayer(155,280);
			
		}
		else{
			//Odd check
			if(res_val%2!=0){
				int x=res_val/2;
				int y=res_val%2;
				align_Repeater(x);
				for(int a=1;a<=x+y;a++){
					getResistorPic(arr[a],110);
					
				}
				for(int a=1;a<=x;a++){
					getResistorPic(arr[a],240);
				}
				getHorizontalLayer(arr[x+1],281);
				getVerticallLayer(arr[x+1]+74,162);
			}
			else{
				int x=res_val/2;
				align_Repeater(x);
				for(int a=1;a<=x;a++){
					getResistorPic(arr[a],110);
					
				}
				for(int a=1;a<=x;a++){
					getResistorPic(arr[a],240);
				}
				getVerticallLayer(arr[x+1]-26,162);
			}
		}
	}
	//For Capacitor R/C 0/0, 0/1, 0/2, 0/4 etc...
	void y_Repeater(int cap_val){
		if(cap_val==1){
			getCapacitorPic(156,110);
			getVerticallLayer(230,162);
			getHorizontalLayer(155,280);
			
		}
		else{
			//Odd check
			if(cap_val%2!=0){
				int x=cap_val/2;
				int y=cap_val%2;
				align_Repeater(x);
				for(int a=1;a<=x+y;a++){
					getCapacitorPic(arr[a],110);
					
				}
				for(int a=1;a<=x;a++){
					getCapacitorPic(arr[a],240);
				}
				getHorizontalLayer(arr[x+1],281);
				getVerticallLayer(arr[x+1]+74,162);
			}
			else{
				int x=cap_val/2;
				align_Repeater(x);
				for(int a=1;a<=x;a++){
					getCapacitorPic(arr[a],110);
					
				}
				for(int a=1;a<=x;a++){
					getCapacitorPic(arr[a],240);
				}
				getVerticallLayer(arr[x+1]-26,162);
			}
		}
	}
	
	void both_Even_Repeater(int cap_val,int res_val){
				int x=cap_val+res_val/2;
				align_Repeater(x);
				for(int a=1;a<=x-1;a++){
					getResistorPic(arr[a],110);
					
				}
				for(int a=1;a<=x-1;a++){
					getCapacitorPic(arr[a],240);
				}
				getVerticallLayer(arr[x+1]-126,162);
			}
	void both_Odd_Repeater(int cap_val,int res_val){
		int x=cap_val+res_val/2;
		align_Repeater(x);
		for(int a=1;a<=x-1;a++){
			getResistorPic(arr[a],110);
			
		}
		for(int a=1;a<=x-1;a++){
			getCapacitorPic(arr[a],240);
		}
		getVerticallLayer(arr[x+1]-126,162);
	}
	void even_Odd_Repeater(int cap_val,int res_val){
		int x=cap_val+res_val;
		align_Repeater(x);
		int y=x-res_val;
		for(int a=1;a<=res_val;a++){
			getResistorPic(arr[a],110);
			
		}
		for(int a=1;a<=y;a++){
			getCapacitorPic(arr[a],240);
		}
		/*------------------------------------*/
		eo_Repeater(cap_val,res_val);
		
	}
	void odd_Even_Repeater(int cap_val,int res_val){
		int x=cap_val+res_val;
		align_Repeater(x);
		int y=x-res_val;
		for(int a=1;a<=y;a++){
			getCapacitorPic(arr[a],240);
		}
		for(int a=1;a<=res_val;a++){
			getResistorPic(arr[a],110);
		}
		/*------------------------------------*/
		eo_Repeater(cap_val,res_val);
	}
	
	//Parallel Calc
	void y_Generator(int cap_val,int res_val){
		int x=cap_val+res_val;
		align_Repeater(x);
		for(int a=1;a<=res_val;a++){
			getpResistorPic(arr[a]+49,125);
		}
		for(int a=1;a<=x;a++){
			getHorizontalLayer(arr[a],150);
		}
		for(int a=1;a<=x;a++){
			getHorizontalLayer(arr[a],282);
		}
		for(int a=1+res_val;a<=cap_val+res_val;a++){
			getpCapacitorPic(arr[a]+49,125);
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame=new JFrame("Simulated");
		frame.setSize(800, 600);
		//frame.setResizable(false);
		
		con=frame.getContentPane();
		con.setLayout(null);
		con.setBackground(Color.orange);
		
		if(!(capacitor_field.getText().isEmpty()) && !(resistor_field.getText().isEmpty())){
			
			int cap_val=Integer.parseInt(capacitor_field.getText());
			int res_val=Integer.parseInt(resistor_field.getText());
			
			if(series.isSelected()){				
				if(res_val > 0 && cap_val==0){
					getSourcePic();
					x_Repeater(res_val);
					frameVisible(true);
				}
				else if(cap_val > 0 && res_val==0){
					getSourcePic();
					y_Repeater(cap_val);
					frameVisible(true);
				}
				else if (cap_val%2==0 && res_val%2==0){
					getSourcePic();
					both_Even_Repeater(res_val,cap_val);
					frameVisible(true);
				}
				else if (cap_val%2!=0 && res_val%2!=0){
					getSourcePic();
					both_Odd_Repeater(res_val,cap_val);
					frameVisible(true);
				}
				else if (res_val%2==0 && cap_val%2!=0){
					getSourcePic();
					even_Odd_Repeater(cap_val,res_val);
					frameVisible(true);
				}
				else if (res_val%2!=0 && cap_val%2==0){
					getSourcePic();
					odd_Even_Repeater(cap_val,res_val);
					frameVisible(true);
				}
				else{
					frameVisible(false,"Error, Value Must be Greater Than '0'");
				}
			}
			else if(parallel.isSelected()){
				getSourcePic();
				y_Generator(cap_val,res_val);
				frameVisible(true);
			}
			else{
				frameVisible(false,"Error, Please Select Series Or Parallel");
			}
		}
		else{
			frameVisible(false,"Error, Please Enter Value..!");
		}
		
	}
}
