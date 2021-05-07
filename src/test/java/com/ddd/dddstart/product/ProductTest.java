package com.ddd.dddstart.product;

import com.ddd.dddstart.product.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    @Commit
    void productImageTest()
    {
        Image image1 = new InternalImage("In1");
        Image image2 = new ExternalImage("Ex1");
        List<Image> imageList = new ArrayList<>();

        imageList.add(image1);
        imageList.add(image2);
        Product product = new Product("상품1", "detail", imageList);
        productRepository.save(product);
        productRepository.delete(product);
    }
}
