package controlador;

import conexion.Conexion;
import dao.FerreteriaDao;
import java.util.Scanner;
import modelo.Ferreteria;

public class FerreteriaController {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Ferreteria userf = new Ferreteria(0);
        Conexion conn = new Conexion();
        FerreteriaDao ferr = new FerreteriaDao(conn);

        System.out.println("Ingrese el nombre del cliente");
        userf.setNombre(scan.next());
        System.out.println("Ingrese el nombre de la herramienta");
        userf.setHerramientas(scan.next());
        System.out.println("Ingrese el precio de las herramientas");
        userf.setPrecio(scan.nextInt());
        System.out.println("Ingrese la fecha de la compra");
        userf.setFecha(scan.next());

        boolean respuesta = ferr.insertar(userf);

        if (respuesta) {
            System.out.println("Su registro fue un exito");
        } else {
            System.out.println("Error al guardar registro");
        }
    }
}
