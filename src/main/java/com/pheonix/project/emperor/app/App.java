package com.pheonix.project.emperor.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

import com.pheonix.project.emperor.swing.BuildingModelEditor;

import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App {

	private JFrame frame;
	private BuildingModelEditor panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("菜单");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("保存");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panel != null){
					panel.saveFile();
				}
			}
		});
		menu.add(menuItem);
		
		JMenu mnAllBuildings = new JMenu("ALL BUILDINGS");
		menuBar.add(mnAllBuildings);
		
		JMenuItem menuItem_1 = new JMenuItem("没有火灾风险");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.noFireRisk();
			}
		});
		mnAllBuildings.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("没有倒塌风险");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.noDamageRisk();
			}
		});
		mnAllBuildings.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("风水-水");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.FengshuiShui();
			}
		});
		mnAllBuildings.add(mntmNewMenuItem);
		panel = new BuildingModelEditor();
		JScrollPane scrollPane = new JScrollPane(panel);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setSize(800,600);
	}

}
