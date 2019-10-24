package br.com.nortesys.clinicplus.service;

import br.com.nortesys.clinicplus.dao.EmpresaDAO;
import br.com.nortesys.clinicplus.domain.Empresa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
@Path("entidade")
public class EmpresaService {

    //http://localhost:8080/ClinicPlus/clinic/entidade 
    @GET
    public String listar() {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        List<Empresa> pessoas = empresaDAO.listaCliente();
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(pessoas);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/entidade/codigo
    @GET
    @Path("{codigo}")
    public String buscar(@PathParam("codigo") Long codigo) {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        Empresa empresa = empresaDAO.buscar(codigo);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(empresa);

        return json;
    }

    //http://localhost:8080/ClinicPlus/clinic/entidade/
    @POST
    public String salvar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        Empresa empresa = gson.fromJson(json, Empresa.class);

        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.merge(empresa);

        String jsonSaida = gson.toJson(empresa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinc/entidade/
    @PUT
    public String editar(String json) {

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        Empresa empresa = gson.fromJson(json, Empresa.class);

        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.editar(empresa);

        String jsonSaida = gson.toJson(empresa);
        return jsonSaida;
    }

    //http://localhost:8080/ClinicPlus/clinic/entidade/{codigo}
    @DELETE
    @Path("{codigo}")
    public String excluir(@PathParam("codigo") Long codigo) {

        EmpresaDAO empresaDAO = new EmpresaDAO();

        Empresa empresa = empresaDAO.buscar(codigo);
        empresaDAO.excluir(empresa);

        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").excludeFieldsWithoutExposeAnnotation().create();
        String saida = gson.toJson(empresa);
        return saida;
    }

}
