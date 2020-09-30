package com.buneev;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        logger.log("Запускаем фильтрацию");
        for (int value : source) {
            if (value < threshold) {
                logger.log("Элемент \"" + value + "\"  не проходит");
            } else {
                logger.log("Элемент \"" + value + "\"  проходит");
                result.add(value);
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элементов из " + source.size());
        return result;
    }
}
