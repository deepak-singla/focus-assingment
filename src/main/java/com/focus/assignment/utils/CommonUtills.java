package com.focus.assignment.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class CommonUtills {
	
    public static final DateTimeFormatter DOB_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	
	public static String transformToString(final LocalDate dateOfBirth) {
		if (Objects.isNull(dateOfBirth))
			return null;

		return dateOfBirth.format(DOB_FORMATTER);
	}

	public static LocalDate transformToLocalDate(final String dateOfBirth) {
		if (dateOfBirth.isEmpty())
			return null;

		return LocalDate.parse(dateOfBirth, DOB_FORMATTER);
	}

}
