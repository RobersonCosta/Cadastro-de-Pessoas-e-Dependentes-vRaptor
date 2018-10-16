package controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;
import model.Pessoa;

@Controller
public class IndexController {
    @Inject private Result result;
    
    @Path("/")
    public void index() {
    }    
}
