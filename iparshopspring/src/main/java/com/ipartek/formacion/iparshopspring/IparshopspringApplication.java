package com.ipartek.formacion.iparshopspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IparshopspringApplication { //implements CommandLineRunner {
//	@Autowired
//	private IparShopSwing frame;

	public static void main(String[] args) {
		// System.setProperty("java.awt.headless", "false");
		
		SpringApplication.run(IparshopspringApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

}
