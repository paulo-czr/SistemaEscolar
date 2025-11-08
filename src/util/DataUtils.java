/**
 * Classe destinada para conversão de datas digitadas em String para SQL
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class DataUtils {

    /**
     * Converte a data digitada pelo usuário (dataBR) para uma data aceita pelo
     * SQL
     *
     * @param dataBR será convertido em dataSQL
     */
    public static String converterDataParaMySQL(String dataBR) {
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

            Date data = formatoEntrada.parse(dataBR);
            return formatoSaida.format(data);

        } catch (Exception e) {
            System.out.println("Erro ao converter data: " + e.getMessage());
            return null;
        }
    }

    /**
     * Valida uma data no formato BR (dd/MM/yyyy) e retorna um objeto Date.
     * Retorna null se a data for inválida.
     *
     * @param dataBR data no formato dd/MM/yyyy
     * @return objeto Date se válido, null caso contrário
     */
    public static Date validarData(String dataBR) {
        if (dataBR == null || dataBR.isBlank() || !dataBR.matches("[0-9/]+")) {
            JOptionPane.showMessageDialog(null, "Data inválida! Correto: dd/MM/aaaa",
                    "Erro", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false); // garante que datas reais sejam validadas

        try {
            return formato.parse(dataBR); // retorna o objeto Date
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida! Correto: dd/MM/aaaa",
                    "Erro", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
}
