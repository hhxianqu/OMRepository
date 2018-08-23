package cn.edu.nju.omrepository.util;

import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.entity.ProductPreAddInfo;
import cn.edu.nju.omrepository.vo.ProductPreAddVO;
import cn.edu.nju.omrepository.vo.ProductVO;

public class VPoUtil {
    public ProductInfo convertVOtoPO (ProductVO productVO, ProductInfo productInfo) {
        productInfo.setId(productVO.getId());
        productInfo.setBarCode(productVO.getBarCode());
        productInfo.setPrimeCost(productVO.getPrimeCost());
        productInfo.setProductName(productVO.getProductName());
        productInfo.setProductPrice(productVO.getProductPrice());
        productInfo.setCreateTime(productVO.getCreateTime());
        productInfo.setSupply(productVO.getSupply());
        productInfo.setBalance(productVO.getBalance());

        return productInfo;
    }

    public ProductVO convertPOtoVO (ProductVO productVO, ProductInfo productInfo) {
        productVO.setId(productInfo.getId());
        productVO.setBarCode(productInfo.getBarCode());
        productVO.setPrimeCost(productInfo.getPrimeCost());
        productVO.setProductName(productInfo.getProductName());
        productVO.setProductPrice(productInfo.getProductPrice());
        productVO.setCreateTime(productInfo.getCreateTime());
        productVO.setSupply(productInfo.getSupply());
        productVO.setBalance(productInfo.getBalance());
        productVO.setAddNumber(0);

        return productVO;
    }

    public ProductPreAddInfo convertVOtoPO (ProductPreAddVO vo, ProductPreAddInfo po) {
        po.setProductID(vo.getProductID());
        po.setProductNum(vo.getProductNum());
        return po;
    }
}
