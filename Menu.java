import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Obj> cola = new LinkedList<>();
        Stack<Obj> pila = new Stack<>();
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("bienvenidos al banco honesto");
            System.out.println("¿Que desea realizar?");
            System.out.println("1) llenar Pedidos ");
            System.out.println("2) Mostrar Pedidos ");
            System.out.println("3) Atender Turno ");
            System.out.println("4) Mostrar Pedidos Pendientes");
            System.out.println("5) Mostrar Pedidos Atendidos");
            System.out.println("6) Apilar los pendientes");
            System.out.println("7) motrar arreglo de atendidos");
            System.out.println("8) Salir ");
            int opt = m.ValidarEentero(sc);
            switch (opt) {
                case 1:
                    cola = m.LlenarCola(cola, m, sc);
                    break;
                case 2:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 1));
                    break;
                case 3:
                    cola = m.Atender(cola);
                    break;
                case 4:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 2));
                    break;
                case 5:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 3));

                    break;
                case 6:
                    pila = m.Apilar(cola, pila);
                    m.MostrarPila(pila);
                    break;
                case 7:
                    Obj[] a = m.ArregloAtendidos(cola);
                    m.MostrarArreglo(a);
                    break;
                case 8:
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;

                default:
                    System.out.println("esta opcion no existe");
                    break;
            }
        }
    }
}