package ru.getcourse.dmdev.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.getcourse.dmdev.project.dto.ProductDto;
import ru.getcourse.dmdev.project.service.MealService;
import ru.getcourse.dmdev.project.service.ProductService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
            printWriter.write("<li>");
            var mealDto = mealService.findMealById(mealId);
            var productDtoList = mealDto.getProductDtos();

            for (ProductDto productDto : productDtoList) {
                productService.findByProductId(productDto.getId());
            }

            printWriter.write("""
                        <ul>
                        <li><a href="/compounds?productId=%d">%s</a></li>
                        <li><a href="/compounds?productId=%d">%s</a></li>
                        </ul>
                        """.formatted(mealDto.getProductDtos().get(0).getId(),mealDto.getProductDtos().get(0).getTitle(),
                    mealDto.getProductDtos().get(1).getId(),mealDto.getProductDtos().get(1).getTitle()));
            printWriter.write("</li>");
            printWriter.write("</ul>");
        }
    }
}
