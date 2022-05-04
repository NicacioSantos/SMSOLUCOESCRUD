package com.project.smsolucoes.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Formater {

	public static String formatDate(LocalDate data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatter);
	}

	
}
