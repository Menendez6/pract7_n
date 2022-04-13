package pat.practicas.pract7.service.dto;


public record CustomerDTO(
		Long id,
		String customerName,
		String customerPassword,
		String customerEmail) {}
