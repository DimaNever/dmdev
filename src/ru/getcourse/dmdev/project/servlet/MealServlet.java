package ru.getcourse.dmdev.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.getcourse.dmdev.project.service.MealService;
import ru.getcourse.dmdev.project.service.ProductService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/meals")
public class MealServlet extends HttpServlet {

//    private final ProductService productService = ProductService.getInstance();
    private final MealService mealService = MealService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список всех блюд:</h1>");
            printWriter.write("<ol>");
            mealService.findAllMeals().forEach(mealDto -> {
                printWriter.write("""
                        <li>
                        <a href="/products?mealId=%d">%s</a>
                        </li>
                        """.formatted(mealDto.getId(),mealDto.getTitleMeal()));
            });
            printWriter.write("</ol>");
        }
    }
}
