package com.pheonix.project.emperor.swing;

import java.awt.Dimension;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

import com.pheonix.project.emperor.tablemodel.AllBuildingsTm;
import com.pheonix.project.emperor.tablemodel.AllHousesTm;
import com.pheonix.project.emperor.tablemodel.BuildingModsTm;
import com.pheonix.project.emperor.tablemodel.HouseModsTm;

public class BuildingModelEditor extends JPanel {
	/** 
	 * @Fields serialVersionUID : TODO 
	 */
	private static final long serialVersionUID = 2849644221586864615L;
	private JLabel lbl_buildingModels;
	private JTable tbl_buildingModels;
	private JLabel lbl_allBuildings;
	private JTable tbl_allBuildings;
	private JLabel lbl_houseModels;
	private JTable tbl_houseModels;
	private JLabel lbl_allHouses;
	private JTable tbl_allHouses;

	/**
	 * Create the panel.
	 */
	public BuildingModelEditor() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		int rh = 16,hh = 20;
		lbl_buildingModels = new JLabel("BUILDING MODS");		
		add(lbl_buildingModels);
		
		tbl_buildingModels = new JTable();
		tbl_buildingModels.setModel(new BuildingModsTm());
		JScrollPane scr_buildingModels = new JScrollPane(tbl_buildingModels);
		scr_buildingModels.setBorder(BorderFactory.createEmptyBorder());
		tbl_buildingModels.setPreferredSize(new Dimension(0,rh * 5));
		scr_buildingModels.setPreferredSize(new Dimension(0,rh * 5 + hh));
		scr_buildingModels.setAutoscrolls(false);
		add(scr_buildingModels);

		lbl_allBuildings = new JLabel("ALL BUILDINGS");
		add(lbl_allBuildings);

		tbl_allBuildings = new JTable();
		tbl_allBuildings.setModel(new AllBuildingsTm());
		JScrollPane scr_allBuildings = new JScrollPane(tbl_allBuildings);
		scr_allBuildings.setBorder(BorderFactory.createEmptyBorder());
		tbl_allBuildings.setPreferredSize(new Dimension(0,rh * 269));
		scr_allBuildings.setPreferredSize(new Dimension(0,rh * 269 + hh));
		add(scr_allBuildings);

		lbl_houseModels = new JLabel("HOUSE MODS");
		add(lbl_houseModels);

		tbl_houseModels = new JTable();
		tbl_houseModels.setModel(new HouseModsTm());
		JScrollPane scr_houseModels = new JScrollPane(tbl_houseModels);
		scr_houseModels.setBorder(BorderFactory.createEmptyBorder());
		scr_houseModels.setPreferredSize(new Dimension(0,rh * 5 + hh));
		add(scr_houseModels);

		lbl_allHouses = new JLabel("ALL HOUSES");
		add(lbl_allHouses);

		tbl_allHouses = new JTable();
		tbl_allHouses.setModel(new AllHousesTm());
		JScrollPane scr_allHouses = new JScrollPane(tbl_allHouses);
		scr_allHouses.setBorder(BorderFactory.createEmptyBorder());
		scr_allHouses.setPreferredSize(new Dimension(0,rh * 15 + hh));
		add(scr_allHouses);
		
	}
	public void saveFile() {
		//弹出文件选择框
		JFileChooser chooser = new JFileChooser();
		
		//后缀名过滤器
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "模型文件(*.txt)", "txt");
		chooser.setFileFilter(filter);
		
		//下面的方法将阻塞，直到【用户按下保存按钮且“文件名”文本框不为空】或【用户按下取消按钮】
		int option = chooser.showSaveDialog(null);
		if(option==JFileChooser.APPROVE_OPTION){	//假如用户选择了保存
			File file = chooser.getSelectedFile();
			
			String fname = chooser.getName(file);	//从文件名输入框中获取文件名
			
			//假如用户填写的文件名不带我们制定的后缀名，那么我们给它添上后缀
			if(fname.indexOf(".txt")==-1){
				file=new File(chooser.getCurrentDirectory(),fname+".txt");
			}
			
			try {
				
				FileWriter writer = new FileWriter(file);
				String str = "Notes on working with the model data\n" +
						"-------------------------------------\n" +
						"\n" +
						"0. Modifying this data can have unexpected, undesired side effects. Always keep a back up copy.\n" +
						"\n" +
						"1. The numbers within the curly brackets ( { and } ) are the actual data.\n" +
						"\n" +
						"2. Please keep everything (including the spacing) as it is laid out here,\n" +
						"   only changing the numbers (This helps when hardcoding the data back into\n" +
						"   the compiled code).\n" +
						"\n" +
						"3. For negative numbers please keep the minus sign directly in front of the\n" +
						"   number ( e.g. -10   NOT   - 10), errors will result otherwise.\n" +
						"\n" +
						"4. From left to right, the (BUILDINGS) numbers refer to :-\n" +
						"	a - Cost of structure or of one tile of a structure (for walls etc)\n" +
						"	b - Initial desirability value\n" +
						"	c - desirability step (in tiles)\n" +
						"	d - desirability step size\n" +
						"	e - max desirability range\n" +
						"	f - Number of people a building employs\n" +
						"	g - Fire Risk Increment\n" +
						"	h - Damage Risk Increment\n" +
						"	i - Resource Used\n" +
						"	j - Risk Reducer\n" +
						"	k - Evolve Desirability (<=0 means there is no evolution)\n" +
						"	l - Structural Integrity value\n" +
						"	m - Feng Shue Value\n" +
						"\n" +
						"5. From left to right, the (HOUSES) numbers refer to :-\n" +
						"	a - DES level at which the house will devolve		EVO_DES_LOW,		// 0\n" +
						"	b - DES level at which the house will evolve		EVO_DES_HIG,		// 1\n" +
						"	c - Herbalist needed to evolve				EVO_HERBALIST,		// 2\n" +
						"	d - Water needed to evolve				EVO_H2O,		// 3\n" +
						"	e - Acupuncture needed to evolve			EVO_ACUPUNCTURE,	// 4\n" +
						"	f - Music needed to evolve				EVO_MUSIC,		// 5\n" +
						"	g - Acrobat needed to evolve				EVO_ACROBAT,		// 6\n" +
						"	h - Drama needed to evolve 				EVO_DRAMA,		// 7\n" +
						"	i - Food quality needed to evolve			EVO_FOOD_QUALITY,	// 8\n" +
						"	j - Hemp needed to evolve				EVO_HEMP,		// 9\n" +
						"	k - Ceramics needed to evolve				EVO_CERAMICS,		// 10\n" +
						"	l - Tea needed to evolve				EVO_TEA,		// 11\n" +
						"	m - Silk needed to evolve				EVO_SILK,		// 12\n" +
						"	n - Bronzeware or lacquerware needed to evolve		EVO_BRONZEWARE,		// 13\n" +
						"	o - Crime Risk Increment				EVO_CRIME_INC,		// 14\n" +
						"	p - Crime Risk Base					EVO_CRIME_BASE,		// 15\n" +
						"	q - UNUSED						EVO_UNUSED_16,		// 16\n" +
						"	r - Population capacity					EVO_CAPACITY,		// 17\n" +
						"	s - tax rate multiplier					EVO_TAX_RATE,		// 18\n" +
						"	t - UNUSED						EVO_UNUSED_19,		// 19\n" +
						"	u - Disease Risk Increment				EVO_DISEASE_INC,	// 20\n" +
						"	v - Ancestor access needed to evolve			EVO_ANCESTOR,		// 21\n" +
						"	w - Confucian access needed to evolve			EVO_CONFUCIAN,		// 22\n" +
						"	x - Daoist or Buddhist access needed to evolve		EVO_BUDDHIST,		// 23\n" +
						"\n" +
						"6. Chained structures such as walls roads etc do not have any effect on\n" +
						"	desirability. (Except for Avenues and Boulevards.)\n" +
						"\n" +
						"7. At the moment the maximum range for spreading desirability = 10 tiles.\n" +
						"\n" +
						"8. When setting DES ranges note that a positive DES level needs a negative\n" +
						"  step.\n" +
						"\n" +
						"9. Set values for the Dock and not the Dockhouse.\n" +
						"\n" +
						"Model data starts here:-\n" +
						"-------------------------\n" ;

				writer.write(str);
				
				writer.write("\nBUILDING MODS\n\n");
				
				writeBuildings(writer,tbl_buildingModels.getModel());

				writer.write("\n\nALL BUILDINGS\n\n");
				writer.write("	    a   b   c   d   e   f   g   h   i   j\n");
				writer.write("	   CST DES STP SZE RGE EMP FRI DRI RES RRD\n\n");
				
				writeBuildings(writer,tbl_allBuildings.getModel());

				writer.write("\n\nHOUSE MODS\n");
				
				writeHouses(writer,tbl_houseModels.getModel());

				writer.write("\n\nALL HOUSES\n");
				
				writeHouses(writer,tbl_allHouses.getModel());

				writer.write("\n\nEnd of model data.\n-------------------");
				
				writer.close();
				
			} catch (IOException e) {
				System.err.println("IO异常");
				e.printStackTrace();
			}	
		}
	}

	
	public void noFireRisk(){
		allBuildingsColumnValue(8,new Integer(0));
	}
	
	public void noDamageRisk(){
		allBuildingsColumnValue(9,new Integer(0));
	}
	void writeBuildings(FileWriter writer,TableModel model) throws IOException{
		int rowCount = model.getRowCount();
		for(int i = 0;i < rowCount;i ++){
			writer.write(model.getValueAt(i, 0).toString());
			writer.write(",");
			writer.write(model.getValueAt(i, 1).toString());
			writer.write(",{,");
			for(int j = 2;j < 15;j ++){
				writer.write(model.getValueAt(i, j).toString());
				writer.write(",");
			}

			writer.write("},,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,\n");
		}
	}
	void writeHouses(FileWriter writer,TableModel model) throws IOException{
		int rowCount = model.getRowCount();
		for(int i = 0;i < rowCount;i ++){
			writer.write(model.getValueAt(i, 0).toString());
			writer.write(",{,");
			for(int j = 1;j < 25;j ++){
				Object o = model.getValueAt(i, j);
				if(o instanceof Boolean){
					if((Boolean)o){
						writer.write("1");
					}else{
						writer.write("0");
					}
				}else{
					writer.write(model.getValueAt(i, j).toString());
				}
				writer.write(",");
			}

			writer.write(",,,,,,\n");
		}
	}
	
	public void FengshuiShui(){
		allBuildingsColumnValue(14,new Integer(4));
	}
	
	void allBuildingsColumnValue(int columnIndex,Integer value){
		modelsCloumnValue(tbl_allBuildings.getModel(),columnIndex,value);
		
	}
	void modelsCloumnValue(TableModel model,int columnIndex,Integer value){
		int rowCount = model.getRowCount();
		for(int i = 0;i < rowCount;i ++){
			model.setValueAt(value, i, columnIndex);
		}		
	}
}
