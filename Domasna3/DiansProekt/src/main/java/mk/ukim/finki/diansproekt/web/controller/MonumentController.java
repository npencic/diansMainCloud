package mk.ukim.finki.diansproekt.web.controller;

import mk.ukim.finki.diansproekt.model.Monument;
import org.springframework.ui.Model;
import mk.ukim.finki.diansproekt.service.MonumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class MonumentController {

    private final MonumentService monumentService;

    public MonumentController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @GetMapping
    public String getMonumentsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error", error);
        }
        List< Monument> monuments=monumentService.findAll();
        model.addAttribute("monuments", monumentService.findAll());

        return "listMonuments";
    }


    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model){
        Monument monument = this.monumentService.findById(id).get();
        model.addAttribute("monument", monument);
        return "monumentDetails";
    }
}
