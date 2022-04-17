package pat.practicas.pract7.service.dto;

public record CoursesJoinDTO(
    String customerName,
    String customerEmail,
    String courseName,
    Integer semester,
    String degree) {}