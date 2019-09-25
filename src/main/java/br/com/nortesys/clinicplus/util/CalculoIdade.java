package br.com.nortesys.clinicplus.util;
import br.com.nortesys.clinicplus.domain.Cliente;
import br.com.nortesys.clinicplus.domain.PessoaFisica;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

/**
 *
 * @author Francisco
 */
public class CalculoIdade {

  private PessoaFisica pessoaFisica;
  private Date DataAtual;

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Date getDataAtual() {
        return DataAtual;
    }

    public void setDataAtual(Date DataAtual) {
        this.DataAtual = DataAtual;
    }
  
    public String idade(){
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        
        Date dataInicio = pessoaFisica.getDataNascimento();
        Date dataAtual = new Date();
      
        long dt = (dataAtual.getTime() - dataInicio.getTime())+3600000;
        Long diasCorridoAnoLong = (dt / 86400000L);
        
        Integer DiasDecorridosInt = (Integer.valueOf(diasCorridoAnoLong.toString()));
        
        String diasDecorridos = String.valueOf(DiasDecorridosInt);
        
        return diasDecorridos; 
    }
    
}
