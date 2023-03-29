package com.kedom.productService.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Data
public class PmsCategoryAfter {
    String value;
    String label;
    ArrayList<PmsCategoryAfter> children;
}
