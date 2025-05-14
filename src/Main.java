import java.util.*;

class Usuario {
    String email;
    String contrasena;
    String nombre;
    String tarjetaCredito;

    public Usuario(String correo, String pass, String nom, String tarjeta) {
        email = correo;
        contrasena = pass;
        nombre = nom;
        tarjetaCredito = tarjeta;
    }

    public String toString() {
        return "Usuario: " + nombre + ", Email: " + email;
    }
}

class Vuelo {
    String idVuelo;
    String origen;
    String destino;
    String fecha;
    String hora;
    String categoriaAsiento;
    String aerolinea;
    int asientosDisponibles;

    public Vuelo(String id, String origenVuelo, String destinoVuelo, String fechaVuelo, String horaVuelo, String categoria, String aerolineaVuelo, int disponibles) {
        idVuelo = id;
        origen = origenVuelo;
        destino = destinoVuelo;
        fecha = fechaVuelo;
        hora = horaVuelo;
        categoriaAsiento = categoria;
        aerolinea = aerolineaVuelo;
        asientosDisponibles = disponibles;
    }

    public String toString() {
        return "Vuelo: " + idVuelo + " de " + origen + " a " + destino + ", Fecha: " + fecha + ", Hora: " + hora;
    }
}

class Reserva {
    String idReserva;
    Usuario usuario;
    Vuelo vuelo;
    String fechaReserva;

    public Reserva(String id, Usuario usu, Vuelo vue, String fechaRes) {
        idReserva = id;
        usuario = usu;
        vuelo = vue;
        fechaReserva = fechaRes;
    }

    public String toString() {
        return "Reserva: " + idReserva + ", Usuario: " + usuario.nombre + ", Vuelo: " + vuelo.idVuelo;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Usuario> usuarios = new ArrayList<>();
    static List<Vuelo> vuelos = new ArrayList<>();
    static List<Reserva> reservas = new ArrayList<>();
    public static void main(String[] args) {
        usuarios.add(new Usuario("juan.perez@gmail.com", "1234", "Juan Perez", "1111222233334444"));
        usuarios.add(new Usuario("maria.gomez@gmail.com", "5678", "Maria Gomez", "5555666677778888"));
        usuarios.add(new Usuario("carlos.rodriguez@gmail.com", "abcd", "Carlos Rodriguez", "9999000011112222"));
        usuarios.add(new Usuario("laura.martinez@gmail.com", "qwerty", "Laura Martinez", "3333444455556666"));
        usuarios.add(new Usuario("diego.torres@gmail.com", "zxcv", "Diego Torres", "7777888899990000"));
        int opcion;
        do {
            System.out.println("\n--VUELOMON AIRLINES---");
            System.out.println("\n-NO ES UN VIAJE ES UN ESTILO DE VIDA-");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Registrar Vuelo");
            System.out.println("3. Registrar Reserva");
            System.out.println("4. Consultar Usuarios");
            System.out.println("5. Consultar Vuelos");
            System.out.println("6. Consultar Reservas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarUsuario();
                case 2 -> registrarVuelo();
                case 3 -> registrarReserva();
                case 4 -> consultarUsuarios();
                case 5 -> consultarVuelos();
                case 6 -> consultarReservas();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    static void registrarUsuario() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contrasena: ");
        String contrasena = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tarjeta de Credito: ");
        String tarjeta = scanner.nextLine();

        usuarios.add(new Usuario(email, contrasena, nombre, tarjeta));
        System.out.println("Usuario registrado exitosamente.");
    }

    static void registrarVuelo() {
        System.out.print("ID Vuelo: ");
        String id = scanner.nextLine();
        System.out.print("Origen: ");
        String origen = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Fecha: ");
        String fecha = scanner.nextLine();
        System.out.print("Hora: ");
        String hora = scanner.nextLine();
        System.out.print("Categoria de Asiento: ");
        String categoria = scanner.nextLine();
        System.out.print("Aerolinea: ");
        String aerolinea = scanner.nextLine();
        System.out.print("Asientos Disponibles: ");
        int asientos = scanner.nextInt();
        scanner.nextLine();

        vuelos.add(new Vuelo(id, origen, destino, fecha, hora, categoria, aerolinea, asientos));
        System.out.println("Vuelo registrado exitosamente.");
    }

    static void registrarReserva() {
        System.out.print("Email del usuario: ");
        String email = scanner.nextLine();
        Usuario usuario = usuarios.stream().filter(u -> u.email.equals(email)).findFirst().orElse(null);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("ID del vuelo: ");
        String idVuelo = scanner.nextLine();
        Vuelo vuelo = vuelos.stream().filter(v -> v.idVuelo.equals(idVuelo)).findFirst().orElse(null);

        if (vuelo == null) {
            System.out.println("Vuelo no encontrado.");
            return;
        }

        System.out.print("ID de la reserva: ");
        String idReserva = scanner.nextLine();
        System.out.print("Fecha de reserva: ");
        String fechaReserva = scanner.nextLine();

        reservas.add(new Reserva(idReserva, usuario, vuelo, fechaReserva));
        System.out.println("Reserva realizada exitosamente.");
    }

    static void consultarUsuarios() {
        usuarios.forEach(System.out::println);
    }

    static void consultarVuelos() {
        vuelos.forEach(System.out::println);
    }

    static void consultarReservas() {
        reservas.forEach(System.out::println);
    }
}

