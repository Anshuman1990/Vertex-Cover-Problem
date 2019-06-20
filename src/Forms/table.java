package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class table extends JFrame {

	private JPanel contentPane;
	public JScrollPane scrollPane;
	public static DefaultTableModel dtab = null;
	public JTable tab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table frame = new table();
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
	public table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 591, 353);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Output");
		lblNewLabel.setBounds(203, 11, 156, 21);
		panel.add(lblNewLabel);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 68, 510, 274);
		
		tab = new JTable();
		scrollPane.setViewportView(tab);
		dtab = new DefaultTableModel();
		tab.setModel(dtab);
		dtab.addColumn("Algorithm Name");
		dtab.addColumn("Result");
		panel.add(scrollPane);
	}
}
