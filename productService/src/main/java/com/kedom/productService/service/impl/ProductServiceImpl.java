package com.kedom.productService.service.impl;

import com.hankcs.hanlp.HanLP;
import com.kedom.productService.entity.GetProductByCategoryVO;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.PmsSkuSaleAttrValue;
import com.kedom.productService.entity.PmsSpuInfo;
import com.kedom.productService.entity.vo.Attr;
import com.kedom.productService.entity.vo.ProductVO;
import com.kedom.productService.entity.vo.Sku;
import com.kedom.productService.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    //spu
    @Autowired
    PmsSpuInfoService pmsSpuInfoService; //spu信息
    @Autowired
    PmsSpuInfoDescService pmsSpuInfoDescService;//spu描述
    @Autowired
    PmsSpuImagesService pmsSpuImagesService;//spu图片
    @Autowired
    PmsProductAttrValueService pmsProductAttrValueService;//spu属性值
    @Autowired
    PmsAttrService pmsAttrService;//属性名字服务

    //sku
    @Autowired
    PmsSkuInfoService pmsSkuInfoService; //spu信息
    @Autowired
    PmsSkuImagesService pmsSkuImagesService;//spu图片
    @Autowired
    PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;//spu属性

    @Value("${imageSave.path}")
    String path;
    @Value("$${imageSave.id}")
    String id;

    @Value("${imageSave.showPath}")
    String showPath;


    @Override
    public List<ProductVO> getProduct(String spuKey, Integer pageNum, Integer pageSize) {

        List<PmsSpuInfo> spuList = pmsSpuInfoService.queryBySpuNameAndPage(spuKey, pageNum, pageSize);
        return null;
    }

    public List<String> saveImage(List<MultipartFile> files) {
        List<String> paths = new ArrayList<>();

        files.forEach(file -> {
            String originalFilename = file.getOriginalFilename();
            String fianlName = id + System.currentTimeMillis() + originalFilename;
            File file1 = new File(path+fianlName);
            try {
                file.transferTo(file1);
                paths.add(showPath+fianlName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return paths;
    }

    @Transactional
    public void addProduct(ProductVO productVO) {

//        //查出SPU的所有属性
//        HashMap<Long, PmsAttr> spuSpecsAttrHashMap = pmsAttrService.queryAllAttrNameByCateId(productVO.getCatalogId(),0);
//
//
//        //spu基本信息
//        PmsSpuInfo pmsSpuInfo = new PmsSpuInfo();
//        BeanUtils.copyProperties(productVO, pmsSpuInfo);
//        pmsSpuInfoService.insertGetKey(pmsSpuInfo);
//
//        //SPU信息图片详情（淘宝详情页）
//        if (!(productVO.getDecript()!=null&&productVO.getDecript().isEmpty()))
//        {
//            PmsSpuInfoDesc pmsSpuInfoDesc = new PmsSpuInfoDesc();
//            //赋值
//            pmsSpuInfoDesc.setSpuId(pmsSpuInfo.getId());
//            pmsSpuInfoDesc.setDecript(String.join(",",productVO.getDecript()));
////        logger.debug("pmsSpuInfoDesc:{}",pmsSpuInfoDesc);
//            pmsSpuInfoDescService.insert(pmsSpuInfoDesc);
//        }
//
//
//        //SPU图片集（淘宝指定商品的展示图 如红色iphone）
//        List<PmsSpuImages> images = productVO.getImages().stream().map(img -> {
//            PmsSpuImages pmsSpuImages = new PmsSpuImages();
//            pmsSpuImages.setSpuId(pmsSpuInfo.getId());
//            pmsSpuImages.setImgUrl(img);
//            return pmsSpuImages;
//        }).collect(Collectors.toList());
//        pmsSpuImagesService.insertList(images);
//
//        //SPU规格属性
//        List<BaseAttrs> baseAttrs = productVO.getBaseAttrs();
//        List<Long> AttrsIds = new ArrayList<>();
//        List<PmsProductAttrValue> skuAttrValues = baseAttrs.stream().map(baseAttr -> {
//            PmsProductAttrValue pmsProductAttrValue = new PmsProductAttrValue();
//            pmsProductAttrValue.setSpuId(pmsSpuInfo.getId());
//            pmsProductAttrValue.setAttrId(baseAttr.getAttrId());
//            pmsProductAttrValue.setAttrValue(baseAttr.getAttrValues());
//
//            AttrsIds.add(baseAttr.getAttrId());
//            return pmsProductAttrValue;
//        }).collect(Collectors.toList());
//        //查出属性名
//
//        skuAttrValues.forEach(pmsProductAttrValue -> {
//            pmsProductAttrValue.setAttrName(spuSpecsAttrHashMap.get(pmsProductAttrValue.getAttrId()).getAttrName());
//        });
//        //添加平台属性
//        pmsProductAttrValueService.insertList(skuAttrValues);
//
//
////        HashMap<Long, PmsAttr> salePmsAttrHashMap = pmsAttrService.queryAllAttrNameByCateId(productVO.getCatalogId(), 1);
//
//        //sku操作
//        List<Skus> skus = productVO.getSkus();
//        //保存sku 因为依赖数据库主键返回只能单个保存 不能批量 后期优化使用雪花ID批量插入
//        skus.forEach(sku ->{
//            //sku基本信息
//            PmsSkuInfo pmsSkuInfo = new PmsSkuInfo();
//            BeanUtils.copyProperties(sku,pmsSkuInfo);
//            pmsSkuInfo.setSpuId(pmsSpuInfo.getId());
//            pmsSkuInfo.setCatalogId(pmsSpuInfo.getCatalogId());
//            pmsSkuInfo.setBrandId(pmsSpuInfo.getBrandId());
//            pmsSkuInfo.setSaleCount(0L);
//
//            //sku默认选中图片
//           for (Images DefaultImages : sku.getImages()) {
//               if (DefaultImages.getDefaultImg()==1)
//               {
//                   pmsSkuInfo.setSkuDefaultImg(DefaultImages.getImgUrl());
//                   break;
//               }
//            }
//            pmsSkuInfoService.insertGetKey(pmsSkuInfo);
//
//            //sku图片
//            List<PmsSkuImages> skuImages = sku.getImages().stream().map(img -> {
//                PmsSkuImages pmsSkuImages = new PmsSkuImages();
//                pmsSkuImages.setSkuId(pmsSkuInfo.getSkuId());
//                pmsSkuImages.setImgUrl(img.getImgUrl());
//                return pmsSkuImages;
//            }).collect(Collectors.toList());
//
//            pmsSkuImagesService.insertList(skuImages);
//
//
//            //sku销售属性
//            List<PmsSkuSaleAttrValue> skuSaleAttrValues = sku.getAttr().stream().map(saleAttr -> {
//                PmsSkuSaleAttrValue pmsSkuSaleAttrValue = new PmsSkuSaleAttrValue();
//                pmsSkuSaleAttrValue.setSkuId(pmsSkuInfo.getSkuId());
//                pmsSkuSaleAttrValue.setAttrId(saleAttr.getAttrId());
//                pmsSkuSaleAttrValue.setAttrValue(saleAttr.getAttrValue());
//                pmsSkuSaleAttrValue.setAttrSort(0);
//                pmsSkuSaleAttrValue.setAttrName(salePmsAttrHashMap.get(saleAttr.getAttrId()).getAttrName());
//                return pmsSkuSaleAttrValue;
//            }).collect(Collectors.toList());
//
//            pmsSkuSaleAttrValueService.insertList(skuSaleAttrValues);
//        });
//

    }

    @Override
    public Sku getProduct(Long id) {
        Sku sku = new Sku();
        sku.setAttr(new ArrayList<>());
        //查询sku基本信息
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoService.queryById(id);
        BeanUtils.copyProperties(pmsSkuInfo, sku);
        //查询sku图片
//        List<PmsSkuImages> pmsSkuImages = pmsSkuImagesService.selectList(new EntityWrapper<PmsSkuImages>().eq("sku_id", id));
//        sku.setImages(pmsSkuImages);
        //查询sku销售属性
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues = pmsSkuSaleAttrValueService.queryBySkuId(id);
        for (int i = 0; i < pmsSkuSaleAttrValues.size(); i++) {
            Attr attr = new Attr();
            attr.setAttrId(pmsSkuSaleAttrValues.get(i).getAttrId());
            attr.setAttrName(pmsSkuSaleAttrValues.get(i).getAttrName());
            attr.setAttrValue(pmsSkuSaleAttrValues.get(i).getAttrValue());
            sku.getAttr().add(attr);
        }
        return sku;
    }

    @Override
    public List<Sku> getProductByKey(String spuKey, Integer offset) {
        //分词
        List<String> words = HanLP.extractKeyword(spuKey, 10);
        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoService.queryByKey(words, offset);
        List<Sku> skus = pmsSkuInfos.stream().map(pmsSkuInfo -> {
            Sku sku = new Sku();
            BeanUtils.copyProperties(pmsSkuInfo, sku);
            return sku;
        }).collect(Collectors.toList());

        for (int i = 0; i < skus.size(); i++) {
            skus.get(i).setAttr(new ArrayList<>());
            List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues = pmsSkuSaleAttrValueService.queryBySkuId(skus.get(i).getSkuId());
            for (int j = 0; j < pmsSkuSaleAttrValues.size(); j++) {
                Attr attr = new Attr();
                attr.setAttrId(pmsSkuSaleAttrValues.get(j).getAttrId());
                attr.setAttrName(pmsSkuSaleAttrValues.get(j).getAttrName());
                attr.setAttrValue(pmsSkuSaleAttrValues.get(j).getAttrValue());
                skus.get(i).getAttr().add(attr);
            }
        }
        return skus;

    }

    @Override
    public List<Sku> getProductByCategory(GetProductByCategoryVO pamrs) {

        pamrs.getAttrs().forEach(attr -> {
            String attrValue = attr.getAttrValue();
            if (attrValue != null && !(("").equals(attrValue))) {
                pamrs.setAttrSize(pamrs.getAttrSize() + 1);
            }
        });


        List<PmsSkuInfo> pmsSkuInfos = pmsSkuInfoService.queryByCategory(pamrs);
        List<Sku> skus = pmsSkuInfos.stream().map(pmsSkuInfo -> {
            Sku sku = new Sku();
            BeanUtils.copyProperties(pmsSkuInfo, sku);
            return sku;
        }).collect(Collectors.toList());

        for (int i = 0; i < skus.size(); i++) {
            skus.get(i).setAttr(new ArrayList<>());
            List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValues = pmsSkuSaleAttrValueService.queryBySkuId(skus.get(i).getSkuId());
            for (int j = 0; j < pmsSkuSaleAttrValues.size(); j++) {
                Attr attr = new Attr();
                attr.setAttrId(pmsSkuSaleAttrValues.get(j).getAttrId());
                attr.setAttrName(pmsSkuSaleAttrValues.get(j).getAttrName());
                attr.setAttrValue(pmsSkuSaleAttrValues.get(j).getAttrValue());
                skus.get(i).getAttr().add(attr);
            }
        }


        return skus;
    }

    @Override
    public void takeDownProduct(Long id) {
        pmsSkuInfoService.takeDownProduct(id);
    }

    @Cacheable(value = "product", key = "'aaa'")
    public String a() {
        return "a";
    }

    public static void main(String[] args) {
        logger.info("a");
    }

}
