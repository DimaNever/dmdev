package ru.getcourse.dmdev.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.getcourse.dmdev.project.dto.MealDto;
import ru.getcourse.dmdev.project.service.MealService;
import ru.getcourse.dmdev.project.service.ProductService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private final ProductService productService = ProductService.getInstance();
    private final MealService mealService = MealService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var mealId = Long.valueOf(req.getParameter("mealId"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список продуктов:</h1>");
            printWriter.write("<ul>");
            var mealDto = mealService.findMealById(mealId);
            printWriter.write("""
                        <li>
                        <a href="/compounds?productId=%d">%s</a>
                        </li>
                        """.formatted(mealDto.getId(),mealDto.getTitleMeal()));
            printWriter.write("</ul>");
        }
    }
}
