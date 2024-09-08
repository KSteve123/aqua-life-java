
package com.Aqualife.Aqualife.controller;

import com.Aqualife.Aqualife.model.LoginProcess;
import com.Aqualife.Aqualife.model.LoginSession;
import com.Aqualife.Aqualife.model.LoginUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginuser")
@CrossOrigin("http://localhost:3000")
public class UserLoginController {
public static String ConfirmedEmail;
 @PostMapping("/check")
    public String check(@RequestBody LoginUser loginu){
        LoginProcess login = new LoginProcess();
        if (login.ifLogged(loginu.getEmail().toString(), loginu.getPassword().toString())) {

            ConfirmedEmail = String.valueOf(LoginSession.Id);
            return ConfirmedEmail;
        }else {
            ConfirmedEmail="Incorrect Credential";
            return ConfirmedEmail;
        }


    }

    @GetMapping("/Authenticaton")
    public ResponseEntity<String> sendString() {
        String stringValue = ConfirmedEmail;

        return ResponseEntity.ok().body(stringValue);
    }
    
}
