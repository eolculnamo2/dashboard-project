package com.dashboard.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

import com.dashboard.entities.ReadCurrentTeam;
import com.dashboard.entities.Team;

public class Helpers {
	public Helpers() {
		
	}
	public static String convertJsonToString(InputStream body) {
		BufferedReader br = new BufferedReader( new InputStreamReader(body));
		String json = "";
		
		if(br != null) {
			try {
				json = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return json;
	}
	@Transactional
	public static void loginSuccessHandler(Authentication authentication, HttpServletRequest request) {
		System.out.println("getName=");
		System.out.println(authentication.getName());
		Team team = new ReadCurrentTeam(authentication.getName()).getTeam();
		System.out.println(team.getFounder());
		request.getSession().setAttribute("team", team);
	}
}
