package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
@ResponseBody
public class SocialMediaController {
    private AccountService accountService;
    private MessageService messageService;

    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }


    @PostMapping("register")
    public ResponseEntity<Account> register(@RequestBody Account acc){
        if(acc == null ){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        boolean usernameExists = accountService.findByUsername(acc.getUsername());
        if(usernameExists){
            return ResponseEntity.status(409).build();

        }
        try {
            Account newAcc =  accountService.registerUser(acc);
            return ResponseEntity.status(200).body(newAcc);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/login")
    public Account login(String username, String password){
        return null;
    }
    @PostMapping("/messages")
    public Message createMessage(String username, String password){
        return null;
    }
    @GetMapping("/messages")
    public void getAllMessages(@RequestBody Message messages){
        return ;
    }
    @GetMapping("/messages/{id}")
    public void getMessageById(@PathVariable int id){
        return ;
    }
    @DeleteMapping("/messages/{id}")
    public void deleteMessageById(@PathVariable int id){
        return; 
    }
    @PatchMapping("/messages/{message_id}")
    public Message updateMessageById(@PathVariable int message_id){
        return null;
    }

    @GetMapping("/accounts/{account_id}/messages")
        public Message getAllMessageForUserAccount(@PathVariable int account_id){
            return null;
    }
    
    


}
