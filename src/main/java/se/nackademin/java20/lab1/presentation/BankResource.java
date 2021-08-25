package se.nackademin.java20.lab1.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.nackademin.java20.lab1.Domain.Account;
import se.nackademin.java20.lab1.application.BankService;

@Controller
public class BankResource {

    private final BankService bankService;


    public BankResource(BankService bankService){
        this.bankService = bankService;
    }

    @GetMapping("/bank/{holder}/account")
    public String openAccount(@PathVariable("holder") String holder) {
       final Account account = bankService.openAccount(holder);
        return "redirect:/bank/unknown/account/1";
    }

    @GetMapping("/bank/{holder}/account/{accountId}")
    public String bankForm(@PathVariable("holder") String holder, @PathVariable("accountId") Long accountId, Model model) {
        model.addAttribute("holder", holder);
        model.addAttribute("accountId", accountId);
        return "bank";
    }

}
