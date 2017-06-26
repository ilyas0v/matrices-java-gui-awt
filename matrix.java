import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class matrix{
	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("Number of rows of first matrix: ");
		final int row = sc.nextInt();
		System.out.print("Number of columns of first matrix: ");
		final int col = sc.nextInt();
		
		System.out.print("Number of rows of second matrix: ");
		final int row2 = sc.nextInt();
		System.out.print("Number of columns of second matrix: ");
		final int col2 = sc.nextInt();
		
		final Panel pnl = new Panel();
		final Panel pnl2 = new Panel();
		
		pnl.setLayout(new GridLayout(row,col));
		pnl2.setLayout(new GridLayout(row2,col2));
		
		
		final TextField[][] matrix1 = new TextField[row][col];
		final TextField[][] matrix2 = new TextField[row2][col2];
		
		final String matrix1_qiymetler[][] = new String[row][col];
		final String matrix2_qiymetler[][] = new String[row2][col2]; 
		final int cem_qiymetler[][] = new int[row][col];
		
		Button OKbutton1 = new Button("Hazir");
		Button OKbutton2 = new Button("Hazir");
		
		Button matrix1_butonu = new Button("Matrix 1'i tamamla");
		Button matrix2_butonu = new Button("Matrix 2'ni tamamla");
		
		Button hesabla_butonu = new Button("Hesabla");
		
		
		final Frame fr = new Frame("First Matrix");
		final Frame fr2 = new Frame("Second Matrix");
		
		
		
		
		matrix1_butonu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr.show();
			}
		});
		
		matrix2_butonu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				fr2.show();
			}
		});
		
		// --------------------------------------
		OKbutton1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
						for(int i=0;i<row;i++){
							for(int j=0;j<col;j++){
								matrix1_qiymetler[i][j] = matrix1[i][j].getText();
								System.out.print(matrix1_qiymetler[i][j] +" ");
							}
							System.out.println();
						}
						System.out.println("-------------------------------");
						fr.hide();
					}
		});
		
		//----------------------------------
		OKbutton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
						for(int i=0;i<row2;i++){
							for(int j=0;j<col2;j++){
								matrix2_qiymetler[i][j] = matrix2[i][j].getText();
								System.out.print(matrix2_qiymetler[i][j] +" ");
							}
							System.out.println();
						}
						System.out.println("-------------------------------");
						fr2.hide();
					}
		});
		
		//-------------------------------------
		
		
		final Frame cem = new Frame("Cem");
		cem.setSize(30*col,30*row);
		cem.setLayout(new GridLayout(row,col));
		
		
		hesabla_butonu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(row==row2 && col==col2 && matrix1_qiymetler[0][0]!=null && matrix2_qiymetler[0][0]!=null){
					for(int i=0;i<row;i++){
						for(int j=0;j<col;j++){
							System.out.print(Integer.parseInt(matrix1_qiymetler[i][j]) +Integer.parseInt(matrix2_qiymetler[i][j]) + " " );
							//cem_qiymetler[i][j] = Integer.parseInt(matrix1_qiymetler[i][j]) +Integer.parseInt(matrix2_qiymetler[i][j]);
							cem.add(new Label(String.valueOf(Integer.parseInt(matrix1_qiymetler[i][j]) +Integer.parseInt(matrix2_qiymetler[i][j]))));
						}System.out.println();
					}
					cem.show();
				}//System.out.println(":)");
			}
		});
		
		
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++){
				matrix1[i][j] = new TextField();
				pnl.add(matrix1[i][j]);
			}
			
		for(int i=0;i<row2;i++)
			for(int j=0;j<col2;j++){
				matrix2[i][j] = new TextField();
				pnl2.add(matrix2[i][j]);
			}
		
		Frame esas_frame = new Frame("Iki matrixin cemi");
		
		Panel esas_ucun_panel = new Panel(); 
		
		esas_ucun_panel.setLayout(new GridLayout(1,2));
		
		esas_ucun_panel.add(matrix1_butonu);
		esas_ucun_panel.add(matrix2_butonu);
		
		esas_frame.add(esas_ucun_panel,"Center");
		esas_frame.add(hesabla_butonu , "South");
		esas_frame.setSize(300,200);
		esas_frame.show();
			
		fr.add(new Label("First Matrix"),"North");
		fr.add(pnl,"Center");
		fr.add(OKbutton1,"South");
		
		fr2.add(new Label("Second Matrix"),"North");
		fr2.add(pnl2,"Center");
		fr2.add(OKbutton2,"South");
		
		fr.setSize(30*col,50*row);
		fr2.setSize(30*col2,50*row2);
		//fr.show();
		//fr2.show();
		
		fr.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            fr.hide();
         }        
      });    
		
		fr2.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            fr2.hide();
         }        
      }); 
	  
	  esas_frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      }); 
	  
	  cem.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            cem.hide();
         }        
      }); 
		
		
	}
}