package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;


    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.IbecaFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }



    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@RequestParam(value = "id" ) int id) {
        LOG.info("User id");
        LOG.info(id);
        this.IbecaFacade.deleteUser((long) id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserTO> findUserById(@RequestParam(value = "id" ) int id) {
        LOG.info("User id F::");
        LOG.info(id);
        UserTO findUserByIdResponse = this.IbecaFacade.findUserById((long) id);
        return new ResponseEntity<>( findUserByIdResponse,HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserTO userTO) {
        this.IbecaFacade.saveUser(userTO);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO userTO) {
        if(userTO.getId() != 0){
            this.IbecaFacade.updateUser(userTO);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
    //// examen
    @RequestMapping(value = "/logins", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LoginTO>> getAllLogin() {
        LOG.info("Se invoca /logins");
        List<LoginTO> logins = this.IbecaFacade.getAllLogin();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteLogin(@RequestParam(value = "id" ) int id) {
        LOG.info("Login id");
        LOG.info(id);
        this.IbecaFacade.deleteLogin((long) id);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LoginTO> findLoginById(@RequestParam(value = "id" ) int id) {
        LOG.info("Login id F::");
        LOG.info(id);
        LoginTO findLoginByIdResponse = this.IbecaFacade.findLoginById((long) id);
        return new ResponseEntity<>( findLoginByIdResponse,HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveLogin(@RequestBody LoginTO loginTO) {

        //cuando guarde debe se ver si ya existe, si existe return bad request
        this.IbecaFacade.saveLogin(loginTO);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateLogin(@RequestBody LoginTO loginTO) {
        if(loginTO.getId() != 0){
            this.IbecaFacade.updateLogin(loginTO);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login/validate", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LoginTO> validateLoginByUserName(@RequestParam(value = "username" ) String userName,@RequestParam(value = "password") String password) {
        LOG.info("Validate Login Name F::");
        LOG.info(userName);
        LOG.info(password);
        LoginTO validateLoginByUserNamen = this.IbecaFacade.validateUser(userName);
        return new ResponseEntity<>( validateLoginByUserNamen,HttpStatus.OK);
    }
    ///termina
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
       int result = this.IbecaFacade.operation(5,10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
