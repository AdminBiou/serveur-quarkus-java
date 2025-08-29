package ci.mobio;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.enterprise.context.ApplicationScoped;

@Path("/calcul") // Racine de ton API
@ApplicationScoped
public class ServeurCalculService {

    @GET
    @Path("/add")
    @Produces(MediaType.TEXT_PLAIN)
    public String add(@QueryParam("a") int a, @QueryParam("b") int b) {
        return String.valueOf(a + b);
    }

    @GET
    @Path("/sub")
    @Produces(MediaType.TEXT_PLAIN)
    public String sub(@QueryParam("a") int a, @QueryParam("b") int b) {
        return String.valueOf(a - b);
    }

    @GET
    @Path("/mul")
    @Produces(MediaType.TEXT_PLAIN)
    public String mul(@QueryParam("a") int a, @QueryParam("b") int b) {
        return String.valueOf(a * b);
    }

    @GET
    @Path("/div")
    @Produces(MediaType.TEXT_PLAIN)
    public String div(@QueryParam("a") int a, @QueryParam("b") int b) {
        if (b == 0) return "Erreur : division par zéro";
        return String.valueOf(a / b);
    }

    @GET
    @Path("/eq1")
    @Produces(MediaType.TEXT_PLAIN)
    public String eq1(@QueryParam("a") int a, @QueryParam("b") int b) {
        if (a == 0) return "Erreur : a = 0";
        return "x = " + (-b / (double) a);
    }

    @GET
    @Path("/eq2")
    @Produces(MediaType.TEXT_PLAIN)
    public String eq2(@QueryParam("a") int a, @QueryParam("b") int b, @QueryParam("c") int c) {
        double delta = b * b - 4 * a * c;
        if (a == 0) return "Erreur : a = 0";
        if (delta < 0) return "Pas de solution réelle";
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return "x1=" + x1 + ", x2=" + x2;
    }
}
