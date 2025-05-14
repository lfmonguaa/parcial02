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
}

