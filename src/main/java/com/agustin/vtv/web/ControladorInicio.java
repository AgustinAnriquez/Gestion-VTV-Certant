package com.agustin.vtv.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class ControladorInicio{
	@GetMapping("/")
	public String inicio() {
		return "index";
	}
}