package example3.controllers;

import example3.models.Product;
import example3.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Отображение всех продуктов
     * <a href="http://localhost:8080/products">...</a>
     *
     * @param model
     * @return список всех продуктов
     */
    @GetMapping("/prod")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "prod";
    }

    /**
     * Обработчик кнопки добавления продукта
     *
     * @param p     продукт
     * @param model
     * @return список всех продуктов
     */
    @PostMapping("/prod")
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        model.addAttribute("products", productService.getAllProducts());
        return "prod";
    }

}
