package com.example.mcj.web;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mcj.domain.User;
import com.example.mcj.repository.UserRepository;
import com.example.mcj.web.util.PaginationUtil;
import com.example.mcj.web.vm.ManagedUserVM;


@Controller
@RequestMapping("/app/admin")
public class AdminController {

    @Inject
    private UserRepository userRepository;
    
    /*
     * ovo ne moze ovde, jer je Controller, a ne RestController
     * zašto?
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    */
    
	@RequestMapping(value = "/{id}", produces = "text/html")
	public String test(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("fields", null);
        
        return "/test"; // ne radi mi vracanje strana. Trazi THYMELEAF i ostala sranja.
        //valda nisam konfigurisao
        // /app/admin/test - ne radi
        
        //mora ovde druga organizacija mapiranja, sve sam pomešao
	}
	
    /**
     * GET  /users : get all users.
     * 
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     * @throws URISyntaxException if the pagination headers couldn't be generated
     */
    @RequestMapping(value = "/users",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ManagedUserVM>> getAllUsers(Pageable pageable)
        throws URISyntaxException {
    	//Optional<User> user = userRepository.findOneById(4L);
        Page<User> page = userRepository.findAllWithAuthorities(pageable);
        List<ManagedUserVM> managedUserVMs = page.getContent().stream()
            .map(ManagedUserVM::new)
            .collect(Collectors.toList());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/users");
        return new ResponseEntity<>(managedUserVMs, headers, HttpStatus.OK);
    }
}