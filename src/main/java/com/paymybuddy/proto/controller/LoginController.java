package com.paymybuddy.proto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

//    @GetMapping({"/", "/home"})
//    public String getLogin(Authentication authentication, Model model) {
//
//        //The name has been override as email:
//        DaoUser user = userService.findByEmail(authentication.getName());
//        String name = user.getUserName();
//        Set<DaoUser> myFriends = friendsService.findAllMyFriends(user.getId());
//
//        Account account = accountService.findByUserId(user.getId());
//
//        model.addAttribute("transactionList", (account == null) ? new ArrayList<>() : transactionService.findTransactionsByFromAccount_Id(account.getId()));
//        model.addAttribute("friendList", myFriends == null ? new HashSet<>() : myFriends);
//
//        model.addAttribute("message", "Hi " + name);
//        model.addAttribute("balance", user.getAccount() == null ? new BigDecimal(0) : user.getAccount().getBalance());
//        return "home";
//    }
}
