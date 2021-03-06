package br.com.nortesys.clinicplus.bean;

import br.com.nortesys.clinicplus.domain.Funcionario;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Francisco Junior
 */
@ManagedBean
@RequestScoped
public class ImagemBean {

    @ManagedProperty("#{param.caminho}")

    private String caminho;
    private Funcionario funcionario;
    private StreamedContent foto;

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    

    public StreamedContent getFoto() throws IOException {

        if (caminho == null || caminho.isEmpty()) {
            Path path = Paths.get("D:/Curso/imagemProjeto/sem-foto.jpg");
            InputStream stream = Files.newInputStream(path);
            foto = new DefaultStreamedContent(stream);
        } else {
            Path path = Paths.get(caminho);
            InputStream stream = Files.newInputStream(path);
            foto = new DefaultStreamedContent(stream);
        }
         
        return foto;
    }

    public void setFoto(StreamedContent foto) {
        this.foto = foto;
    }

}
