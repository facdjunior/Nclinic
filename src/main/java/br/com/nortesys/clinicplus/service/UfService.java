package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.UfDAO;
import br.com.nortesys.clinicplus.domain.UF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Francisco Junior
 */
@Path("uf")
public class UfService {
    
     //http://localhost:8080/ClinicPlus/clinic/uf 
    @GET
    public String listar() {

        UfDAO ufDAO = new UfDAO();
        List<UF> ufs = ufDAO.listar();

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(ufs);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/uf/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        UfDAO ufDAO = new UfDAO();
        UF uf = ufDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String json = gson.toJson(uf);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/uf/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        UF uf = gson.fromJson(json, UF.class);

        UfDAO ufDAO = new UfDAO();
        UF resultado = (UF) ufDAO.listarSequencia();

        if (resultado == null) {
            uf.setDataCadastro(new Date());
            uf.setSequencia(1L);
            

        } else {
            uf.setDataCadastro(new Date());
            uf.setSequencia(resultado.getSequencia() + 1L);
            
        }

        ufDAO.merge(uf);

        String jsonSaida = gson.toJson(uf);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/uf/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        UF uf = gson.fromJson(json, UF.class);

        UfDAO ufDAO = new UfDAO();
        ufDAO.editar(uf);

        String jsonSaida = gson.toJson(uf);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/uf/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        UfDAO ufDAO = new UfDAO();

        UF uf = ufDAO.buscar(codigo);
        ufDAO.excluir(uf);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        String saida = gson.toJson(uf);
        return saida;
    }
}
