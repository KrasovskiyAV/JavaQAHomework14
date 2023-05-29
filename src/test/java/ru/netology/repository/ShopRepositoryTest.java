package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.repository.ShopRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopRepositoryTest {

    Product product1 = new Product(25, "Самокат", 15_000);
    Product product2 = new Product(11, "Ролики", 7_000);
    Product product3 = new Product(8, "Скейтборд", 8_000);
    ShopRepository repo = new ShopRepository();

    @BeforeEach
    public void add() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void shouldRemoveProductById() {

        repo.remove(11);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGenerateNotFoundException() {

        assertThrows(NotFoundException.class, () -> {
            repo.remove(5);
        });
    }
}
