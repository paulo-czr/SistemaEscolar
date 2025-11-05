package sistemaescolar;

import view.TelaInicial;

/**
 * Ponto de entrada do sistema escolar.
 * 
 * @author Paulo
 * @version 1.0
 */
public class Main {

    /**
     * Método principal que inicia o sistema.
     * 
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        
        TelaInicial menu = new TelaInicial();
        menu.setVisible(true);
    }
}
