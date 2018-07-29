package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.repository.ProductRepository;
import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.vo.ProductVO;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
        productInfo.setBalance(productVO.getBalance());

        return productInfo;
    }

    private ProductVO convertPOtoVO (ProductVO productVO, ProductInfo productInfo) {
        productVO.setBarCode(productInfo.getBarCode());
        productVO.setPrimeCost(productInfo.getPrimeCost());
        productVO.setProductName(productInfo.getProductName());
        productVO.setProductPrice(productInfo.getProductPrice());
        productVO.setCreateTime(productInfo.getCreateTime());
        productVO.setSupply(productInfo.getSupply());
        productVO.setBalance(productInfo.getBalance());

        return productVO;
    }

    @Override
    public void addProduct(ProductVO productVO) {
        ProductInfo productInfo = new ProductInfo();
        productInfo = convertVOtoPO(productVO, productInfo);

        productRepository.save(productInfo);
    }

    @Override
    public List<ProductVO> checkProduct(String barCode) {
        List<ProductInfo> productList = productRepository.findAllByBarCode(barCode);
        List<ProductVO> resultList = new ArrayList<>();

        for (ProductInfo productInfo : productList) {
            ProductVO vo = new ProductVO();
            resultList.add(convertPOtoVO(vo, productInfo));
        }
        return resultList;
    }


}
