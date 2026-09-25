
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public Queue<Obj> LlenarCola(Queue<Obj> cola, Metodos m, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            Obj o = new Obj();
            o.setTurno(m.ValidarTurno(cola));
            o.setName(m.MenuComida(sc));
            System.out.println("Ingrese la cantidad ");
            o.setCantidad(sc.nextInt());
            System.out.println("Ingrese el precio ");
            o.setPrice(sc.nextDouble());
            o.setEstate(1);
            System.out.println("Desea Agregar mas turnos 1 si , 2 no ");
            int opt = sc.nextInt();
            if (opt == 2) {
                System.out.println("Vuelve Pront");
                continuar = false;
            }
            cola.offer(o);

        }
        return cola;

    }

    public int ValidarTurno(Queue<Obj> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    public int MenuComida(Scanner sc) {
        System.out.println("Bienvenido a negocio de jenny que desea llevar");
        System.out.println("1) Sacocho de bagre");
        System.out.println("2) sacocho trifasico");
        System.out.println("3) Ajiaco");
        System.out.println("4) Consome de Pollo");
        System.out.println("5) Sancocho de costilla ");
        System.out.println("6) Mondongo de la abuela ");
        return sc.nextInt();

    }

    public String MostrarTodosTurnos(Queue<Obj> cola, int opt) {
        switch (opt) {
            case 1:
                for (Obj o : cola) {
                    System.out.println("Turno: " + o.getTurno());
                    System.out.println(MenuSacochito(o.getName()));
                    System.out.println("Cantidad: " + o.getCantidad());
                    System.out.println("Precio: " + o.getPrice());
                    if (o.getEstate() == 1) {
                        System.out.println("Estado: Pendiente");
                    } else {
                        System.out.println("Estado: Atendido");
                    }
                    System.out.println("----------------------------------------- \n");

                }

                break;
            case 2:
                for (Obj o : cola) {
                    if (o.getEstate() == 1) {
                        System.out.println("Turno: " + o.getTurno());
                        System.out.println(MenuSacochito(o.getName()));
                        System.out.println("Cantidad: " + o.getCantidad());
                        System.out.println("Precio: " + o.getPrice());
                        if (o.getEstate() == 1) {
                            System.out.println("Estado: Pendiente");
                        } else {
                            System.out.println("Estado: Atendido");
                        }
                    }

                }
                break;

            default:
                for (Obj o : cola) {
                    if (o.getEstate() != 1) {
                        System.out.println("Turno: " + o.getTurno());
                        System.out.println(MenuSacochito(o.getName()));
                        System.out.println("Cantidad: " + o.getCantidad());
                        System.out.println("Precio: " + o.getPrice());
                        if (o.getEstate() == 1) {
                            System.out.println("Estado: Pendiente");
                        } else {
                            System.out.println("Estado: Atendido");
                        }

                    }

                }
                break;
        }
        return "Datos mostrados correctamente";
    }

    private static String MenuSacochito(int opt) {
        String mensaje = "";
        switch (opt) {
            case 1:
                mensaje = "Sacocho de bagre";
                break;
            case 2:
                mensaje = "sacocho trifasico";
                break;
            case 3:
                mensaje = "Ajiaco";
                break;
            case 4:
                mensaje = "Consome de Pollo";
                break;
            case 5:
                mensaje = "Sancocho de costilla ";
                break;

            default:
                mensaje = "Mondongo de la abuela ";
                break;
        }
        return mensaje;
    }

    public Queue<Obj> Atender(Queue<Obj> cola) {
        for (Obj o : cola) {
            if (o.getEstate() == 1) {
                System.out.println("El siguiente turno es " + o.getTurno() + " con un pedido de :" + o.getName());
                o.setEstate(2);
                break;
            }
        }
        System.out.println("Turno atendido correctamente ");
        return cola;
    }

    public int ValidarEentero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ojala en el rango de 1 a 5 ");
            sc.next();
        }
        return sc.nextInt();
    }

    public Stack<Obj> Apilar(Queue<Obj> c, Stack<Obj> p) {
        for (Obj o : c) {
            if (o.getEstate() == 1) {
                p.push(o);
            }
        }
        return p;
    }

    public void MostrarPila(Stack<Obj> p) {
        for (Obj o : p) {
            System.out.println("Turno: " + o.getTurno());
            System.out.println(MenuSacochito(o.getName()));
            System.out.println("Cantidad: " + o.getCantidad());
            System.out.println("Precio: " + o.getPrice());
            if (o.getEstate() == 1) {
                System.out.println("Estado: Pendiente");
            } else {
                System.out.println("Estado: Atendido");
            }
        }
    }

    public Obj[] ArregloAtendidos(Queue<Obj> c) {
        Obj[] arreglo = new Obj[Dimension(c)];
        int i = 0;
        for (Obj o : c) {
            if (o.getEstate() != 1) {
                arreglo[i] = o;
                i++;
            }
        }
        return arreglo;
    }

    private static int Dimension(Queue<Obj> c) {
        int cont = 0;
        for (Obj o : c) {
            if (o.getEstate() != 1) {
                cont++;
            }
        }
        return cont;
    }

    public void MostrarArreglo(Obj[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Turno: " + a[i].getTurno());
            System.out.println(MenuSacochito(a[i].getName()));
            System.out.println("Cantidad: " + a[i].getCantidad());
            System.out.println("Precio: " + a[i].getPrice());
            if (a[i].getEstate() == 1) {
                System.out.println("Estado: Pendiente");
            } else {
                System.out.println("Estado: Atendido");
            }
        }
    }

}