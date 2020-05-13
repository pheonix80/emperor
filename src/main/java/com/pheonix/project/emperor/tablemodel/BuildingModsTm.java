package com.pheonix.project.emperor.tablemodel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class BuildingModsTm extends DefaultTableModel implements TableModel {
	/** 
	 * @Fields serialVersionUID : TODO 
	 */
	private static final long serialVersionUID = 655825346872643147L;
	private static String[] columnNames = new String[]{
			"",
			"难度",
			"建造价格",
			"吸引力",
			"吸引力单位大小",
			"吸引力变化大小",
			"吸引力影响范围",
			"雇佣的工人数",
			"火灾风险度",
			"倒塌风险度",
			"资源使用量",
			"风险减少量",
			"升级需求的吸引力",
			"建筑物的生命值",
			"风水"
	};
	
	private static Object[][] data = new Object[][]{
		{"0","Very Easy Modifiers",50,100,100,100,100,100,50,50,100,100,100,100,100},
		{"1","Easy Modifiers",80,100,100,100,100,100,80,80,100,100,100,100,100},
		{"2","Normal Modifier",100,100,100,100,100,100,100,100,100,100,100,100,100},
		{"3","Hard Modifiers",120,100,100,100,100,100,120,120,100,100,100,100,100},
		{"4","Very Hard Modifiers",150,100,100,100,100,100,150,150,100,100,100,100,100}
	};
	public BuildingModsTm(){
		super(data,columnNames);
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex > 1;
	}
}
