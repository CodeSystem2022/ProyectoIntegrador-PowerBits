
package domain;
//Importamos la animaciones y clase scanner 
import static domain.animaciones.bienvenidos;
import static domain.animaciones.cartonLleno;
import static domain.animaciones.desarrolladores;
import static domain.animaciones.esperar;
import static domain.animaciones.teclaSeguir;
import java.util.Scanner;

public class main {
    //Atributos
    private int variante1;         
    private int variante2;
    private int cont = 0;
    private int nros[] = new int[100];    //Array para numeros sorteados

    
    public static void main(String[] args) {
       bienvenidos();
       animaciones.teclaSeguir();
       main me = new main();       //Se llama a la  función menu de esta forma porque tienen diferente modificador de acceso
       me.menu(); 
    }
    
    public void menu(){  
        Scanner entrada = new Scanner(System.in);
        //Variable que guardara la opcion de meu elegida por el usuario 
        int opcion;
        // Se declaran las variables para los nombre de los jugadores
        String nombre1 = " ";    
        String nombre2 = " ";
        
        //Se utiliza un do while para el menu de opciones 
        do{
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("                                                      - - - M E N U   D E   O P C I O N E S - - -");
            System.out.println("");
            System.out.println("                                        1- Jugar Loteria");
            System.out.println("                                        2- Jugar Quini6");
            System.out.println("                                        3- Desarrolladores");
            System.out.println("                                        4- Salir");
            System.out.println("");
            System.out.print("                                        - Ingrese una opcion: ");
        opcion = Integer.parseInt(entrada.nextLine());
        }while(opcion > 4 || opcion < 1);

        
        System.out.println("");
        System.out.println("");
          
        //Switch que mostara la opcion elegia por el usuario 
        switch(opcion){
            case 1:
                menuJugadores(nombre1, nombre2);
            case 2: 
                jugarQuini6();
            case 3: 
                desarrolladores();
                esperar(1);
                teclaSeguir();
                esperar(1);
                menu();
            case 4:
                animaciones.hastaPronto();
                break;
        }
    }
    
    public void menuJugadores(String nombre1, String nombre2){
        
        Scanner entrada = new Scanner(System.in); 
        
        int eleccion;
        System.out.println("                              ------------------------------------------------------------------------------------");
        System.out.println("                                                                    L O T E R I A");
        System.out.println("");
        System.out.println("                                        1- Ingrese el nombre de los jugadores");
        System.out.println("                                        2- Seleccion de los cartones");
        System.out.println("                                        3- Jugar");
        System.out.println("                                        4- Volver al menu principal");
        System.out.println("");
        System.out.print("                                        -Ingrese una opcion: ");
        eleccion = Integer.parseInt(entrada.nextLine());
        
        
        System.out.println("");
        
        switch(eleccion){   //Mediante un switch se muestra la distintas opciones del menu 
        
            case 1:
                System.out.println("                                                      ------------------------------------------");
                System.out.print("                                                      Ingrese el nombre del JUGADOR 1: ");
                nombre1 = entrada.nextLine();
                System.out.println("                                                      ------------------------------------------");
                System.out.println("");
                System.out.println("                                                      ------------------------------------------");
                System.out.print("                                                      Ingrese el nombre del JUGADOR 2: ");
                nombre2 = entrada.nextLine();
                System.out.println("                                                      ------------------------------------------");
                System.out.println("");
                System.out.println("");
                animaciones.teclaSeguir();
                System.out.println("");
                menuJugadores(nombre1, nombre2);   // Regreso al menu de jugadores con los nombres ya guardados
                animaciones.teclaSeguir();
            case 2:
                seleccionCartones(nombre1, nombre2);  //Selecion de los cartones 
                menuJugadores(nombre1, nombre2);      // Regreso al menu de jugadores con los cartones seleccionados          
            case 3:
                sortear(nombre1, nombre2);   // Llamamos al método sortear para jugar
                teclaSeguir();
                menu();
            case 4:
                menu();   //regreso al menu principal
        }    
    }
    
    public void seleccionCartones(String nombre1, String nombre2) {
        Scanner entrada = new Scanner(System.in);

        int cartonElegido = 0;
        System.out.println("                              ------------------------------------------------------------------------------------");
        carton_1();
        carton_2();
        carton_3();
        carton_4();
        System.out.println("");
        System.out.println("");
        System.out.print("                                       - " + nombre1 + " seleccione el numero de carton que desee: ");
        variante1 = Integer.parseInt(entrada.nextLine());
        System.out.println("");
        System.out.println("");
        this.variante1 = variante1;
        System.out.println("                              ------------------------------------------------------------------------------------");

        if (variante1 < 5 && variante1 > 0) { //Utilizamos un if para que el usuario ingrese un valor dentro del rango requerido
            switch (variante1) { //Mediante un switch mostramos las distintas opciones para cada valor 
                case 1:
                    System.out.println("                                        " + nombre1 + " selecciono:");
                    carton_1();
                    cartonElegido = 1;
                    break;
                case 2:
                    System.out.println("                                        " + nombre1 + " selecciono:");
                    carton_2();
                    cartonElegido = 2;
                    break;
                case 3:
                    System.out.println("                                        " + nombre1 + " selecciono:");
                    carton_3();
                    cartonElegido = 3;
                    break;
                case 4:
                    System.out.println("                                        " + nombre1 + " selecciono:");
                    carton_4();
                    cartonElegido = 4;
                    break;
            }
        } else {
            System.out.println("                                        Digito una opcion incorrecta de carton, ingrese otra por favor...");
            seleccionCartones(nombre1, nombre2);
        }
        System.out.println("                              ------------------------------------------------------------------------------------");
        
        // if que mostara las opciones de cartones para el jugador 2 despues de haya elegido el jugador 1 
        if (cartonElegido == 1) { //Si el carton elegido es igual a 1 se mostrara solo los cartones 2, 3 y 4
            carton_2();
            carton_3();
            carton_4();
        } else if (cartonElegido == 2) {
            carton_1();
            carton_3();
            carton_4();
        } else if (cartonElegido == 3) {
            carton_1();
            carton_2();
            carton_4();
        } else if (cartonElegido == 4) {
            carton_1();
            carton_2();
            carton_3();
        }

        boolean bandera = false;
        do {
            System.out.println("");
            System.out.println("");
            System.out.print("                                       - " + nombre2 + " seleccione el numero de carton que desee: ");
            variante2 = Integer.parseInt(entrada.nextLine());
            System.out.println("");
            System.out.println("");
            this.variante2 = variante2;
            System.out.println("                              ------------------------------------------------------------------------------------");

            if (variante2 < 5 && variante2 > 0 && variante2 != variante1) { //Usamos el if para que el usuario ingrese un valor dentro del rango requerido
                switch (variante2) {                                       // y que a su vez no sea igual al valor de la variante anterior
                    case 1:
                        System.out.println("                                        " + nombre2 + " selecciono:");
                        carton_1();
                        break;
                    case 2:
                        System.out.println("                                        " + nombre2 + " selecciono:");
                        carton_2();
                        break;
                    case 3:
                        System.out.println("                                        " + nombre2 + " selecciono:");
                        carton_3();
                        break;
                    case 4:
                        System.out.println("                                        " + nombre2 + " selecciono:");
                        carton_4();
                        break;
                }
                bandera = true;
                break;
            }else{
                System.out.println("                                        Digito una opcion incorrecta de carton, ingrese otra por favor...");
                System.out.println("                              ------------------------------------------------------------------------------------");
                bandera = false;
            }
            
            
        }while (bandera = true);
    }

    public void sortear(String nombre1, String nombre2){
        boolean cartonLleno = false; 
        int cont_carton1 = 0, cont_carton2 = 0, nro_sorteado;
        
        int variante1 = this.variante1;
        int variante2 = this.variante2;
        String carton1[][] = new String[3][9];
        String carton2[][] = new String[3][9];
        
        // Se arman los cartones segun la variante seleccionada
        armadoCartonPorVariante(variante1, carton1);
        armadoCartonPorVariante(variante2, carton2);
        
        // Bucle para recorrer los cartones hasta que haya un carton lleno
        do{
            System.out.println("");
            System.out.println("");
            animaciones.teclaSeguir();
            nro_sorteado = obtenerSinRepetir(); // Obtenemos un numero que aun no haya salido
            
            for(int i=0; i<=2; i++){         //Mediante el siguiente for se realiza la comprobación de coincidencias dentro de cada carton y 
                for(int j=0; j<=8; j++){    //a su misma vez reemplazando los numeros sorteados con un "X"
                    if(Integer.toString(nro_sorteado).equals(carton1[i][j].replaceAll("\\s", ""))){ // Usamos equals para comparar entre dos strings. replaceAll es para eliminar los espacios vacios que trae el carton
                        carton1[i][j] = " X"; // Si existe el nro_sorteado en el carton lo cambiamos por una X
                        cont_carton1++;// Se le suma 1 al contador del carton por cada coincidencia
                    }
                    if(Integer.toString(nro_sorteado).equals(carton2[i][j].replaceAll("\\s", ""))){
                        carton2[i][j] = " X";
                        cont_carton2++;
                    }
                }
            }
            System.out.println("");
            System.out.println("           [-> "+nombre1+" <-]");
            System.out.println("");
            
            mostrarCartonPorVariante(variante1,carton1); // MOstramos el carton actualizado con las coincidencias
            
            System.out.println("           [-> "+nombre2+" <-]");
            mostrarCartonPorVariante(variante2,carton2);
            System.out.println("");
            System.out.println("");
            System.out.println("                             El numero sorteado es: " + nro_sorteado);
            System.out.println("");
            
            System.out.println("\n                                              -> LISTA DE NUMEROS YA SORTEADOS <-");
            for(int i=0; i<cont; i++){ // Ek for es para mostrar los numeros ya sorteados
                if(this.nros[i] > 0){
                    System.out.print(" " + this.nros[i]);
                }
                if (i == 45) { // cuando el contador sea igual a 45 reliza un salto de linea
                    System.out.println("");
                }
            }
            
            System.out.println("");

            // Si el contador de cada carton llega a 15 (es la cantidad de numeros por carton) es CartonLLeno
            if(cont_carton1 == 15){
                esperar(1);
                animaciones.cartonLleno();
                System.out.println("");
                esperar(2);
                System.out.println("                                           FELICITACIONES "+nombre1+" HAS GANADO EL JUEGO");
                cartonLleno = true;
            }
            
            if(cont_carton2 == 15){
                esperar(1);
                animaciones.cartonLleno();
                System.out.println("");
                esperar(2);
                System.out.println("                                           FELICITACIONES "+nombre2+" HAS GANADO EL JUEGO");
                cartonLleno = true;
            }
        }while(cartonLleno == false);
        
    }
    
    public int obtenerSinRepetir(){

        int nro_sorteado = 0;
        boolean repetido;
        
        for (int i = 1; i <= 1; i++) { // Inicio un bucle de una sola vuelta para obtener 1 unico nro
            repetido = false;
            nro_sorteado = (int)(Math.random()*((90-0)+1)); // Obtengo un numero aleatorio hasta 90
            
            for(int j=1; j <= this.cont; j++) { // Busco el nuevo numero en los nros ya sorteados 
                if (nro_sorteado == this.nros[j]) { // Si ya existe seteo repetido=true
                    repetido=true; 
                }                
            }
            
            if (repetido == true) {//Si repetido=true le resto 1 al contador para que vuelva a iniciarse
                i--;
            } else { // Sino lo cargo a los numeros y aumento 1 al contador
                this.nros[this.cont] = nro_sorteado;
                this.cont++;
            }
        }
        return nro_sorteado;
    }
    // Se arma el carton segun la variante(variante= opcion de carton elegida)
    public static void armadoCartonPorVariante(int variante, String[][] carton){
        if (variante == 1){
            armadoCarton1(carton);
        }else{
            if (variante == 2){
                armadoCarton2(carton);
            }else{
                if (variante == 3){
                    armadoCarton3(carton);
                }else{
                    if (variante == 4){
                        armadoCarton4(carton);
                    }
                }
            }
        }
    }
    //Se muestra el carton segun la variante 
    public static void mostrarCartonPorVariante(int variante, String[][] carton){
        if (variante == 1){
            mostrarCarton1(carton);
        }else{
            if (variante == 2){
                mostrarCarton2(carton);
            }else{
                if (variante == 3){
                    mostrarCarton3(carton);
                }else{
                    if (variante == 4){
                        mostrarCarton4(carton);
                    }
                }
            }
        }
    }
    //// Armado del carton, Cargamos los numeros del carton en una matris y colocamos ceros en los espacios que luego iran en blanco
    public static void armadoCarton1(String[][] carton1){
        
        carton1[0][0] = " 1"; carton1[0][1] = "0"; carton1[0][2] = "0"; carton1[0][3] = "31"; carton1[0][4] = "0"; carton1[0][5] = "57"; carton1[0][6] = "65"; carton1[0][7] = "0"; carton1[0][8] = "88"; 
        carton1[1][0] = "0"; carton1[1][1] = "12"; carton1[1][2] = "0"; carton1[1][3] = "35"; carton1[1][4] = "47"; carton1[1][5] = "0"; carton1[1][6] = "0"; carton1[1][7] = "75"; carton1[1][8] = "0";
        carton1[2][0] = " 8"; carton1[2][1] = "19"; carton1[2][2] = "0"; carton1[2][3] = "0"; carton1[2][4] = "48"; carton1[2][5] = "0"; carton1[2][6] = "67"; carton1[2][7] = "76"; carton1[2][8] = "90"; 
    }
    //Mostramos el carton
    public static void mostrarCarton1(String[][] carton1) {
        System.out.println("");
        System.out.println("                                        CARTON N°1");
        System.out.println("");
        System.out.println("                                        ----------------------------------------------");  // Linea que delimitara al carton en la parte superior
        
        for (int i = 0; i <= 2; i++) {   //For para recorrer el carton 
            System.out.print("                                        |");
            for (int j = 0; j <= 8; j++) {
                if (carton1[i][j] == "0"){   // Se reemplaza con un espacio en blanco  cada cero que se encuetre en el carton
                    carton1[i][j] = "  "; 
                }
                // Alineacion de los numeros del carton a traves de un if
                if (carton1.length > 1){  // Si la longuitud del caracter es mayor a 1 dejo un espacio delante y otro atras del mismo, 
                                          // si no dejo un esacio adelante y doble espacio por detras 
                    System.out.print(" "+carton1[i][j]+ " |");
                }else{
                    System.out.print(" "+carton1[i][j]+ "  |");
                }
            } 
            System.out.println("");
        }
        System.out.println("                                        ----------------------------------------------");  // Linea que delimitara al carton en la parte inferior
     }
    
    public static void armadoCarton2(String[][] carton2){

        carton2[0][0] = " 1"; carton2[0][1] = "0"; carton2[0][2] = "23"; carton2[0][3] = "0"; carton2[0][4] = "45"; carton2[0][5] = "0"; carton2[0][6] = "61"; carton2[0][7] = "0"; carton2[0][8] = "82"; 
        carton2[1][0] = "0"; carton2[1][1] = "14"; carton2[1][2] = "0"; carton2[1][3] = "37"; carton2[1][4] = "49"; carton2[1][5] = "0"; carton2[1][6] = "69"; carton2[1][7] = "70"; carton2[1][8] = "0";
        carton2[2][0] = " 4"; carton2[2][1] = "0"; carton2[2][2] = "28"; carton2[2][3] = "0"; carton2[2][4] = "0"; carton2[2][5] = "55"; carton2[2][6] = "0"; carton2[2][7] = "78"; carton2[2][8] = "87";
    }
    
    public static void mostrarCarton2(String[][] carton2) {
        System.out.println("");
        System.out.println("                                        CARTON N°2");
        System.out.println("");
        System.out.println("                                        ----------------------------------------------");
        
        for (int i = 0; i <= 2; i++) {
            System.out.print("                                        |");
            for (int j = 0; j <= 8; j++) {
                if (carton2[i][j] == "0"){
                    carton2[i][j] = "  "; 
                }
                if (carton2.length > 1){
                    System.out.print(" "+carton2[i][j]+ " |");
                }else{
                    System.out.print(" "+carton2[i][j]+ "  |");
                }
            } 
            System.out.println("");
        }
        System.out.println("                                        ----------------------------------------------");
        
     }

    public static void armadoCarton3(String[][] carton3){
        carton3[0][0] = "0"; carton3[0][1] = "0"; carton3[0][2] = "22"; carton3[0][3] = "0"; carton3[0][4] = "40"; carton3[0][5] = "50"; carton3[0][6] = "0"; carton3[0][7] = "71"; carton3[0][8] = "0"; 
        carton3[1][0] = " 6"; carton3[1][1] = "0"; carton3[1][2] = "29"; carton3[1][3] = "30"; carton3[1][4] = "0"; carton3[1][5] = "54"; carton3[1][6] = "0"; carton3[1][7] = "0"; carton3[1][8] = "81";
        carton3[2][0] = " 7"; carton3[2][1] = "16"; carton3[2][2] = "0"; carton3[2][3] = "34"; carton3[2][4] = "46"; carton3[2][5] = "0"; carton3[2][6] = "66"; carton3[2][7] = "0"; carton3[2][8] = "90";
    }
    
    public static void mostrarCarton3(String[][]  carton3) {
        System.out.println("");
        System.out.println("                                        CARTON N°3");
        System.out.println("");
        System.out.println("                                        ----------------------------------------------");
        
        for (int i = 0; i <= 2; i++) {
            System.out.print("                                        |");
            for (int j = 0; j <= 8; j++) {
                if (carton3[i][j] == "0"){
                    carton3[i][j] = "  "; 
                }
                if (carton3.length > 1){
                    System.out.print(" "+carton3[i][j]+ " |");
                }else{
                    System.out.print(" "+carton3[i][j]+ "  |");
                }
            } 
            System.out.println("");
        }
        System.out.println("                                        ----------------------------------------------");
    }
    
    public static void armadoCarton4(String[][] carton4){
        carton4[0][0] = "0"; carton4[0][1] = "11"; carton4[0][2] = "0"; carton4[0][3] = "36"; carton4[0][4] = "43"; carton4[0][5] = "0"; carton4[0][6] = "64"; carton4[0][7] = "73"; carton4[0][8] = "83"; 
        carton4[1][0] = "0"; carton4[1][1] = "13"; carton4[1][2] = "21"; carton4[1][3] = "0"; carton4[1][4] = "0"; carton4[1][5] = "51"; carton4[1][6] = "0"; carton4[1][7] = "77"; carton4[1][8] = "0";
        carton4[2][0] = " 5"; carton4[2][1] = "0"; carton4[2][2] = "26"; carton4[2][3] = "0"; carton4[2][4] = "44"; carton4[2][5] = "56"; carton4[2][6] = "0"; carton4[2][7] = "0"; carton4[2][8] = "86";
    }
    
        
    public static void mostrarCarton4(String[][]   carton4) {
        System.out.println("");
        System.out.println("                                        CARTON N°4");
        System.out.println("");
        System.out.println("                                        ----------------------------------------------");
        
        for (int i = 0; i <= 2; i++) {
            System.out.print("                                        |");
            for (int j = 0; j <= 8; j++) {
                if (carton4[i][j] == "0"){
                    carton4[i][j] = "  "; 
                }
                if (carton4.length > 1){
                    System.out.print(" "+carton4[i][j]+ " |");
                }else{
                    System.out.print(" "+carton4[i][j]+ "  |");
                }
            } 
            System.out.println("");
        }
        System.out.println("                                        ----------------------------------------------");
    }
    // Metodo para mostar los cartones 
    public static void carton_1(){  
        String carton1[][] = new String[3][9]; 
        armadoCarton1(carton1);  //Llamamos al metodo de armado y mostar carton  
        mostrarCarton1(carton1);
    }
    public static void carton_2(){
        String carton2[][] = new String[3][9]; 
        armadoCarton2(carton2); 
        mostrarCarton2(carton2);
        }
    public static void carton_3(){
        String carton3[][] = new String[3][9]; 
        armadoCarton3(carton3); 
        mostrarCarton3(carton3);
        }
    public static void carton_4(){
        String carton4[][] = new String[3][9]; 
        armadoCarton4(carton4); 
        mostrarCarton4(carton4);
        }

    
    public void jugarQuini6(){
        
    Scanner entrada = new Scanner(System.in); 
    
    //--------------------------------------------------------------------------
    // Parte bienvenidos al quini
    System.out.println("                              ------------------------------------------------------------------------------------");
    System.out.println("                                                                   Q U I N I - 6");
    
    //--------------------------------------------------------------------------
    // Creamos el arreglo que tendra los numeros aleatorios sin repetir
    
    int aleatorios[] = new int[6];  // iniciamos el arreglo
    

    for (int i = 0; i < 6; i++) {   // iniciamos el primer ciclo for, este hace 6 veces el recorrido

        boolean encontrado = false; // usamos una variable como bandera

        int aleatorio = (int) (Math.random() * 49) + 1; // le asignamos un numero aleatorio a la variable

        for (int j = 0; j < i; j++) {   // segundo ciclo for, este verifica que no se repitan los numeros generados al azar
            if (aleatorios[j] == aleatorio) {   // se recorre todo el arreglo, y si el numero aleatorio esta repetido
                encontrado = true;  // la bandera pasa a ser verdadera
            }
        }
        if (!encontrado) {
            aleatorios[i] = aleatorio; // aca se guardan los numeros sin repetir
        }else{                         // para despues poder mostrarlos
            i--;
        }
    }
    //--------------------------------------------------------------------------
    // Parte donde el usuario ingresa los numeros que eligio
    
    int numeros[] = new int[6];
    int numero;
    System.out.println("");
    System.out.println("");
    System.out.println(" - Digite un numero en el rango de 1 a 50");
    for (int i = 0; i < 6; i++) {
        System.out.print(" - Numero "+(i+1)+": ");
        numero = entrada.nextInt();
            
        if (numero < 0 || numero > 50){ // si el numero esta fuera de rango no ingresa al arreglo y el iterador retrocede uno
            System.out.println("Fuera de rango, ingrese otro numero...");
            i --;
        }else{
            numeros[i] = numero;// cada numero ingresado por el usuario
                                // es guardado en el arreglo
        }                         
    }
    
    //--------------------------------------------------------------------------
    // Ahora vemos si hay repetidos en los dos arreglos
    
    int cont = 0;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            if (numeros[i]==aleatorios[j]){
                cont += 1;
            }
        }
    }
    //--------------------------------------------------------------------------
    // Mostramos los numeros premiados y el premio del jugador
    esperar(2);
    System.out.println("");
    System.out.println("-------------------------");
    System.out.println("--> NUMEROS PREMIADOS <--");
    for (int i = 0; i < 6; i++) {
        System.out.print(" "+aleatorios[i]+" ");
    } 
    System.out.println("");
    System.out.println("-------------------------");
    esperar(1);
    System.out.println("");
    System.out.println("- La cantidad de coincidencias son: "+cont);
    System.out.println("");
        
    //--------------------------------------------------------------------------    
    // Parte donde se asignan los premios segun la cantidad de coincidencias
    
    if (cont != 0){ //Utilizamos un if como condicion y lugo un switch para mostrar el orden de los premios segun corresponda
        switch (cont){
            case 1:
                System.out.println("--> Su premio es un Mouse inalámbrico <--");
                break;
            case 2:
                System.out.println("--> Su premio son unos Auriculares con Microfono <--");
                break;
            case 3:
                System.out.println("--> Su premio es un Monitor 144hz <--");
                break;
            case 4: 
                System.out.println("--> Su premo es una Silla Gamer <--");
                break;
            case 5:
                System.out.println("--> Su premo es una Pc Gamer <--");
                break;
            case 6: 
                System.out.println("--> Su premio es una Pc Gamer + Periféricos <--");
                break;
            }
    }else{
        esperar(2);
        System.out.println("------------------------------------");
        System.out.println("Lo sentimos, no obtuvo ningun premio");
        System.out.println("         La proxima sera :)");
        System.out.println("------------------------------------");
        }
    esperar(2);
    teclaSeguir();  // llamamos al metodo seguir para que
    menu();         // lo lleve de nuevo al manu principal 
    //--------------------------------------------------------------------------
    }  
}



