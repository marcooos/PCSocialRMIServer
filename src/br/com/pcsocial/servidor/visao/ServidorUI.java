package br.com.pcsocial.servidor.visao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import br.com.pcsocial.servidor.servicoServer.ServicoServer;

public class ServidorUI {
	private JLabel label1 = new JLabel("Servidor de Aplicação");
	private JTextArea mensagemConexao = new JTextArea();
	private JButton btnIniciar = new JButton("Iniciar Servidor"),
			btnParar = new JButton("Parar Servidor"), btnSair = new JButton(
					"Fechar Servidor");
	private JFrame frame = new JFrame("Servidor de aplicação");
	private JPanel painelSuperior = new JPanel(),
			painelInferior = new JPanel();
	private BorderLayout layout = new BorderLayout();
	private FlowLayout layoutSuperior = new FlowLayout(),
			layoutInferior = new FlowLayout();

	public ServidorUI() {
	}

	void createAndShowGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(new Dimension(800, 600));
		frame.setLayout(layout);
		frame.setLocationRelativeTo(null);

		painelSuperior.setLayout(layoutSuperior);
		painelInferior.setLayout(layoutInferior);

		// Painel superior FlowLayout
		painelSuperior.add(label1);
		painelSuperior.add(btnIniciar);
		painelSuperior.add(btnParar);
		
		// Painel inferior FlowLayout
		painelInferior.setAlignmentY(JFrame.RIGHT_ALIGNMENT);
		painelInferior.add(btnSair);
		
		

		frame.add(painelSuperior, BorderLayout.NORTH);
		frame.add(mensagemConexao, BorderLayout.CENTER);
		frame.add(painelInferior, BorderLayout.SOUTH);
		frame.setVisible(true);

		// Eventos bot�es
		btnIniciar.addActionListener(al);
		btnParar.addActionListener(al);
		btnSair.addActionListener(al);

	}

	ActionListener al = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			ServicoServer ms = new ServicoServer();
			if (e.getSource().equals(btnIniciar)) {
				ms.startAplicationServer();
				mensagemConexao.setText(ms.getMensagemRetorno());
			}
			if (e.getSource().equals(btnParar)) {
				ms.stopAplicationServer();
				mensagemConexao.setText(ms.getMensagemRetorno());
			}
			if (e.getSource().equals(btnSair)) {
				if (javax.swing.JOptionPane.showConfirmDialog(null,
						"Atenção o servidor será desligado", "Confirme sua operação ",
						javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
					ms.stopAplicationServer();
					System.exit(0);
				}
			}
		}
	};
}
