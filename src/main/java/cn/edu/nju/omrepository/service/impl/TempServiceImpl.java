package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.repository.ProductRepository;
import cn.edu.nju.omrepository.service.TempService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TempServiceImpl implements TempService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public void addProduct() {
        ProductInfo productInfo = new ProductInfo();

        productRepository.save(productInfo);
    }
}
