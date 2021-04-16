package tn.esprit.spring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.AuthenticationRequest;
import tn.esprit.spring.entities.AuthenticationResponse;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.MyUserDetailsService;
import tn.esprit.spring.service.UserService;
import tn.esprit.spring.util.JwtUtil;

@Controller
@ComponentScan("org.springframework.security.authentication")
public class Resource {

	@Autowired
	BCryptPasswordEncoder coder;
	@Autowired
	UserService userser;
   @Bean
   public AuthenticationManager customAuthenticationManager() throws Exception
   {
	   return authenticationManager;
   }
   private  AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtTokenUtil;
	 // URL :http://localhost:8082/SpringMVC/servlet/admin
    //succeeded login access to this result
    @RequestMapping ("/admin")
    public String admin() {
    	return " welcome admin";
    	}
    // URL :http://localhost:8082/SpringMVC/servlet/borrower

    @RequestMapping("/borrower")
    public String borrower() {
    	return "welcome borrower";
    }
    // URL :http://localhost:8082/SpringMVC/servlet/lender

    @RequestMapping("/lender")
    public String lender() {
    	return "welcome lender";
    }

  /* @RequestMapping (value ="/authenticate" , method= RequestMethod.POST)*/
   /* public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
    	try{
 
    	authenticationManager.authenticate ( new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));}
    	catch (BadCredentialsException e) { throw new Exception("Incorrect Username or password",e);
    		}
    	final UserDetails userDetails = userDetailsService
    			.loadUserByUsername(authenticationRequest.getUsername());
    	
    	final String jwt = jwtTokenUtil.generateToken(userDetails);
    	return ResponseEntity.ok(new AuthenticationResponse(jwt));
    	
    	
    	
    	}*/
	@GetMapping("/authenticate")
	@ResponseBody
	public String sauthentifier(@RequestBody User u)  {
		String mdpcrypt=coder.encode(u.getPassword());
	if(userser.getuserbyloginandpassword(u.getLogin(),mdpcrypt)!=null)
	{
		return "Bienvenue Mr/Mrs :"+u.getFirstName()+".";
	}
	else{
		return "Verifier votre Mot de passe ou Login ";
	}
	}
   
}
