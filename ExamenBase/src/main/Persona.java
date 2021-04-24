import java.util.Random;

/**
 *
 * @author Jesús Montalvo
 */
public class Persona {

   private String nombre = "";
   private int edad = 0;
   private String nss = "";
   private char sexo = 'H';
   private double peso = 0;
   private double altura = 0;

   private static final double FALTA_PESO_HOMBRE = 20;
   private static final double FALTA_PESO_MUJER = 19;
   private static final double PESO_NORMAL_HOMBRE = 25;
   private static final double PESO_NORMAL_MUJER = 24;

   Persona() {

   }

   Persona(String nombre, int edad, String nss, char sexo, double peso, double altura) {
      this.nombre = nombre;
      this.edad = edad;
      this.nss = nss;
      this.sexo = sexo;
      this.peso = peso;
      this.altura = altura;
   }

   public int calcularIMC() {
      double peso_ideal = Math.round(peso / (Math.pow(altura, 2)));
      if (sexo == 'H') {
         if (peso_ideal < FALTA_PESO_HOMBRE) {
            return -1;
         } else if (peso_ideal > FALTA_PESO_HOMBRE && peso_ideal <= PESO_NORMAL_HOMBRE) {
            return 0;
         } else {
            return 1;
         }
      } else {
         if (peso_ideal < FALTA_PESO_MUJER) {
            return -1;
         } else if (peso_ideal > FALTA_PESO_MUJER && peso_ideal <= PESO_NORMAL_MUJER) {
            return 0;
         } else {
            return 1;
         }
      }
   }

   public boolean esMayorDeEdad() {
      return edad >= 18;
   }

   public boolean comprobarSexo(char sexo) {
      return sexo == 'H' || sexo == 'M';
   }

   @Override
   public String toString() {
      return "nombre: " + nombre + ", edad: " + edad + ", nss: " + nss + ", sexo: " + sexo + ", peso: " + peso
            + ", altura: " + altura;
   }

   public void generaNSS() {
      String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
      StringBuilder sb = new StringBuilder();
      Random random = new Random();
      int tamano = 8;
      for (int i = 0; i < tamano; i++) {
         int index = random.nextInt(caracteres.length());
         char randomChar = caracteres.charAt(index);
         sb.append(randomChar);
      }
      String nss = sb.toString();
      this.nss = nss;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setEdad(int edad) {
      this.edad = edad;
   }

   public void setSexo(char sexo) {
      this.sexo = sexo;
   }

   public void setPeso(double peso) {
      this.peso = peso;
   }

   public void setAltura(double altura) {
      this.altura = altura;
   }

}
