package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.AddToStoreInfo;
import cn.edu.nju.omrepository.entity.ProductInfo;
import cn.edu.nju.omrepository.entity.ProductPreAddInfo;
import cn.edu.nju.omrepository.repository.AddToStoreRepository;
import cn.edu.nju.omrepository.repository.ProductPreAddRepository;
import cn.edu.nju.omrepository.repository.ProductRepository;
import cn.edu.nju.omrepository.service.StoreService;
import cn.edu.nju.omrepository.util.DateUtil;
import cn.edu.nju.omrepository.util.VPoUtil;
import cn.edu.nju.omrepository.vo.ProductPreAddVO;
import cn.edu.nju.omrepository.vo.ProductVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private ProductPreAddRepository productPreAddRepository;

    @Resource
    private AddToStoreRepository addToStoreRepository;

    private VPoUtil vPoUtil = new VPoUtil();
    private DateUtil dateUtil = new DateUtil();


    /**
     * 商品入库
     * @param addToStoreList
     * @return
     */
    @Override
    public Boolean addToStore(List<ProductVO> addToStoreList) {

        //入库单存储
        try {
            AddToStoreInfo addToStoreInfo = new AddToStoreInfo();
            addToStoreInfo.setCreateTime(dateUtil.localdateToDate(LocalDate.now()));
            addToStoreRepository.save(addToStoreInfo);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        //入库单上每个商品处理
        addToStoreList.forEach(productVO -> {
            productVO.setBalance(productVO.getBalance() + productVO.getAddNumber());
            ProductInfo productInfo = productRepository.save(vPoUtil.convertVOtoPO(productVO, new ProductInfo()));

            ProductPreAddVO productPreAddVO = new ProductPreAddVO();
            productPreAddVO.setProductID(productInfo.getId());
            productPreAddVO.setProductNum(productVO.getAddNumber());
            productPreAddRepository.save(vPoUtil.convertVOtoPO(productPreAddVO, new ProductPreAddInfo()));
        });
        return true;
    }


    public List<ProductVO> checkWarseHouse() {
        List<ProductVO> productVOS = new ArrayList<>();

        return productVOS;
    }

}
