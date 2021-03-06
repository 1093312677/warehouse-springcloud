package com.kone.authservice.controller;

import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@SessionAttributes({"authorizationRequest"})
public class OAuth2ApprovalController {
//    @RequestMapping("/login")
//    public String login(Map<String, Object> model, HttpServletRequest request)
//            throws Exception {
//        System.out.println("oauth login");
//        return "/oauth/login";
//    }

    @RequestMapping("/login2")
    @ResponseBody
    public String login2(Map<String, Object> model, HttpServletRequest request)
            throws Exception {
        System.out.println("login2");
        return "oauth/login";
    }

    @RequestMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request){
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("oauth/grant");
        view.addObject("clientId", authorizationRequest.getClientId());
        return view;
    }
}
