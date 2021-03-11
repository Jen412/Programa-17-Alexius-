import java.util.Scanner;

public class programa17 {
    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        String auxNumAlf, auxNumEs, arrayEs[];
        int numAlf = 0, numEs = 0;
        char arrayAlf[];
        boolean ban = true;
        // ingresar el numero de letras
        do {
            System.out.print("\nIngrese el numero de letras que contiene el alfabeto: ");
            auxNumAlf = leer.nextLine();
            // debe ser un numero y no acepta el enter o null
            if (auxNumAlf.matches("[0-9]*") == true && auxNumAlf.length() != 0) {
                numAlf = Integer.parseInt(auxNumAlf);
                // debe ser mayor de 0
                if (numAlf > 0) {
                    // inicializo el arreglo con el numero de letras
                    arrayAlf = new char[numAlf];
                    break;
                } else {
                    System.out.println("Debe ingresar un valor numerico mayor de 0");
                    ban = false;
                }
            } else {
                System.out.println("Debe ingresar un valor numerico mayor de 0");
                ban = false;
            }

        } while (ban = true);
        // manda a llamar al metodo para ingresar el alfabeto
        arrayAlf = alfabeto(numAlf);
        // para volver a usarla
        ban = true;

        // ingresar el numero de estados
        do {
            System.out.print("\nIngrese el numero de estados: ");
            auxNumEs = leer.nextLine();
            // debe ser un numero y no acepta el enter o null
            if (auxNumEs.matches("[0-9]*") == true && auxNumEs.length() != 0) {
                numEs = Integer.parseInt(auxNumEs);
                // debe ser mayor de 0
                if (numEs > 0) {
                    // inicializo el arreglo con el numero de estados
                    arrayEs = new String[numEs];
                    break;
                } else {
                    System.out.println("Debe ingresar un valor numerico mayor de 0");
                    ban = false;
                }
            } else {
                System.out.println("Debe ingresar un valor numerico mayor de 0");
                ban = false;
            }

        } while (ban = true);
        // manda a llamar al metodo para ingresar el arreglo
        arrayEs = estados(numEs);
        // por si se vuelve a ocupar la bandera
        ban = true;
    }

    // Metodos
    // ingresar el alfabeto
    public static char[] alfabeto(int numAlf) {
        Scanner leer = new Scanner(System.in);
        String auxCar;
        char arrayAlf[] = new char[numAlf];
        boolean ban = true;
        int cont = 0;
        System.out.println("\nINGRESE LAS LETRAS DEL ALFABETO");
        for (int x = 0; x < numAlf; x++) {
            do {
                System.out.print("Ingrese la letra " + (x + 1) + " del alfabeto: ");
                auxCar = leer.nextLine();
                if (auxCar.matches("[a-z]*") == true && auxCar.length() != 0) {
                    if (auxCar.length() == 1) {
                        for (int i = 0; i < numAlf; i++) {
                            if (arrayAlf[i] == auxCar.charAt(0)) {
                                cont++;
                            }
                        }
                        if (cont == 0) {
                            ban = true;
                            arrayAlf[x] = auxCar.charAt(0);
                            break;
                        } else {
                            cont = 0;
                            System.out.println("Caracter repetido");
                            ban = false;
                        }
                    } else {
                        System.out.println("Solo debe ingresar un caracter");
                        ban = false;
                    }
                } else {
                    System.out.println("Debe ingresar un caracter de la a-z minuscula");
                    ban = false;
                }
            } while (ban = true);
        }
        return arrayAlf;
    }

    // ingresar los estados
    public static String[] estados(int numEs) {
        Scanner leer = new Scanner(System.in);
        String estado;
        String arrayEs[] = new String[numEs];
        boolean ban = true;
        int cont = 0;
        // esto es para que no esten en null y poder usar el equals
        for (int i = 0; i < numEs; i++) {
            arrayEs[i] = " ";
        }
        System.out.println("\nINGRESE LOS ESTADOS");
        System.out.println("El estado debe empezar con q seguido de numeros\n");
        for (int x = 0; x < numEs; x++) {
            do {
                System.out.print("Ingrese el estado " + (x + 1) + ": ");
                estado = leer.nextLine();
                // no puedes ingresar un vacio osea el enter
                if (estado.length() != 0) {
                    // valido que empiece con q y siga numeros
                    if (estado.charAt(0) == 'q' && estado.substring(1).matches("[0-9]*")) {
                        // itero entre el arreglo para ver si ya esta registrado
                        for (int i = 0; i < numEs; i++) {
                            if (arrayEs[i].equals(estado)) {
                                cont++;
                            }
                        }
                        // si el contador es diferente de 0 pues hay alguno igul
                        if (cont == 0) {
                            ban = true;
                            arrayEs[x] = estado;
                            break;
                        } else {
                            cont = 0;
                            System.out.println("Estado repetido");
                            ban = false;
                        }
                    } else {
                        System.out.println("El estado debe empezar con q seguido de numeros");
                        ban = false;
                    }
                } else {
                    System.out.println("El estado debe empezar con q seguido de numeros");
                    ban = false;
                }
            } while (ban = true);
        }
        return arrayEs;
    }
}