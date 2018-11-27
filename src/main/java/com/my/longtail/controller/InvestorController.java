package com.my.longtail.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.my.longtail.model.Users;

@Controller
@RequestMapping(value = "/investor")
public class InvestorController {
	
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public ModelAndView getLoginInfo(Model model, OAuth2AuthenticationToken authentication) {
		ModelAndView modelView = new ModelAndView();
		OAuth2AuthorizedClient client = authorizedClientService
				.loadAuthorizedClient(
						authentication.getAuthorizedClientRegistrationId(), 
						authentication.getName());
		
		String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
		if(!StringUtils.isEmpty(userInfoEndpointUri)) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
			HttpEntity entity = new HttpEntity("", headers);
			ResponseEntity<Map> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
			Map userAttribute = response.getBody();
			System.out.println("result "+ userAttribute);
		}else {
			//error getting user details
		}
		
		modelView.setViewName("Investor/home");
		return modelView;
	}
	
}
