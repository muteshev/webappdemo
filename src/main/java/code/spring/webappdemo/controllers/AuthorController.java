package code.spring.webappdemo.controllers;

import code.spring.webappdemo.MyConfiguration;
import code.spring.webappdemo.MyMessage;
import code.spring.webappdemo.MyProfile;
import code.spring.webappdemo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@EnableAutoConfiguration
@Import(MyConfiguration.class)
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Autowired
    private String message;
    @Autowired
    private MyMessage myMessage;
    @Autowired
    private MyProfile myProfile;

    @Value("${id}")
    private String id;
    @Value("${firstName}")
    private String firstName;
    @Value("${lastName}")
    private String lastName;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("id", id);
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("message", message);
        model.addAttribute("myMessageInt", myMessage.getMessageInt());
        model.addAttribute("myMessageString", myMessage.getMessageString());
        model.addAttribute("myMessageValue", myProfile.getMessageValue());
        return "authors/list";
    }
}
