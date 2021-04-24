import java.io.*;

/**
 *
 * @author Jesús Montalvo
 */
public class Main {

   static String nombre = "";
   static int edad = 0;
   static char sexo = 'H';
   static double peso = 0;
   static double altura = 0;

   public static void main(String[] args) {
      formulario();
      Persona persona = new Persona();
      persona.setNombre(nombre);
      persona.setEdad(edad);
      persona.generaNSS();
      persona.setSexo(sexo);
      persona.setPeso(peso);
      persona.setAltura(altura);

      comprobarIMC(persona);
      comprobarEdad(persona);
      System.out.println(persona.toString());

   }

   public static void formulario() {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      // Formulario
      try {
         System.out.println("Ingrese su nombre: ");
         nombre = br.readLine().toUpperCase();
         System.out.println("Ingrese su edad: ");
         edad = Integer.parseInt(br.readLine());
         System.out.println("Ingrese su sexo (H o M): ");
         sexo = br.readLine().toUpperCase().charAt(0);
         System.out.println("Ingrese su peso (en kg): ");
         peso = Double.parseDouble(br.readLine());
         System.out.println("Ingrese su altura (en metros): ");
         altura = Double.parseDouble(br.readLine());
      } catch (IOException e) {
         System.err.println(e);
      }
   }

   public static void comprobarIMC(Persona p) {
      int imc = p.calcularIMC();
      if (imc < 0) {
         System.out.println("Usted está bajo de peso, debería cuidar su salud!");
      } else if (imc == 0) {
         System.out.println("Usted está en su peso ideal, excelente!");
      } else {
         System.out.println("Usted tiene sobrepeso, debería cuidar su salud!");
      }
   }

   public static void comprobarEdad(Persona p) {
      if (p.esMayorDeEdad()) {
         System.out.println("Usted es MAYOR de edad");
      } else {
         System.out.println("Usted es MENOR de edad");
      }
   }
}
