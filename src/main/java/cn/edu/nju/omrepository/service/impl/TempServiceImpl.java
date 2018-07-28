package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.repository.ProductRepository;
import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TempServiceImpl implements TempService {

    @Resource
    private ProductRepository productRepository;

    private ProductInfo convertVOtoPO (ProductVO productVO, ProductInfo productInfo) {
        productInfo.setBarCode(productVO.getBarCode());
        productInfo.setPrimeCost(productVO.getPrimeCost());
        productInfo.setProductName(productVO.getProductName());
        productInfo.setProductPrice(productVO.getProductPrice());
        productInfo.setCreateTime(productVO.getCreateTime());
        productInfo.setSupply(productVO.getSupply());
        
        return productInfo;
    }

    @Override
    public void addProduct(ProductVO productVO) {
        ProductInfo productInfo = new ProductInfo();
        productInfo = convertVOtoPO(productVO, productInfo);

        productRepository.save(productInfo);
    }
}
