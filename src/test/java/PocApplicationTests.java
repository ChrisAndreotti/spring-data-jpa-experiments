import com.candreotti.demo.PocApplication;
import com.candreotti.demo.entities.Product;
import com.candreotti.demo.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={PocApplication.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PocApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setId(1);
        product.setName("iPhone");
        product.setDesc("Overpriced");
        product.setPrice(1000d);
        productRepository.save(product);

        Product productResult = productRepository.findById(1).get();
        assertNotNull(productResult);
        assertEquals("iPhone", productResult.getName());
    }

    @Test
    public void testUpdate() {
        Product product = new Product();
        product.setId(1);
        product.setName("iPhone");
        product.setDesc("Overpriced");
        product.setPrice(1000d);
        productRepository.save(product);

        Product initialProduct = productRepository.findById(1).get();
        assertNotNull(initialProduct);

        product.setPrice(1200d);
        productRepository.save(product);

        Product productResult = productRepository.findById(1).get();
        assertNotNull(productResult);
        assertEquals(1200d, productResult.getPrice(), 0);
    }

    @Test
    public void testDelete() {
        Product product = new Product();
        product.setId(1);
        product.setName("iPhone");
        product.setDesc("Overpriced");
        product.setPrice(1000d);
        productRepository.save(product);

        Product productResult = productRepository.findById(1).get();
        assertNotNull(productResult);

        productRepository.delete(product);
        assertTrue(!productRepository.findById(1).isPresent());
    }
}
