package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.SodukuDto;
import com.example.services.SodokuService;

@Controller
public class WelcomeController {

	@Autowired
	private SodokuService sodokuService;

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;

	private List<List<Integer>> list = new ArrayList<List<Integer>>();
	private static int[][] sdk;

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("list", list);
		SodukuDto sodukuDto = new SodukuDto();
        model.addAttribute("sodukuDto", sodukuDto);
		return "welcome"; // view
	}

	@PostMapping("/solve")
	public String solve(@ModelAttribute("sodukuDto") SodukuDto sodukuDto, Model model) {
		model.addAttribute("message", message);

		sdk = sodokuService.solveSodoku(sodokuService.populateSdk(sodukuDto));
		list = new ArrayList<List<Integer>>();
		for (int i = 0; i < sdk.length; i++) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < sdk.length; j++) {
				tmp.add(sdk[j][i]);
			}
			list.add(tmp);
		}
		model.addAttribute("list", list);
		return "solve"; // view
	}
}
