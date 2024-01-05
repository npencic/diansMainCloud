package mk.ukim.finki.diansproekt.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.diansproekt.model.Monument;
import mk.ukim.finki.diansproekt.service.MonumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final MonumentService monumentService;

    public SearchController(MonumentService monumentService) {
        this.monumentService = monumentService;
    }

    @GetMapping
    public String getSearchPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error", error);
        }
        List<Monument> monuments=monumentService.findAll();
        model.addAttribute("monuments", monuments);
        return "search";
    }


    @PostMapping("/search1")
    public String Search1(@RequestParam String name,
                          @RequestParam(name = "type", required = false) String type,
                          @RequestParam(name="searchName", required = false) String searchType2,
                          Model model){
        List<Monument> monuments ;


        if (type != null) {
            if(searchType2 != null) {
                monuments = this.monumentService.searchByName(name.replace(",", ""),type);
            }
            else {
                monuments = this.monumentService.searchByCity(name.replace(",", ""),type);
            }
        }
        else {
            if(searchType2 != null) {
                monuments = this.monumentService.searchNameWithoutType(name.replace(",", ""));
            }
            else {
                monuments = this.monumentService.searchCityWithoutType(name.replace(",", ""));
            }

        }

        model.addAttribute("monuments", monuments);
        return "searchResults";
    }


}
