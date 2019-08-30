package br.com.nortesys.clinicplus.util;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Francisco
 */
@ApplicationPath("clinic")
public class ClinicPlusResourceConfig extends ResourceConfig{
    
    public ClinicPlusResourceConfig(){
        
        packages("br.com.nortesys.clinicplus.service");
    }
}
