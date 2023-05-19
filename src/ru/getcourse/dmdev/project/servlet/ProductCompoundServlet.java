package ru.getcourse.dmdev.project.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.getcourse.dmdev.project.dto.ProductDto;
import ru.getcourse.dmdev.project.service.ProductService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet("/compounds")
public class ProductCompoundServlet extends HttpServlet {

    private final ProductService productService = ProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var productId = Long.valueOf(req.getParameter("productId"));
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (var printWriter = resp.getWriter()) {
            printWriter.write("<h1>В 100 г. продукта содержится:</h1>");
            printWriter.write("<ul>");
            ProductDto productDto = productService.findByProductId(productId);
            printWriter.write("""
                    <li>
                    <p>Белки = %s г.
                    <p>Жиры = %s  г.
                    <p>Углеводы = %s г.
                    <p>Каллорийность = %s Ккал.
                    </li>
                    """.formatted(productDto.getProteinIn100Grams(), productDto.getFatsIn100Grams(),
                    productDto.getCarbsIn100Grams(), productDto.getCaloriesIn100Grams()));
            printWriter.write("</ul>");
        }
    }
}
