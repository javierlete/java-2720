package com.ipartek.formacion.iparshopspring.presentacion.swing;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.iparshopspring.entidades.Producto;
import com.ipartek.formacion.iparshopspring.servicios.AdminService;

// @Component
public class IparShopSwing extends JFrame {

	@Autowired
	private AdminService adminService;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JLabel lblPrecio;
	private JTextField tfPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IparShopSwing frame = new IparShopSwing();
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
	public IparShopSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{46, 104, 0};
		gbl_contentPane.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 0;
		contentPane.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 0;
		contentPane.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 1;
		contentPane.add(lblPrecio, gbc_lblPrecio);
		
		tfPrecio = new JTextField();
		GridBagConstraints gbc_tfPrecio = new GridBagConstraints();
		gbc_tfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecio.gridx = 1;
		gbc_tfPrecio.gridy = 1;
		contentPane.add(tfPrecio, gbc_tfPrecio);
		tfPrecio.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(tfNombre.getText());
				System.out.println(tfPrecio.getText());
				
				var producto = Producto.builder().nombre(tfNombre.getText()).precio(new BigDecimal(tfPrecio.getText())).build();
				
				adminService.guardarProducto(producto);
			}
		});
		
		btnGuardar.addActionListener(e -> System.out.println("LAMBDA"));
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 2;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
