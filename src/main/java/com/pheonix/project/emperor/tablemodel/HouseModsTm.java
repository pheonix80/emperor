package com.pheonix.project.emperor.tablemodel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class HouseModsTm extends DefaultTableModel implements TableModel {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */
	private static final long serialVersionUID = 6877444330828157059L;
	private static String[] columnNames = new String[]{
		"难度",
		"衰落阀值",
		"升级阀值",
		"草药医生",
		"水",
		"针灸",
		"音乐",
		"杂技",
		"戏剧",
		"食物品质",
		"亚麻",
		"瓷器",
		"茶叶",
		"丝绸",
		"生活器皿",
		"动乱增长率",
		"动乱基础值",
		"未使用",
		"人口容量",
		"税率基数",
		"未使用",
		"疾病增长率",
		"先祖",
		"孔庙",
		"道士或和尚"
	};
	
	private static Object[][] data = new Object[][]{
		{"Very Easy Modifiers",-5,-5,0,0,0,0,0,0,0,0,0,0,0,0,-5,0,0,0,0,0,-5,0,0,0},
		{"Easy Modifiers",-2,-2,0,0,0,0,0,0,0,0,0,0,0,0,-2,0,0,0,0,0,-2,0,0,0},
		{"Normal Modifier",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
		{"Hard Modifiers",3,3,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,3,0,0,0},
		{"Very Hard Modifiers",8,8,0,0,0,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,8,0,0,0}
	};
	public HouseModsTm(){
		super(data,columnNames);
	}
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex > 0;
	}

	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex){
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 22:
			case 23:
			case 24:
				return new Boolean(false).getClass();
			default:
				return super.getColumnClass(columnIndex);				
		}
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 22:
			case 23:
			case 24:
				if(data[rowIndex][columnIndex].equals(0)){
					return new Boolean(false);
				}
				return new Boolean(true);
			default:
				return data[rowIndex][columnIndex];  				
		}
	}
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {  
		switch(columnIndex){
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 10:
			case 11:
			case 12:
			case 13:
			case 14:
			case 22:
			case 23:
			case 24:
				if((Boolean)aValue){
					data[rowIndex][columnIndex] = new Integer(1);
				}
				else{
					data[rowIndex][columnIndex] = new Integer(0);
				}
				break;
			default:
				data[rowIndex][columnIndex] = aValue;  				
		}
		fireTableCellUpdated(rowIndex, columnIndex);  
	}
}
