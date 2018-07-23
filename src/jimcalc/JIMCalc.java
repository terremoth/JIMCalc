/*
    Author: Lucas Marques Dutra (c) 2018
    
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

package jimcalc;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * @author Lucas Marques Dutra <dutr4@outlook.com>
 */
public class JIMCalc 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {}

        String weightStr = JOptionPane.showInputDialog("Digite seu peso em KG:", "60.00");
        String heightStr = JOptionPane.showInputDialog("Digite sua altura em Metros:", "1.50");
        
        if (!isNumeric(weightStr) || !isNumeric(heightStr)) {
            JOptionPane.showMessageDialog(null, "Você deve entrar apenas com números"); 
            main(args);
            System.exit(0);
        }
        
        float weight = Float.parseFloat(weightStr);
        float height = Float.parseFloat(heightStr);
        
        float calc = weight / (height * height);
        
        DecimalFormat format = new DecimalFormat("#.00"); 
        String formated = format.format(calc);
        
        String result = "";
        
        if (calc  <= 18.5) {
            result = "Abaixo do Peso";
        }
        
        if (calc > 18.5 && calc <= 24.9) {
            result = "Peso Normal";
        }
        
        if (calc >= 25  && calc <= 29.9) {
            result = "Acima do Peso";
        }
        
        if (calc >= 30) {
            result = "Acima do Peso";
        }
        
        JOptionPane.showMessageDialog(null, 
                  "Seu IMC é: "+formated+"\n"
                + "-------------------------------------------\n"
                + "De acordo com os valores do BMI:\n"
                + "Abaixo do Peso: menor ou igual a 18.5\n"
                + "Normal:               entre 18.5 a 24.9\n"
                + "Acima do Peso:  entre 25 a 29.9\n"
                + "Obeso:                 30 ou maior\n"
                + "-------------------------------------------\n"
                + "Resultado final: "+result
        );

    }
    
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?"); 
    }
}   
