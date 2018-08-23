package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.repository.ProductRepository;
import cn.edu.nju.omrepository.service.TempService;
import cn.edu.nju.omrepository.util.VPoUtil;
import cn.edu.nju.omrepository.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempServiceImpl implements TempService {

    @Resource
    private ProductRepository productRepository;

    private VPoUtil vPoUtil = new VPoUtil();

    /**
     * 新增商品
     * @param productVO
     */
    @Override
    public void addProduct(ProductVO productVO) {
        ProductInfo productInfo = new ProductInfo();
        productInfo = vPoUtil.convertVOtoPO(productVO, productInfo);

        productRepository.save(productInfo);
    }

    /**
     * 根据条码查询商品
     * @param barCode
     * @return
     */
    @Override
    public List<ProductVO> checkProductByBarcode(String barCode) {
        List<ProductInfo> productList = productRepository.findAllByBarCodeLike("%" + barCode + "%");
        List<ProductVO> resultList = new ArrayList<>();

        for (ProductInfo productInfo : productList) {
            ProductVO vo = new ProductVO();
            resultList.add(vPoUtil.convertPOtoVO(vo, productInfo));
        }
        return resultList;
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<ProductVO> checkAllProduct() {
        List<ProductInfo> productList = productRepository.findAll();
        List<ProductVO> resultList = new ArrayList<>();

        for (ProductInfo productInfo : productList) {
//            if (productInfo.getBalance() > 0) {
                ProductVO vo = new ProductVO();
                resultList.add(vPoUtil.convertPOtoVO(vo, productInfo));
//            }
        }
        return resultList;
    }

    /**
     * 根据id查询商品
     * @param Id
     * @return
     */
    @Override
    public ProductVO checkProductByID(int Id) {
        return vPoUtil.convertPOtoVO(new ProductVO(), productRepository.getById(Id));
    }

    /**
     * 根据商品名字查询商品
     * @param name
     * @return
     */
    @Override
    public List<ProductVO> checkProductByName(String name) {
        List<ProductInfo> productList = productRepository.findAllByProductNameLike("%" + name + "%");
        List<ProductVO> resultList = new ArrayList<>();

        for (ProductInfo productInfo : productList) {
            ProductVO vo = new ProductVO();
            resultList.add(vPoUtil.convertPOtoVO(vo, productInfo));
        }
        return resultList;
    }

}
