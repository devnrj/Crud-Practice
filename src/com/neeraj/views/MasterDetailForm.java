package com.neeraj.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.neeraj.item.Item;
import com.neeraj.item.ItemOperations;

public class MasterDetailForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6570335348968136738L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField idField;
	private JTextField qtyField;
	private JTable table;
	
	
	JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MasterDetailForm frame = new MasterDetailForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MasterDetailForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBounds(207, 101, 130, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(104, 106, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(104, 145, 61, 16);
		contentPane.add(lblPrice);
		
		priceField = new JTextField();
		priceField.setBounds(207, 140, 130, 26);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		idField = new JTextField();
		idField.setColumns(10);
		idField.setBounds(207, 63, 130, 26);
		contentPane.add(idField);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(104, 68, 61, 16);
		contentPane.add(lblId);
		
		JLabel lblMasterDetailForm = new JLabel("Master Detail Form");
		lblMasterDetailForm.setBounds(164, 24, 124, 16);
		contentPane.add(lblMasterDetailForm);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(104, 181, 61, 16);
		contentPane.add(lblQuantity);
		
		qtyField = new JTextField();
		qtyField.setColumns(10);
		qtyField.setBounds(207, 176, 130, 26);
		contentPane.add(qtyField);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewItem();
			}
		});
		btnAdd.setBounds(56, 233, 117, 29);
		contentPane.add(btnAdd);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		btnPrint.setBounds(210, 233, 117, 29);
		contentPane.add(btnPrint);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(362, 233, 117, 29);
		contentPane.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(513, 233, 117, 29);
		contentPane.add(btnReset);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 293, 616, 212);
		contentPane.add(scrollPane);
	
		
		table = new JTable(new MyModel());
		scrollPane.setViewportView(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(362, 176, 117, 29);
		contentPane.add(btnSearch);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove();
			}
		});
		btnRemove.setBounds(513, 176, 117, 29);
		contentPane.add(btnRemove);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort();
			}
		});
		btnSort.setBounds(362, 140, 117, 29);
		contentPane.add(btnSort);
		
	}
	public void addNewItem() {
		ItemOperations ar = ItemOperations.getInstance();
		int id= Integer.parseInt(idField.getText());
		String name = nameField.getText();
		Double price = Double.parseDouble(priceField.getText());
		int qty = Integer.parseInt(qtyField.getText());
		Item i = new Item(id,name,price,qty);
		String result = ar.addItem(i);
		JOptionPane.showMessageDialog(this, result);
		table.setModel(new MyModel());
	}
	public void reset() {
		idField.setText("");
		priceField.setText("");
		nameField.setText("");
		qtyField.setText("");
	}
	public void showList() {
	}
	public void search() {
		String result = ItemOperations.getInstance().searchItem(Integer.parseInt(idField.getText()), nameField.getText()) >= 0 ? "Item Found":"Item Not Found";
		JOptionPane.showMessageDialog(this, result);
		
		
	}
	public void remove() {
		String result = ItemOperations.getInstance().deleteItem(Integer.parseInt(idField.getText()), nameField.getText());
		JOptionPane.showMessageDialog(this, result);
		table.setModel(new MyModel());
	}
	public void sort() {
		ItemOperations.getInstance().sortItem();
		table.setModel(new MyModel());
	}
}

