package com.pheonix.project.emperor.tablemodel;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class AllHousesTm extends DefaultTableModel implements TableModel {

	/** 
	 * @Fields serialVersionUID : TODO 
	 */
	private static final long serialVersionUID = 7616456665758093241L;

	private static String[] columnNames = new String[]{
		"住宅等级",
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
		{"1: Shelter",-99,-10,0,0,0,0,0,0,0,0,0,0,0,0,          17,10,0,7,0,0,20,0,0,0},
		{"2: Hut",-14,-2,0,1,0,0,0,0,0,0,0,0,0,0,               16,5,0,14,0,0,15,0,0,0},
		{"3: Plain Cottage",-6,6,0,1,0,0,0,0,20,0,0,0,0,0,      15,5,0,22,1,0,15,1,0,0},
		{"4: Attractive Cottage",2,14,0,1,0,0,0,0,30,1,0,0,0,0, 14,0,0,31,1,0,10,1,0,0},
		{"5: Spacious Dwelling",10,22,1,1,0,1,0,0,30,1,0,0,0,0, 13,0,0,41,1,0,10,1,0,0},
		{"6: Elegant Dwelling",18,30,1,1,0,1,0,0,50,1,1,0,0,0,  12,0,0,52,1,0,5,1,0,0},
		{"7: Ornate Apartment",25,40,1,1,1,1,1,0,50,1,1,0,0,0,  11,0,0,63,1,0,5,1,0,0},
		{"8: Lux. Apartment",35,100,1,1,1,1,1,0,50,1,1,1,0,0,   10,0,0,74,2,0,5,1,0,1},
		{"Elite: Unoccupied",-99,40,0,0,0,0,0,0,0,0,0,0,0,0,-20,0,0,0,0,0,-100,0,0,0},
		{"Elite 0: Abandoned",-99,40,0,0,0,0,0,0,0,0,0,0,0,0,-20,0,0,1,0,0,-100,0,0,0},
		{"Elite 1: Modest Siheyuan",35,50,0,0,0,0,0,0,0,1,1,0,0,0,-20,0,0,5,10,0,0,0,0,0},
		{"Elite 2: Lavish Siheyuan",45,60,1,0,0,1,1,0,50,1,1,0,1,0,-20,0,0,10,18,0,0,1,0,0},
		{"Elite 3: Humble Compound",55,70,1,0,1,1,1,0,70,1,1,0,1,1,-20,0,0,15,20,0,0,1,0,0},
		{"Elite 4: Impressive Compound",65,80,1,0,1,1,1,0,70,1,1,0,1,1,-20,0,0,20,22,0,0,1,1,1},
		{"Elite 5: Heavenly Compound",75,100,1,0,1,1,1,1,70,1,1,1,1,1,-20,0,0,25,24,0,0,1,1,1}
	};
	public AllHousesTm(){
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
