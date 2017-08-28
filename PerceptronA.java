/*
 */
package Controller;

/**
 *
 * @author camaldonado
 */
public class PerceptronA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int entrenamiento [][] = {
                                {0,0,0,0},
                                {0,0,1,0},
                                {0,1,0,0},
                                {0,1,1,0},
                                {1,0,0,0},
                                {1,0,1,0},
                                {1,1,0,0},
                                {1,1,1,1},
        };
        /*int entrenamiento [][] = {
                                {1,0,0,1},
                                {1,0,1,1},
                                {1,1,0,1},
                                {1,1,1,0},
        };*/
        /*int entrenamiento [][] = {
                                {0,0,0},
                                {0,1,0},
                                {1,0,0},
                                {1,1,1},
        };*/
        
        String operador = "AND";
        double tasaAprendiz = 0.1;
        double umbral = 0.5;
        int nroEntrada = entrenamiento[0].length - 1;
        int nroArgumento = entrenamiento.length;
        int verificador[] = new int[nroArgumento];
        double pesos[]= new double[nroEntrada];
        
        double totalAcum;
        System.out.println("Operación: " + operador);
        System.out.println("Nro de Entradas: " + Integer.toString(nroEntrada));
        System.out.println("Nro de Argumento: " + Integer.toString(nroArgumento));
        System.out.println("Nro de Salidas: " + Integer.toString(pesos.length));
        int countIn, countArg;
        while (!(verificaEstado(entrenamiento, pesos, umbral ))) {
            countArg=0;
            for (int i[]: entrenamiento) {
                int iSalida = i[i.length-1];
                int iEntrada[] = new int[i.length-1];
                System.arraycopy(i, 0, iEntrada, 0, iEntrada.length);
                System.out.println("Nuevo Argumentos");
                countIn=0;
                totalAcum=0;
                for (int j : iEntrada) {
                    
                    totalAcum+= pesos[countIn] * ((double) j);
                    countIn++;
                    
                }
                if(totalAcum>umbral){verificador[countArg] = 1; }
                else { verificador[countArg] = 0; }
                //Actualizacion de Pesos
                countIn=0;
                for (int j : iEntrada) {
                    pesos[countIn]+= tasaAprendiz* ((double) (iSalida - verificador[countArg])* j);
                    System.out.println("Peso " + Integer.toString(countIn) + ": " + Double.toString(pesos[countIn])); 
                    countIn++;
                } 
                
                countArg++;
            }
            
        }
        
        
        
        
    }

    private static boolean verificaEstado(int[][] entrenamiento, double[] pesos, double umbral) {
        
        double totalAcum;
        for(int i = 0; i<entrenamiento.length; i++){
            totalAcum=0;
            for (int j = 0; j < entrenamiento[i].length-1; j++) {
                totalAcum += pesos[j] * entrenamiento[i][j];
            }
            //System.out.println("Nro de Prueba: " + Integer.toString(entrenamiento[i][entrenamiento[i].length-1]));
            if (entrenamiento[i][entrenamiento[i].length-1]!= (totalAcum>umbral? 1:0)) {
                return false;
            }
            
            
        }
        
        return true;
    }
    
}
