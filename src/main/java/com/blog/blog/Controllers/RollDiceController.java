package com.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;


@Controller
public class RollDiceController {

    private int something;

    @GetMapping("/roll-dice")
    public String RollDice(Model dice){
        Random random = new Random();
        int diceRolled = random.nextInt(6)+1;
        something = diceRolled;
        dice.addAttribute("dice",diceRolled);
        return "rolldice";
    }

    @GetMapping("/roll-dice/{guess}")
    @ResponseBody
    public String guessDice(@PathVariable int guess){
        if(guess == something) {
            return "You guessed right!";
        }
        return "Sorry but that was not right!";
    }


}
