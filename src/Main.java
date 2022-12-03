public class Main {
    //Avisen si hay o no que usar la letra 'ñ'
    public static String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static int numeroDeCaracteres = alfabeto.length();
    public static void main(String[] args) {
        Est a = new Est();
        //Ejemplo propuesto
        String mensaje = "act";
        String matrizDeEncriptacion = "GYBNQKURP";

        //Encriptar con una matriz dada
        String mensajeEncriptadoXD = encriptarPorElCifradoHillConUnaMatrizDada(matrizDeEncriptacion, mensaje);

        //No dieron como deberia quedar 
        System.out.println(mensajeEncriptadoXD);
    }

    private static String encriptarPorElCifradoHillConUnaMatrizDada(String matrizDeEncriptacion, String mensaje) {
        //Para no usar la ñ pongo tamanio xd
        int tamanioDelMensaje = mensaje.length();
        
        int [] matrizDelMensaje = new int[tamanioDelMensaje];
        
        int [][] matrizDeEncripcion = new int[tamanioDelMensaje][tamanioDelMensaje];

        int [] matrizDelMensajeEncriptadoXD = new int[tamanioDelMensaje];

        //Para que no haya problemas con minusculas o mayusculas
        mensaje = mensaje.toUpperCase();

        for (int i =0; i<tamanioDelMensaje;i++){
            for (int j =0; j<tamanioDelMensaje;j++){
                //Lleno la matriz, la forma que lo hago es media xd, la plena que me da pereza esto ya
                matrizDeEncripcion[i][j] = alfabeto.indexOf(matrizDeEncriptacion.charAt((i*tamanioDelMensaje)+j));
            }
        }

        for (int i =0; i<tamanioDelMensaje;i++){
            //Lleno la matriz
            matrizDelMensaje[i] = alfabeto.indexOf(mensaje.charAt(i));
        }

        for (int i =0; i<mensaje.length();i++){
            for (int j =0; j<mensaje.length();j++){
                //Multiplicacion de matrices
                matrizDelMensajeEncriptadoXD[i] += matrizDeEncripcion[i][j] * matrizDelMensaje[j];
            }
        }

        for (int j =0; j<mensaje.length();j++){
            //Hago lo del modulo
            matrizDelMensajeEncriptadoXD[j] = matrizDelMensajeEncriptadoXD[j]%numeroDeCaracteres;
        }

        String mensajeEncriptado = "";

        for (int i =0; i<tamanioDelMensaje; i++){
            mensajeEncriptado += alfabeto.charAt(matrizDelMensajeEncriptadoXD[i]);
        }

        return mensajeEncriptado;
    }
}