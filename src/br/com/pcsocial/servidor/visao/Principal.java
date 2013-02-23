package br.com.pcsocial.servidor.visao;

public class Principal {
	
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	ServidorUI msu = new ServidorUI();
                msu.createAndShowGUI();
            }
        });

    }

}
